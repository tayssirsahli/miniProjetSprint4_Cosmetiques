package com.tayssir.cosmetiques.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.cosmetiques.entities.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {

}
