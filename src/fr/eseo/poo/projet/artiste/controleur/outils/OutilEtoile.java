package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueEtoile;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilEtoile extends OutilForme{
	
	public PanneauBarreOutils barreOutil;
	
	public OutilEtoile(PanneauBarreOutils panneauBarreOutil) {
		this.barreOutil = panneauBarreOutil;
	}
	
	protected VueForme creerVueForme() {
				
		int nbBranche = barreOutil.getNbBranches();
		double longueurBranche = barreOutil.getLongueurBranche();
	
		Coordonnees debut = super.getDebut();
		Coordonnees fin = super.getFin();
		
		double distance = fin.distanceVers(debut);
		double angle = fin.angleVers(debut);
		
		if(angle>Math.PI) {
			angle += 2*Math.PI;
		}
		if(angle<-Math.PI) {
			angle -= 2*Math.PI;
		}
		
		
		Coordonnees p = new Coordonnees(fin.getAbscisse() - distance/Math.sqrt(2), fin.getOrdonnee() - distance/Math.sqrt(2));
		Coordonnees p2 = new Coordonnees(fin.getAbscisse() - distance, fin.getOrdonnee() - distance);
		
		VueEtoile ve;
		
		if(super.compteur == 1) {
			
			Etoile e = new Etoile(p);
			ve = new VueEtoile(e);
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
			super.compteur = 0;
			
			
		}
		else {
			Etoile e = new Etoile(p2, 2*distance, nbBranche, angle, longueurBranche);
			ve = new VueEtoile(e);
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
		}
		return ve;
	}

}
