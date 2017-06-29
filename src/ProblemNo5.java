
public class ProblemNo5 {
	private long number;
	private long lcm;
	
	public ProblemNo5(long n) {
		number = n;
		System.out.println(lcmOfNumbersThrough(number));
	}
	
	private long lcmOfNumbersThrough(long n) {
		lcm = factorial(n);
		Boolean foundLcm = false; 
		
		while (!foundLcm) {
			for (int i = 2; i < n; i++) {
				for (int j = 2; j < n; j++) {
					if ((lcm / i) % j != 0 ) {
						if (j == n - 1) {
							foundLcm = true;
						}
						break;
					}
					if (j == n - 1) {
						lcm /= i;
					}
				}
			}
		}
		return lcm;
	}
	
	private long factorial(long n) {
		long f = n;
		for (long i = n - 1; i > 1; i--) {
			f *= i;
		}
		return f;
	}
}
