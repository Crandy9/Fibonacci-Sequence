package fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

	// recursive method
	public static int fibRecursion(int n) {
		// if the number is 0, just return it
		// this is the base case that the below code will succumb to eventually
		if (n <= 1) {
			return n;
		}

		// recursion explanation:
		/*
		 * Basically whatever n equals, the medothds will continually (recursively) be
		 * called until n eventually equals 0 or 1 then, the function will add up all of
		 * the recursive values for each of the method calls which will produce the
		 * fibonacci number
		 * 
		 */
		return fibRecursion(n - 1) + fibRecursion(n - 2);

	}

	// iterative method
	public static int fibIteration(int n) {
		// if the number is 0, just return it
		if (n <= 1) {
			return n;
		}

		int previous = 0, current = 1;

		for (int i = 0; i < n - 1; i++) {
			// a fibonacci number is a sum of the two previous numbers
			int newNum = previous + current;

			// the previous number gets the current number's value
			previous = current;

			// the current number gets the newNum number's value
			current = newNum;
		}

		return current;

	}

	/*
	 * this method basically follows the same methodology as the recursive method above, but is more
	 * efficient by storing already calculated values in a HashMap
	 */

	public static int fibMap(int n, Map<Integer, Integer> map) {

		if (n <= 1) {
			return n;
		}

		map.putIfAbsent(n, fibMap(n - 1, map) + fibMap(n - 2, map));

		return map.get(n);
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		Scanner scan;
		scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		/*
		 * alternatively, if you do not wish to use a scanner, let int num = any integer
		 */

		// send the user input number to the various methods
		System.out.println("The nth Fibonacci number using recursion: " + fibRecursion(num) + "\n");

		System.out.println("The nth Fibonacci number using iteration(for loop): " + fibIteration(num) + "\n");
		System.out.println("The nth Fibonacci number using a HashMap: " + fibMap(num, map) + "\n");

		// close scanner
		scan.close();
	}

}
