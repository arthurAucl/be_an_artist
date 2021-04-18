package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {
	
	private static final double EPSILON = 0.001;

	@Test
	public void testLigneDefaut() {
		Ligne l1 = new Ligne();
		assertEquals("test abscisse", 0, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, l1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, l1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testLigne2() {
		Ligne l1 = new Ligne(20,15);
		assertEquals("test abscisse", 0, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 20, l1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, l1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testLigne2Negatif() {
		Ligne l1 = new Ligne(-15,-30);
		assertEquals("test abscisse", 0, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", -15, l1.getLargeur(), EPSILON);
		assertEquals("test hauteur", -30, l1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testLigne3() {
		Coordonnees p1 = new Coordonnees(4,1);
		Ligne l1 = new Ligne(p1);
		assertEquals("test abscisse", 4, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 1, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, l1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, l1.getHauteur(), EPSILON);	
	}
	
	@Test
	public void testLigne3Negatif() {
		Coordonnees p1 = new Coordonnees(-3,-2);
		Ligne l1 = new Ligne(p1);
		assertEquals("test abscisse", -3, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", -2, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, l1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, l1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testLigne4() {
		Coordonnees p1 = new Coordonnees(3,2);
		Ligne l1 = new Ligne(p1,20,30);
		assertEquals("test abscisse", 3, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 2, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 20, l1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 30, l1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testForme1() {
		Forme f = new Ligne();
		assertEquals("test abscisse", 0, f.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, f.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, f.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, f.getHauteur(), EPSILON);
	}
	
	@Test
	public void testForme2() {
		Forme f = new Ligne(20,30);
		assertEquals("test abscisse", 0, f.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, f.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 20, f.getLargeur(), EPSILON);
		assertEquals("test hauteur", 30, f.getHauteur(), EPSILON);
	}
	
	@Test
	public void testForme3() {
		Coordonnees p1 = new Coordonnees(3,2);
		Forme f = new Ligne(p1);
		assertEquals("test abscisse", 3, f.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 2, f.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, f.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, f.getHauteur(), EPSILON);
	}
	
	@Test
	public void testForme4() {
		Coordonnees p1 = new Coordonnees(3,2);
		Forme f = new Ligne(p1,20,30);
		assertEquals("test abscisse", 3, f.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 2, f.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 20, f.getLargeur(), EPSILON);
		assertEquals("test hauteur", 30, f.getHauteur(), EPSILON);
	}
	
	@Test
	public void testSetPosition() {
		Coordonnees p1 = new Coordonnees(4,1);
		Ligne l1 = new Ligne(p1);
		assertEquals("test abscisse", 4, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 1, l1.getPosition().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testGetC1C2() {
		Coordonnees p1 = new Coordonnees(4,2);
		Ligne l1 = new Ligne(p1,20,20);
		assertEquals("test abscisseC1", 4, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonneeC1", 2, l1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test abscisseC2", 24, l1.getPosition().getAbscisse() + l1.getLargeur(), EPSILON);
		assertEquals("test ordonneeC2", 22, l1.getPosition().getOrdonnee() + l1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testSetC1() {
		Ligne l1 = new Ligne();
		Coordonnees p1bis = new Coordonnees(2,3);
		l1.setC1(p1bis);
		assertEquals("test nouvelle abscisse C1", 2, l1.getC1().getAbscisse(),EPSILON);
		assertEquals("test nouvelle ordonnee C1", 3, l1.getC1().getOrdonnee(),EPSILON);
		assertEquals("test nouvelle largeur", 8, l1.getLargeur(), EPSILON);
		assertEquals("test nouvelle hauteur", 7, l1.getHauteur(), EPSILON);
	}
	
	@Test
	public void testSetC2() {
		Ligne l1 = new Ligne();
		Coordonnees p1bis = new Coordonnees(4,5);
		l1.setC2(p1bis);
		assertEquals("test nouvelle abscisse C2", 4, l1.getC2().getAbscisse(), EPSILON);
		assertEquals("test nouvelle ordonnee C2", 5, l1.getC2().getOrdonnee(), EPSILON);
		assertEquals("test nouvelle largeur", 4, l1.getLargeur(), EPSILON);
		assertEquals("test nouvelle hauteur", 5, l1.getHauteur(), EPSILON);	
	}
	
	@ Test
	public void testAire() {
		Ligne l1 = new Ligne();
		assertEquals("test aire", 0, l1.aire(), EPSILON);
	}
	
	@Test
	public void testPerimetre() {
		Ligne l1 = new Ligne(40,20);
		assertEquals("test perimetre", Math.sqrt(2000), l1.perimetre(), EPSILON);
	}
	
	@Test
	public void testToString() {
		Coordonnees p1 = new Coordonnees(10,10);
		Ligne l1 = new Ligne(p1,-5,20);
		l1.setCouleur(Color.CYAN);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 angle : 104,04° couleur = R0,V255,B255";
		assertTrue("test string", result.equals(l1.toString()));
	}
	
	@Test
	public void testToString2() {
		Coordonnees p1 = new Coordonnees(10,10);
		Ligne l1 = new Ligne(p1,-5,20);
		l1.setCouleur(Color.CYAN);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0) longueur : 20.62 angle : 104.04° couleur = R0,G255,B255";
		assertTrue("test string", result.equals(l1.toString()));
	}
	
	
	@Test
	public void testGetCadreMinX() {
		Coordonnees p1 = new Coordonnees(10,15);
		Ligne l1 = new Ligne(p1);
		assertEquals("test CadreMinX", 10, l1.getCadreMinX(),EPSILON);
	}
	
	@Test
	public void testGetCardeMaxX() {
		Coordonnees p1 = new Coordonnees(5,7);
		Ligne l1 = new Ligne(p1,15,20);
		assertEquals("test CadreMaxX", 20, l1.getCadreMaxX(),EPSILON);
	}
	
	@Test
	public void testGetCadreMinY() {
		Coordonnees p1 = new Coordonnees(3,4);
		Ligne l1 = new Ligne(p1,11,12);
		assertEquals("test CadreMinY", 4, l1.getCadreMinY(), EPSILON);
	}
	
	@Test
	public void testGetCadreMaxY() {
		Coordonnees p1 = new Coordonnees(3,4);
		Ligne l1 = new Ligne(p1,11,12);
		assertEquals("test CadreMaxY", l1.getC2().getOrdonnee(), l1.getCadreMaxY(), EPSILON);
	}
	
	@Test
	public void testDeplacerDe() {
		Ligne l1 = new Ligne();
		l1.deplacerDe(25, 30);
		assertEquals("new abscisse", 25, l1.getPosition().getAbscisse(), EPSILON);
		assertEquals("new ordonnee", 30, l1.getPosition().getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(0,5);
		Coordonnees p1 = new Coordonnees();
		Ligne l1 = new Ligne(p1,0,10);
		assertTrue(l1.contient(a));
	}
	
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(10,10);
		Coordonnees p1 = new Coordonnees();
		Ligne l1 = new Ligne(p1,0,10);
		assertFalse(l1.contient(a));
	}

}
