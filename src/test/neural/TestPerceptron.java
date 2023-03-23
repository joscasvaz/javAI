package test.neural;

import java.util.List;

import neural.Perceptron;
import utils.CommonFunctions;
import utils.Parsers;
import utils.Readers;

public class TestPerceptron {
	
	 private static String inputsPerceptron = "../javAI/src/test/data/inputs/perceptron.csv";
		
		private static List<List<Double>> data = Readers.readCSV(inputsPerceptron,
				Parsers.parseToDouble);
	
	public static void main(String[] args) {
		
		List<Double> weights = data.get(0);
		List<List<Double>> values = data.subList(1, data.size());
		
		for(List<Double> l:values) {
			
			try {
				
				Perceptron p1 = new Perceptron(l, weights, null, CommonFunctions.threshold);
				System.out.println(String.format("Weights: %s\nValues: %s\nOutput: %s\n#",
						weights, l, p1.getOutput()));
				
			} catch (Exception e) { e.printStackTrace(); }
		}
		
	}
}
