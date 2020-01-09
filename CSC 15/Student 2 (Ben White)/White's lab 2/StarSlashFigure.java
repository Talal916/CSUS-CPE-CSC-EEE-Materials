/**
 * Helper class for the Star Slash Program
 */
public class StarSlashFigure {
	//adjust the size of the shape via constant class
	public static final int HEIGHT = 10;
	
	public static void drawSlashFigure() {
		/*
		 * Draw complete figure by calling the
		 * drawUpperPart(), drawDivider(), and drawLowerPart()
		 * methods
		 */
		drawUpperPart();
		drawDivider();
		drawLowerPart();
	}
	
	//draw the top part of the shape
	public static void drawUpperPart() {
		drawLine();				//draw the top horizontal line
		drawFwrdSlshLines();	//draw the star forward slash lines
	}
	
	//draw a line with "+" on each ends and "-" in between
	public static void drawLine() {	
		System.out.print("+");
		for (int i = 1; i <= HEIGHT * 4; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	public static void drawFwrdSlshLines() {
		//loop (HEIGHT + 1) times, once for each line
		for (int i = 1; i <= HEIGHT + 1; i++) {
			// *
			for (int j = 1; j <= HEIGHT + 1 - i; j++) {
				System.out.print("*");
			}
			// spaces
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}
			// slash
			for (int l = 1; l <= HEIGHT * 2 + 2 - 2 * i; l++) {
				System.out.print("/");
			}
			// backslash
			for (int m = 1; m <= 2 * i - 2; m++) {
				System.out.print("\\");
			}
			// spaces
			for (int k = 1; k <= i; k++) {
				System.out.print(" ");
			}
			// *
			for (int j = 1; j <= HEIGHT + 1 - i; j++) {
				System.out.print("*");
			}
		System.out.println();//go to next line
		}
	}
	
	public static void drawDivider() {
		//Draw the front slash line that has no "*"
		for (int i = 0; i <= HEIGHT; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i <= HEIGHT * 2 - 1; i++) {
			System.out.print("/");
		}
		System.out.println();
	}

	//draw the bottom part of the shape
	public static void drawLowerPart() {
		drawBckwrdSlshLines();		//draw the slashes line
		drawLine();					//draw the bottom horizontal line
	}
	
	public static void drawBckwrdSlshLines() {
		// loop (HEIGHT) times, once for each line
		for (int i = 1; i <= HEIGHT; i++) {
			// *
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			// spaces
			for (int k = 1; k <= HEIGHT + 1 - i; k++) {
				System.out.print(" ");
			}
			// backslash
			for (int m = 1; m <= HEIGHT * 2 + 2 - 2 * i; m++) {
				System.out.print("\\");
			}
			// slash
			for (int l = 1; l <= 2 * i - 2; l++) {
				System.out.print("/");
			}
			// spaces
			for (int k = 1; k <= HEIGHT + 1 - i; k++) {
				System.out.print(" ");
			}
			// *
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}