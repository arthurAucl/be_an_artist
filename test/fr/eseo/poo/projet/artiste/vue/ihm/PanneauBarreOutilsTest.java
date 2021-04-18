package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;

public class PanneauBarreOutilsTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
	}
	
	public PanneauBarreOutilsTest(){
		this.test();
	}
	
	@Test
	private void test() {
		
		JFrame f = new JFrame();
		PanneauDessin panneau = new PanneauDessin();
		OutilLigne outil = new OutilLigne();
		PanneauBarreOutils pbo = new PanneauBarreOutils(panneau);
		panneau.associerOutil(outil);
		f.add(panneau);
		f.add(pbo, BorderLayout.EAST);
		f.setSize(new Dimension(700, 600));
		f.setTitle("PanneauBarreOutilsTest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	
	}
}
