import java.util.Random;


public class MinimumEditDistanceClient {
	
	public static final String stringA = "ATGTTAT";
	public static final String stringB = "ATCGTAC";
	public static final char[] validBases = {'A', 'C', 'G', 'T'};
	public static final int MAXIMUM_NUCLEOTIDE_STRING_LENGTH = 30;
	
	private Random randomNumberGenerator;

	public static void main(String[] args) {
		
		MinimumEditDistanceClient minimumEditDistanceClient = new MinimumEditDistanceClient();
		minimumEditDistanceClient.showStringAlignment();

	}
	
	public MinimumEditDistanceClient() {
		
		this.randomNumberGenerator = new Random(System.currentTimeMillis());
		
	}
	
	private void showStringAlignment() {
		
		MinimumEditDistance minimumEditDistance = new MinimumEditDistance(getRandomNucleotideString(), getRandomNucleotideString());
		System.out.println("Alignment score: " + minimumEditDistance.getAlignmentScore() + '\n');
		minimumEditDistance.printTracebackSteps();
		
	}
	
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
