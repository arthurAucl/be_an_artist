package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Polygone;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VuePolygoneTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VuePolygoneTest();
			}
		});
	}
	
	public VuePolygoneTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VuePolygoneTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(250,250);
		Polygone po1 = new Polygone(p1,400,5,0);
		po1.setCouleur(Color.CYAN);
		po1.setRempli(true);
		VuePolygone vpo1 = new VuePolygone(po1);
		pd.ajouterVueForme(vpo1);
		

		Coordonnees p2 = new Coordonnees(150,450);
		Polygone po2 = new Polygone(p2,100,8,0);
		po2.setCouleur(Color.black);
		po2.setRempli(true);
		VuePolygone vpo2 = new VuePolygone(po2);
		pd.ajouterVueForme(vpo2);
		
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
