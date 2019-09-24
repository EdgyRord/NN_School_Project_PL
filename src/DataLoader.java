import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DataLoader {

	private String TrainingData;
	private String TestingData;

	public DataLoader() {

		loadTrainingData();
		loadTestingData();

	}

	private void loadTrainingData() {
		StringBuilder result = new StringBuilder("");

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("optdigits_tra.txt").getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			System.out.println(":Training data successfully loaded:");
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		TrainingData = result.toString();
	}

	private void loadTestingData() {
		StringBuilder result = new StringBuilder("");

		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("optdigits_tes.txt").getFile());

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			System.out.println(":Testing data successfully loaded:");
			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		TestingData = result.toString();
	}

	public String[] getTrainingData() {
		return TrainingData.split("\\r?\\n");
	}
	
	public String[] getTestingData(){
		return TestingData.split("\\r?\\n");
	}

}
