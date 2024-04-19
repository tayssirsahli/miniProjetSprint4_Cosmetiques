package com.tayssir.cosmetiques.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cosmetique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCosmetique;
	private String nomCosmetique;
	private Double prixCosmetique;
	private Date dateCreation;
	
	
	public Cosmetique() {
		super();
	}


	public Cosmetique( String nomCosmetique, Double prixCosmetique, Date dateCreation) {
		super();
		this.nomCosmetique = nomCosmetique;
		this.prixCosmetique = prixCosmetique;
		this.dateCreation = dateCreation;
	}


	public Long getIdCosmetique() {
		return idCosmetique;
	}


	public void setIdCosmetique(Long idCosmetique) {
		this.idCosmetique = idCosmetique;
	}


	public String getNomCosmetique() {
		return nomCosmetique;
	}


	public void setNomCosmetique(String nomCosmetique) {
		this.nomCosmetique = nomCosmetique;
	}


	public Double getPrixCosmetique() {
		return prixCosmetique;
	}


	public void setPrixCosmetique(Double prixCosmetique) {
		this.prixCosmetique = prixCosmetique;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	@Override
	public String toString() {
		return "Cosmetique [idCosmetique=" + idCosmetique + ", nomCosmetique=" + nomCosmetique + ", prixCosmetique="
				+ prixCosmetique + ", dateCreation=" + dateCreation + "]";
	}
	
	
	


}
