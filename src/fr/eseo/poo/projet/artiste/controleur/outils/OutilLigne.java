package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.formes.VueLigne;

public class OutilLigne extends OutilForme {
	
	protected VueForme creerVueForme() {
		Ligne l = new Ligne(getDebut());
		l.setC2(getFin());
		l.setCouleur(this.getPanneauDessin().getCouleurCourante());
		VueLigne vueLigne = new VueLigne(l);
		return vueLigne;
	}
}