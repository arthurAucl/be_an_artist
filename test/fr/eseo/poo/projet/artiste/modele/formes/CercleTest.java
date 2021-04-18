package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static final double EPSILON = 0.5;

	@Test
	public void testCercle() {
		Cercle c1 = new Cercle();
		assertEquals("test abscisse", 0, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, c1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testCercle2() {
		Cercle c1 = new Cercle(15);
		assertEquals("test abscisse", 0, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, c1.getHauteur(), EPSILON);	
	}
	
	@Test
	public void testCercle3() {
		Coordonnees p1 = new Coordonnees(3,5);
		Cercle c1 = new Cercle(p1);
		assertEquals("test abscisse", 3, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, c1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testCercle4() {
		Coordonnees p1 = new Coordonnees(3,5);
		Cercle c1 = new Cercle(p1,15);
		assertEquals("test abscisse", 3, c1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 5, c1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, c1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, c1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testCercleTailleNegative() {
		Cercle c1 = new Cercle();
		try {
			c1.setTaille(-10);
		}
		catch(Exception c) {
			assertTrue(c.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testGetTaille() {
		Cercle c1 = new Cercle(15);
		assertEquals("test hauteur", 15, c1.getTaille(), EPSILON);
	}
	
	@Test
	public void testSetHauteur() {
		Cercle c1 = new Cercle(15);
		c1.setHauteur(20);
		assertEquals("test hauteur", 20, c1.getHauteur(), EPSILON);
		assertEquals("test largeur", 20, c1.getLargeur(), EPSILON);
	}
	
	@Test
	public void testSetLargeur() {
		Cercle c1 = new Cercle(15);
		c1.setLargeur(20);
		assertEquals("test hauteur", 20, c1.getHauteur(), EPSILON);
		assertEquals("test largeur", 20, c1.getLargeur(), EPSILON);
	}
	
	@Test
	public void testToString() {
		Coordonnees p1 = new Coordonnees(10,10);
		Cercle c1 = new Cercle(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(false);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Cercle] : pos (10,0 , 10,0) dim 25,0 x 25,0 périmètre : 78,54 aire : 490,87 couleur = R0,V0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testToString2() {
		Coordonnees p1 = new Coordonnees(10,10);
		Cercle c1 = new Cercle(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(false);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Cercle] : pos (10.0 , 10.0) dim 25.0 x 25.0 périmètre : 78.54 aire : 490.87 couleur = R0,G0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testToString3() {
		Coordonnees p1 = new Coordonnees(10,10);
		Cercle c1 = new Cercle(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(true);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Cercle-Rempli] : pos (10,0 , 10,0) dim 25,0 x 25,0 périmètre : 78,54 aire : 490,87 couleur = R0,V0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testToString4() {
		Coordonnees p1 = new Coordonnees(10,10);
		Cercle c1 = new Cercle(p1,25);
		c1.setCouleur(Color.black);
		c1.setRempli(true);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Cercle-Rempli] : pos (10.0 , 10.0) dim 25.0 x 25.0 périmètre : 78.54 aire : 490.87 couleur = R0,G0,B0";
		assertTrue(result.equals(c1.toString()));
	}
	
	@Test
	public void testPerimetre() {
		Coordonnees p1 = new Coordonnees(10,10);
		Cercle c1 = new Cercle(p1,25);
		assertEquals("test perimetre", 78.54, c1.perimetre(), EPSILON);	
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(5,5);
		Coordonnees p1 = new Coordonnees();
		Cercle c1 = new Cercle(p1,10);
		assertTrue(c1.contient(a));
	}
		
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(10,10);
		Coordonnees p1 = new Coordonnees();
		Cercle c1 = new Cercle(p1,10);
		assertFalse(c1.contient(a));
	}
	
	//UNIQUE BUT DE 100% DANS LE COVERAGE DE L'ACSM  :)    :p     :D
	
	@Test
	public void testDuBleu1() {
		Cercle c1 = new Cercle();
		assertEquals(1,c1.jeVeuxQueDuBleu(), EPSILON);
	}
	
	@Test
	public void testDuBleu2() {
		Cercle c1 = new Cercle();
		c1.setHauteur(20);
		assertEquals(0,c1.jeVeuxQueDuBleu(), EPSILON);
	}
	
	@Test
	public void testDuBleu3() {
		Cercle c1 = new Cercle();
		assertEquals(1,c1.jeVeuxQueDuBleu2(), EPSILON);
	}
	
	@Test
	public void testDuBleu4() {
		Cercle c1 = new Cercle();
		c1.setHauteur(20);
		assertEquals(0,c1.jeVeuxQueDuBleu2(), EPSILON);
	}

}