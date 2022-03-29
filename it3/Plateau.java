package it3;

public class Plateau {
	protected static final int NBCASES = 40; //Nombre de cases
	private Case[] cases; //Cases du jeu
	
	/**
	 * Constructeur de plateau
	 */
	public Plateau() {
		cases = new Case[NBCASES];
		
	}
	
	/**
	 * Initialisation des cases du jeu
	 */
	public void initialiserCases() {
		for(int i=0; i<NBCASES; i++) {
			cases[i] = new Case(i*10);
		}
	}
	
	public Case getCase(int pos) {
		return cases[pos];
	}
	
	@Override
	public String toString() {
		String msg = "";
		for (int i=0; i<NBCASES; i++) {
			msg += "Case " + i + " : " + cases[i];
		}
		return msg;
	}

}
