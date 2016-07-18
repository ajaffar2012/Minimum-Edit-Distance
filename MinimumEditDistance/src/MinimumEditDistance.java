
public class MinimumEditDistance {
	
	public static final String SKIP_CHARACTER = "_";
	public static final String SPACER = " ";
	
	private String stringA;
	private String stringB;
	private final int stringALength;
	private final int stringBLength;
	private int[][] stringAlignmentCache;
	
	/**
	 * Constructor
	 * 
	 * @param stringA
	 * @param stringB
	 */
	public MinimumEditDistance(String stringA, String stringB) {
		this.stringA = stringA;
		this.stringB = stringB;
		this.stringALength = stringA.length();
		this.stringBLength = stringB.length();
		this.stringAlignmentCache = new int[this.stringBLength + 1][this.stringALength + 1];
		findAlignmentScore();
	}
	
	/**
	 * Find the string alignment score using dynamic programming
	 */
	private void findAlignmentScore() {
		
		//Initialize bottom row of cache
		for (int columnCounter = 0; columnCounter <= this.stringALength; ++columnCounter) {
			this.stringAlignmentCache[0][columnCounter] = columnCounter;
		}
		
		//Initialize left column of cache
		for (int rowCounter = 0; rowCounter <= this.stringBLength; ++rowCounter) {
			this.stringAlignmentCache[rowCounter][0] = rowCounter;
		}
		
		//Fill in the remaining cache entries row by row from bottom to top till you reach the
		//top right entry, which will contain the best alignment score
		for (int columnCounter = 1; columnCounter <= this.stringALength; ++columnCounter) {
			for (int rowCounter = 1; rowCounter <= this.stringBLength; ++rowCounter) {
				
				this.stringAlignmentCache[rowCounter][columnCounter] = getMinimumScore(this.stringAlignmentCache[rowCounter - 1][columnCounter] + 1, 
																					   this.stringAlignmentCache[rowCounter][columnCounter - 1] + 1, 
																					   this.stringAlignmentCache[rowCounter - 1][columnCounter - 1] + 
																					  (this.stringA.charAt(columnCounter - 1) == this.stringB.charAt(rowCounter - 1) ? 0 : 1));
				
			}
		}
		
	}
	
	/**
	 * @param integer1
	 * @param integer2
	 * @param integer3
	 * @return the least of the three parameters
	 */
	private int getMinimumScore(int integer1, int integer2, int integer3) {
		
		return Math.min(Math.min(integer1, integer1), integer3);
		
	}
	
	/**
	 * @return the number of substitutions, insertions or deletions needed to convert one string to another
	 */
	public int getAlignmentScore() {
		return this.stringAlignmentCache[stringB.length()][stringA.length()];
	}
	
	/**
	 * Print the steps needs to convert one string to another
	 */
	public void printTracebackSteps() {
		
		printTraceback(this.stringBLength, this.stringALength);
		
	}
	
	/**
	 * Recursive method to print the steps needs to convert one string to another
	 */
	private void printTraceback(int rowIndex, int columnIndex) {
		
		//Base case where no more characters are left
		if (columnIndex == 0 && rowIndex == 0) {
			return;
		}
		
		//String A is over
		if (columnIndex == 0) {
			System.out.println(SKIP_CHARACTER + SPACER + this.stringB.charAt(rowIndex - 1));
			printTraceback(rowIndex - 1, columnIndex);
			return;
		}
		
		//String B is over
		if (rowIndex == 0) {
			System.out.println(this.stringA.charAt(columnIndex - 1) + SPACER + SKIP_CHARACTER);
			printTraceback(rowIndex, columnIndex - 1);
			return;
		}
		
		//If one more than cell to the left
		if (this.stringAlignmentCache[rowIndex][columnIndex] == this.stringAlignmentCache[rowIndex][columnIndex - 1] + 1) {
			System.out.println(this.stringA.charAt(columnIndex - 1) + SPACER + SKIP_CHARACTER);
			printTraceback(rowIndex, columnIndex - 1);
			return;
		}
		
		//If one more than cell below
		if (this.stringAlignmentCache[rowIndex][columnIndex] == this.stringAlignmentCache[rowIndex - 1][columnIndex] + 1) {
			System.out.println(SKIP_CHARACTER + SPACER + this.stringB.charAt(rowIndex - 1));
			printTraceback(rowIndex - 1, columnIndex);
			return;
		}
		
		//Difference is with cell below and to the left
		System.out.println(this.stringA.charAt(columnIndex - 1) + SPACER + this.stringB.charAt(rowIndex - 1));
		printTraceback(rowIndex - 1, columnIndex - 1);
		return;
		
	}

}
