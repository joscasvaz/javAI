package neural;

public record NeuralLink(Double input, Double weight) {
	
	public Double output() { return input * weight; }
}
