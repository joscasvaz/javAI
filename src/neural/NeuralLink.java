package neural;

public record NeuralLink(Perceptron source, Perceptron dest, Double weight) {
	
	//METHODS
	
	public Double output() { return source.output() * weight; }
	
	//toSTRING
	
	public String toString() {
		return String.format("[NeuralLink: from:%s, to:%s, (input: %s, weight: %s), output: %s]",
				source(), dest(), weight(), output());
	}
}
