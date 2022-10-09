import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// do 5 testcases
		
		for (int testcase=0;testcase<5;testcase++) {
			doTestcase();
		}
	}
	
	private static void doTestcase() {
		// do one testcase with 5 numbers
		
		for (int i=0;i<5;i++) {
			long number = sc.nextLong();
			int partial = calculatePartial(number);
			int remainder = partial % 10;
			int compensateDigit;
			if (remainder == 0) {
				compensateDigit = 0;
			} else {
				compensateDigit = 10-remainder;
			}
			System.out.print(compensateDigit);
		}
		System.out.println();
		
		
	}

	private static int calculatePartial(long number) {
		// calculate partial sum of a number
		long current = number;
		boolean doubleDigit = true;
		int sum = 0;
		while (current>0) {
			int lastDigit = (int)(current % 10);
			if (doubleDigit) {
				sum += addDigits(lastDigit*2);
			} else {
				sum += lastDigit;
			}
			current /= 10;
			doubleDigit =!doubleDigit;
		}
		
		return sum;
	}

	private static int addDigits(int num) {
		// sum up all digits of a number
		int current = num;
		int sum = 0;
		while (current>0) {
			sum += current % 10;
			current = current/10;
		}
		return sum;
	}

}
