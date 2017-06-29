/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * @author Mark Pan
 *
 */
public class ProblemNo9 {
	private int perimeter;
	
	public ProblemNo9(int perimeter) {
		this.perimeter = perimeter;
		 
		System.out.println(productOfTriple(this.perimeter));
	}
	
	private double productOfTriple(int p) {
		double upperLimB = p / 2;
		double lowerLimB = Math.round(upperLimB * (2 - Math.sqrt(2)));
		double c;
		
		for (double b = lowerLimB; b < upperLimB; b++) {
			for (double a = upperLimB - b; a < b; a++) {
				c = Math.sqrt(a * a + b * b);
				//System.out.println("a = " + a + "; b = " + b + "; c = " + c);
				if (a + b + c == p) {
					return a * b * c;
				}
			}
		}
		
		return 0;
	}
}
