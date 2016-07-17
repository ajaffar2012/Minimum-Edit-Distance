
public class MinimumEditDistance {
	
	private String stringA;
	private String stringB;
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
		this.stringAlignmentCache = new int[stringA.length() + 1][stringB.length() + 1];
		alignStrings();
	}
	
	/**
	 * Find the string alignment using dynamic programming
	 */
	private void alignStrings() {
		
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
