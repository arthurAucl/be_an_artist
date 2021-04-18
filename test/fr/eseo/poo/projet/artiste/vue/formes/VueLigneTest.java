package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import java.awt.Dimension;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class VueLigneTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VueLigneTest();
			}
		});
	}
	
	public VueLigneTest() {
		this.testConstructeur();
	}
	
	@Test
	public void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("VueLigneTest");
		PanneauDessin pd = new PanneauDessin();
		
		Coordonnees p1 = new Coordonnees(50,50);
		Ligne l1 = new Ligne(p1,50,50);
		VueLigne vl1 = new VueLigne(l1);
		pd.ajouterVueForme(vl1);
		
		Coordonnees p2 = new Coordonnees(450,150);
		Ligne l2 = new Ligne(p2,5,400);
		VueLigne vl2 = new VueLigne(l2);
		pd.ajouterVueForme(vl2);
		
		Coordonnees p3 = new Coordonnees(500,50);
		Ligne l3 = new Ligne(p3,-350,450);
		VueLigne vl3 = new VueLigne(l3);
		pd.ajouterVueForme(vl3);
		
		Coordonnees p4 = new Coordonnees(100,50);
		Ligne l4 = new Ligne(p4,-500,50);
		VueLigne vl4 = new VueLigne(l4);
		pd.ajouterVueForme(vl4);
		
		
		f.add(pd);
		f.setSize(new Dimension(800,700));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);			
	}

}
