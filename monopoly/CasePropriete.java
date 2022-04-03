package monopoly;

public class CasePropriete extends Case {

	private String nomProp;
	private int prixProp;
	private int loyer;
	private Joueur proprietaire;
	
	public CasePropriete(int num) {
		super();
		ParseJSON json = new ParseJSON();
		nomProp = json.getNomPropriete(num);
		prixProp = json.getPrixPropriete(num);
		loyer = prixProp/10;
	}
	
	public void eventCase(Joueur j) {
		if (proprietaire == null) {
			if (j.getArgent() >= prixProp && Controleur.askAchat(this, j)) {
				proprietaire = j;
				j.ajouterArgent(-prixProp);
			}
		}
		else
			loyer(j);
	}
	
	public String getNom() {
		return nomProp;
	}
	
	public int getPrix() {
		return prixProp;
	}
	
	public void loyer(Joueur j) {
		j.ajouterArgent(-loyer); //Le loyer correspond à 1/10 du prix de la propriété
		proprietaire.ajouterArgent(loyer);
	}
	
	@Override
	public String toString() {
		String msg = nomProp + " (Prix: " + prixProp;
		if (proprietaire != null)
			msg += ", chez " + proprietaire.getNom();
		msg += ")" + super.toString();
		return msg;
	}
}
