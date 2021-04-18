package fr.eseo.poo.projet.artiste.vue.ihm;

import org.junit.Test;

import java.awt.Color;
import java.awt.Dimension;


import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class PanneauDessinTest {

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PanneauDessinTest();
			}
		});
	}
	
	public PanneauDessinTest(){
		this.testConstructeurParDefaut();
		this.testConstructeur();
	}
	
	@Test
	private void testConstructeurParDefaut() {
		JFrame f = new JFrame();
		f.setTitle("Etre un Artiste");
		f.add(new PanneauDessin());
		f.setSize(new Dimension(700, 500));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);		
	}
	
	@Test
	private void testConstructeur() {
		JFrame f = new JFrame();
		f.setTitle("Blues du Businessman");
		f.add(new PanneauDessin(500, 400, Color.MAGENTA));
		f.setSize(new Dimension(700, 500));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);	
		
	}

}
