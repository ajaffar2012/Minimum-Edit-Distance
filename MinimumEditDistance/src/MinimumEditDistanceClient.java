import java.util.Random;


public class MinimumEditDistanceClient {
	
	public static final String YES = "Y";
	public static final char[] validBases = {'A', 'C', 'G', 'T'};
	public static final int MAXIMUM_NUCLEOTIDE_STRING_LENGTH = 30;
	
	private Random randomNumberGenerator;
	private boolean skipRecursion;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MinimumEditDistanceClient minimumEditDistanceClient = new MinimumEditDistanceClient(args);
		minimumEditDistanceClient.showStringAlignment();

	}
	
	/**
	 * Constructor
	 */
	public MinimumEditDistanceClient(String[] args) {
		
		this.randomNumberGenerator = new Random(System.currentTimeMillis());
		this.skipRecursion = (args.length > 0 && YES.equals(args[0].trim())) ? true : false;
		
	}
	
	/**
	 * Show the difference between the strings
	 */
	private void showStringAlignment() {
		
		String stringA = getRandomNucleotideString(), stringB = getRandomNucleotideString();
		
		System.out.println("First string: " + stringA);
		System.out.println("Second string: " + stringB);

		MinimumEditDistance minimumEditDistance = null;
		
		if (this.skipRecursion) {
			System.out.println("\nRecursive alignment score computation skipped.\n");
		} else {
			minimumEditDistance = new MinimumEditDistance(stringA, stringB, true);
			System.out.println("\nAlignment score by recursion: " + minimumEditDistance.getAlignmentScore() + '\n');
		}
		minimumEditDistance = new MinimumEditDistance(stringA, stringB, false);
		System.out.println("Alignment score by Dynamic Programming: " + minimumEditDistance.getAlignmentScore() + '\n');
		try {
			minimumEditDistance.printTracebackSteps();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * @return a random nucleotide string
	 */
	private String getRandomNucleotideString() {
		
		StringBuffer randomNucleotideString = new StringBuffer();
		int randomNucleotideStringLength = this.randomNumberGenerator.nextInt(MAXIMUM_NUCLEOTIDE_STRING_LENGTH + 1);
		int numberOfValidBases = validBases.length;
		
		for (int nucleotideCounter = 0; nucleotideCounter < randomNucleotideStringLength; ++nucleotideCounter) {
			randomNucleotideString.append(validBases[this.randomNumberGenerator.nextInt(numberOfValidBases)]);
		}
		
		return randomNucleotideString.toString();
		
	}
	
}
