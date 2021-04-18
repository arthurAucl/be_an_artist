package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirCouleur extends AbstractAction{
	
	public static final String NOM_ACTION = "Choix couleur";
	private PanneauDessin panneauDessin;

	public ActionChoisirCouleur(PanneauDessin panneauDessin){
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		Color couleur = JColorChooser.showDialog(panneauDessin, NOM_ACTION, panneauDessin.getCouleurCourante());
		this.panneauDessin.setCouleurCourante(couleur);
	}
}

