package uppgift1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ex04_17 - GissaTal.java
 *
 * @author Robert Jonsson
 *
 *         Testar att använda do-while och metoder i Math. Ett tal slumpas fram
 *         och användaren ska gissa vilket talet är.
 */
public class GissaTal {
	public static void main(String[] args) throws IOException {

		// För att kunna läsa in från tangentbordet
		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));
		// Secrect number object
		SecretNumber secret = new SecretNumber(input);
		// create a secret number
		secret.generateSecrect(secret.setLow(), secret.setHigh());

		// Skapar en flaggan som är tänkt att indikerar när vi gissat rätt
		// (den sätts till true när vi gissar rätt). Vi initierar den till
		// false eftersom vi ännu inte gissat och då inte kan ha gissat rätt
		// flaggan används i do-while-loopen för att avgöra när loopen ska
		// avbrytas
		boolean ok = false;

		// Skriver ut en "rubrik" till användaren
		System.out.println("Gissa vilket tal jag tänker på...\n");
		System.out.println("Skriv-> sluta\nför att avsluta\n");

		// Utför do-while -loopen
		do {
			// Läser in och konverterar strängen till ett tal
			System.out.print("gissning> ");
			String s = input.readLine();

			// check if user want to quit.
			if (s.equalsIgnoreCase("sluta")) {
				Skrivare2.skrivUt("Avslutar programemt");
				break;
			} else {
				// check users input is correct.
				switch (secret.checkAnswere(s)) {
					case RIGHT:
						ok = true;
						System.out.println("Rätt gissat!");
						break;
					case HIGH:
						Skrivare2.skrivUt("Din gissning är för hög");
						break;
					case LOW:
						Skrivare2.skrivUt("Din gissning är för låg");
						break;
					case ILLEGALE:
					default:
						Skrivare2
								.skrivUt("Din gissning är för ogiltig, skrev du verkligen in ett nummer");
						break;
				}
			}

			// Kollar om våran gissning är lika med talet
			// ok = (gissning == tal);

			// if (!ok) {
			// System.out.println(gissning + " är inte talet jag tänker på");
			// }

		} while (!ok);

	}
}