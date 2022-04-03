package monopoly;

public class Test {

	public static void main(String[] args) {
		Jeu j = new Jeu(10);
		Joueur j1 = new Joueur("Toto");
		Joueur j2 = new Joueur("Titi");
		j.ajouterJoueur(j1);
		j.ajouterJoueur(j2);
		j.lancerJeu();
	}

}
