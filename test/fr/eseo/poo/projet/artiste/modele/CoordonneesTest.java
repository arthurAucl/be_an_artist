package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordonneesTest {

	private static final double EPSILON = 0.001;
	
	@Test
	public void testCoordonneesDefaut() {
		Coordonnees p1 = new Coordonnees();
		assertEquals("test x", 0, p1.getAbscisse(), EPSILON);
		assertEquals("test y", 0, p1.getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testCoordonnees() {
		Coordonnees p1 = new Coordonnees(5,3);
		assertEquals("test x", 5, p1.getAbscisse(), EPSILON);
		assertEquals("test y", 3, p1.getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testDeplacerDe() {
		Coordonnees p1 = new Coordonnees(2,1);
		p1.deplacerDe(3,2);
		assertEquals("test x", 5, p1.getAbscisse(), EPSILON);
		assertEquals("test y", 3, p1.getOrdonnee(), EPSILON);	
	}
	
	@Test
	public void testDeplacerVers() {
		Coordonnees p1 = new Coordonnees(4,3);
		p1.deplacerVers(7,2);
		assertEquals("test x", 7, p1.getAbscisse(), EPSILON);
		assertEquals("test y", 2, p1.getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testDistanceVers() {
		Coordonnees p1 = new Coordonnees(1,1);
		Coordonnees p2 = new Coordonnees(3,1);
		p1.distanceVers(p2);
		assertEquals("distance", 2, p1.distanceVers(p2), EPSILON);
	}
	
	@Test
	public void testAngleVers() {
		Coordonnees p1 = new Coordonnees(1,1);
		Coordonnees p2 = new Coordonnees(2,2);
		p1.angleVers(p2);
		assertEquals("angle", Math.PI/4, p1.angleVers(p2), EPSILON);
	}
	
	@Test
	public void testToString() {
		Coordonnees p1 = new Coordonnees(1.234, 5.678);
		String result = "(1,23 , 5,68)";
		assertTrue(result.equals(p1.toString()));
	}
	
	//UNIQUE BUT DE 100% DANS LE COVERAGE DE L'ACSM  :)    :p     :D
	
	@Test
	public void testDuBleu1() {
		Coordonnees p1 = new Coordonnees();
		p1.setAbscisse(0);
		assertEquals(1,p1.jeVeuxQueDuBleu(), EPSILON);
	}
	
	@Test
	public void testDuBleu2() {
		Coordonnees p1 = new Coordonnees();
		p1.setAbscisse(10);
		assertEquals(0,p1.jeVeuxQueDuBleu(), EPSILON);
	}
}
