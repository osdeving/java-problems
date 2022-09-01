package br.com.willams.util;

public class ConsolePrinter {
	public enum Color {
		BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE,
	}

	public enum Style {
		NORMAL, BOLD, DUMMY1, DUMMY2, UNDERLINE
	}

	private static final String ESCAPE_CODE = "\033[";
	private static final String NORMAL = "0";
	private static final String BOLD = "1";
	private static final String UNDERLINE = "4";

	private static final String FOREGROUND = "3";
	private static final String BACKGROUND = "4";

	public static String createEscapeSequence(Color color, boolean isForeground, Style style) {
		if(isForeground)
			return ESCAPE_CODE + style.ordinal() + ";3" + color.ordinal() + "m";
		else
			return ESCAPE_CODE + "4" + color.ordinal() + "m";
	}

	// Reset
	public static final String RESET = "\033[0m";  // Text Reset

	// Regular Colors
	public static final String BLACK = "\033[0;30m";   // BLACK
	public static final String RED = "\033[0;31m";     // RED
	public static final String GREEN = "\033[0;32m";   // GREEN
	public static final String YELLOW = "\033[0;33m";  // YELLOW
	public static final String BLUE = "\033[0;34m";    // BLUE
	public static final String PURPLE = "\033[0;35m";  // PURPLE
	public static final String CYAN = "\033[0;36m";    // CYAN
	public static final String WHITE = "\033[0;37m";   // WHITE

	// Bold
	public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
	public static final String RED_BOLD = "\033[1;31m";    // RED
	public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
	public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
	public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
	public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

	// Underline
	public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
	public static final String RED_UNDERLINED = "\033[4;31m";    // RED
	public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
	public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
	public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
	public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
	public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
	public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

	// Background
	public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
	public static final String RED_BACKGROUND = "\033[41m";    // RED
	public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
	public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
	public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
	public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
	public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
	public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

	// High Intensity
	public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
	public static final String RED_BRIGHT = "\033[0;91m";    // RED
	public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
	public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
	public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
	public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
	public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
	public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

	// Bold High Intensity
	public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
	public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
	public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
	public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
	public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
	public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
	public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
	public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

	// High Intensity backgrounds
	public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
	public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
	public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
	public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
	public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
	public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
	public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
	public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

	public static ConsolePrinter console = new ConsolePrinter();

	private static void reset() {
		System.out.print(RESET);
	}

	public static ConsolePrinter ln() {
		System.out.println();
		return console;
	}

	private static <T> ConsolePrinter print(T text, String colorCode) {
		System.out.print(colorCode);
		System.out.print(text);
		reset();
		return console;
	}

	public static <T> ConsolePrinter red(T text) { return print(text, RED); }
	public static <T> ConsolePrinter strongRed(T text) { return print(text, RED_BOLD); }
	public static <T> ConsolePrinter underlineRed(T text) { return print(text, RED_UNDERLINED); }

	public static <T> ConsolePrinter blue(T text) { return print(text, BLUE); }
	public static <T> ConsolePrinter strongBlue(T text) { return print(text, BLUE_BOLD); }
	public static <T> ConsolePrinter underlineBlue(T text) { return print(text, BLUE_UNDERLINED); }


	public static <T> ConsolePrinter green(T text) { return print(text, GREEN); }
	public static <T> ConsolePrinter strongGreen(T text) { return print(text, GREEN_BOLD); }
	public static <T> ConsolePrinter underlineGreen(T text) { return print(text, GREEN_UNDERLINED); }

	public static <T> ConsolePrinter purple(T text) { return print(text, PURPLE); }
	public static <T> ConsolePrinter strongPurple(T text) { return print(text, PURPLE_BOLD); }
	public static <T> ConsolePrinter underlinePurple(T text) { return print(text, PURPLE_UNDERLINED); }

	public static <T> ConsolePrinter white(T text) { return print(text, WHITE); }
	public static <T> ConsolePrinter strongWhite(T text) { return print(text, WHITE_BOLD); }
	public static <T> ConsolePrinter underlineWhite(T text) { return print(text, WHITE_UNDERLINED); }

	public static <T> ConsolePrinter black(T text) { return print(text, BLACK); }
	public static <T> ConsolePrinter strongBlack(T text) { return print(text, BLACK_BOLD); }
	public static <T> ConsolePrinter underlineBlack(T text) { return print(text, BLACK_UNDERLINED); }

	public static <T> ConsolePrinter yellow(T text) { return print(text, YELLOW); }
	public static <T> ConsolePrinter strongYellow(T text) { return print(text, YELLOW_BOLD); }
	public static <T> ConsolePrinter underlineYellow(T text) { return print(text, YELLOW_UNDERLINED); }

	public static <T> ConsolePrinter cyan(T text) { return print(text, CYAN); }
	public static <T> ConsolePrinter strongCyan(T text) { return print(text, CYAN_BOLD); }
	public static <T> ConsolePrinter underlineCyan(T text) { return print(text, CYAN_UNDERLINED); }


	public static void main(String[] args) {
		ConsolePrinter
			.blue("Ola ")
			.strongBlue("Mundo ")
			.strongWhite("cruel!")
			.ln();

		System.out.println(createEscapeSequence(Color.RED, true, Style.UNDERLINE) + "ola");
	}
}