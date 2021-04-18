package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.Locale;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;


public class EtoileTest {

	private static final double EPSILON = 0.001;

	@Test
	public void testEtoile() {
		Etoile e1 = new Etoile();
		assertEquals("test abscisse", 0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, e1.getHauteur(),EPSILON);
		assertEquals("test nbBranches", 5, e1.getNombreBranches(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremiereBranche(),EPSILON);
		assertEquals("test longueurBranches", 0.5, e1.getLongueurBranche(),EPSILON);
	}
	
	@Test
	public void testEtoile2() {
		Etoile e1 = new Etoile(50);
		assertEquals("test abscisse", 0, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 0, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 50, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 50, e1.getHauteur(),EPSILON);
		assertEquals("test nbBranches", 5, e1.getNombreBranches(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremiereBranche(),EPSILON);
		assertEquals("test longueurBranches", 0.5, e1.getLongueurBranche(),EPSILON);
	}
	
	@Test
	public void testEtoile3() {
		Coordonnees p1 = new Coordonnees(20,30);
		Etoile e1 = new Etoile(p1);
		assertEquals("test abscisse", 20, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 30, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 10, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 10, e1.getHauteur(),EPSILON);
		assertEquals("test nbBranches", 5, e1.getNombreBranches(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremiereBranche(),EPSILON);
		assertEquals("test longueurBranches", 0.5, e1.getLongueurBranche(),EPSILON);
	}
	
	@Test
	public void testEtoile4() {
		Coordonnees p1 = new Coordonnees(10,20);
		Etoile e1 = new Etoile(p1,40);
		assertEquals("test abscisse", 10, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 20, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 40, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 40, e1.getHauteur(),EPSILON);
		assertEquals("test nbBranches", 5, e1.getNombreBranches(),EPSILON);
		assertEquals("test anglePremiereBracnhes", 0, e1.getAnglePremiereBranche(),EPSILON);
		assertEquals("test longueurBranches", 0.5, e1.getLongueurBranche(),EPSILON);
	}
	
	@Test
	public void testEtoile5() {
		Coordonnees p1 = new Coordonnees(25,35);
		Etoile e1 = new Etoile(p1, 15, 10, Math.PI, 0.9);
		assertEquals("test abscisse", 25, e1.getPosition().getAbscisse(), EPSILON);
		assertEquals("test ordonnee", 35, e1.getPosition().getOrdonnee(), EPSILON);
		assertEquals("test largeur", 15, e1.getLargeur(), EPSILON);
		assertEquals("test hauteur", 15, e1.getHauteur(),EPSILON);
		assertEquals("test nbBranches", 10, e1.getNombreBranches(),EPSILON);
		assertEquals("test anglePremiereBracnhes", Math.PI, e1.getAnglePremiereBranche(),EPSILON);
		assertEquals("test longueurBranches", 0.9, e1.getLongueurBranche(),EPSILON);
	}
	
	@Test
	public void testSetHauteur() {
		Etoile e1 = new Etoile();
		e1.setHauteur(35);
		assertEquals("hauteur", 35, e1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testSetHauteurNegatif() {
		Etoile e1 = new Etoile();
		try {
			e1.setHauteur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testSetLargeur() {
		Etoile e1 = new Etoile();
		e1.setLargeur(35);
		assertEquals("hauteur", 35, e1.getHauteur(),EPSILON);
	}
	
	@Test
	public void testSetLargeurNegatif() {
		Etoile e1 = new Etoile();
		try {
			e1.setLargeur(-10);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le ou les arguments rentrés en paramètre doivent etre positifs"));
		}
	}
	
	@Test
	public void testSetPosition() {
		Etoile e1 = new Etoile();
		Coordonnees p1 = new Coordonnees(15,20);
		e1.setPosition(p1);
		assertEquals("abscisse", 15, e1.getPosition().getAbscisse(),EPSILON);
		assertEquals("ordonnees", 20, e1.getPosition().getOrdonnee(),EPSILON);
	}
	
	@Test
	public void testSetNombreBranches() {
		Etoile e1 = new Etoile();
		e1.setNombreBranches(10);
		assertEquals("nb branches", 10, e1.getNombreBranches(),EPSILON);
	}
	
	@Test
	public void testSetNombresBranchesFaux1() {
		Etoile e1 = new Etoile();
		try {
			e1.setNombreBranches(2);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le nombre de branches doit etre compris entre 3 et 15"));
		}
	}
	
	@Test
	public void testSetNombresBranchesFaux2() {
		Etoile e1 = new Etoile();
		try {
			e1.setNombreBranches(20);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("Le nombre de branches doit etre compris entre 3 et 15"));
		}
	}
	
	@Test
	public void testSetLongueurBranches() {
		Etoile e1 = new Etoile();
		e1.setLongueurBranche(0.1);
		assertEquals("nb branches", 0.1, e1.getLongueurBranche(),EPSILON);
	}
	
	@Test
	public void testSetLongueurBranchesFaux1() {
		Etoile e1 = new Etoile();
		try {
			e1.setLongueurBranche(-1);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("La longueur des branches doivent etre comprises entre 0 et 1"));
		}
	}
	
	@Test
	public void testSetLongueurBranchesFaux2() {
		Etoile e1 = new Etoile();
		try {
			e1.setLongueurBranche(2);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("La longueur des branches doivent etre comprises entre 0 et 1"));
		}
	}
	
	@Test
	public void testAnglePremiereBranche() {
		Etoile e1 = new Etoile();
		e1.setAnglePremiereBranche(Math.PI/4);
		assertEquals("nb branches", Math.PI/4, e1.getAnglePremiereBranche(),EPSILON);
	}
	
	@Test
	public void testAnglePremiereBrancheFaux1() {
		Etoile e1 = new Etoile();
		try {
			e1.setAnglePremiereBranche(3*Math.PI/2);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("L'angle doit etre compris entre pi et -pi"));
		}
	}
	
	@Test
	public void testAnglePremiereBrancheFaux2() {
		Etoile e1 = new Etoile();
		try {
			e1.setAnglePremiereBranche(-2*Math.PI);
		}
		catch(Exception e) {
			assertTrue(e.getMessage().equals("L'angle doit etre compris entre pi et -pi"));
		}
	}
	
	@Test
	public void testToString() {
		Etoile e1 = new Etoile();
		e1.setCouleur(Color.RED);
		e1.setRempli(true);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Etoile-Rempli] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 33,2 aire : 36,74 couleur = R255,V0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString2() {
		Etoile e1 = new Etoile();
		e1.setCouleur(Color.RED);
		e1.setRempli(true);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Etoile-Rempli] : pos (0.0 , 0.0) dim 10.0 x 10.0 périmètre : 33.2 aire : 36.74 couleur = R255,G0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString3() {
		Etoile e1 = new Etoile();
		e1.setCouleur(Color.RED);
		e1.setRempli(false);
		Locale.setDefault(new Locale("fr","FRANCE","WIN"));
		String result = "[Etoile] : pos (0,0 , 0,0) dim 10,0 x 10,0 périmètre : 33,2 aire : 36,74 couleur = R255,V0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testToString4() {
		Etoile e1 = new Etoile();
		e1.setCouleur(Color.RED);
		e1.setRempli(false);
		Locale.setDefault(new Locale("en","US","WIN"));
		String result = "[Etoile] : pos (0.0 , 0.0) dim 10.0 x 10.0 périmètre : 33.2 aire : 36.74 couleur = R255,G0,B0";
		assertTrue(result.equals(e1.toString()));
	}
	
	@Test
	public void testContient() {
		Coordonnees a = new Coordonnees(5,5);
		Etoile e1 = new Etoile();
		assertTrue(e1.contient(a));
	}
	
	@Test
	public void testContientPas() {
		Coordonnees a = new Coordonnees(9,9);
		Etoile e1 = new Etoile();
		assertFalse(e1.contient(a));
	}
		
}
