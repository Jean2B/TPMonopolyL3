package monopoly;

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
	
	public static boolean askAchat(Case c, Joueur j) {
		boolean rep = false;
		String prop = c.toString();
		String joueur = j.toString();
		String reponse = IHM.askAchat(prop, joueur);
		if (reponse.equals("o"))
			rep = true;
		return rep;
	}

}
