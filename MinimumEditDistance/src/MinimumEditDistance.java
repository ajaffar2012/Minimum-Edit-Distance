
public class MinimumEditDistance {
	
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
		this.stringAlignmentCache = new int[this.stringALength + 1][this.stringBLength + 1];
		alignStrings();
	}
	
	/**
	 * Find the string alignment using dynamic programming
	 */
	private void alignStrings() {
		
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
				
				this.stringAlignmentCache[columnCounter][rowCounter] = getMinimumScore(this.stringAlignmentCache[columnCounter - 1][rowCounter] + 1, 
																					   this.stringAlignmentCache[columnCounter][rowCounter - 1] + 1, 
																					   this.stringAlignmentCache[columnCounter - 1][rowCounter - 1] + 
																					   this.stringA.charAt(columnCounter) == this.stringB.charAt(rowCounter) ? 0 : 1);
				
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
		return this.stringAlignmentCache[stringA.length()][stringB.length()];
	}
	
	/**
	 * @return a string containing the steps to convert string A to string B
	 */
	public String getTracebackSteps() {
		
		StringBuffer tracebackSteps = new StringBuffer();
		
		
		
		
		return tracebackSteps.toString();
		
	}

}
