package monopoly;

import java.util.Scanner;

public class IHM {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Controleur c = new Controleur();
		c.creerJeu(askTours());
		c.creerJoueur("Toto");
		c.creerJoueur("Titi");
		c.creerJoueur("Roger");
		c.lancerJeu();
	}
	
	public static int askTours() {
		int tours = 0;
		while (tours <= 0) {
			System.out.print("Combien de tours ? : ");
			tours = scanner.nextInt();
		}
		return tours;
	}

	public static String askAchat(String prop, String joueur) {
		String reponse = "";
		while (!reponse.equals("o") && !reponse.equals("n")) {
			System.out.println(joueur + "\nAcheter " + prop + " ? (o/n)");
			reponse = scanner.next();
		}
		return reponse;
	}
}
