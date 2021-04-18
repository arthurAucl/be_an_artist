package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class VueEllipse extends VueForme {
	
	private Color couleurCourante;
	private Ellipse ellipse;
	
	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
		this.ellipse = ellipse;
	}
	
	public void affiche(Graphics2D g2D) {
		int x = (int) (super.getForme().getPosition().getAbscisse());
		int y = (int) (super.getForme().getPosition().getOrdonnee());
		int l = (int) (super.getForme().getLargeur());
		int h = (int) (super.getForme().getHauteur());
		
		couleurCourante = g2D.getColor();
		g2D.setColor(this.getForme().getCouleur());
		g2D.draw(new Ellipse2D.Double(x, y, l, h));
		
		if(this.ellipse.estRempli()) {
			g2D.fillOval(x, y, l, h);
		}
		g2D.setColor(couleurCourante);
	}
}
