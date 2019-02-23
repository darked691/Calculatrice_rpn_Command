package fr.uvsq.inf103.Calculatrice;

public enum CalculatriceRPN {



	CALCULATRICE;



	/**

	 * Demande et Gestion de Saisie puis éxecution de l'opération en cas de saisie correcte

	 * sinon affiche "Saisie incorrecte" 

	 * @param args paramètre à mettre en arguments

	 */

	public void run(String[] args) {

			SaisieRPN saisie = new SaisieRPN();
			saisie.afficheValues();
			saisie.saisie();


	}

	

	/**

	 * Execute la fonction run

	 * @param args

	 */

	public static void main(String[] args) {

		CALCULATRICE.run(args);

	}

}
