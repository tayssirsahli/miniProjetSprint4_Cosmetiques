package com.tayssir.cosmetiques.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Cosmetique {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCosmetique;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomCosmetique;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixCosmetique;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	
	
	@ManyToOne
	private Classification classification;
	
	
	public Cosmetique() {
	
	}




	public Cosmetique(String nomCosmetique, Double prixCosmetique, Date dateCreation) {
		
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
	


	public Classification getClassification() {
		return classification;
	}


	public void setClassification(Classification classification) {
		this.classification = classification;
	}


	@Override
	public String toString() {
		return "Cosmetique [idCosmetique=" + idCosmetique + ", nomCosmetique=" + nomCosmetique + ", prixCosmetique="
				+ prixCosmetique + ", dateCreation=" + dateCreation + "]";
	}
	
	
	


}
