package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

import java.awt.event.MouseEvent;

public abstract class OutilForme extends Outil {
	
	
	public int compteur = 0;
	
	public void mouseClicked(MouseEvent event) {
		super.setDebut(new Coordonnees(event.getX(), event.getY()));
		super.setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT, event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
		if(event.getClickCount() == 2){
			compteur = 1;
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}
	
	public void mouseReleased(MouseEvent event) {
		if(super.getDebut().getAbscisse() != event.getX() || super.getDebut().getOrdonnee() != event.getY()) {
			super.mouseReleased(event);
			super.setFin(new Coordonnees(event.getX(), event.getY()));
			super.getPanneauDessin().ajouterVueForme(this.creerVueForme());
			super.getPanneauDessin().repaint();
		}
	}	
	
	protected abstract VueForme creerVueForme();

}
