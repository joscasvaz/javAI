package test.utils;

import java.util.List;

import utils.CommonFunctions;
import utils.Parsers;
import utils.Readers;

public class TestCommonFunctions {
	
	private static List<List<Double>> data = Readers.readCSV("/javAI/src/test/data/inputs/utils.csv",
			Parsers.parseToDouble);
	
	public static void main(String[] args) {
		
		for(List<Double> l:data)
			for(Double d:l)
				System.out.println(CommonFunctions.relu.applyAsDouble(d));
			
		
	}
}
