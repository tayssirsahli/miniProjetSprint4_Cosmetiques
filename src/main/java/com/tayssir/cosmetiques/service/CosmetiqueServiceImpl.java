package com.tayssir.cosmetiques.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tayssir.cosmetiques.entities.Classification;
import com.tayssir.cosmetiques.entities.Cosmetique;
import com.tayssir.cosmetiques.repos.ClassificationRepository;
import com.tayssir.cosmetiques.repos.CosmetiqueRepository;

@Service
public class CosmetiqueServiceImpl implements CosmetiqueService {

	@Autowired
	CosmetiqueRepository cosmetiqueRepository;
	
	
	@Autowired
	ClassificationRepository classificationRepository;

	@Override
	public Cosmetique saveCosmetique(Cosmetique c) {

		return cosmetiqueRepository.save(c);
	}

	@Override
	public Cosmetique updateCosmetique(Cosmetique c) {
		return cosmetiqueRepository.save(c);
	}

	@Override
	public void deleteCosmetique(Cosmetique c) {
		cosmetiqueRepository.delete(c);

	}

	@Override
	public void deleteCosmetiqueById(Long id) {
		cosmetiqueRepository.deleteById(id);

	}

	@Override
	public Cosmetique getCosmetique(Long id) {
		return cosmetiqueRepository.findById(id).get();

	}

	@Override
	public List<Cosmetique> getAllCosmetiques() {
		return cosmetiqueRepository.findAll();
	}

	@Override
	public Page<Cosmetique> getAllCosmetiquesParPage(int page, int size) {

		return cosmetiqueRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Cosmetique> findByNomCosmetique(String nom) {

		return cosmetiqueRepository.findByNomCosmetique(nom);
	}

	@Override
	public List<Cosmetique> findByNomCosmetiqueContains(String nom) {
		// TODO Auto-generated method stub
		return cosmetiqueRepository.findByNomCosmetiqueContains(nom);
	}

	@Override
	public List<Cosmetique> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return cosmetiqueRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Cosmetique> findByCategorie(Classification classification) {
		// TODO Auto-generated method stub
		return cosmetiqueRepository.findByClassfication(classification);
	}

	@Override
	public List<Cosmetique> findByClassificationIdClas(Long id) {
		// TODO Auto-generated method stub
		return cosmetiqueRepository.findByclassificationIdClas(id);
	}

	@Override
	public List<Cosmetique> findByOrderByNomCosmetiqueAsc() {
		// TODO Auto-generated method stub
		return cosmetiqueRepository.findByOrderByNomCosmetiqueAsc();
	}

	@Override
	public List<Cosmetique> trierCosmetiquesNomsPrix() {
		// TODO Auto-generated method stub
		return cosmetiqueRepository.trierCosmetiquesNomsPrix();
	}

	

	@Override
	public List<Classification> getAllClassifications() {
		
		return classificationRepository.findAll();
	}

}
