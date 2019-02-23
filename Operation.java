package fr.uvsq.inf103.Calculatrice;

public enum Operation{


	PLUS('+') { 

		public double eval(double op1, double op2) {
			return op1 + op2;
		}
	},

	
	MOINS('-') {

		public double eval(double op1, double op2) {
			return op2 - op1;
		}
	},

	MULT('*') {
		public double eval(double op1, double op2) {
			return op1 * op2;
		}
	},

	DIV('/') {

		public double eval(double op1, double op2){
			return op2 / op1;
		}

	};

	private char symbole;

	private Operation(char symbole) {
		this.symbole=symbole;
	}


	public abstract double eval(double op1, double op2);


	public char getSymbole() {
		return symbole;
	}

}