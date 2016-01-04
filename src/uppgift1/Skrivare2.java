package uppgift1;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Simple print text class Handles different type of printing text making.
 * asking qeustions
 *
 * @version 2
 * @author seb
 *
 */
public class Skrivare2 {

	private BufferedReader _lineReader = null;

	/**
	 * Default constructor initalizes the line reader
	 */
	public Skrivare2() {
		_lineReader = new BufferedReader(new InputStreamReader(System.in));
	}

	/**
	 * programmer provides reader.
	 *
	 * @param input
	 */
	public Skrivare2(BufferedReader input) {
		_lineReader = input;
	}

	/**
	 * Prints out a question to user and check if user provides a not null or
	 * empty answer.
	 *
	 * @param question
	 *            text of the question
	 * @return users answer.
	 */
	public String ask(String question) {
		System.out.println(question);
		try {
			String svar = _lineReader.readLine();

			// slutat använda google guave för att jag använde bara använder den
			// 2 gånger
			// if (Strings.isNullOrEmpty(svar) == false) {
			if (svar != null && svar.isEmpty() == false) {
				return svar;
			} else {
				Skrivare2.skrivUt("ogiltigt svar");
				return ask(question);
			}

		} catch (IOException e) {
			// ställ frågan igen.
			return ask(question);
		}
	}

	/**
	 * Similare to ask but returns a int
	 *
	 * @param question
	 * @return user answere as int.
	 */
	public int askInt(String question) {
		try {
			return Integer.parseInt(ask(question));

		} catch (NumberFormatException e) {
			Skrivare2.skrivUt("Ogiltig siffra");
			return askInt(question);
		}
	}

	/**
	 * Similare to askint but askes in a row.
	 *
	 * @param question
	 * @return user answere as int.
	 */
	public int askRowInt(String question) {
		try {
			return Integer.parseInt(askRow(question));

		} catch (NumberFormatException e) {
			Skrivare2.skrivUt("Ogiltig siffra");
			return askRowInt(question);
		}
	}

	/**
	 * Prints out a question to user and check if user provides a not null or
	 * empty answer. on same row
	 *
	 * @param question
	 *            text of the question
	 * @return users answer.
	 */
	public String askRow(String question) {
		System.out.print(question);
		try {
			String svar = _lineReader.readLine();

			// slutat använda google guave för att jag använde bara använder den
			// 2 gånger
			// if (Strings.isNullOrEmpty(svar) == false) {
			if (svar != null && svar.isEmpty() == false) {
				return svar;
			} else {
				Skrivare2.skrivUt("ogiltigt svar");
				return askRow(question);
			}

		} catch (IOException e) {
			// ställ frågan igen.
			return askRow(question);
		}
	}

	/**
	 * Simplifies the writing System.out.println
	 *
	 * @param text
	 *            text you want to display to the user.
	 */
	public static void skrivUt(String text) {
		System.out.println(text);
	}

	/**
	 * Simplifies the writing on same line; System.out.print
	 *
	 * @param text
	 *            text you want to display to the user.
	 */
	public static void skrivUtRad(String text) {
		System.out.print(text);
	}

	/**
	 * Simplifies the writing Jpan popup With out qualifiers.
	 *
	 * @param question
	 *            question you want to ask the user.
	 */
	public String popup(String question) {
		return JOptionPane.showInputDialog(question);
	}

	/**
	 * Similare to ask in the same row and returns a double
	 *
	 * @param question
	 * @return users answer is a double value.
	 */
	public double askRowDouble(String question) {
		try {
			return Double.parseDouble(askRow(question));
		} catch (NumberFormatException e) {
			Skrivare2.skrivUt("error occurred, not a number");
			return askRowDouble(question);
		}
	}
}
