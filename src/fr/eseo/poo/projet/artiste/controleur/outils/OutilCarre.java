package fr.eseo.poo.projet.artiste.controleur.outils;

import static java.lang.Math.abs;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme{
	
	protected VueForme creerVueForme() {
		VueCarre vc;
		Carre c = new Carre(getDebut());
	
		double fa = this.getFin().getAbscisse();
		double fo = this.getFin().getOrdonnee();
		double da = this.getDebut().getAbscisse();
		double dor = this.getDebut().getOrdonnee();
		double largeur = fa - da;
		double hauteur = fo - dor;
		double taille = Math.max(abs(largeur), abs(hauteur));
	
		Coordonnees p = new Coordonnees(this.getDebut().getAbscisse(), this.getDebut().getOrdonnee());
		
		if((largeur > 0) && (hauteur > 0)) {
		
			c = new Carre(p, abs(taille));
			c.setCouleur(this.getPanneauDessin().getCouleurCourante());
			c.setRempli(this.getPanneauDessin().getModeRemplissage());
			vc = new VueCarre(c);
		
		}
	
		else if((largeur > 0) && (hauteur < 0)) {
		
			Coordonnees p2 = new Coordonnees(p.getAbscisse(), p.getOrdonnee() - abs(taille));
			c = new Carre(p2, abs(taille));
			c.setCouleur(this.getPanneauDessin().getCouleurCourante());
			c.setRempli(this.getPanneauDessin().getModeRemplissage());
			vc = new VueCarre(c);
		
		}

		else if((largeur < 0) && (hauteur > 0)) {

			Coordonnees p2 = new Coordonnees(p.getAbscisse() - abs(taille), p.getOrdonnee());
			c = new Carre(p2, abs(taille));
			c.setCouleur(this.getPanneauDessin().getCouleurCourante());
			c.setRempli(this.getPanneauDessin().getModeRemplissage());
			vc = new VueCarre(c);

		}

		else {
		
			Coordonnees p2 = new Coordonnees(p.getAbscisse() - abs(taille), p.getOrdonnee() - abs(taille));
			c = new Carre(p2, abs(taille));
			c.setCouleur(this.getPanneauDessin().getCouleurCourante());
			c.setRempli(this.getPanneauDessin().getModeRemplissage());
			vc = new VueCarre(c);

		}
		
		return vc;
	}
	
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}

}
