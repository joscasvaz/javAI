package neural;

public record NeuralLink(Double input, Double weight) {
	
	//METHODS
	
	public Double output() { return input * weight; }
	
	//toSTRING
	
	public String toString() {
		return String.format("[NeuralLink: (input: %s, weight: %s), output: %s]",
				input(), weight(), output());
	}
}
