package monopoly;

public class CasePrison extends Case {
	
	public CasePrison() {
		super();
	}
	
	public void eventCase(Joueur j) {
		
	}
	
	@Override
	public String toString() {
		String msg = "Prison" + super.toString();
		return msg;
	}
}
