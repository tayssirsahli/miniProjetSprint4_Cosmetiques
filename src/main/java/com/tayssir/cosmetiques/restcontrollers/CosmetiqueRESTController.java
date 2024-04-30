package com.tayssir.cosmetiques.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tayssir.cosmetiques.entities.Cosmetique;
import com.tayssir.cosmetiques.service.CosmetiqueService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CosmetiqueRESTController {

	@Autowired
	CosmetiqueService cosmetiqueService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Cosmetique> getAllCosmetiques() {
		return cosmetiqueService.getAllCosmetiques();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cosmetique getCosmetiqueById(@PathVariable("id") Long id) {
		return cosmetiqueService.getCosmetique(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Cosmetique createCosmetique(@RequestBody Cosmetique cosmetique) {
		return cosmetiqueService.saveCosmetique(cosmetique);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Cosmetique updateCosmetique(@RequestBody Cosmetique cosmetique) {
		return cosmetiqueService.updateCosmetique(cosmetique);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCosmetique(@PathVariable("id") Long id) {
		cosmetiqueService.deleteCosmetiqueById(id);
	}

	@RequestMapping(value = "/cosmsclas/{idClas}", method = RequestMethod.GET)
	public List<Cosmetique> getCosmetiquesByCatId(@PathVariable("idClas") Long idClas) {
		return cosmetiqueService.findByClassificationIdClas(idClas);
	}
}
