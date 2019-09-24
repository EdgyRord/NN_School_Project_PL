import java.util.ArrayList;

public class Trainer {

	double wsp_uczenia = 0.25;
	double err = 0.10;
	int liczba_epok = 500;

	public Trainer(ArrayList<SetClass> lista, Neuron[] warstwa_ukryta, Neuron[] warstwa_wyjsciowa) {

		int epoka = 1;
		double[] layer1_output = new double[warstwa_ukryta.length];
		// double[] layer2_output = new double[warstwa_wyjsciowa.length];
		GUI.displayLog("Training Start\n");
		do {

			for (int set_treningowy = 0; set_treningowy < lista.size(); set_treningowy++) {
				// System.out.println("Training set : " + set_treningowy );
				for (int i = 0; i < warstwa_ukryta.length; i++) // KROK 1 -
																// oblicz wektor
																// wyjsciowy
																// warstwy 1
																// ukrytej
				{
					warstwa_ukryta[i].calculateNET(lista.get(set_treningowy).getData()).calculateOUTPUT();
					layer1_output[i] = warstwa_ukryta[i].output;
				}
				double[] answerTable = AnswersClass.getAnswerForInt(lista.get(set_treningowy).getAnswer());
				for (int i = 0; i < warstwa_wyjsciowa.length; i++) // KROK 2 -
																	// oblicz
																	// wektor
																	// wyjsciowy
																	// warstwy 2
																	// wyjsciowej
					
				{
					warstwa_wyjsciowa[i].calculateNET(layer1_output).calculateOUTPUT();
					// -----------------------------------------------------------------
					warstwa_wyjsciowa[i].calculateERROUT(answerTable[i]); // KROK
																									// 3
																									// -
																									// oblicz
																									// błąd
																									// warstwy
																									// wyjsciowej
				}

				for(int i = 0; i < warstwa_ukryta.length; i++) {
					double derivative = warstwa_ukryta[i].lambda * warstwa_ukryta[i].output
							* (1 - warstwa_ukryta[i].output);

					double temporal = 0;
					for (int j = 0; j < warstwa_wyjsciowa.length; j++) {
						temporal += warstwa_wyjsciowa[j].err * warstwa_wyjsciowa[j].w[i]; // SUMA
																							// BŁĘDÓW
																							// NEURONÓW
																							// WARSTWY
																							// NASTĘPNEJ
																							// (WYJŚCIOWEJ)
						// System.out.println(warstwa_wyjsciowa[j].w[i]);

					}

					warstwa_ukryta[i].err = derivative * temporal;

					// BŁAD OBLICZONY ZACZYNAMY NAUKE // KROK 4 NAUKA

					for (int j = 0; j < warstwa_ukryta[i].w.length - 1; j++) {
						warstwa_ukryta[i].w[j] += wsp_uczenia * warstwa_ukryta[i].err
								* lista.get(set_treningowy).getData()[j]; // WAGI
					}
					warstwa_ukryta[i].w[warstwa_ukryta[i].w.length - 1] += wsp_uczenia * warstwa_ukryta[i].err; // PRÓG

				}
				
				for(int i = 0; i < warstwa_wyjsciowa.length; i++) // NAUKA WARSTWY WYJSCIOWEJ
				{
					for(int j = 0; j < warstwa_wyjsciowa[i].w.length - 1; j++)
					{
						warstwa_wyjsciowa[i].w[j] += wsp_uczenia * warstwa_wyjsciowa[i].err * layer1_output[j];
					}
					warstwa_wyjsciowa[i].w[warstwa_wyjsciowa[i].w.length - 1] += wsp_uczenia* warstwa_wyjsciowa[i].err;
				}
				
				
				

			}

			 System.out.println(":Training in progress:");

			epoka++;
		} while (epoka <= liczba_epok);
		GUI.displayLog("Training Finished\n");
	}

}
