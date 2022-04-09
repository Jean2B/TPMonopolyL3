package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import monopoly.*;

class MonopolyTest {

	@DisplayName("Test prison")
	@Test
	void testPrison() {
		Jeu jeu = new Jeu(10);
		Joueur j = new Joueur("Test");
		jeu.ajouterJoueur(j);
		Plateau plateau = jeu.getPlateau();
		plateau.initialiserCases();
		assertEquals(0, j.getPosition());
		jeu.emprisonner(j);
		assertEquals(10, j.getPosition());
		assertEquals(3, j.getCoupsPrison());
		
	}

}
