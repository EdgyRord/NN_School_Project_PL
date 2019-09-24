import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TrainingSets {

	private ArrayList<SetClass> trainingSet = new ArrayList<SetClass>();

	public TrainingSets(String[] trainingSetArray) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for (int i = 0; i < trainingSetArray.length; i++) // Lista liczb 0-3822 (Rozmiar tablicy)
		{
			tmp.add(new Integer(i));
		}
		Collections.shuffle(tmp);
		for (int i = 0; i < 1200; i++) {
			trainingSet.add(new SetClass(trainingSetArray[tmp.get(i)])); // Dodaj
																			// pierwszych
																			// 1200
																			// rekordów
																			// z
																			// pomieszanej
																			// listy.
																			// (Losowe
																			// przykłady
																			// za
																			// każdym
																			// razem)
		}
	}

	public ArrayList<SetClass> getTrainingSet() {
		return trainingSet;
	}

}
