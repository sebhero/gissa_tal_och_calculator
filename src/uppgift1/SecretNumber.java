package uppgift1;

import java.io.BufferedReader;

/**
 * Holder and generator of the secret number.
 * @author seb
 *
 */
/**
 * @author seb
 *
 */
public class SecretNumber {

	int _low;
	int _high;
	int _secret;

	private Skrivare2 skriv;

	/**
	 * Default constructor
	 */
	public SecretNumber() {
	}

	/**
	 * Construtor take the readeline reader and connects it with the skrivare
	 *
	 * @param input
	 */
	public SecretNumber(BufferedReader input) {
		skriv = new Skrivare2(input);
	}

	/**
	 * Sets lower value. with number test
	 *
	 * @return lower number
	 */
	public int setLow() {
		return _low = this.skriv.askRowInt("Ange minsta värdet: ");
	}

	/**
	 * Sets higher value. with number test. prequirements is that the low number
	 * is generated.
	 *
	 * @return higher number
	 */
	public int setHigh() {
		int tal = this.skriv.askRowInt("Ange högsta värdet: ");
		// om low är inte skapad, skapa.
		if (((Integer) _low) == null) {
			_low = setLow();
		}
		// kolla att hightal är större än low
		if (tal > _low) {
			return tal;
		} else {
			Skrivare2.skrivUt("Högsta värdet måste vara högre än: " + _low);
			return setHigh();
		}
	}

	public void generateSecrect() {
		this.generateSecrect(setLow(), setHigh());
	}

	public int generateSecrect(int low, int high) {
		this._low = low;
		this._high = high;
		return this._secret = (int) (low + (Math.random() * (high - low)));
	}

	public NUM_RESULT checkAnswere(String answere) {
		try {
			int guess = Integer.parseInt(answere);
			if (guess == _secret) {
				return NUM_RESULT.RIGHT;
			}
			if (guess < _secret) {
				return NUM_RESULT.LOW;
			} else {
				// om det är inte lågt så måste det vara högt.
				return NUM_RESULT.HIGH;
			}

		} catch (NumberFormatException e) {
			// är inte ett nummer.
			return NUM_RESULT.ILLEGALE;
		}
	}
}
