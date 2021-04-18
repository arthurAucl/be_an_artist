package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme {
	
	private Color couleurCourante;
	private Rectangle rectangle;
	
	public VueRectangle(Rectangle rectangle) {
		super(rectangle);
		this.rectangle = rectangle;
	}
	
	public void affiche(Graphics2D g2D) {
		int x = (int) (super.getForme().getPosition().getAbscisse());
		int y = (int) (super.getForme().getPosition().getOrdonnee());
		int l = (int) (super.getForme().getLargeur());
		int h = (int) (super.getForme().getHauteur());
		
		couleurCourante = g2D.getColor();
		g2D.setColor(this.getForme().getCouleur());
		g2D.drawRect(x, y, l, h);
		
		if(this.rectangle.estRempli()) {
			g2D.fillRect(x, y, l, h);
		}
		g2D.setColor(couleurCourante);
	}
	
	

}
