package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEtoileTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VueEtoileTest();
			}
		});
	}
	
	public VueEtoileTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VueEtoileTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(250,250);
		Etoile e1 = new Etoile(p1,400,5,0,0.5);
		e1.setCouleur(Color.CYAN);
		e1.setRempli(true);
		VueEtoile ve1 = new VueEtoile(e1);
		pd.ajouterVueForme(ve1);
		

		Coordonnees p2 = new Coordonnees(350,450);
		Etoile e2 = new Etoile(p2,100,14,0,0.3);
		e2.setCouleur(Color.black);
		e2.setRempli(true);
		VueEtoile ve2 = new VueEtoile(e2);
		pd.ajouterVueForme(ve2);
		
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
