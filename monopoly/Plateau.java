package monopoly;

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
			ParseJSON json = new ParseJSON();
			typeCase = json.getTypeCase(i);
			switch(typeCase) {
				case "depart": cases[i] = new CaseDepart(); break;
				case "propriete": cases[i] = new CasePropriete(i); break;
				case "impot": cases[i] = new CaseImpot(i); break;
				case "chance": cases[i] = new CaseChance(); break;
				case "prison": cases[i] = new CasePrison(); break;
				case "parc": cases[i] = new CaseParc(); break;
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
			msg += "[" + i + "] " + cases[i] + "\n";
		}
		return msg;
	}
}
