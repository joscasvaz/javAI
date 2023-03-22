package utils;

import java.util.function.DoubleUnaryOperator;

public class CommonFunctions {
	
	public static DoubleUnaryOperator threshold = x->{ return 0 < x ? 1 : 0; };
	public static DoubleUnaryOperator relu = x->{ return 0 < x ? x : 0; };
	public static DoubleUnaryOperator signo = x-> {return threshold.applyAsDouble(x) < 1 ? -1 : 1; };
	public static DoubleUnaryOperator sigmoid = x ->{ return Math.pow(1 + Math.pow(Math.E, -x), -1); };
	
}
