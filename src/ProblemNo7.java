/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 * @author Mark Pan
 *
 */
public class ProblemNo7 {

	public ProblemNo7(int n) {
		System.out.println(nthPrime(n));
	}
	
	private long nthPrime(int nthPosition) {
		int primeCount = 0;
		int curr = 2;
		int PRIME_TABLE_LIMIT = 200000;
		
		Boolean[] isPrime = new Boolean[PRIME_TABLE_LIMIT];
        
        for (int i = 0; i < PRIME_TABLE_LIMIT; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i < (int)Math.sqrt(PRIME_TABLE_LIMIT) + 1; i++){
            if (isPrime[i]) {
                
                for (int j = 2; j * i < PRIME_TABLE_LIMIT; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
		
		while (primeCount != nthPosition) {
			if (isPrimeUber(curr, isPrime)) {
				primeCount++;
				//System.out.println("#" + primeCount + ": " + curr);
			}
			curr++;
		}
		return --curr;
	}
	
	private Boolean isPrime(long n) {		
		for (long i = 2; i < n ; i++) {
			if (n % i == 0 && n != 2) {
				return false;
			}
		}
		return true;
	}
	
	private Boolean isPrimeUber(int n, Boolean[] primes) {
		 
        return primes[n];
	}
 }


