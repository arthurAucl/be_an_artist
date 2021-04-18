package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class PolygoneTest {

	private static final double EPSILON = 0.001;

	@Test
	public void testPolygone() {
		Polygone e1 = new Polygone();
		assertEquals("test abscisse", 0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, e1.getHauteur(),EPSILON);
		assertEquals("test nbSommets", 5, e1.getNombreSommet(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremierSommet(),EPSILON);
	}
	
	@Test
	public void testPolygone2() {
		Polygone e1 = new Polygone(50);
		assertEquals("test abscisse", 0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 50, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 50, e1.getHauteur(),EPSILON);
		assertEquals("test nbSommets", 5, e1.getNombreSommet(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremierSommet(),EPSILON);
	}
	
	@Test
	public void testPolygone3() {
		Coordonnees p1 = new Coordonnees(20,30);
		Polygone e1 = new Polygone(p1);
		assertEquals("test abscisse", 20, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 30, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, e1.getHauteur(),EPSILON);
		assertEquals("test nbSommets", 5, e1.getNombreSommet(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremierSommet(),EPSILON);
	}
	
	@Test
	public void testPolygone4() {
		Coordonnees p1 = new Coordonnees(10,20);
		Polygone e1 = new Polygone(p1,40);
		assertEquals("test abscisse", 10, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 20, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 40, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 40, e1.getHauteur(),EPSILON);
		assertEquals("test nbSommets", 5, e1.getNombreSommet(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremierSommet(),EPSILON);
	}
	
	@Test
	public void testPolygone5() {
		Coordonnees p1 = new Coordonnees(25,35);
		Polygone e1 = new Polygone(p1, 15, 10, Math.PI);
		assertEquals("test abscisse", 25, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 35, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, e1.getHauteur(),EPSILON);
		assertEquals("test nbSommets", 10, e1.getNombreSommet(),EPSILON);
		assertEquals("test anglePremiereBracnhes", Math.PI, e1.getAnglePremierSommet(),EPSILON);
	}
	
	@Test
	public void testSetHauteur() {
		Polygone e1 = new Polygone();
		e1.setHauteur(35);
		assertEquals("hauteur", 35, e1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testSetHauteurNegatif() {
		Polygone e1 = new Polygone();
		try {
			e1.setHauteur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testSetLargeur() {
		Polygone e1 = new Polygone();
		e1.setLargeur(35);
		assertEquals("hauteur", 35, e1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testSetLargeurNegatif() {
		Polygone e1 = new Polygone();
		try {
			e1.setLargeur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testSetPosition() {
		Polygone e1 = new Polygone();
		Coordonnees p1 = new Coordonnees(15,20);
		e1.setPosition(p1);
		assertEquals("abscisse", 15, e1.getPosition().getAbscisse(),EPSILON);
		assertEquals("ordonnees", 20, e1.getPosition().getOrdonnee(),EPSILON);
	}
	
	@Test
	public void testSetNombreSommet() {
		Polygone e1 = new Polygone();
		e1.setNombreSommet(10);
		assertEquals("nb Sommets", 10, e1.getNombreSommet(),EPSILON);
	}
	
	@Test
	public void testSetNombresSommetFaux1() {
		Polygone e1 = new Polygone();
		try {
			e1.setNombreSommet(2);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le nombre de sommets doit etre compris entre 3 et 15"));
		}
	}
	
	@Test
	public void testSetNombresSommetFaux2() {
		Polygone e1 = new Polygone();
		try {
			e1.setNombreSommet(20);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le nombre de sommets doit etre compris entre 3 et 15"));
		}
	}
	
	
	@Test
	public void testAnglePremiereSommet() {
		Polygone e1 = new Polygone();
		e1.setAnglePremierSommet(Math.PI/4);
		assertEquals("nb Sommets", Math.PI/4, e1.getAnglePremierSommet(),EPSILON);
	}
	
	@Test
	public void testAnglePremiereSommetFaux1() {
		Polygone e1 = new Polygone();
		try {
			e1.setAnglePremierSommet(3*Math.PI/2);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("L'angle doit etre compris entre pi et -pi"));
		}
	}
	
	@Test
	public void testAnglePremiereSommetFaux2() {
		Polygone e1 = new Polygone();
		try {
			e1.setAnglePremierSommet(-2*Math.PI);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("L'angle doit etre compris entre pi et -pi"));
		}
	}
	
	@Test
	public void testToString() {
		Polygone e1 = new Polygone();
		e1.setCouleur(Color.RED);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Polygone-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 29,39 aire : 73,47 couleur = R255,V0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString2() {
		Polygone e1 = new Polygone();
		e1.setCouleur(Color.RED);
		e1.setRempli(true);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Polygone-Rempli] : pos (0.0 , 0.0) dim 10.0 x 10.0 périmètre : 29.39 aire : 73.47 couleur = R255,G0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString3() {
		Polygone e1 = new Polygone();
		e1.setCouleur(Color.RED);
		e1.setRempli(false);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Polygone] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 29,39 aire : 73,47 couleur = R255,V0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString4() {
		Polygone e1 = new Polygone();
		e1.setCouleur(Color.RED);
		e1.setRempli(false);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Polygone] : pos (0.0 , 0.0) dim 10.0 x 10.0 périmètre : 29.39 aire : 73.47 couleur = R255,G0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(5,5);
		Polygone e1 = new Polygone();
		assertTrue(e1.contient(a));
	}
	
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(0,0);
		Polygone e1 = new Polygone();
		assertFalse(e1.contient(a));
	}
		
}

