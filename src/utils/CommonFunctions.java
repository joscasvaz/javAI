package utils;

import java.util.function.DoubleUnaryOperator;

public class CommonFunctions {
	
	public static DoubleUnaryOperator threshold = z->{ return 0 < z ? 1 : 0; };
	public static DoubleUnaryOperator relu = z->{ return 0 < z ? z : 0; };
	public static DoubleUnaryOperator sig = z-> {return z < 0 ? -1 : 1; };
	public static DoubleUnaryOperator sigmoid = z ->{ return 1 / (1 + Math.pow(Math.E, -z)); };
	public static DoubleUnaryOperator tanh = z ->{
		Double ez = Math.pow(Math.E, z);
		return (ez - 1 / ez) / (ez + 1 / ez); };
	
}
