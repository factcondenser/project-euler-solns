/**
 * The sum of the squares of the first ten natural numbers is,
 * 12 + 22 + ... + 102 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * @author Mark Pan
 *
 */
public class ProblemNo6 {
	private int numberOfTerms;
	
	public ProblemNo6(int n) {
		numberOfTerms = n;
		System.out.println(squareOfSum(numberOfTerms) - sumOfSquares(numberOfTerms));
	}
	
	private long sumOfSquares(int n) {
		long sum = n * n;
		
		for (int i = n - 1; i > 0; i--) {
			sum += i * i;
		}
		
		return sum;
	}
	
	private long squareOfSum(int n) {
		long sum = n;
		
		for (int i = n - 1; i > 0; i--) {
			sum += i;
		}
		
		return sum * sum;
	}
}
