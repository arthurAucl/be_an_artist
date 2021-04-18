package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

import java.text.DecimalFormat;
import java.util.Locale;

public class Ellipse extends Forme implements Remplissable{
	
	private boolean remplissage;
	
	public Ellipse(Coordonnees coordonnees, double largeur, double hauteur) {
		this.setPosition(coordonnees);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
	}
	
	public Ellipse() {
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);

	}
	
	public Ellipse(Coordonnees coordonnees) {
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
			type = "Cercle";
		}
		else {
			type = "Ellipse";
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
		return Math.PI * 0.25 * this.getLargeur() * this.getHauteur();
	}
	
	public double perimetre() {
		double a = (Math.min(super.getLargeur(), super.getHauteur()))/2;
		double b = (Math.max(super.getLargeur(), super.getHauteur()))/2;
		double h = Math.pow(((a-b)/(a+b)),2);
		return Math.PI * (a + b) * (1 + ((3 * h)/(10 + Math.sqrt(4 - 3 * h))));
	}
	
	public boolean contient(Coordonnees point) {
		double x = point.getAbscisse();
		double y = point.getOrdonnee();
		double a = super.getLargeur()/2;
		double b = super.getHauteur()/2;
		double u = super.getPosition().getAbscisse() + super.getLargeur()/2;
		double v = super.getPosition().getOrdonnee() + super.getHauteur()/2;
		return((Math.pow((x - u), 2)/Math.pow(a, 2)) + ((Math.pow((y-v), 2)/Math.pow(b, 2)))<=1);
		
	}

	public boolean estRempli() {
		return remplissage;
	}
	
	public void setRempli(boolean bool) {
		this.remplissage = bool;
	}
}
