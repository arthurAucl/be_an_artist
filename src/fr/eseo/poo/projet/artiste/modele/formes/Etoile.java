package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Etoile extends Forme implements Remplissable{
	
	public static final int NOMBRE_BRANCHES_PAR_DEFAUT = 5;
	public static final double ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT = 0;
	public static final double LONGUEUR_BRANCHE_PAR_DEFAUT = 0.5;
	
	public int nbBranches;
	public double longueur;
	public double angle;
	
	private List<Coordonnees> coordonnees = new ArrayList <Coordonnees>();
	private List<Ligne> lignes = new ArrayList <Ligne>();
	private int compteur;
	private boolean remplissage;
	
	public Etoile(Coordonnees coordonnees, double taille, int nombreBranches, double anglePremiere, double longueurBranche) {
		this.setPosition(coordonnees);
		this.setHauteur(taille);
		this.setLargeur(taille);
		this.setNombreBranches(nombreBranches);
		this.setAnglePremiereBranche(anglePremiere);
		this.setLongueurBranche(longueurBranche);
	}
	
	public Etoile(){
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, 
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(double taille) {
		this(new Coordonnees(), taille, NOMBRE_BRANCHES_PAR_DEFAUT, 
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees) {
		this(coordonnees, LARGEUR_PAR_DEFAUT, NOMBRE_BRANCHES_PAR_DEFAUT, 
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
	}
	
	public Etoile(Coordonnees coordonnees, double taille) {
		this(coordonnees, taille, NOMBRE_BRANCHES_PAR_DEFAUT, 
				ANGLE_PREMIERE_BRANCHE_PAR_DEFAUT, LONGUEUR_BRANCHE_PAR_DEFAUT);
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
	
	public void setNombreBranches(int nbBranches) {
		if(nbBranches<3 || nbBranches>15) {
			throw new IllegalArgumentException("Le nombre de branches doit etre compris entre 3 et 15");
		}
		this.nbBranches = nbBranches;
	}
	
	public void setLongueurBranche(double longueur) {
		if(longueur<0 || longueur>1) {
			throw new IllegalArgumentException("La longueur des branches doivent etre comprises entre 0 et 1");
		}
		this.longueur = longueur;
	}
	
	public void setAnglePremiereBranche(double angle) {
		if(angle<-Math.PI || angle>Math.PI) {
			throw new IllegalArgumentException("L'angle doit etre compris entre pi et -pi");
		}
		this.angle = angle;
	}
	
	
	public List<Coordonnees> getCoordonnees() {
		double x0 = (this.getCadreMaxX() + this.getCadreMinX())/2;
		double y0 = (this.getCadreMaxY() + this.getCadreMinY())/2;
		Coordonnees centre = new Coordonnees(x0,y0);
		
		double rayonExt = this.getLargeur()/2;
		double rayonInt = (1-getLongueurBranche()) * rayonExt;
		
		for(int i = 0; i<this.getNombreBranches(); i++) {
			double angleSuivant = i * 2 * Math.PI/getNombreBranches();
			
			double xExt = centre.getAbscisse() + rayonExt * Math.cos(this.getAnglePremiereBranche() + angleSuivant);
			double yExt = centre.getOrdonnee() + rayonExt * Math.sin(this.getAnglePremiereBranche() + angleSuivant);
			Coordonnees sommetExt = new Coordonnees(xExt,yExt);
			
			double angleDebut = this.getAnglePremiereBranche() + Math.PI/getNombreBranches();
			
			double xInt = centre.getAbscisse() + rayonInt * Math.cos(angleDebut + angleSuivant);
			double yInt = centre.getOrdonnee() + rayonInt * Math.sin(angleDebut + angleSuivant);
			Coordonnees sommetInt = new Coordonnees(xInt,yInt);
			
			this.coordonnees.add(sommetExt);
			this.coordonnees.add(sommetInt);
		}
		return this.coordonnees;
	}
	
	public int getNombreBranches() {
		return this.nbBranches;
	}
	
	public double getLongueurBranche() {
		return this.longueur;
	}
	
	public double getAnglePremiereBranche() {
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
		
		return "[Etoile" + rempli + "] : pos " + super.getPosition().toString() + " dim " + df.format(super.getLargeur()) 
				+ " x " + df.format(super.getHauteur()) + " périmètre : " + df.format(this.perimetre()) + " aire : " 
				+ df.format(this.aire()) + " couleur = R" + this.getCouleur().getRed() + "," + voug 
				+ this.getCouleur().getGreen() + ",B" + this.getCouleur().getBlue();
		
	}
	
	public double aire() {
		double rayon1 = this.getLargeur()/2;
		double rayon2 = (1-getLongueurBranche()) * rayon1;
		Coordonnees a = this.getCoordonnees().get(1);
		Coordonnees b = this.getCoordonnees().get(3);
		double distanceAb = a.distanceVers(b);
		double perim1 = 0.5 * distanceAb * (rayon1 - rayon2) * this.getNombreBranches();
		double perim2 = 0.5 * distanceAb * rayon2 * this.getNombreBranches();
		return perim1 + perim2;
	}
	
	public double perimetre() {
		Coordonnees a = this.getCoordonnees().get(0);
		Coordonnees b = this.getCoordonnees().get(1);
		double distanceAb = a.distanceVers(b);
		return distanceAb * this.getNombreBranches() * 2;	
	}
	
	public List<Ligne> getLignes() {
		for(int i = 0; i<this.getNombreBranches() * 2; i++) {
			Coordonnees point = this.getCoordonnees().get(i);
			double largeurL = this.getCoordonnees().get(i+1).getAbscisse() - point.getAbscisse();
			double hauteurH = this.getCoordonnees().get(i+1).getOrdonnee() - point.getOrdonnee();
			Ligne ligne = new Ligne(point, largeurL, hauteurH);
			this.lignes.add(ligne);
		}
		return this.lignes;
	}
	
	public boolean contient(Coordonnees coordonnees) {
		Coordonnees pointExt = new Coordonnees(super.getPosition().getAbscisse(), super.getPosition().getOrdonnee());
		double largeur = coordonnees.getAbscisse() - pointExt.getAbscisse();
		double hauteur = coordonnees.getOrdonnee() - pointExt.getOrdonnee();
		Ligne ligneTest = new Ligne(pointExt, largeur, hauteur);
			
					
		for(int i = 0; i<this.getNombreBranches() * 2; i++) {
			
			
			Ligne ligneEtoile = this.getLignes().get(i);
			
			Coordonnees a = ligneTest.getC1();
			Coordonnees b = ligneTest.getC2();
			Coordonnees c = ligneEtoile.getC1();
			Coordonnees d = ligneEtoile.getC2();
			
			
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
