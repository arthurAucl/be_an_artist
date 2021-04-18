package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.vue.formes.VueForme;
import fr.eseo.poo.projet.artiste.controleur.outils.Outil;


@SuppressWarnings("serial")
public class PanneauDessin extends JPanel {
	
	private final List<VueForme> vueFormes = new ArrayList <VueForme>();
	
	public static final int LARGEUR_PAR_DEFAUT = 800;
	public static final int HAUTEUR_PAR_DEFAUT = 500;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	
	private Outil outilCourant;
	private Color couleurCourante;
	private boolean remplissage;
	
	public PanneauDessin(){
		super.setPreferredSize(new Dimension(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT));
		super.setBackground(COULEUR_FOND_PAR_DEFAUT);
		this.setCouleurCourante(COULEUR_PAR_DEFAUT);	
	}
	
	public PanneauDessin(int largeur, int hauteur, Color fond){
		super.setPreferredSize(new Dimension(largeur, hauteur));
		super.setBackground(fond);
		this.setCouleurCourante(COULEUR_PAR_DEFAUT);
	}
	
	public List<VueForme> getVueFormes(){
		return vueFormes;
	}
	
	public void ajouterVueForme(VueForme vueForme) {
		vueFormes.add(vueForme);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		for(int i = 0; i < vueFormes.size(); i++) {
			vueFormes.get(i).affiche(g2D);
		}
		g2D.dispose();
	}
	
	public void associerOutil(Outil outil) {
		if(outil == null) {
			this.getOutilCourant();
		}
		else {
			if (this.getOutilCourant() != null){
			this.dissocierOutil();
			}
			this.setOutilCourant(outil);
			outil.setPanneauDessin(this);
			this.addMouseListener(outil);
			this.addMouseMotionListener(outil);
		}
	}
		
	private void dissocierOutil() {
		this.getOutilCourant().setPanneauDessin(null);
		super.removeMouseListener(outilCourant);
		super.removeMouseMotionListener(outilCourant);
		this.setOutilCourant(null);
	}
	
	public Outil getOutilCourant() {
		return outilCourant;
	}
	
	private void setOutilCourant(Outil outil) {
		this.outilCourant = outil;
	}
	
	public Color getCouleurCourante() {
		return couleurCourante;
	}
	
	public void setCouleurCourante(Color couleur) {
		this.couleurCourante = couleur;
	}
	
	public boolean getModeRemplissage() {
		return remplissage;
	}
	
	public void setModeRemplissage(boolean remp) {
		this.remplissage = remp;
	}

}
