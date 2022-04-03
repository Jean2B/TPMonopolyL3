package monopoly;

public class CaseImpot extends Case {
	
	private int montant;

	public CaseImpot(int num) {
		super();
		ParseJSON json = new ParseJSON();
		montant = json.getMontant(num);
	}
	
	public void eventCase(Joueur j) {
		j.ajouterArgent(-montant);
	}
	
	public int getTaxe() {
		return montant;
	}
	
	@Override
	public String toString() {
		String msg = "Impots" + " (Payer " + montant + ")" + super.toString();
		return msg;
	}
}
