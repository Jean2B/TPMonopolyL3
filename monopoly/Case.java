package monopoly;

import java.util.ArrayList;

public class Case {
	private ArrayList<Joueur> listeJoueurs; //Joueurs présents sur la case
	private int argent;
	
	/**
	 * Constructeur de case
	 */
	public Case(int argent) {
		listeJoueurs = new ArrayList<Joueur>();
		this.argent = argent;
	}
	
	public int getArgent() {
		return argent;
	}
	
	/**
	 * Méthode positionnant le pion du joueur sur la case
	 * @param joueur Pion à placer
	 */
	public void placerJoueur(Joueur joueur) {
		listeJoueurs.add(joueur);
	}
	
	/**
	 * Enlève un pion de la case
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
