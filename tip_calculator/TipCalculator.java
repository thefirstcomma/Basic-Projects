import java.util.*;

public class TipCalculator {

	public static void main(String[] args) throws NumberFormatException {
		double bill = 0;
		double tip_rate = 0;
		double total = 0;
		double tip_value = 0;
		double result[] = checkValidNumber();

		bill = result[0];
		tip_rate = result[1];
		tip_value = tip_rate * bill;

		System.out.println(String.format("Tip value: $%.2f", tip_value));
		System.out.println(String.format("Total Bill: $%.2f", (bill + tip_value)));
	}

	public static double[] checkValidNumber() throws NumberFormatException{
		int count = 0;
		int max_tries = 10;
		double result[] = new double[2];
		while(true) {
			try {
				result = prompt();
				break;
			} catch (NumberFormatException e){
				System.out.println("Please enter a valid number for the bill/tip amount.\n");
				if(++count == max_tries) throw e;
			}
		}
		return result;
	}

	public static double[] prompt() {
		Scanner scan = new Scanner(System.in);
		double bill = -1;
		double tip_rate = -1;

		while(bill < 0 || tip_rate < 0) {
			System.out.print("What is the bill amount?\n>> ");
			String billString = scan.nextLine();
			bill = Double.valueOf(billString);

			System.out.print("What is the tip percentage?\n>> ");
			String tipString = scan.nextLine();
			tip_rate = Double.valueOf(tipString)/100.0;

			if(bill < 0 || tip_rate < 0) {
				System.out.println("Cannot input Negative numbers!\n");
			}

		}
		return new double[] {bill, tip_rate};
	}
	
}