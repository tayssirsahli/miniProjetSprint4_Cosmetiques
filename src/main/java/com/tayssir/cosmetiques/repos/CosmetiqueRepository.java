package com.tayssir.cosmetiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.cosmetiques.entities.Cosmetique;

public interface CosmetiqueRepository extends JpaRepository<Cosmetique, Long> {

}
