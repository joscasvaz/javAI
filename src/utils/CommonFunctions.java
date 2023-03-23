package utils;

import java.util.function.DoubleUnaryOperator;

public class CommonFunctions {
	
	public static DoubleUnaryOperator threshold = x->{ return 0 < x ? 1 : 0; };
	public static DoubleUnaryOperator relu = x->{ return 0 < x ? x : 0; };
	public static DoubleUnaryOperator sig = x-> {return x < 0 ? -1 : 1; };
	public static DoubleUnaryOperator sigmoid = x ->{ return 1 / (1 + Math.pow(Math.E, -x)); };
	
}
