package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionEffacer extends AbstractAction{
	
	
	public static final String NOM_ACTION = "Effacer tout";
	private PanneauDessin panneauDessin;
	
	
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);	
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		int a = JOptionPane.showConfirmDialog(this.panneauDessin, "Etes-vous sûr de vouloir tout effacer ???", NOM_ACTION, 
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if(a == 0) {
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();
		}
		
	}
}
