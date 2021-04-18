package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class RectangleTest {

	private static final double EPSILON = 0.01;

	@Test
	public void testRectangle() {
		Rectangle r1 = new Rectangle();
		assertEquals("test abscisse", 0, r1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, r1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, r1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, r1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testRectangle2() {
		Rectangle r1 = new Rectangle(15,20);
		assertEquals("test abscisse", 0, r1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, r1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, r1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 20, r1.getHauteur(), EPSILON);	
	}
	
	@Test
	public void testRectangle3() {
		Coordonnees p1 = new Coordonnees(3,5);
		Rectangle r1 = new Rectangle(p1);
		assertEquals("test abscisse", 3, r1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, r1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, r1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, r1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testRectangle4() {
		Coordonnees p1 = new Coordonnees(3,5);
		Rectangle r1 = new Rectangle(p1,15,20);
		assertEquals("test abscisse", 3, r1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, r1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, r1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 20, r1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testSetLargeur() {
		Rectangle r1 = new Rectangle(15,20);
		r1.setLargeur(25);
		assertEquals("largeur", 25, r1.getLargeur(),EPSILON);
	}
	
	@Test
	public void testSetLargeurNegatif() {
		Rectangle r1 = new Rectangle();
		try {
			r1.setLargeur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testSetHauteur() {
		Rectangle r1 = new Rectangle(15,20);
		r1.setHauteur(35);
		assertEquals("hauteur", 35, r1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testSetHauteurNegatif() {
		Rectangle r1 = new Rectangle();
		try {
			r1.setHauteur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testAire() {
		Coordonnees p1 = new Coordonnees(3,5);
		Rectangle r1 = new Rectangle(p1,10,20);
		assertEquals("test aire", 200, r1.aire(), EPSILON);
	}
	
	@Test
	public void testPerimetre() {
		Rectangle r1 = new Rectangle(10,20);
		assertEquals("perimetre", 60, r1.perimetre(),EPSILON);
	}
	
	@Test
	public void testToString() {
		Coordonnees p1 = new Coordonnees(10,10);
		Rectangle r1 = new Rectangle(p1,25,15);
		r1.setCouleur(Color.RED);
		r1.setRempli(true);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Rectangle-Rempli] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 80,0 aire : 375,0 couleur = R255,V0,B0";
		assertTrue(result.equals(r1.toString()));
	}
	
	@Test
	public void testToString2() {
		Coordonnees p1 = new Coordonnees(10,10);
		Rectangle r1 = new Rectangle(p1,25,15);
		r1.setCouleur(Color.RED);
		r1.setRempli(true);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Rectangle-Rempli] : pos (10.0 , 10.0) dim 25.0 x 15.0 périmètre : 80.0 aire : 375.0 couleur = R255,G0,B0";
		assertTrue(result.equals(r1.toString()));
	}
	
	@Test
	public void testToString3() {
		Coordonnees p1 = new Coordonnees(10,10);
		Rectangle r1 = new Rectangle(p1,25,15);
		r1.setCouleur(Color.RED);
		r1.setRempli(false);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Rectangle] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 80,0 aire : 375,0 couleur = R255,V0,B0";
		assertTrue(result.equals(r1.toString()));
	}
	
	@Test
	public void testToString4() {
		Coordonnees p1 = new Coordonnees(10,10);
		Rectangle r1 = new Rectangle(p1,25,15);
		r1.setCouleur(Color.RED);
		r1.setRempli(false);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Rectangle] : pos (10.0 , 10.0) dim 25.0 x 15.0 périmètre : 80.0 aire : 375.0 couleur = R255,G0,B0";
		assertTrue(result.equals(r1.toString()));
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(10,5);
		Coordonnees p1 = new Coordonnees();
		Rectangle r1 = new Rectangle(p1,20,10);
		assertTrue(r1.contient(a));
	}
	
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(30,10);
		Coordonnees p1 = new Coordonnees();
		Rectangle r1 = new Rectangle(p1,20,10);
		assertFalse(r1.contient(a));
	}
}
