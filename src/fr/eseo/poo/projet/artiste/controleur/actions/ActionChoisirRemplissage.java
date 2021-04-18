package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirRemplissage extends AbstractAction{
	
	public static final String NOM_ACTION = "    Remplissage";
	private PanneauDessin panneauDessin;
	
	public ActionChoisirRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		if(this.panneauDessin.getModeRemplissage()) {
			this.panneauDessin.setModeRemplissage(false);
		}
		else {
			this.panneauDessin.setModeRemplissage(true);
		}
			
	}
}

