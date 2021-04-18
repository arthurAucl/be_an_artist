package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Polygone extends Forme implements Remplissable {

	public static final int NOMBRE_SOMMET_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIER_SOMMET_PAR_DEFAUT = 0;
	
	public int nbSommet;
	public double longueur;
	public double angle;
	
	private List<Coordonnees> coordonnees = new ArrayList <Coordonnees>();
	private List<Ligne> lignes = new ArrayList <Ligne>();
	private int compteur;
	private boolean remplissage;
	
	public Polygone(Coordonnees coordonnees, double taille, int nombreSommet, double anglePremier) {
		this.setPosition(coordonnees);
		this.setHauteur(taille);
		this.setLargeur(taille);
		this.setNombreSommet(nombreSommet);
		this.setAnglePremierSommet(anglePremier);
	}
	
	public Polygone(){
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, NOMBRE_SOMMET_PAR_DEFAUT, ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(double taille) {
		this(new Coordonnees(), taille, NOMBRE_SOMMET_PAR_DEFAUT, ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, NOMBRE_SOMMET_PAR_DEFAUT, ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public Polygone(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_SOMMET_PAR_DEFAUT, ANGLE_PREMIER_SOMMET_PAR_DEFAUT);
	}
	
	public void setHauteur(double hauteur) {
		if(hauteur<0) {
			throw new IllegalArgumentException("Le ou les arguments rentrés en paramètre doivent etre positifs");
		}
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}
	
	public void setLargeur(double largeur) {
		if(largeur<0) {
			throw new IllegalArgumentException("Le ou les arguments rentrés en paramètre doivent etre positifs");
		}
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	public void setPosition(Coordonnees position) {
		super.setPosition(position);
	}
	
	public void setNombreSommet(int nbSommet) {
		if(nbSommet<3 || nbSommet>15) {
			throw new IllegalArgumentException("Le nombre de sommets doit etre compris entre 3 et 15");
		}
		this.nbSommet = nbSommet;
	}
		
	public void setAnglePremierSommet(double angle) {
		if(angle<-Math.PI || angle>Math.PI) {
			throw new IllegalArgumentException("L'angle doit etre compris entre pi et -pi");
		}
		this.angle = angle;
	}
	
	public List<Coordonnees> getCoordonnees() {
		double x0 = (this.getCadreMaxX() + this.getCadreMinX())/2;
		double y0 = (this.getCadreMaxY() + this.getCadreMinY())/2;
		Coordonnees centre = new Coordonnees(x0,y0);
		
		double rayon = this.getLargeur()/2;
		
		for(int i = 0; i<this.getNombreSommet(); i++) {
			double angleSuivant = i * 2 * Math.PI/getNombreSommet();
			double x = centre.getAbscisse() + rayon * Math.cos(this.getAnglePremierSommet() + angleSuivant);
			double y = centre.getOrdonnee() + rayon * Math.sin(this.getAnglePremierSommet() + angleSuivant);
			Coordonnees sommet = new Coordonnees(x,y);
			this.coordonnees.add(sommet);
		}
		return this.coordonnees;
	}
	
	public int getNombreSommet() {
		return this.nbSommet;
	}
	
	public double getAnglePremierSommet() {
		return this.angle;
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

		String rempli = "";
		if (estRempli()) {
			rempli = "-Rempli";
		}
		
		return "[Polygone" + rempli + "] : pos " + super.getPosition().toString() + " dim " + df.format(super.getLargeur()) 
				+ " x " + df.format(super.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : " 
				+ df.format(this.aire()) + " couleur = R" + this.getCouleur().getRed() + "," + voug 
				+ this.getCouleur().getGreen() + ",B" + this.getCouleur().getBlue();
		
	}
	
	public double perimetre() {
		Coordonnees a = this.getCoordonnees().get(0);
		Coordonnees b = this.getCoordonnees().get(1);
		double distanceAb = a.distanceVers(b);
		return distanceAb * this.getNombreSommet();	
	}
	
	public double aire() {
		double hauteur = this.getLargeur()/2;
		return 0.5 * hauteur * this.perimetre();
	}
	
	
	public boolean contient(Coordonnees coordonnees) {
		Coordonnees pointExt = new Coordonnees(super.getPosition().getAbscisse(), super.getPosition().getOrdonnee());
		double largeur = coordonnees.getAbscisse() - pointExt.getAbscisse();
		double hauteur = coordonnees.getOrdonnee() - pointExt.getOrdonnee();
		Ligne ligneTest = new Ligne(pointExt, largeur, hauteur);
			
		
		//CREATION D'UNE LISTE DE LIGNE
		
		for(int i = 0; i<this.getNombreSommet(); i++) {
			Coordonnees point = this.getCoordonnees().get(i);
			double largeurL = this.getCoordonnees().get(i+1).getAbscisse() - point.getAbscisse();
			double hauteurH = this.getCoordonnees().get(i+1).getOrdonnee() - point.getOrdonnee();
			Ligne ligne = new Ligne(point, largeurL, hauteurH);
			this.lignes.add(ligne);
		}

				
		for(int i = 0; i<this.getNombreSommet(); i++) {
			
			
			Ligne lignePoly = this.lignes.get(i);
			
			Coordonnees a = ligneTest.getC1();
			Coordonnees b = ligneTest.getC2();
			Coordonnees c = lignePoly.getC1();
			Coordonnees d = lignePoly.getC2();
			
			
			double abX = b.getAbscisse() - a.getAbscisse(); 
			double abY = b.getOrdonnee() - a.getOrdonnee();
			double acX = c.getAbscisse() - a.getAbscisse(); 
			double acY = c.getOrdonnee() - a.getOrdonnee();
			double adX = d.getAbscisse() - a.getAbscisse(); 
			double adY = d.getOrdonnee() - a.getOrdonnee();
			double caX = a.getAbscisse() - c.getAbscisse();
			double caY = a.getOrdonnee() - c.getOrdonnee();
			double cbX = b.getAbscisse() - c.getAbscisse();
			double cbY = b.getOrdonnee() - c.getOrdonnee();
			double cdX = d.getAbscisse() - c.getAbscisse();
			double cdY = d.getOrdonnee() - c.getOrdonnee();
			
//			double produitVectAbCd = abX * cdY - abY * cdX;
			double produitVectAbAd = abX * adY - abY * adX;
			double produitVectAbAc = abX * acY - abY * acX;
			double produitVectCdCb = cdX * cbY - cdY * cbX;
			double produitVectCdCa = cdX * caY - cdY * caX;
			
			
			boolean condition1 = false;
			if(produitVectAbAd * produitVectAbAc <=0) {
				condition1 = true;
			}
			
			boolean condition2 = false;
			if(produitVectCdCb * produitVectCdCa <=0) {
				condition2 = true;
			}
				
//			boolean condition3 = false;
//			if(a != b && c != d) {
//				condition3 = true;
//			}
//			
//			boolean condition4 = false;
//			if(produitVectAbCd != 0) {
//				condition4 = true;
//			}
			
			
		
			
//			if(condition1 && condition2 && condition3 && condition4 ) {
			if(condition1 && condition2) {
				compteur ++;
			}
		}
		if (compteur%2 == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean estRempli() {
		return remplissage;
	}
	
	public void setRempli(boolean bool) {
		this.remplissage = bool;
	}

}
