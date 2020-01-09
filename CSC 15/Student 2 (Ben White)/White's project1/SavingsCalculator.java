/**
 * Helper class for Project 1
 * Called by driver class SavingCalculatorMain
 */
public class SavingsCalculator {
	// constant classes
	public static final double RATE_DECREMENT = 0.25;		//per year
	public static final double INITIAL_RATE = 0.4525;		//initial interest 45.25%
	public static final double BONUS_PER_STACK = 500;		//bonus added to initial deposit
	public static final double DEPOSIT = 3000;				//base initial deposit
	public static final double DEPOSIT_INCREMENT = 1000;	//$3000, $4000, $5000
	public static final int GRAPH = 10000;					//for the histogram
	
	public static void calBlocks() {		
		double saving = 0;		//initialize variable "saving"
		
		//loop 3 times for 3 reports with different initial deposits
		for (int rep = 0; rep <= 2; rep++) {
			double int_saving = DEPOSIT + rep * DEPOSIT_INCREMENT;	//initial saving is only for the heading part
			//print the heading
			System.out.println("-----------SAVING CALCULATOR-------------------------");
			System.out.printf("Initial Deposit: $%.1f\t Initial Rate: %%%.2f\n", int_saving, INITIAL_RATE*100);
			System.out.println("-----------------------------------------------------\n");
			
			//actual calculation
			//i = 0 is the 5-year block
			for (int i = 0; i <= 4; i++) {
				saving += int_saving;		//saving at the end of a block
				double bonus = i * BONUS_PER_STACK;		//bonus amount for the block, i as block's multiplier
				double rate = INITIAL_RATE / (1 + i*RATE_DECREMENT);
				int year = (i+1) * 5;		//year block
				
				//calculate the saving through out the time frame of current the block
				for (int j = 1; j <= 5*i + 3; j++) {
					//calculate the first year
					for (int k = 0; k < 2 - j; k++) {
						saving += bonus + ((saving + bonus) * rate);
					}
					//the rest
					saving += (saving * rate);
				}
				System.out.printf("%2s year: $%9.2f\t", year, saving);	//print out the result for a block
				
				for (int star = 1; star < saving/GRAPH; star++) {		//histogram, $10000 = 1 "*"
					System.out.print("*");
				}
				System.out.println();		//next block
				saving = 0;					//flush the current value before the next loop
			}
			System.out.println();		//next report
		}
	}
}		