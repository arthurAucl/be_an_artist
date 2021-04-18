package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

public class VueEtoile extends VueForme{

	private Color couleurCourante;
	private Etoile etoile;
	
	public VueEtoile(Etoile etoile) {
		super(etoile);
		this.etoile = etoile;
	}
			
	public void affiche(Graphics2D g2d) {
		int x[] = new int[etoile.getCoordonnees().size()];
		int y[] = new int[etoile.getCoordonnees().size()];
		
		for(int i=etoile.getNombreBranches() * 2 - 1 ; i>=0; i--) {
			x[i] = (int)Math.round(etoile.getCoordonnees().get(i).getAbscisse());
			y[i] = (int)Math.round(etoile.getCoordonnees().get(i).getOrdonnee());
		}
		
		this.couleurCourante = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		g2d.drawPolygon(x,y,etoile.getNombreBranches() * 2);
		if(etoile.estRempli()) {
			g2d.fillPolygon(x,y,etoile.getNombreBranches() * 2);
		}
		g2d.setColor(couleurCourante);

	}
}
