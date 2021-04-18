package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Carre extends Rectangle implements Remplissable{
	
private boolean remplissage;
	
	public Carre(Coordonnees coordonnees, double taille) {
		super.setPosition(coordonnees);
		super.setLargeur(taille);
		super.setHauteur(taille);
	}
	
	public Carre() {
		super(new Coordonnees(), LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}	
	
	public Carre(double taille) {
		super(new Coordonnees(), taille, taille);
	}
	
	public Carre(Coordonnees coordonnees) {
		super(coordonnees, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public double getTaille() {
		return super.getLargeur();
	}
	
	public void setTaille(double taille) {
		super.setLargeur(taille);
		super.setHauteur(taille);
	}
	
	public void setLargeur(double largeur) {
		this.setTaille(largeur);
	}
	
	public void setHauteur(double hauteur) {
		this.setTaille(hauteur);
	}
	
	public String toString() {
		return super.toString();
	}
	
	public double perimetre() {
		return super.perimetre();
	}
	
	public boolean estRempli() {
		return remplissage;
	}
	
	public void setRempli(boolean bool) {
		this.remplissage = bool;
	}

}
