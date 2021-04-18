package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;
import fr.eseo.poo.projet.artiste.vue.formes.VuePolygone;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;

public class OutilPolygone extends OutilForme {

public PanneauBarreOutils barreOutil;
	
	public OutilPolygone(PanneauBarreOutils panneauBarreOutil) {
		this.barreOutil = panneauBarreOutil;
	}
	
	protected VueForme creerVueForme() {
				
		int nbBranche = barreOutil.getNbBranches();
	
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
		
		VuePolygone vp;
		
		if(super.compteur == 1) {
			
			Polygone po = new Polygone(p);
			vp = new VuePolygone(po);
			po.setCouleur(this.getPanneauDessin().getCouleurCourante());
			po.setRempli(this.getPanneauDessin().getModeRemplissage());
			super.compteur = 0;
			
			
		}
		else {
			Polygone e = new Polygone(p2, 2*distance, nbBranche, angle);
			vp = new VuePolygone(e);
			e.setCouleur(this.getPanneauDessin().getCouleurCourante());
			e.setRempli(this.getPanneauDessin().getModeRemplissage());
		}
		return vp;
	}

}

