package com.tayssir.cosmetiques.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tayssir.cosmetiques.entities.Classification;
import com.tayssir.cosmetiques.entities.Cosmetique;
import com.tayssir.cosmetiques.service.CosmetiqueService;

import jakarta.validation.Valid;

@Controller
public class CosmetiqueControllers {

	@Autowired
	CosmetiqueService cosmetiqueService;

	@RequestMapping("/ListeCosmetiques")
	public String listeProduits(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Cosmetique> cosms = cosmetiqueService.getAllCosmetiquesParPage(page, size);
		modelMap.addAttribute("cosmetiques", cosms);
		modelMap.addAttribute("pages", new int[cosms.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeCosmetiques";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Classification> clas = cosmetiqueService.getAllClassifications();
		if (clas != null && !clas.isEmpty()) {

			modelMap.addAttribute("cosmetique", new Cosmetique());
			modelMap.addAttribute("mode", "new");
			modelMap.addAttribute("cosmetiques", clas);
		} else {

			System.out.println("Classifications list is empty!");
		}

		return "formCosmetique";
	}

	@RequestMapping("/saveCosmetique")
	public String saveCosmetique(@Valid Cosmetique cosmetique, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		int currentPage;
		boolean isNew = false;
		if (bindingResult.hasErrors())
			return "formCosmetique";
		if (cosmetique.getIdCosmetique() == null) // ajout
			isNew = true;

		cosmetiqueService.saveCosmetique(cosmetique);
		if (isNew) // ajout
		{
			Page<Cosmetique> cosms = cosmetiqueService.getAllCosmetiquesParPage(page, size);
			currentPage = cosms.getTotalPages() - 1;
		} else // modif
			currentPage = page;

		return ("redirect:/ListeCosmetiques?page=" + currentPage + "&size=" + size);
	}

	@RequestMapping("/supprimerCosmetique")
	public String supprimerCosmetique(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		cosmetiqueService.deleteCosmetiqueById(id);
		Page<Cosmetique> cosms = cosmetiqueService.getAllCosmetiquesParPage(page, size);
		modelMap.addAttribute("cosmetiques", cosms);
		modelMap.addAttribute("pages", new int[cosms.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeCosmetiques";
	}

	@RequestMapping("/modifierCosmetique")
	public String editerCosmetique(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		Cosmetique c = cosmetiqueService.getCosmetique(id);
		List<Classification> clas = cosmetiqueService.getAllClassifications();
		modelMap.addAttribute("cosmetique", c);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("cosmetiques", clas);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);

		return "formCosmetique";
	}

	@RequestMapping("/updateCosmetique")
	public String updateCosmetique(@ModelAttribute("cosmetique") Cosmetique cosmetique,
			@RequestParam("date") String date, ModelMap modelMap) throws ParseException {
		// conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		cosmetique.setDateCreation(dateCreation);

		cosmetiqueService.updateCosmetique(cosmetique);
		List<Cosmetique> cosms = cosmetiqueService.getAllCosmetiques();
		modelMap.addAttribute("cosmetiques", cosms);
		return "listeCosmetiques";
	}

	@GetMapping(value = "/")
	public String welcome() {
		return "index";
	}

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	    http.authorizeHttpRequests((requests) -> requests
	            .requestMatchers("/showCreate", "/saveCosmetique").hasAnyAuthority("ADMIN", "AGENT")
	            .requestMatchers("/ListeCosmetiques").hasAnyAuthority("ADMIN", "AGENT", "USER")
	            .requestMatchers("/login", "/webjars/**").permitAll()
	            .anyRequest().authenticated())
	        .formLogin((formLogin) -> formLogin
	            .loginPage("/login")
	            .defaultSuccessUrl("/"))
	        .httpBasic(Customizer.withDefaults())
	        .exceptionHandling((exception) -> exception
	            .accessDeniedPage("/accessDenied"));
	    return http.build();
	}

}
