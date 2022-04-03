package monopoly;

import java.util.*;

public class Jeu {
	private static final int NBJOUEURMAX = 6; //Nombre max de joueurs
	private static final int DMAX = 6; //Valeur max du dé
	private static final int NUMPRISON = 10; // Numéro de la case prison
	private ArrayList<Joueur> listeJoueurs; //Liste des joueurs
	private int nbTours; //Nombre de tours
	private static Random r = new Random();
	private Plateau plateau;
	private boolean finJeu; //Permet d'arrêter le jeu
	
	/**
	 * Constructeur de jeu
	 * @param nbTours Nombre de tours
	 */
	public Jeu(int nbTours) {
		this.nbTours = nbTours;
		listeJoueurs = new ArrayList<Joueur>();
		this.plateau = new Plateau();
	}
	
	/**
	 * Ajoute un joueur à la liste des joueurs
	 * @param j Joueur à ajouter
	 */
	public void ajouterJoueur(Joueur j) {
		if (listeJoueurs.size() < NBJOUEURMAX)
			listeJoueurs.add(j);
		else
			System.err.println("Le nombre max de joueurs a été atteint");
	}
	
	/**
	 * Démarrage du jeu
	 */
	public void lancerJeu() {
		finJeu = false;
		plateau.initialiserCases();
		for (int i=0; i<nbTours; i++) {
			if (!finJeu)
				tourJeu();
		}
		System.out.println(this);
	}
	
	/**
	 * Un tour de la partie
	 */
	public void tourJeu() {
		int nbJoueurs = listeJoueurs.size();
		Joueur joueur;
		int d1; //Dé 1
		int d2; //Dé 2
		int doubles = 0; //Nombre de doubles du joueur
		for (int j=0; j<nbJoueurs; j++) {
			joueur = listeJoueurs.get(j);
			d1 = lancerDe();
			d2 = lancerDe();
			//Gestion des doubles
			if (d1 == d2) {
				doubles++;
				if (doubles == 3) {
					emprisonner(joueur);
					doubles = 0;
				}
				else {
					joueur.setCoupsPrison(0);
					j--;
				}
			}
			else {
				doubles = 0;
			}
			if (joueur.getCoupsPrison() > 0) {
				joueur.setCoupsPrison(joueur.getCoupsPrison() - 1);
				if (joueur.getCoupsPrison() == 0)
					joueur.ajouterArgent(-50);
			}
			else {
				deplacerJoueur(joueur, d1+d2);
				plateau.getCase(joueur.getPosition()).eventCase(joueur); //Événement lorsque le joueur est sur la case
			}
			//Vérifie le solde du joueur
			if (joueur.getArgent() < 0) {
				finJeu = true; //Fin si un joueur a perdu
			}
		}
	}
	
	public int lancerDe() {
		int de = r.nextInt(DMAX)+1;
		return de;
	}
	
	public void deplacerJoueur(Joueur j, int nb) {
		int prevPos = j.getPosition();
		Case prevCase = plateau.getCase(prevPos);
		int pos = prevPos + nb;
		if (pos >= Plateau.NBCASES) {
			j.ajouterArgent(CaseDepart.getBonus());
			pos = pos % Plateau.NBCASES;
		}
		Case newCase = plateau.getCase(pos);
		prevCase.enleverJoueur(j);
		newCase.placerJoueur(j);
		j.setPosition(pos);
	}
	
	public void emprisonner(Joueur j) {
		int prevPos = j.getPosition();
		j.setCoupsPrison(3);
		Case prevCase = plateau.getCase(prevPos);
		Case newCase = plateau.getCase(NUMPRISON);
		prevCase.enleverJoueur(j);
		newCase.placerJoueur(j);
		j.setPosition(NUMPRISON);
	}

	@Override
	public String toString() {
		String msg = plateau.toString();
		return msg;
	}
}
