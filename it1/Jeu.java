package it1;

import java.util.*;

public class Jeu {
	private static final int NBJOUEURMAX = 6; //Nombre max de joueurs
	private static final int NBCASES = 40; //Nombre de cases
	private static final int DMAX = 6; //Valeur max du d�
	private ArrayList<Joueur> listeJoueurs; //Liste des joueurs
	private Case[] cases; //Cases du jeu
	private int nbTours; //Nombre de tours
	private static Random r = new Random();
	
	/**
	 * Constructeur de jeu
	 * @param nbTours Nombre de tours
	 */
	public Jeu(int nbTours) {
		this.nbTours = nbTours;
		listeJoueurs = new ArrayList<Joueur>();
		cases = new Case[NBCASES];
	}
	
	/**
	 * Ajoute un joueur � la liste des joueurs
	 * @param j Joueur � ajouter
	 */
	public void ajouterJoueur(Joueur j) {
		if (listeJoueurs.size() < NBJOUEURMAX)
			listeJoueurs.add(j);
		else
			System.err.println("Le nombre max de joueurs a �t� atteint");
	}
	
	/**
	 * Initialisation des cases du jeu
	 */
	public void initialiserCases() {
		for(int i=0; i<NBCASES; i++) {
			cases[i] = new Case();
		}
	}
	
	/**
	 * D�marrage du jeu
	 */
	public void lancerJeu() {
		int nbJoueurs = listeJoueurs.size();
		Joueur joueur;
		int pos; //Position du joueur
		int d1; //D� 1
		int d2; //D� 2
		initialiserCases();
		for (int i=0; i<nbTours; i++) {
			for (int j=0; j<nbJoueurs; j++) {
				joueur = listeJoueurs.get(j);
				pos = joueur.getPosition();
				d1 = r.nextInt(DMAX)+1;
				d2 = r.nextInt(DMAX)+1;
				cases[pos].enleverJoueur(joueur);
				pos = (pos+d1+d2) % NBCASES;
				joueur.setPosition(pos);
				cases[pos].placerJoueur(joueur);
			}
		}
		System.out.println(this);
	}
	
	@Override
	public String toString() {
		String msg = "";
		Joueur joueur;
		for (int i=0; i<NBCASES; i++) {
			msg += "Case " + i + " : " + cases[i];
		}
		return msg;
	}
}
