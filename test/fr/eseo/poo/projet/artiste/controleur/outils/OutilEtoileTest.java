package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEtoileTest {


	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OutilEtoileTest();
			}
		});
	}
		
	public OutilEtoileTest(){
		this.test();
	}
		
	@Test
	private void test() {
		JFrame f = new JFrame();
		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutil = new PanneauBarreOutils(panneau);
		OutilEtoile outil = new OutilEtoile(panneauBarreOutil);
		panneau.associerOutil(outil);
		f.add(panneau);
		f.setSize(new Dimension(700, 600));
		f.setTitle("VueEtoileTest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
		
}
