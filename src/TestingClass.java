import java.util.ArrayList;
import java.util.Collections;

public class TestingClass {


	private ArrayList<SetClass> testingSet = new ArrayList<SetClass>();
	NeuronNetwork network;
	private double Yas = 0;
	private double Nah = 0;

	public TestingClass(String[] trainingSetArray, int how_many, NeuronNetwork network) {
		this.network = network;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < trainingSetArray.length; i++) // Lista liczb 0-3822 (Rozmiar tablicy)
		{
			tmp.add(new Integer(i));
		}
		Collections.shuffle(tmp);
		for (int i = 0; i < how_many; i++) {
			testingSet.add(new SetClass(trainingSetArray[tmp.get(i)]));
		}
	}

	public ArrayList<SetClass> getTrainingSet() {
		return testingSet;
	}
	
	
	public void test()
	{
		for(SetClass set : testingSet)
		{
			if(network.solve(set))
			{
				Yas++;
			}
			else{
				Nah++;
			}
		}
		
		System.out.println(Yas/(Yas+Nah)*100+ "% compatibility");
		GUI.displayLog("Automatic test results: out of " + (Yas+Nah) + " sets " + Yas + " were correct. " + Yas/(Yas+Nah)*100+ "% compatibility.\n");
	}

}
