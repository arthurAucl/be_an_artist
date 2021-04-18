package fr.eseo.poo.projet.artiste.controleur.outils;

import static java.lang.Math.abs;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueRectangle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilRectangle extends OutilForme{
	
	protected VueForme creerVueForme() {
		VueRectangle vr;
		Rectangle r = new Rectangle(getDebut());
		
		double fa = this.getFin().getAbscisse();
		double fo = this.getFin().getOrdonnee();
		double da = this.getDebut().getAbscisse();
		double dor = this.getDebut().getOrdonnee();
		double largeur = fa - da;
		double hauteur = fo - dor;
		
		Coordonnees p = new Coordonnees(this.getDebut().getAbscisse(), this.getDebut().getOrdonnee());
		
		if((largeur > 0) && (hauteur > 0)) {
			
			r = new Rectangle(p, abs(largeur), abs(hauteur));
			r.setCouleur(this.getPanneauDessin().getCouleurCourante());
			r.setRempli(this.getPanneauDessin().getModeRemplissage());
			vr = new VueRectangle(r);
			
		}
		
		else if((largeur > 0) && (hauteur < 0)) {
			
			Coordonnees p2 = new Coordonnees(p.getAbscisse(), p.getOrdonnee() - abs(hauteur));
			r = new Rectangle(p2, abs(largeur), abs(hauteur));
			r.setCouleur(this.getPanneauDessin().getCouleurCourante());
			r.setRempli(this.getPanneauDessin().getModeRemplissage());
			vr = new VueRectangle(r);
			
		}

		else if((largeur < 0) && (hauteur > 0)) {
	
			Coordonnees p2 = new Coordonnees(p.getAbscisse() - abs(largeur), p.getOrdonnee());
			r = new Rectangle(p2, abs(largeur), abs(hauteur));
			r.setCouleur(this.getPanneauDessin().getCouleurCourante());
			r.setRempli(this.getPanneauDessin().getModeRemplissage());
			vr = new VueRectangle(r);
	
		}

		else {
			
			Coordonnees p2 = new Coordonnees(p.getAbscisse() - abs(largeur), p.getOrdonnee() - abs(hauteur));
			r = new Rectangle(p2, abs(largeur), abs(hauteur));
			r.setCouleur(this.getPanneauDessin().getCouleurCourante());
			r.setRempli(this.getPanneauDessin().getModeRemplissage());
			vr = new VueRectangle(r);
	
		}
			
		return vr;
	}
	
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}

}
