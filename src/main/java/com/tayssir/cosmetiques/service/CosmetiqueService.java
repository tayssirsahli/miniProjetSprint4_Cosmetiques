package com.tayssir.cosmetiques.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tayssir.cosmetiques.entities.Classification;
import com.tayssir.cosmetiques.entities.Cosmetique;

public interface CosmetiqueService {

	Cosmetique saveCosmetique(Cosmetique c);

	Cosmetique updateCosmetique(Cosmetique c);

	void deleteCosmetique(Cosmetique c);

	void deleteCosmetiqueById(Long id);

	Cosmetique getCosmetique(Long id);

	List<Cosmetique> getAllCosmetiques();
	
	Page<Cosmetique> getAllCosmetiquesParPage(int page, int size);
	
	List<Cosmetique> findByNomCosmetique(String nom);
	List<Cosmetique> findByNomCosmetiqueContains(String nom);
	List<Cosmetique> findByNomPrix (String nom, Double prix);
	List<Cosmetique> findByCategorie (Classification classification);
	List<Cosmetique> findByClassificationIdClas(Long id);
	List<Cosmetique> findByOrderByNomCosmetiqueAsc();
	List<Cosmetique> trierCosmetiquesNomsPrix();
	
	List<Classification> getAllClassifications();


}
