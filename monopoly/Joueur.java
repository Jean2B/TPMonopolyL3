package monopoly;

public class Joueur {
	private String nom;
	private String code; //Code du joueur (J1, J2,...)
	private int position; //Position du pion
	private static int nbJoueurs = 0;
	private int argent;
	/**
	 * Constructeur de joueur
	 * @param nom Nom du joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
		nbJoueurs++;
		code = "J" + nbJoueurs;
	}
	
	/**
	 * Accesseur
	 * @return Nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Accesseur
	 * @return Position du joueur
	 */
	public int getPosition() {
		return position;
	}
	
	/**
	 * Modificateur
	 * @param pos Nouvelle position du joueur
	 */
	protected void setPosition(int pos) {
		position = pos;
	}
	
	@Override
	public String toString() {
		String msg = code + " " + nom + " (" + argent + "€)";
		return msg;
	}
	
	public void ajouterArgent(int a) {
		argent += a;
	}
}
