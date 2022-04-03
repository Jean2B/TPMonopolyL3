package monopoly;

import java.util.Random;

public class CaseChance extends Case {
	
	private int mystere;
	private static Random r = new Random();
	
	public CaseChance() {
		super();
		mystere = r.nextInt(2)*200-100;
	}
	
	public void eventCase(Joueur j) {
		j.ajouterArgent(mystere);
	}
	
	public int getMystere() {
		return mystere;
	}
	
	@Override
	public String toString() {
		String msg = "Chance" + " (" + mystere + ")" + super.toString();
		return msg;
	}

}
