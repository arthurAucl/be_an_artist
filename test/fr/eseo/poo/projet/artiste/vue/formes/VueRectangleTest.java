package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VueRectangleTest();
			}
		});
	}
	
	public VueRectangleTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VueRectangleTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(250,250);
		Rectangle r1 = new Rectangle(p1,100,50);
		r1.setCouleur(Color.CYAN);
		r1.setRempli(true);
		VueRectangle vr1 = new VueRectangle(r1);
		pd.ajouterVueForme(vr1);
		
		Coordonnees p2 = new Coordonnees(450,150);
		Rectangle r2 = new Rectangle(p2,50,400);
		r2.setCouleur(Color.GREEN);
		r2.setRempli(true);
		VueRectangle vr2 = new VueRectangle(r2);
		pd.ajouterVueForme(vr2);
		
		Coordonnees p3 = new Coordonnees(450,150);
		Rectangle r3 = new Rectangle(p3,300,100);
		r3.setCouleur(Color.black);
		r3.setRempli(false);
		VueRectangle vr3 = new VueRectangle(r3);
		pd.ajouterVueForme(vr3);
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
