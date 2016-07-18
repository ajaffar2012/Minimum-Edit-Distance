
public class MinimumEditDistanceClient {
	
	public static final String stringA = "AGTTCAAT";
	public static final String stringB = "GTGAATC";
	

	public static void main(String[] args) {
		
		MinimumEditDistanceClient minimumEditDistanceClient = new MinimumEditDistanceClient();
		minimumEditDistanceClient.showStringAlignment();

	}
	
	private void showStringAlignment() {
		
		MinimumEditDistance minimumEditDistance = new MinimumEditDistance(stringA, stringB);
		System.out.println("Alignment score: " + minimumEditDistance.getAlignmentScore() + '\n');
		minimumEditDistance.printTracebackSteps();
		
	}
	

}
