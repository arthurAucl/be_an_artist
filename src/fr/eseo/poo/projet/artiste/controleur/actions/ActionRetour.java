package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionRetour extends AbstractAction{
	public static final String NOM_ACTION = "Retour";
	private PanneauDessin panneauDessin;
	
	
	public ActionRetour(PanneauDessin panneauDessin) {
		super(NOM_ACTION);	
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		int i = this.panneauDessin.getVueFormes().size() -1;
		this.panneauDessin.getVueFormes().remove(i);
		this.panneauDessin.repaint();
	}
}
