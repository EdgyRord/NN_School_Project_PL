
public class NeuronNetwork {

	Neuron[] layer1;
	Neuron[] layer2;
	double minComp = 0.5;
	boolean isManual = false;

	public NeuronNetwork(Neuron[] warstwa_ukryta, Neuron[] warstwa_wyjsciowa) {
		layer1 = warstwa_ukryta;
		layer2 = warstwa_wyjsciowa;
	}

	public boolean solve(SetClass testSet) {
		
		int expAns = testSet.getAnswer();
		
		System.out.println("Answers for this set:");
		if(isManual){
			GUI.displayLog("Answers for this set:\n");
		}
		
		
		double[] answerTable = AnswersClass.getAnswerForInt(testSet.getAnswer());
		System.out.println("Expected: " + testSet.getAnswer() + " || " );
		if(isManual){
			GUI.displayLog("Expected: " + testSet.getAnswer() + "\n");
		}
		
		for(int i = 0; i < answerTable.length; i++)
		{
			System.out.print(answerTable[i] +" , ");
			if(isManual){
				GUI.displayLog(answerTable[i] +" , ");
			}
		}
		
		double[] layer1_output = new double[layer1.length];

		for (int i = 0; i < layer1.length; i++)  // Oblicz output warstwy 1
		{
			layer1[i].calculateNET(testSet.getData()).calculateOUTPUT();
			layer1_output[i] = layer1[i].output;
		}
		
		System.out.println("\nReceived output: ");
		if(isManual){
			GUI.displayLog("\nReceived output: ");
		}
		
		
		for (int i = 0; i < layer2.length; i++) // oblicz output 2 warstwy
		{
			layer2[i].calculateNET(layer1_output).calculateOUTPUT();
			double tmp = layer2[i].output;
			if(tmp < minComp)
			{
				tmp = 0;
			}
			else
				tmp = 1;
			System.out.print(tmp + " , ");
			if(isManual){
				GUI.displayLog(tmp + " , ");
			}
		}
		System.out.println();
		double tmp = layer2[expAns].output;
		
		if(tmp < minComp) tmp = 0;
		else tmp = 1;
		
		if(tmp == 1){
			System.out.println("Correct");
			if(isManual){
				GUI.displayLog("\nCorrect");
			}
			return true;
		}
		else{
			System.out.println("Wrong");
			if(isManual){
				GUI.displayLog("\nWrong");
			}
			return false;
		}
		
		

	}
}
