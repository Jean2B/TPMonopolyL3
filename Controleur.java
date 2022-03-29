package it3;

public class Controleur {
	private Jeu jeu;
	
	public void creerJeu(int nbTours) {
		jeu = new Jeu(nbTours);
	}
	
	public void creerJoueur(String nom) {
		Joueur j = new Joueur(nom);
		jeu.ajouterJoueur(j);
	}
	
	public void lancerJeu() {
		jeu.lancerJeu();
	}

}
