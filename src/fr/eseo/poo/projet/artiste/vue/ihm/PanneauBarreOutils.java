package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JPanel;
import javax.swing.JSpinner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionRetour;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Etoile;

@SuppressWarnings("serial")
public class PanneauBarreOutils extends JPanel {
	
	private PanneauDessin panneauDessin;
	public static final String SPINNER_NOM = "     Nombre branches / sommets";
	public static final String LONGUEUR_SPINNER_NOM = "     Longueur branches";
	
	SpinnerNumberModel model1 = new SpinnerNumberModel(Etoile.NOMBRE_BRANCHES_PAR_DEFAUT, 3, 15, 1);
	JSpinner boutonNbbranches = new JSpinner(model1);

	SpinnerNumberModel model2 = new SpinnerNumberModel(Etoile.LONGUEUR_BRANCHE_PAR_DEFAUT, 0.00, 1.00, 0.01);
	JSpinner boutonLongueurbranches = new JSpinner(model2);

	
	public int getNbBranches() {
		return (int) boutonNbbranches.getValue();
	}
	
	public double getLongueurBranche() {
		return (double) boutonLongueurbranches.getValue();	
	}	
	
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.panneauDessin = panneauDessin;
		this.initComponents();
		this.setLayout(box);
		this.setPreferredSize(new Dimension(200,100));
		this.setLayout(new GridLayout(20,5));
		
	}
	
	public void initComponents() {
		ButtonGroup boutonGroupe = new ButtonGroup();
		
		JButton boutonEffacett = new JButton(new ActionEffacer(panneauDessin));
		boutonEffacett.setName(ActionEffacer.NOM_ACTION);
		boutonEffacett.setBackground(Color.lightGray);
		this.add(boutonEffacett);
		boutonGroupe.add(boutonEffacett);
		
		JButton boutonRetour = new JButton(new ActionRetour(panneauDessin));
		boutonRetour.setName(ActionEffacer.NOM_ACTION);
		boutonRetour.setBackground(Color.lightGray);
		this.add(boutonRetour);
		boutonGroupe.add(boutonRetour);
		
		
		ActionChoisirForme choixLigne = new ActionChoisirForme(panneauDessin, this, "Ligne");
		ActionChoisirForme choixRectangle = new ActionChoisirForme(panneauDessin, this, "Rectangle");
		ActionChoisirForme choixCarre = new ActionChoisirForme(panneauDessin, this, "Carré");
		ActionChoisirForme choixEllipse = new ActionChoisirForme(panneauDessin, this, "Ellipse");
		ActionChoisirForme choixCercle = new ActionChoisirForme(panneauDessin, this, "Cercle");
		ActionChoisirForme choixEtoile = new ActionChoisirForme(panneauDessin, this, "Etoile");
		ActionChoisirForme choixPolygone = new ActionChoisirForme(panneauDessin, this, "Polygone");
		
		
		JToggleButton boutonLigne = new JToggleButton(choixLigne);
		JToggleButton boutonRectangle = new JToggleButton(choixRectangle);
		JToggleButton boutonCarre = new JToggleButton(choixCarre);
		JToggleButton boutonEllipse = new JToggleButton(choixEllipse);
		JToggleButton boutonCercle = new JToggleButton(choixCercle);
		JToggleButton boutonEtoile = new JToggleButton(choixEtoile);
		JToggleButton boutonPolygone = new JToggleButton(choixPolygone);
		
		boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		boutonRectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		boutonCarre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		boutonEtoile.setName(ActionChoisirForme.NOM_ACTION_ETOILE);
		boutonPolygone.setName(ActionChoisirForme.NOM_ACTION_POLYGONE);
		
		boutonLigne.setBackground(Color.red);
		boutonRectangle.setBackground(Color.orange);
		boutonCarre.setBackground(Color.yellow);
		boutonEllipse.setBackground(Color.green);
		boutonCercle.setBackground(Color.cyan);
		boutonEtoile.setBackground(Color.blue);
		boutonPolygone.setBackground(Color.magenta);
		
		this.add(boutonLigne);
		this.add(boutonRectangle);
		this.add(boutonCarre);
		this.add(boutonEllipse);
		this.add(boutonCercle);
		this.add(boutonEtoile);
		this.add(boutonPolygone);
		
		boutonGroupe.add(boutonLigne);
		boutonGroupe.add(boutonRectangle);
		boutonGroupe.add(boutonCarre);
		boutonGroupe.add(boutonEllipse);
		boutonGroupe.add(boutonCercle);
		boutonGroupe.add(boutonEtoile);
		boutonGroupe.add(boutonPolygone);
		
	
		ActionSelectionner choixSelection = new ActionSelectionner(panneauDessin);
		JToggleButton boutonSelectionner = new JToggleButton(choixSelection);
		boutonSelectionner.setName(ActionSelectionner.NOM_ACTION);
		boutonSelectionner.setBackground(Color.lightGray);
		this.add(boutonSelectionner);
		boutonGroupe.add(boutonSelectionner);
		
		
		ActionChoisirCouleur choixCouleur = new ActionChoisirCouleur(panneauDessin);
		JButton boutonCouleur = new JButton(choixCouleur);
		boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
		boutonCouleur.setBackground(Color.lightGray);
		this.add(boutonCouleur);
		boutonGroupe.add(boutonCouleur);
		
		
		ActionChoisirRemplissage choixRemplissage = new ActionChoisirRemplissage(panneauDessin);
		JCheckBox checkRemplissage = new JCheckBox(choixRemplissage);
		checkRemplissage.setName(ActionChoisirRemplissage.NOM_ACTION);
		this.add(checkRemplissage);
		
		
		JLabel label1 = new JLabel(SPINNER_NOM);
		this.add(label1);
		boutonNbbranches.setName(SPINNER_NOM);
		this.add(boutonNbbranches);
		
		

		JLabel label2 = new JLabel(LONGUEUR_SPINNER_NOM);
		this.add(label2);
		boutonLongueurbranches.setName(LONGUEUR_SPINNER_NOM);
		this.add(boutonLongueurbranches);
		
	}
}
