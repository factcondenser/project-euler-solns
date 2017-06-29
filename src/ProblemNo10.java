/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * @author Mark Pan
 *
 */
public class ProblemNo10 {
	int limit;
	
	public ProblemNo10(int lim) {
		limit = lim;
		System.out.println(sumOfPrimesBelowUber(limit));
	} 
	
	private long sumOfPrimesBelowRecursive(long limit) {
		long sum = 0;
		
		if (limit == 2) {
			return sum;
		}
		
		if (isPrime(--limit)) {
			sum += limit;
			//System.out.println("curr = " + limit + "; sum = " + sum);
		}
		
		return sum + sumOfPrimesBelowRecursive(limit);
	}
	
	// 1353076ms
	private long sumOfPrimesBelow(long limit) {
		long sum = 0;
		
		if (limit <= 2) {
			return sum;
		}
		
		for (long i = 3; i < limit ; i += 2) {
			if (isPrime(i)) {
				sum += i;
				System.out.println("curr = " + i + "; sum = " + sum);
			}
		}
		
		return sum + 2;
	}
		
	private Boolean isPrime(long n) {
		
		if (n == 2 || n == 3 || n == 5 || n == 7) {
			return true;
		}
		
		if (n % 2 == 0 || n % 5 == 0 || n % 3 == 0 || n % 7 == 0) {
			return false;
		}
		
		for (long i = 11; i < n ; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		
		if (n == 1) {
			return false;
		}
		
		return true;
	}
	
	// 5983ms
	private long sumOfPrimesBelowUber(int n) {
		Boolean[] isPrime = new Boolean[n];
        
        for (int i = 0; i < n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i < (int)Math.sqrt(n) + 1; i++){
            if (isPrime[i]) {
                
                for (int j = 2; j * i < n; j++) { 
                    isPrime[i * j] = false;
                }
            }
        }
        
        long sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                sum += i;
                System.out.println("curr = " + i + "; sum = " + sum);
            } 
        }
        
        return sum;
	}
}
