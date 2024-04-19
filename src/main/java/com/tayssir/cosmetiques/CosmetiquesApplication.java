package com.tayssir.cosmetiques;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tayssir.cosmetiques.entities.Cosmetique;
import com.tayssir.cosmetiques.service.CosmetiqueService;

@SpringBootApplication
public class CosmetiquesApplication implements CommandLineRunner  {

	@Autowired
	CosmetiqueService cosmetiqueService;
	
	public static void main(String[] args) {
		SpringApplication.run(CosmetiquesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cosmetiqueService.saveCosmetique(new Cosmetique("parfum ", 600.0, new Date()));
		cosmetiqueService.saveCosmetique(new Cosmetique("vernis", 28.0, new Date()));
		cosmetiqueService.saveCosmetique(new Cosmetique("teint", 9.0, new Date()));
		
	}

}
