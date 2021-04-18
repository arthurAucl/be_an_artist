package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Dimension;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class VueCercleTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VueCercleTest();
			}
		});
	}
	
	public VueCercleTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VueCercleTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(250,250);
		Cercle c1 = new Cercle(p1,300);
		c1.setCouleur(Color.RED);
		c1.setRempli(true);
		VueCercle vc1 = new VueCercle(c1);
		pd.ajouterVueForme(vc1);
		
		Coordonnees p2 = new Coordonnees(450,150);
		Cercle c2 = new Cercle(p2,40);
		c2.setCouleur(Color.YELLOW);
		c2.setRempli(true);
		VueEllipse vc2 = new VueCercle(c2);
		pd.ajouterVueForme(vc2);
		
		Coordonnees p3 = new Coordonnees(50,150);
		Cercle c3 = new Cercle(p3,100);
		c3.setCouleur(Color.black);
		c3.setRempli(false);
		VueCercle vc3 = new VueCercle(c3);
		pd.ajouterVueForme(vc3);
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
