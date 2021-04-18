package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {
	
	private static final double EPSILON = 0.01;

	@Test
	public void testEllipse() {
		Ellipse e1 = new Ellipse();
		assertEquals("test abscisse", 0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, e1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testEllipse2() {
		Ellipse e1 = new Ellipse(15,20);
		assertEquals("test abscisse", 0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 20, e1.getHauteur(), EPSILON);	
	}
	
	@Test
	public void testEllipse3() {
		Coordonnees p1 = new Coordonnees(3,5);
		Ellipse e1 = new Ellipse(p1);
		assertEquals("test abscisse", 3, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, e1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testEllipse4() {
		Coordonnees p1 = new Coordonnees(3,5);
		Ellipse e1 = new Ellipse(p1,15,20);
		assertEquals("test abscisse", 3, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 20, e1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testSetLargeur() {
		Ellipse e1 = new Ellipse(15,20);
		e1.setLargeur(25);
		assertEquals("largeur", 25, e1.getLargeur(),EPSILON);
	}
	
	@Test
	public void testSetLargeurNegatif() {
		Ellipse e1 = new Ellipse();
		try {
			e1.setLargeur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testSetHauteur() {
		Ellipse e1 = new Ellipse(15,20);
		e1.setHauteur(35);
		assertEquals("hauteur", 35, e1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testSetHauteurNegatif() {
		Ellipse e1 = new Ellipse();
		try {
			e1.setHauteur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testAire() {
		Coordonnees p1 = new Coordonnees(3,5);
		Ellipse e1 = new Ellipse(p1,10,20);
		assertEquals("test aire", 157.08, e1.aire(), EPSILON);
	}
	
	@Test
	public void testPerimetre() {
		Ellipse e1 = new Ellipse(10,20);
		assertEquals("perimetre", 48.44, e1.perimetre(),EPSILON);
	}
	
	@Test
	public void testToString() {
		Coordonnees p1 = new Coordonnees(10,10);
		Ellipse e1 = new Ellipse(p1,25,15);
		e1.setCouleur(Color.RED);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Ellipse-Rempli] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52 couleur = R255,V0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString2() {
		Coordonnees p1 = new Coordonnees(10,10);
		Ellipse e1 = new Ellipse(p1,25,15);
		e1.setCouleur(Color.RED);
		e1.setRempli(true);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Ellipse-Rempli] : pos (10.0 , 10.0) dim 25.0 x 15.0 périmètre : 63.82 aire : 294.52 couleur = R255,G0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString3() {
		Coordonnees p1 = new Coordonnees(10,10);
		Ellipse e1 = new Ellipse(p1,25,15);
		e1.setCouleur(Color.RED);
		e1.setRempli(false);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 63,82 aire : 294,52 couleur = R255,V0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString4() {
		Coordonnees p1 = new Coordonnees(10,10);
		Ellipse e1 = new Ellipse(p1,25,15);
		e1.setCouleur(Color.RED);
		e1.setRempli(false);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Ellipse] : pos (10.0 , 10.0) dim 25.0 x 15.0 périmètre : 63.82 aire : 294.52 couleur = R255,G0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(10,5);
		Coordonnees p1 = new Coordonnees();
		Ellipse e1 = new Ellipse(p1,20,10);
		assertTrue(e1.contient(a));
	}
	
	@Test
	public void testContientSurLeCercle() {
		Coordonnees a = new Coordonnees(10,10);
		Coordonnees p1 = new Coordonnees();
		Ellipse e1 = new Ellipse(p1,20,10);
		assertTrue(e1.contient(a));
	}
	
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(20,10);
		Coordonnees p1 = new Coordonnees();
		Ellipse e1 = new Ellipse(p1,20,10);
		assertFalse(e1.contient(a));
	}
}
