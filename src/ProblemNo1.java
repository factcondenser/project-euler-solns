
public class ProblemNo1 {
	private int firstNumber;
	private int secondNumber;
	private int exclusiveMax;
	private int sum;
	
	public ProblemNo1(int l, int m, int n) {
		firstNumber = l;
		secondNumber = m;
		exclusiveMax = n;
		sum = 0;
		
		System.out.println(sumOfMultiplesBelow(firstNumber, secondNumber, exclusiveMax));
	}

	private int sumOfMultiplesBelow(int f, int s, int e) {
		
		for (int i = 0; i < e; i++) {
			if (i % f == 0 || i % s == 0) {
				sum += i;
			}
		}
			
		return sum;
	}
}
