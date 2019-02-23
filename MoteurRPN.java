package fr.uvsq.inf103.Calculatrice;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;

public class MoteurRPN implements Interpreteur{
	
	public Stack <Double> pile;
	public Hashtable co;
	
	public MoteurRPN() {
		pile=new Stack<Double>();
		co=new Hashtable();
		
	}
	public void push(double a){
		pile.push(a);
	}
	public Double enregistreOperande(double val) {
		return pile.push(val);
	}
	
	public Double calculeOperation(Operation op) {
		return enregistreOperande(op.eval(pile.pop(), pile.pop()));
	}
	
	public String listeOperandes(){
		String string = "";
		for(Double val: pile){
			string += val + " ";
		}

		return string;
	}

	public void undo() {
		pile.pop();
		System.out.println(listeOperandes());
	}
	
	public void quit() {
		System.out.println("CALCULATRICE QUITTEE. ");
	}

}
