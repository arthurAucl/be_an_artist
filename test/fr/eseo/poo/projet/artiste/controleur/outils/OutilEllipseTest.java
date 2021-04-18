package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilEllipseTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OutilEllipseTest();
			}
		});
	}
	
	public OutilEllipseTest(){
		this.test();
	}
	
	@Test
	private void test() {
		JFrame f = new JFrame();
		PanneauDessin panneau = new PanneauDessin();
		OutilEllipse outil = new OutilEllipse();
		panneau.associerOutil(outil);
		f.add(panneau);
		f.setSize(new Dimension(700, 600));
		f.setTitle("VueEllipseTest");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
