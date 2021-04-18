package fr.eseo.poo.projet.artiste.vue.formes;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

import java.awt.Color;
import java.awt.Graphics2D;

public class VueLigne extends VueForme  {
	
	private Color couleurCourante;
		
	public VueLigne(Ligne ligne) {
		super(ligne);
	}
	
	public void affiche(Graphics2D g2D) {
		int x1 = (int) (super.getForme().getPosition().getAbscisse());
		int y1 = (int) (super.getForme().getPosition().getOrdonnee());
		int x2 = (int) (super.getForme().getPosition().getAbscisse() + super.getForme().getLargeur());
		int y2 = (int) (super.getForme().getPosition().getOrdonnee() + super.getForme().getHauteur());
		couleurCourante = g2D.getColor();
		g2D.setColor(this.getForme().getCouleur());
		g2D.drawLine(x1, y1, x2, y2);
		g2D.setColor(couleurCourante);
		
		
		
		
	}
}
