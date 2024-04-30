package com.tayssir.cosmetiques.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tayssir.cosmetiques.entities.Classification;
import com.tayssir.cosmetiques.entities.Cosmetique;

@RepositoryRestResource(path = "rest")
public interface CosmetiqueRepository extends JpaRepository<Cosmetique, Long> {

	List<Cosmetique> findByNomCosmetique(String nom);
	 List<Cosmetique> findByNomCosmetiqueContains(String nom); 
		/*
		 * @Query("select c from Cosmetique c where c.nomCosmetique like %?1 and c.prixCosmetique> ?2"
		 * ) List<Cosmetique> findByNomPrix (String nom, Double prix);
		 */
	 
	 @Query("select c from Cosmetique c where c.nomCosmetique like %:nom and c.prixCosmetique> %:prix")
	 List<Cosmetique> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 
	 @Query("select c from Cosmetique c where c.classification = ?1")
	 List<Cosmetique> findByClassfication(Classification clas);
	 
	 
	 List<Cosmetique> findByclassificationIdClas(Long id);
	 
	 List<Cosmetique> findByOrderByNomCosmetiqueAsc();
	 
	 @Query("select p from Cosmetique p order by p.nomCosmetique ASC, p.prixCosmetique ASC")
	 List<Cosmetique> trierCosmetiquesNomsPrix ();


}
