
public class ProblemNo2 {
	private int exclusiveMax;
	private int sum;

	public ProblemNo2(int n) {
		exclusiveMax = n;
		sum = 0;
		System.out.println(sumEvenFibsBelow(1, 2, exclusiveMax));
	}
	
	private int sumEvenFibsBelow(int prev, int curr, int e) {
		int next = prev + curr;
		
		if (curr >= e) {
			return sum;
		}
		
		if (curr % 2 == 0) {
			sum += curr;
		}
		
		return sumEvenFibsBelow(curr, next, e);
	}
}
