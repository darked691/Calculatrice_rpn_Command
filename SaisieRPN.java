package fr.uvsq.inf103.Calculatrice;

import java.util.Scanner;

public class SaisieRPN {

	private Scanner scanner;
	private MoteurRPN moteur;

	public SaisieRPN() {
		this.scanner = new Scanner(System.in);
		this.moteur = new MoteurRPN();
	}


	public void saisie(){

		String string = "";
		boolean arret = false;
		System.out.println("Saisir nombre, opération ou exit pour quitter la calculatrice.");

		while (arret == false) {

			if (scanner.hasNextDouble()) { // si la saisie est un nombre
				moteur.enregistreOperande(scanner.nextDouble()); // on met le nombre en haut de la pile
				System.out.println(moteur.listeOperandes()); // affichage opérande
				string = scanner.nextLine(); // lecture de la prochaine saisie
			}

			else { // si la saisie est une opération ou une chaine de caractère
				string = scanner.nextLine();
				if (this.testeOperation(string)) {// si la saisie est une opération
						// enlève les deux premiers éléments, fait l'opération et met le résultat dans la pile 
						moteur.calculeOperation(this.renvoieOperation(string)); 
						System.out.println(moteur.listeOperandes());  
				}

				// si la saisie est "exit", on arrête le programme 
				else if (string.equals("quit")) {
					arret = true;
					moteur.quit();
				}
				else if(string.equals("undo")) {
					moteur.undo();
				}

				else
					System.out.println("ERREUR CALCULATRICE : Saisie Incorrecte. ");
			}
		}
	}


	private boolean testeOperation(String string) {
		if (string.length() != 1)
			return false;
		return this.renvoieOperation(string) != null;
	}


	private Operation renvoieOperation(String string) {
		for (Operation op : Operation.values())
			if (string.charAt(0) == op.getSymbole())
				return op;
		return null;
	}

	public MoteurRPN getMoteurRPN() {
		return this.moteur;
	}

	public void afficheValues(){
		System.out.println(moteur.listeOperandes());
	}

}