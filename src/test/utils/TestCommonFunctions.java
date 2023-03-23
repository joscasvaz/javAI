package test.utils;

import java.util.List;

import utils.CommonFunctions;
import utils.Parsers;
import utils.Readers;

public class TestCommonFunctions {
	
    private static String inputsCommonFuntions = "../javAI/src/test/data/inputs/common_functions.csv";
	
	private static List<List<Double>> data = Readers.readCSV(inputsCommonFuntions,
			Parsers.parseToDouble);
	
	public static void main(String[] args) {
		
		for(List<Double> l:data)
			for(Double d:l) {
				
				System.out.println(
						String.format("Input:%s\nThreshold:%s\nSigno:%s\nRelu:%s\nSigmoid:%s\n#",
								d, CommonFunctions.threshold.applyAsDouble(d),
								CommonFunctions.sig.applyAsDouble(d),
								CommonFunctions.relu.applyAsDouble(d),
								CommonFunctions.sigmoid.applyAsDouble(d)));
			}
	}
}
