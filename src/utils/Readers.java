package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Readers {
	
	public static <T> List<List<T>> readCSV(String path, Function<String,T> parser) {
		
		List<List<T>> res = new ArrayList<>();
		
		List<String[]> parts = null;
		
		try {
			
			parts = Files.lines(Paths.get(path))
					.map(s->s.split(","))
					.toList();
			
		} catch (IOException e) { e.printStackTrace(); }
		
		for(String[] part:parts) {
			
			List<T> aux = new ArrayList<>();
			for(String s:part) { aux.add(parser.apply(s.trim())); }
			
			res.add(aux);
		}
		
		return res;
	}
	
}
