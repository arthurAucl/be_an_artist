package fr.eseo.poo.projet.artiste.modele.formes;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import static java.lang.Math.toDegrees;

import java.text.DecimalFormat;
import java.util.Locale;

public class Ligne extends Forme {
		
	public static final double EPSILON = 0.1;
	
	public Ligne() {
		super();
	}
	
	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}
	
	public Ligne(Coordonnees coordonnees) {
		super(coordonnees);
		
	}
	
	public Ligne(Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
	}
	
	public Coordonnees getC1() {
		return this.getPosition();
	}
	
	public Coordonnees getC2() {
		double x = this.getPosition().getAbscisse() + getLargeur();
		double y = this.getPosition().getOrdonnee() + getHauteur();
		return new Coordonnees(x, y);
	}
	
	public void setC1 (Coordonnees coordonnees) {
		Coordonnees temp = this.getC2();
		this.setPosition(coordonnees);
		this.setC2(temp);
	}
	
	public void setC2 (Coordonnees coordonnees) {
		this.setLargeur(coordonnees.getAbscisse() - this.getPosition().getAbscisse());
		this.setHauteur(coordonnees.getOrdonnee() - this.getPosition().getOrdonnee());
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("#0.0#");
		df.setMaximumFractionDigits(2);
		double angle = toDegrees(this.getC1().angleVers(this.getC2()));
		angle += 360; 
		angle = angle%360;
		
		String voug ="";
		if(Locale.getDefault().getLanguage().equals("fr")) {
			voug = "V";
		}
		else {
			voug = "G";
		}
			
		return ("[Ligne] c1 : " + this.getC1().toString() + " c2 : " + this.getC2().toString() + 
				" longueur : " + df.format(this.perimetre()) + " angle : " + df.format(angle) + 
				"° couleur = R" + this.getCouleur().getRed() + "," + voug + this.getCouleur().getGreen() + 
				",B" + this.getCouleur().getBlue());
	}
		
	public double aire() {
		return 0;	
	}
	
	public double perimetre() {
		return this.getPosition().distanceVers(this.getC2());
		
	}
	
	public boolean contient(Coordonnees point) {
		return ((this.getC1().distanceVers(point) + point.distanceVers(this.getC2()) 
		- this.getC1().distanceVers(this.getC2()))<EPSILON);
	}	
}
