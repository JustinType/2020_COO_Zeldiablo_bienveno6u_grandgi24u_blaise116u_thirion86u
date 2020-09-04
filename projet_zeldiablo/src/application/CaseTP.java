package application;

// TODO: Auto-generated Javadoc
/**
 * The Class CaseTP.
 */
public class CaseTP extends Case {
	
	/** The numero. */
	private int numero;
	
	/**
	 * Instantiates a new case TP.
	 *
	 * @param x the x
	 * @param y the y
	 * @param n the n
	 */
	public CaseTP(int x, int y, int n) {
		super(x, y, false);
		this.sprite = "case_2_3";
		this.setNumero(n);
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

}
