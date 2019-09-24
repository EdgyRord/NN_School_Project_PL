import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Neuron {
	
	public double w[];
	public double output = 0;
	public double prevNET = 0;
	public double err = 0;
	public double lambda = 1;
	

	public Neuron(int wagi) {
		this.w = new double[wagi]; // 64 Wagi + próg
		Random r = new Random();
		for(int i = 0; i < w.length; i++)
		{
			w[i] = -1 + (1 + 1) * r.nextDouble();
		}
		}
	
	
	
	public Neuron calculateNET(double[] input){
		this.prevNET = 0;
		
		for(int i = 0; i < w.length - 1; i++) // Dla każdej wagi z wyjątkiem Progu, wyliczamy NET przez mnożenie wagi i wejścia
		{
			this.prevNET += w[i]*input[i];
		}
		this.prevNET += w[w.length-1];
		return this;
	}
	
	public Neuron calculateOUTPUT(){
		this.output = 1/(1+Math.exp((-1)*lambda*this.prevNET));
		return this;
	}
	
	
	public double calculateERROUT(double expectedAnswer){   
		err = lambda*output*(1-output)*(expectedAnswer - output);
		
		return err;
	}
	

}
