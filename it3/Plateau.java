package it3;

public class Plateau {
	protected static final int NBCASES = 40; //Nombre de cases
	private Case[] cases; //Cases du jeu
	
	public Plateau() {
		cases = new Case[NBCASES];
	}
	
	/**
	 * Initialisation des cases du jeu
	 */
	public void initialiserCases() {
		String typeCase;
		for(int i=0; i<NBCASES; i++) {
			typeCase = ParseJSON.getTypeCase(i);
			switch(typeCase) {
				case "depart": cases[i] = new CaseDepart();
				case "propriete": cases[i] = new CasePropriete(i);
				case "impot": cases[i] = new CaseImpot(i);
				case "chance": cases[i] = new CaseChance(i);
				case "prison": cases[i] = new CasePrison(i);
			}
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
