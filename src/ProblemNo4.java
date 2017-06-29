
public class ProblemNo4 {
	
	public ProblemNo4() {
		for (Integer n = 998001; n > 9999; n--) {
			if (isPalindromic(n) && isProductOfTwoThreeDigitIntegers(n)) {
				System.out.println(n);
				return;
			}
		}
	}
	
	private Boolean isPalindromic(Integer n) {
		String s = n.toString();
		for (int i = 0; i < s.length() / 2;) {
			if (s.charAt(i) != s.charAt(s.length() - ++i)) {
				return false;
			}
		}
		return true;
	}
	
	private Boolean isProductOfTwoThreeDigitIntegers(Integer n) {
		for (int i = 100; i < 1000; i++) {
			if (n % i == 0 && new Integer(n / i).toString().length() == 3) {
				return true;
			}
		}
		return false;
	}
}