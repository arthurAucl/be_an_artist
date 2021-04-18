package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Polygone;

public class VuePolygone extends VueForme{
	
	private Color couleurCourante;
	private Polygone polygone;
	
	public VuePolygone(Polygone polygone) {
		super(polygone);
		this.polygone = polygone;
	}
			
	public void affiche(Graphics2D g2d) {
		int x[] = new int[polygone.getCoordonnees().size()];
		int y[] = new int[polygone.getCoordonnees().size()];
		
		for(int i=polygone.getNombreSommet() - 1 ; i>=0; i--) {
			x[i] = (int)Math.round(polygone.getCoordonnees().get(i).getAbscisse());
			y[i] = (int)Math.round(polygone.getCoordonnees().get(i).getOrdonnee());
		}
		
		this.couleurCourante = g2d.getColor();
		g2d.setColor(this.getForme().getCouleur());
		g2d.drawPolygon(x,y,polygone.getNombreSommet());
		if(polygone.estRempli()) {
			g2d.fillPolygon(x,y,polygone.getNombreSommet());
		}
		g2d.setColor(couleurCourante);

	}
}
