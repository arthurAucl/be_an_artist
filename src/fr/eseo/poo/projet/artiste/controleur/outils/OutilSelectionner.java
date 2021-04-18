package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;

public class OutilSelectionner extends Outil {
	
	private Forme formeSelectionnee;
	
	public OutilSelectionner() {
		
	}
	
	@SuppressWarnings("static-access")
	public void mouseClicked(MouseEvent event) {
		double x = event.getX();
		double y = event.getY();
		Coordonnees click = new Coordonnees(x,y);
		int tailleListe = super.getPanneauDessin().getVueFormes().size();
		for(int i = tailleListe - 1; i > -1; i--) {
			if(super.getPanneauDessin().getVueFormes().get(i).getForme().contient(click)) {	
				this.formeSelectionnee = super.getPanneauDessin().getVueFormes().get(i).getForme();
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(super.getPanneauDessin(), this.formeSelectionnee.toString(), 
						ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}			
	}
	
	public Forme getFormeSelectionnee() {
		return this.formeSelectionnee;
	}
}
