package monopoly;

public class CaseParc extends Case{

	public CaseParc() {
		super();
	}
	
	public void eventCase(Joueur j) {
		
	}
	
	@Override
	public String toString() {
		String msg = "Parc gratuit" + super.toString();
		return msg;
	}
}
