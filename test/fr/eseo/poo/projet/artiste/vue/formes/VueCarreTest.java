package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Carre;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VueCarreTest();
			}
		});
	}
	
	public VueCarreTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VueCarreTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(250,250);
		Carre c1 = new Carre(p1,300);
		c1.setCouleur(Color.RED);
		c1.setRempli(true);
		VueCarre vc1 = new VueCarre(c1);
		pd.ajouterVueForme(vc1);
		
		Coordonnees p2 = new Coordonnees(450,150);
		Carre c2 = new Carre(p2,40);
		c2.setCouleur(Color.YELLOW);
		c2.setRempli(true);
		VueCarre vc2 = new VueCarre(c2);
		pd.ajouterVueForme(vc2);
		
		Coordonnees p3 = new Coordonnees(50,150);
		Carre c3 = new Carre(p3,100);
		c3.setCouleur(Color.black);
		c3.setRempli(false);
		VueCarre vc3 = new VueCarre(c3);
		pd.ajouterVueForme(vc3);
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
