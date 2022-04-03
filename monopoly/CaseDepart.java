package monopoly;

public class CaseDepart extends Case {
	
	private static final int BONUS = 200;
	
	public CaseDepart() {
		super();
	}
	
	public void eventCase(Joueur j) {
		
	}
	
	public static int getBonus() {
		return BONUS;
	}
	
	@Override
	public String toString() {
		String msg = "Case départ" + super.toString();
		return msg;
	}
}
