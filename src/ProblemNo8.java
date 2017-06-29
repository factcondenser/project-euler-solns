import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class ProblemNo8 {
	
	private String integer;
	private int NUMBER_OF_DIGITS = 13;
	
	public ProblemNo8 (String[] args) {
		
		/** Check whether exactly one command-line argument is given */
		if (args.length != 1) {
			System.out.println("Usage: java ProblemNo8 FileName");
			System.exit(0);
		}

		/** Check whether the input file exists and is readable */
		// Create Scanner to read the input file
		Scanner fileReader = null;
		// Create File object to hold the input file
		File file;

		if (args[0] == null) {
			System.out.println("Error: Cannot access input file 1");
			System.exit(0);
		}

		// Create new File object using the input file; pass that File object
		// to the scanner.
		try {
			file = new File(args[0]);
			fileReader = new Scanner(file);
		} catch (IOException e) {
			System.out.println("Error: Cannot access input file 2");
			e.printStackTrace();
			System.exit(0);
		}
		
		integer = fileReader.nextLine();
		System.out.println(largestProduct(integer, NUMBER_OF_DIGITS));
	}	
	
	private BigInteger largestProduct(String s, int n) {
		int curPos = 0;
		char[] curSeq = s.substring(curPos, curPos + n).toCharArray();
		BigInteger curProd = BigInteger.ONE;
		BigInteger largestProd = BigInteger.ONE;
		
		while (curPos + n <= s.length()) {
			Boolean completedSequence = true;
			
			for (int i = 0; i < n; i++) { 
				
				if (Character.getNumericValue(curSeq[i]) == 0) {	
					curPos++;
					
					if (curPos + n > s.length()) {
						return largestProd;
					}
					
					curProd = BigInteger.ONE;
					completedSequence = false;
					break;	 
				}	
				
				curPos++;
				curProd = curProd.multiply(BigInteger.valueOf(Character.getNumericValue(curSeq[i])));
			}
			
			if (curProd.compareTo(largestProd) > 0) {
				largestProd = curProd;
			}
			
			if (completedSequence) {
				curPos = curPos + 1 - n;
				curProd = BigInteger.ONE;
			}
			
			if (curPos + n <= s.length()) {
				curSeq = s.substring(curPos, curPos + n).toCharArray();
			}
		}
		
		return largestProd;	
	}
}
