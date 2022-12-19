package rest.entities;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
//@XmlRootElement

@ApiModel(description = "Entité Enregistrée dans SWAGGER")
public class Employe {
	
	private String cin;
	private String nom;
	private String prenom;
	
	public Employe() {
		super();
	}
	
	public Employe(String cin, String nom, String prenom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
	}
	@ApiModelProperty(value ="unique CIN")
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	@ApiModelProperty(value="get nom")
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cin, nom, prenom);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		return Objects.equals(cin, other.cin) && Objects.equals(nom, other.nom) && Objects.equals(prenom, other.prenom);
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	

}
