package com.tayssir.cosmetiques;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.tayssir.cosmetiques.entities.Classification;
import com.tayssir.cosmetiques.entities.Cosmetique;
import com.tayssir.cosmetiques.repos.CosmetiqueRepository;
import com.tayssir.cosmetiques.service.CosmetiqueService;

@SpringBootTest
class CosmetiquesApplicationTests {

	@Autowired
	private CosmetiqueRepository cosmetiqueRepository;

	@Autowired
	private CosmetiqueService cosmetiqueService;

	@Test
	public void testCreateCosmetique() {

		Cosmetique cosm = new Cosmetique("gel nettoynat", 30.0, new Date());
		cosmetiqueRepository.save(cosm);
	}

	@Test
	public void testFindCosmetique() {
		Cosmetique c = cosmetiqueRepository.findById(1L).get();
		System.out.println(c);
	}

	@Test
	public void testUpdateCosmetique() {
		Cosmetique c = cosmetiqueRepository.findById(1L).get();
		c.setPrixCosmetique(80.0);
		cosmetiqueRepository.save(c);
	}

	@Test
	public void testDeleteCosmetique() {
		cosmetiqueRepository.deleteById(1L);
	}

	@Test
	public void testListerTousCosmetiques() {
		List<Cosmetique> cosms = cosmetiqueRepository.findAll();
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void testFindByNomCosmetiqueContains() {
		Page<Cosmetique> cosms = cosmetiqueService.getAllCosmetiquesParPage(0, 2);
		System.out.println(cosms.getSize());
		System.out.println(cosms.getTotalElements());
		System.out.println(cosms.getTotalPages());
		cosms.getContent().forEach(p -> {
			System.out.println(p.toString());
		});

		/*
		 * ou bien for (Cosmetique c : cosms) { System.out.println(c); }
		 */
	}

	@Test
	public void testFindByNomCosmetique() {
		List<Cosmetique> cosms = cosmetiqueRepository.findByNomCosmetique("savon");
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void testfindByNomCosmetiqueContains() {
		List<Cosmetique> cosms = cosmetiqueRepository.findByNomCosmetiqueContains("v");
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void testfindByNomPrix() {
		List<Cosmetique> cosms = cosmetiqueRepository.findByNomPrix("ecran solaire", 10.0);
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void testfindByClassification() {
		Classification clas = new Classification();
		clas.setIdClas(1L);

		List<Cosmetique> cosms = cosmetiqueRepository.findByClassfication(clas);
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void findByClassificationIdCat() {
		List<Cosmetique> cosms = cosmetiqueRepository.findByclassificationIdClas(3L);
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void testfindByOrderByNomCosmetiqueAsc() {
		List<Cosmetique> cosms = cosmetiqueRepository.findByOrderByNomCosmetiqueAsc();
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

	@Test
	public void testTrierCosmetiquesNomsPrix() {
		List<Cosmetique> cosms = cosmetiqueRepository.trierCosmetiquesNomsPrix();
		for (Cosmetique c : cosms) {
			System.out.println(c);
		}
	}

}
