package it3;

import java.util.*;

public class Jeu {
	private static final int NBJOUEURMAX = 6; //Nombre max de joueurs
	private static final int DMAX = 6; //Valeur max du dé
	private ArrayList<Joueur> listeJoueurs; //Liste des joueurs
	private int nbTours; //Nombre de tours
	private static Random r = new Random();
	private Plateau plateau;
	
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
		int nbJoueurs = listeJoueurs.size();
		Joueur joueur;
		int pos; //Position du joueur
		int d1; //Dé 1
		int d2; //Dé 2
		int doubles = 0; //Nombre de doubles du joueur
		plateau.initialiserCases();
		for (int i=0; i<nbTours; i++) {
			for (int j=0; j<nbJoueurs; j++) {
				joueur = listeJoueurs.get(j);
				d1 = lancerDe();
				d2 = lancerDe();
				deplacerJoueur(joueur, d1+d2);
				//Gestion des doubles
				if (d1 == d2) {
					doubles++;
					if (doubles == 3)
						System.err.println("prison");
					j--;
				} else {
					doubles = 0;
				}
			}
		}
		System.out.println(plateau);
	}
	
	public int lancerDe() {
		int de = r.nextInt(DMAX)+1;
		return de;
	}
	
	public void deplacerJoueur(Joueur j, int nb) {
		int prevPos = j.getPosition();
		Case prevCase = plateau.getCase(prevPos);
		int pos = (prevPos+nb) % Plateau.NBCASES;
		Case newCase = plateau.getCase(pos);
		prevCase.enleverJoueur(j);
		newCase.placerJoueur(j);
		j.setPosition(pos);
	}

}
