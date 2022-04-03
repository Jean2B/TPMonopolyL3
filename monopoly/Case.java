package monopoly;

import java.util.ArrayList;

public abstract class Case {
	private ArrayList<Joueur> listeJoueurs; //Joueurs pr�sents sur la case
	
	/**
	 * Constructeur de case
	 */
	public Case() {
		listeJoueurs = new ArrayList<Joueur>();
	}
	
	public abstract void eventCase(Joueur j);
	
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
		String msg = " ";
		if (listeJoueurs.size() > 0)
			msg += listeJoueurs;
		return msg;
	}
}
