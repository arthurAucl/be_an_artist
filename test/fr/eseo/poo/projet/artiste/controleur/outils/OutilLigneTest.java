package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

import org.junit.Test;

public class OutilLigneTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OutilLigneTest();
			}
		});
	}
	
	public OutilLigneTest(){
		this.test();
	}
	
	@Test
	private void test() {
		JFrame f = new JFrame();
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outil = new OutilLigne();
		panneau.associerOutil(outil);
		f.add(panneau);
		f.setSize(new Dimension(700, 600));
		f.setTitle("VueLigneTest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
