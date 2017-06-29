/**
 * Adam plays the following game with his birthday cake.
 * He cuts a piece forming a circular sector of 60 degrees and flips the piece upside down, with the icing on the bottom
 * He then rotates the cake by 60 degrees counterclockwise, cuts an adjacent 60 degree piece and flips it upside down.
 * He keeps repeating this, until after a total of twelve steps, all the icing is back on top.
 * Amazingly, this works for any piece size, even if the cutting angle is an irrational number: all the icing will be back on top after a finite number of steps.
 * Now, Adam tries something different: he alternates cutting pieces of size x=3609x=3609 degrees, y=36010y=36010 degrees and z=36011√z=36011 degrees. The first piece he cuts has size x and he flips it. The second has size y and he flips it. The third has size z and he flips it. He repeats this with pieces of size x, y and z in that order until all the icing is back on top, and discovers he needs 60 flips altogether.
 * 
 * p566-cakeicingpuzzle.gif
 * 
 * Let F(a, b, c) be the minimum number of piece flips needed to get all the icing back on top for pieces of size x=360/a degrees, y=360/b degrees and z=360/sqrt(z) degrees.
 * Let G(n)=∑9≤a<b<c≤nF(a,b,c) for integers a, b and c.
 * 
 * You are given that F(9, 10, 11) = 60, F(10, 14, 16) = 506, F(15, 16, 17) = 785232.
 * You are also given G(11) = 60, G(14) = 58020 and G(17) = 1269260.
 * 
 * Find G(53).
 * @author Mark Pan
 *
 */
public class ProblemNo11 {
	private double CIRCLE = 360.0;
	
	public ProblemNo11(int n) {
		
		System.out.println(gOf(n));
	}
	
	private double gOf(int n) {
		double sum = 0;
		
		for (int k = 11; k <= n; k++) {
			for (int j = 10; j < k; j++) {
				for (int i = 9; i < j; i++) {
					sum += fOf(i, j, k);
				}
			}
		}
		
		return sum;
	}
	
	private int fOf(int a, int b, int c) {
		int count = 0;
		double degrees = 0;
		
		while (true) {
			System.out.println("Flips - " + count + "; Degrees - " + degrees);
			degrees += cutDiv(a);
			count++;
			if (degrees % CIRCLE == 0) {
				break;
 			}
			degrees += cutDiv(b);
			count++;
			if (degrees % CIRCLE == 0) {
				break;
			}
			degrees += cutRoot(c);
			count++;
			if (degrees % CIRCLE == 0) {
				break;
			}
		}
		
		return count;
	}
	
	private double cutDiv(int d) {
		return CIRCLE / d;
	}
	
	private double cutRoot(int c) {
		double soln = CIRCLE / Math.sqrt((double)c);
		System.out.println(soln);
		return soln;
	}
}

