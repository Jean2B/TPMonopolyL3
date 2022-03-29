package it3;

public class Joueur {
	private String nom;
	private String code; //Code du joueur (J1, J2,...)
	private int position; //Position du pion
	private static int nbJoueurs = 0; //Nombre de joueurs en jeu
	private int solde; //Solde du joueur
	/**
	 * Constructeur de joueur
	 * @param nom Nom du joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
		position = 0;
		solde = 1500;
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
		String msg = code + " " + nom;
		return msg;
	}
	
	public void ajouterArgent(int a) {
		solde += a;
	}
}
