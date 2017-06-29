
public class ProblemNo3 {
	private long maxNum;
	
	public ProblemNo3(long m) {
		maxNum = m;
		System.out.println(largestPrimeFactorOf(maxNum));
	}
	
	public static long largestPrimeFactorOf(long maxNum) {
		long s = smallestPrimeFactorOf(maxNum);
		if (s == maxNum) {
			return maxNum;
		}
		return largestPrimeFactorOf(maxNum / s);
	}
	
	private static long smallestPrimeFactorOf(long n) {
		for (long i = 2; i < n; i++) {
			if (n % i == 0) {
				return i;
			}
		}
		return n;
	}
}
