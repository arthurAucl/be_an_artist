package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class VueEllipseTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VueEllipseTest();
			}
		});
	}
	
	public VueEllipseTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VueEllipseTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(250,250);
		Ellipse e1 = new Ellipse(p1,100,50);
		e1.setCouleur(Color.CYAN);
		e1.setRempli(true);
		VueEllipse ve1 = new VueEllipse(e1);
		pd.ajouterVueForme(ve1);
		
		Coordonnees p2 = new Coordonnees(450,150);
		Ellipse e2 = new Ellipse(p2,50,400);
		e2.setCouleur(Color.GREEN);
		e2.setRempli(true);
		VueEllipse ve2 = new VueEllipse(e2);
		pd.ajouterVueForme(ve2);
		
		Coordonnees p3 = new Coordonnees(450,150);
		Ellipse e3 = new Ellipse(p3,300,100);
		e3.setCouleur(Color.black);
		e3.setRempli(false);
		VueEllipse ve3 = new VueEllipse(e3);
		pd.ajouterVueForme(ve3);
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
