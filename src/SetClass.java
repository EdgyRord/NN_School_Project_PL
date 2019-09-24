
public class SetClass {
	
	private double[] data;
	
	private int expectedAnswer;
	

	public SetClass(String dataString) {
		
		data = new double[64];
		
		String[] tmp = dataString.split(",");
		for(int i = 0; i < data.length; i++)
		{
			data[i] = Double.parseDouble(tmp[i]);
		}
		expectedAnswer = Integer.parseInt(tmp[64]);
	
	}
	
	public double[] getData(){
		return data;
	}
	
	public int getAnswer(){
		return expectedAnswer;
	}
	

}
