package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Rectangle extends Forme implements Remplissable{
	
private boolean remplissage;
	
	public Rectangle(Coordonnees coordonnees, double largeur, double hauteur) {
		this.setPosition(coordonnees);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
	}
	
	public Rectangle() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Rectangle(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);

	}
	
	public Rectangle(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public void setLargeur(double largeur) {
		if(largeur<0) {
			throw new IllegalArgumentException("Le ou les arguments rentrés en paramètre doivent etre positifs");
		}
		super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		if(hauteur<0) {
			throw new IllegalArgumentException("Le ou les arguments rentrés en paramètre doivent etre positifs");
		}
		super.setHauteur(hauteur);
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.0#");
		df.setMaximumFractionDigits(2);
		
		String voug = "";		
		if(Locale.getDefault().getLanguage().equals("fr")) {
			voug = "V";
		}
		else {
			voug = "G";
		}
		
		
		String type = "";
		if (this.getLargeur() == this.getHauteur()) {
			type = "Carré";
		}
		else {
			type = "Rectangle";
		}
		
		
		String rempli = "";
		if (estRempli()) {
			rempli = "-Rempli";
		}
			
		return "["+ type + rempli + "] : pos " + super.getPosition().toString() + " dim " + df.format(super.getLargeur()) 
				+ " x " + df.format(super.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : " 
				+ df.format(this.aire()) + " couleur = R" + this.getCouleur().getRed() + "," + voug 
				+ this.getCouleur().getGreen() + ",B" + this.getCouleur().getBlue();
		
	}
	
	public double aire() {
		return this.getLargeur() * this.getHauteur();
	}
	
	public double perimetre() {
		return 2 * (this.getLargeur() + this.getHauteur());
	}
	
	public boolean contient(Coordonnees point) {
		double abscisseMin = this.getPosition().getAbscisse();
		double abscisseMax = this.getPosition().getAbscisse() + this.getLargeur();
		double ordonneesMin = this.getPosition().getOrdonnee();
		double ordonneesMax = this.getPosition().getOrdonnee() + this.getHauteur();
		return abscisseMin <= point.getAbscisse() && point.getAbscisse() <= abscisseMax
				&& ordonneesMin <= point.getOrdonnee() && point.getOrdonnee() <= ordonneesMax;	
	}

	public boolean estRempli() {
		return remplissage;
	}
	
	public void setRempli(boolean bool) {
		this.remplissage = bool;
	}
}
