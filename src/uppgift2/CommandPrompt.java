package uppgift2;

import java.text.MessageFormat;
import java.util.EnumMap;
import java.util.Iterator;

import uppgift1.Skrivare2;

public class CommandPrompt {

	public static final String input = "input> ";
	private static Skrivare2 skriv;
	private static EnumMap<COMMANDS, String> helpMap;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		skriv = new Skrivare2();
		initializeHelpInfo();
		start();
	}

	/**
	 * Initializes the Help info.
	 */
	private static void initializeHelpInfo() {
		helpMap = new EnumMap<COMMANDS, String>(COMMANDS.class);

		helpMap.put(COMMANDS.HELP, "\t Displays this help");
		helpMap.put(COMMANDS.H, "\t Displays this help");
		helpMap.put(COMMANDS.CALCULATE, "\t Perform a simple math calcultaion");
		helpMap.put(COMMANDS.CALC, "\t same as calcultaion");
		helpMap.put(COMMANDS.HELLO, "\t prints greeting on the screen");
		helpMap.put(COMMANDS.ODD, "\t Check if a certain number is even or odd");
		helpMap.put(COMMANDS.REPEAT,
				"\t Repeats a given string a number of times");
		helpMap.put(COMMANDS.QUIT, "\t Quit the program");
		helpMap.put(COMMANDS.Q, "\t Quit the program");
	}

	/**
	 * Prints out the help info
	 */
	private static void help() {
		Skrivare2.skrivUt("The following commands are valid:");

		Iterator<COMMANDS> enumKeySet = helpMap.keySet().iterator();
		while (enumKeySet.hasNext()) {
			COMMANDS currentCommand = enumKeySet.next();
			Skrivare2.skrivUt(MessageFormat.format(" {0} \t {1}",
					currentCommand, helpMap.get(currentCommand)));
		}
	}

	/**
	 * asks users to provide with a int. Then check if the int is odd or even.
	 */
	private static void odd() {
		int number;
		try {
			number = skriv.askRowInt("Enter an integer value: ");
			if ((number & 1) == 0) {
				Skrivare2.skrivUt(MessageFormat.format("Number {0} is Even",
						number));
			} else {
				Skrivare2.skrivUt(MessageFormat.format("Number {0} is Odd",
						number));
			}
		} catch (NumberFormatException e) {
			// kanske onödigt.
			Skrivare2.skrivUt("Ogiltig siffra");
			odd();
		}

	}

	/**
	 * Start funktion. holds the menu and handles start and exit.
	 */
	private static void start() {
		COMMANDS command;
		// do {
		String svar = skriv.askRow(input);
		try {
			command = COMMANDS.valueOf(svar.toUpperCase());
		} catch (IllegalArgumentException e) {
			Skrivare2.skrivUt("illegal arg.");
			command = COMMANDS.MISSING;
		}

		switch (command) {
		case H:
		case HELP:
			help();
			break;
		case CALC:
		case CALCULATE:
			calc();
			break;
		case HELLO:
			helloWorld();
			break;
		case ODD:
			odd();
			break;
		case REPEAT:
			repeat();
			break;
		case MISSING:
		default:
			Skrivare2.skrivUt("Kunde inte hitta funktionen");
			break;
		case Q:
		case QUIT:
			Skrivare2.skrivUt("hej då");
			System.exit(0);
			break;

		}
		// recursive kallar på start igen. Fungerar iom System.exit(0) avbryter
		// allt.
		start();
		// } while (!command.equals(COMMANDS.QUIT));
		//
	}

	/**
	 * Simple calculator.
	 */
	private static void calc() {
		Skrivare2
				.skrivUt("To perform this operation you have to enter 2 operands and one operator.");
		double tal1 = skriv.askRowDouble("First Operand: ");
		double tal2 = skriv.askRowDouble("Second Operand: ");
		CalcDao svar = doCalc(tal1, tal2);
		Skrivare2.skrivUt(MessageFormat.format("{0} {2} {1} = {3}", tal1, tal2,
				svar.get_operator(), svar.get_answere()));
	}

	/**
	 * Help class for the calc. Does the calculation
	 * 
	 * @param tal1
	 *            first input number
	 * @param tal2
	 *            second input number
	 * @return solution
	 */
	private static CalcDao doCalc(double tal1, double tal2) {
		String op = skriv.askRow("Operator: ");
		switch (op) {
		case "*":
			return new CalcDao("*", (tal1 * tal2));
		case "/":
			return new CalcDao("/", (tal1 / tal2));
		case "+":
			return new CalcDao("+", (tal1 + tal2));
		case "-":
			return new CalcDao("-", (tal1 - tal2));
		default:
			Skrivare2.skrivUt("Not a valid Operator");
			return doCalc(tal1, tal2);
		}
	}

	/**
	 * reapets a string x number of times
	 */
	private static void repeat() {
		String text = skriv.askRow("Enter the string: ");
		int times = skriv.askInt("Number of times to print the string: ");
		for (int i = 0; i < times; i++) {
			Skrivare2.skrivUt(text);
		}

	}

	/**
	 * prints out hello world.
	 */
	private static void helloWorld() {
		Skrivare2.skrivUt("Hello world!");
	}
}
