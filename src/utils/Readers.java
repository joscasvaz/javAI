package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Readers {

	public <T> List<T> readCSV(String path, Function<String,T> parser) throws IOException{
		
		List<T> res = new ArrayList<>();
		
		List<String[]> parts = Files.lines(Paths.get(path))
				.map(s->s.split(","))
				.toList();
		
		for(String[] part:parts) { for(String s:part) { res.add(parser.apply(s)); } }
		
		return res;
	}
	
}
