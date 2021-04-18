package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissageTest {
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ActionChoisirRemplissageTest();
			}
		});
	}
	
	public ActionChoisirRemplissageTest(){
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
		f.setTitle("ActionRemplissageTest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

}
