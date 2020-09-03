package application;

public class CaseTP extends Case {
	private int numero;
	
	public CaseTP(int x, int y, int n) {
		super(x, y, false);
		this.sprite = "case_2_3";
		this.setNumero(n);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
