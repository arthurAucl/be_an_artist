package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;

import static java.lang.Math.abs;

import java.awt.event.MouseEvent;

public class OutilEllipse extends OutilForme{
	
	protected VueForme creerVueForme() {
		VueEllipse ve;
		Ellipse e = new Ellipse(getDebut());
		
		double fa = this.getFin().getAbscisse();
		double fo = this.getFin().getOrdonnee();
		double da = this.getDebut().getAbscisse();
		double dor = this.getDebut().getOrdonnee();
		double largeur = fa - da;
		double hauteur = fo - dor;
		
		Coordonnees p = new Coordonnees(this.getDebut().getAbscisse(), this.getDebut().getOrdonnee());
		
		if((largeur > 0) && (hauteur > 0)) {
			
			e = new Ellipse(p, abs(largeur), abs(hauteur));
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
			ve = new VueEllipse(e);
			
		}
		
		else if((largeur > 0) && (hauteur < 0)) {
			
			Coordonnees p2 = new Coordonnees(p.getAbscisse(), p.getOrdonnee() - abs(hauteur));
			e = new Ellipse(p2, abs(largeur), abs(hauteur));
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
			ve = new VueEllipse(e);
			
		}

		else if((largeur < 0) && (hauteur > 0)) {
	
			Coordonnees p2 = new Coordonnees(p.getAbscisse() - abs(largeur), p.getOrdonnee());
			e = new Ellipse(p2, abs(largeur), abs(hauteur));
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
			ve = new VueEllipse(e);
	
		}

		else {
			
			Coordonnees p2 = new Coordonnees(p.getAbscisse() - abs(largeur), p.getOrdonnee() - abs(hauteur));
			e = new Ellipse(p2, abs(largeur), abs(hauteur));
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
			ve = new VueEllipse(e);
	
		}
			
		return ve;
	}
	
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}
}
