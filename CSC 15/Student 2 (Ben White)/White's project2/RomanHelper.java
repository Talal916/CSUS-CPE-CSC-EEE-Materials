/**
 * Helper class for the program
 */
public class RomanHelper {
	public static void description() {
		System.out.println("******************************************************");
		System.out.println("*       Welcome to the Roman Numeral Converter!      *");
		System.out.println("* You can use this tool to convert any decimal value *");
		System.out.println("* into a Roman Numeral. To get started, please enter *");
		System.out.println("* how many decimal numbers you need to convert.      *");
		System.out.println("******************************************************\n");
	}
	
	public static String getRoman(int number) {
		String roman = new String("");
		int multiple;

		if (number >= 1000) {					//adding one "M" per 1000
			multiple = number/1000;
			for (int i = 0; i < multiple; i++) {
				roman += "M";
			}
			number = number%1000;
		}
		if (number >= 900) {
			number -= 900;
			roman += "CM";
		}
		if (number >= 500) {
			number -= 500;
			roman += "D";
		}
		if (number >= 400) {
			number -= 400;
			roman += "CD";
		}
		
		if (number >= 100) {
			multiple = number/100;				//adding one "C" per 100
			for (int i = 0; i < multiple; i++) {
				roman += "C";
			}
			number = number%100;
		}
		if (number >= 90) {
			number -= 90;
			roman += "XC";
		}
		if (number >= 50) {
			number -= 50;
			roman += "L";
		}
		if (number >= 40) {
			number -= 40;
			roman += "XL";
		}
		
		if (number >= 10) {
			multiple = number/10;					//adding one "X" per 10
			for (int i = 0; i < multiple; i++) {
				roman += "X";
			}
			number = number%10;
		}
		if (number >= 9) {
			number -= 9;
			roman += "IX";
		}
		if (number >= 5) {
			number -= 5;
			roman += "V";
		}
		if (number >= 4) {
			number -= 4;
			roman += "IV";
		}
		if (number >= 1) {					//adding one "I" per 1
			for (int i = 0; i < number; i++) 
				roman += "I";
		}
		
		return roman;
	}
}