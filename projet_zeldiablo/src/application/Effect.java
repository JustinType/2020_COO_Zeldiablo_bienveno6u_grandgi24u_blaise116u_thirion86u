package application;

// TODO: Auto-generated Javadoc
/**
 * The Class Effect.
 */
public class Effect{
	
	/** The timer. */
	private int TIMER;
	
	/** The vitesse. */
	private int vitesse;
	
	/** The counter. */
	private int COUNTER;
	
	/**
	 * Instantiates a new effect.
	 *
	 * @param TIMER the timer
	 * @param vitesse the vitesse
	 */
	public Effect(int TIMER,int vitesse) {
		this.vitesse = vitesse;
		this.TIMER = TIMER;
	}

	/**
	 * Increse time.
	 *
	 * @return true, if successful
	 */
	public boolean increseTime() {
		COUNTER++;
		return (COUNTER != TIMER);
	}
	
	/**
	 * Gets the vitesse.
	 *
	 * @return the vitesse
	 */
	public int getVitesse() {
		return this.vitesse;
	}
	
}
