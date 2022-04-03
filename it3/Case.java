package it3;

import java.util.ArrayList;

public class Case {
	private ArrayList<Joueur> listeJoueurs; //Joueurs pr�sents sur la case
	private int montant;
	
	/**
	 * Constructeur de case
	 */
	public Case(int montant) {
		listeJoueurs = new ArrayList<Joueur>();
		this.montant = montant;
	}
	
	/**
	 * M�thode positionnant le pion du joueur sur la case
	 * @param joueur Pion � placer
	 */
	public void placerJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	
	/**
	 * Enl�ve un pion de la case
	 */
	public void enleverJoueur(Joueur joueur) {
		listeJoueurs.remove(joueur);
	}
	
	@Override
	public String toString() {
		String msg = "";
		if (listeJoueurs.size() == 0)
			msg += "vide\n";
		else
			msg += listeJoueurs + "\n";
		return msg;
	}
}