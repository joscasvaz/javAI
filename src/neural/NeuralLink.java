package neural;

public record NeuralLink(Perceptron source, Perceptron dest, Double weight) {
	
	//METHODS
	
	public Double output() { return source.output() * weight; }
	
	//toSTRING
	
	public String toString() {
		return String.format("[NeuralLink: src: %s, dest: %s, weight: %s]",
				source(), dest(), weight());
	}
}
