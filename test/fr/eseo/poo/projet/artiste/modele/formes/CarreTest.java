package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CarreTest {

	private static final double EPSILON = 0.5;

	@Test
	public void testCarre() {
		Carre c1 = new Carre();
		assertEquals("test abscisse", 0, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, c1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testCarre2() {
		Carre c1 = new Carre(15);
		assertEquals("test abscisse", 0, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, c1.getHauteur(), EPSILON);	
	}
	
	@Test
	public void testCarre3() {
		Coordonnees p1 = new Coordonnees(3,5);
		Carre c1 = new Carre(p1);
		assertEquals("test abscisse", 3, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, c1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testCarre4() {
		Coordonnees p1 = new Coordonnees(3,5);
		Carre c1 = new Carre(p1,15);
		assertEquals("test abscisse", 3, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, c1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testCarreTailleNegative() {
		Carre c1 = new Carre();
		try {
			c1.setTaille(-10);
		}
		catch(Exception c) {
			assertTrue(c.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testGetTaille() {
		Carre c1 = new Carre(15);
		assertEquals("test hauteur", 15, c1.getTaille(), EPSILON);
	}
	
	@Test
	public void testSetHauteur() {
		Carre c1 = new Carre(15);
		c1.setHauteur(20);
		assertEquals("test hauteur", 20, c1.getHauteur(), EPSILON);
		assertEquals("test largeur", 20, c1.getLargeur(), EPSILON);
	}
	
	@Test
	public void testSetLargeur() {
		Carre c1 = new Carre(15);
		c1.setLargeur(20);
		assertEquals("test hauteur", 20, c1.getHauteur(), EPSILON);
		assertEquals("test largeur", 20, c1.getLargeur(), EPSILON);
	}
	
	@Test
	public void testToString() {
		Coordonnees p1 = new Coordonnees(10,10);
		Carre c1 = new Carre(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(false);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Carré] : pos (10,0 , 10,0) dim 25,0 x 25,0 périmètre : 100,0 aire : 625,0 couleur = R0,V0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testToString2() {
		Coordonnees p1 = new Coordonnees(10,10);
		Carre c1 = new Carre(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(false);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Carré] : pos (10.0 , 10.0) dim 25.0 x 25.0 périmètre : 100.0 aire : 625.0 couleur = R0,G0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testToString3() {
		Coordonnees p1 = new Coordonnees(10,10);
		Carre c1 = new Carre(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(true);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Carré-Rempli] : pos (10,0 , 10,0) dim 25,0 x 25,0 périmètre : 100,0 aire : 625,0 couleur = R0,V0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testToString4() {
		Coordonnees p1 = new Coordonnees(10,10);
		Carre c1 = new Carre(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(true);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Carré-Rempli] : pos (10.0 , 10.0) dim 25.0 x 25.0 périmètre : 100.0 aire : 625.0 couleur = R0,G0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testPerimetre() {
		Coordonnees p1 = new Coordonnees(10,10);
		Carre c1 = new Carre(p1,25);
		assertEquals("test perimetre", 100.0, c1.perimetre(), EPSILON);	
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(5,5);
		Coordonnees p1 = new Coordonnees();
		Carre c1 = new Carre(p1,10);
		assertTrue(c1.contient(a));
	}
		
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(15,10);
		Coordonnees p1 = new Coordonnees();
		Carre c1 = new Carre(p1,10);
		assertFalse(c1.contient(a));
	}

}
