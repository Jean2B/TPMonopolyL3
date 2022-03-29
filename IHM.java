package it3;

public class IHM {

	public static void main(String[] args) {
		Controleur c = new Controleur();
		c.creerJeu(10);
		c.creerJoueur("Toto");
		c.creerJoueur("Titi");
		c.lancerJeu();
	}

}
