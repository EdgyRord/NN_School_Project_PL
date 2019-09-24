import java.awt.EventQueue;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class Main {


	public static void main(String[] args) {
		
		
		
		//2 warstwy: 1 ukryta i 1 wyjściowa. 26 neuronów w pierwszej, 10 w drugiej.
		
		Neuron layer1[] = new Neuron[26]; // Ze wzoru n = root(ilosc_wejsc*ilosc_wyjsc)
		Neuron layer2[] = new Neuron[10]; // 10 cyfr: 0,1,2,3,4,5,6,7,8,9
		NeuronNetwork network = new NeuronNetwork(layer1, layer2);
		
		GUI gui = new GUI(network);
		GUI.displayLog("Project by Kamil Bąkała & Marianna Grabowska\n");
		
		
		for(int i = 0; i < layer1.length; i++){ //Stwórz warstwa 1 UKRYTA
			layer1[i] = new Neuron(65);  // 64 wagi + próg
		}
		for(int i = 0; i < layer2.length; i++){ //Stwórz warstwa 2 WYJŚCIOWA
			layer2[i] = new Neuron(layer1.length + 1);  // 26 wag(z warstwy 1 tyle wyjść) i 1 próg
		}
		
		
		//INPUT 
		String[] trainingData; // SET TRENINGOWY
		String[] testingData;  // SET TESTOWY
		DataLoader dataloader = new DataLoader(); // Wczytaj dane
		trainingData = dataloader.getTrainingData(); //Pobierz set treningowy
		testingData = dataloader.getTestingData(); //Pobierz set testowy
		//System.out.println(trainingData.length);      3823
		
		//SetClass test = new SetClass(trainingData[0]);   DZIAŁA
		TrainingSets sets = new TrainingSets(trainingData);
		Trainer trener = new Trainer(sets.getTrainingSet(), layer1, layer2);
		 // TESTY: alpha - 0.5, l_epok = 200 - FAIL. alpha = 0.25, liczba_epok = 500 - ROZPOZNAJE PO 1 TEŚCIE DLA KAŻDEJ CYFRY - SUKCES - ~90% rozpoznawania?
		
		//AUTOMATIC TEST
		//System.out.println(testingData.length);    1797
		TestingClass testing = new TestingClass(testingData, 1000, network);
		testing.test();
		
		GUI.displayLog("Enter data below for manual test: \n");
		
		//MANUAL TEST
		
				
		SetClass testSet = new SetClass("0,0,0,1,11,0,0,0,0,0,0,7,8,0,0,0,0,0,1,13,6,2,2,0,0,0,7,15,0,9,8,0,0,5,16,10,0,16,6,0,0,4,15,16,13,16,1,0,0,0,0,3,15,10,0,0,0,0,0,2,16,4,0,0,4");
		network.solve(testSet);
		
		network.isManual = true;
		
		
	}

}
