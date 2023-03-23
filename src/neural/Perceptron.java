package neural;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

public class Perceptron {
	
	//PROPERTIES
	
	private List<NeuralLink> inputs;
	private List<NeuralLink> connections;
	private Double bias;
	private static DoubleUnaryOperator activation;
	private Double output;
	
	//CONSTRUCTORS
	
	public Perceptron(List<NeuralLink> inputs, List<NeuralLink> connections,
			Double bias, DoubleUnaryOperator activation) {
		
		this.inputs = inputs;
		this.connections = connections;
		this.bias = bias;
		Perceptron.activation = activation;
		this.output = output();
	}
	
	public Perceptron(List<NeuralLink> inputs, List<NeuralLink> connections,
			DoubleUnaryOperator activation) {
		
		this.inputs = inputs;
		this.connections = connections;
		this.bias = 1.0;
		Perceptron.activation = activation;
		this.output = output();
	}
	
	public Perceptron(List<Double> values, List<Double> weights, List<NeuralLink> connections,
			DoubleUnaryOperator activation) throws Exception {
		
		this.connections = connections;
		this.bias = 1.0;
		Perceptron.activation = activation;
		this.output = output(calculateInputs(values, weights));
	}
	
	//METHODS
	
	private static Double calculateInput(Double value, Double weight) {
		return value * weight; }
	
	private static List<Double> calculateInputs(List<Double> values, List<Double> weights)
			throws Exception {
		
		if(values.size() == weights.size()) {
			
			List<Double> res = new ArrayList<>();
			
			for(int i = 0; i < values.size(); i++) {
				res.add(calculateInput(values.get(i), weights.get(i))); }
			
			return res;
			
		} else throw new Exception("Lists size is different");
	}
	
	public Double output() {
		
		Double sum = getInputs().stream()
				.mapToDouble(NeuralLink::output)
				.sum();
		
		return getActivation().applyAsDouble(sum);
	}
	
	public Double output(List<Double> inputs) {
		Double sum = inputs.stream()
				.reduce((x, y) -> x + y)
				.get();
		
		return getActivation().applyAsDouble(sum);
	}
	
	//GETTERS AND SETTERS

	public List<NeuralLink> getInputs() { return inputs; }

	public void setInputs(List<NeuralLink> inputs) { this.inputs = inputs; }
	
	public List<NeuralLink> getConnections() { return connections; }

	public void setConnections(List<NeuralLink> connections) {
		this.connections = connections; }

	public Double getBias() { return bias; }

	public void setBias(Double bias) { this.bias = bias; }

	public static DoubleUnaryOperator getActivation() { return activation; }

	public void setActivation(DoubleUnaryOperator f) { Perceptron.activation = f; }
	
	public Double getOutput() { return output; }
	
	//HASH AND EQUALS
	
	@Override
	public int hashCode() { return Objects.hash(bias, activation, inputs); }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perceptron other = (Perceptron) obj;
		return Objects.equals(bias, other.bias) && Objects.equals(activation, Perceptron.activation) && Objects.equals(inputs, other.inputs);
	}

	//toSTRING
	
	@Override
	public String toString() {
		return String.format("[Perceptron (inputs: %s, connections: %s, bias: %s, activation: %s), output: %s]",
				getInputs(), getConnections(), getBias(), getActivation(), output());
	}
	
}
