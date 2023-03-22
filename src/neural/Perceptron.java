package neural;

import java.util.List;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

public class Perceptron {
	
	//PROPERTIES
	
	private List<NeuralLink> inputs;
	private Double bias;
	private DoubleUnaryOperator activation;
	
	//CONSTRUCTORS
	
	public Perceptron(List<NeuralLink> inputs, Double bias, DoubleUnaryOperator f) {
		
		this.inputs = inputs;
		this.bias = bias;
		this.activation = f;
	}
	
	public Perceptron(List<NeuralLink> inputs, DoubleUnaryOperator f) {
		
		this.inputs = inputs;
		this.bias = 1.0;
		this.activation = f;
	}
	
	//METHODS
	
	public Double output() {
		
		Double sum = getInputs().stream()
				.mapToDouble(NeuralLink::output)
				.sum();
		
		return getActivation().applyAsDouble(sum);
	}
	
	//GETTERS AND SETTERS

	public List<NeuralLink> getInputs() {
		return inputs;
	}

	public void setInputs(List<NeuralLink> inputs) {
		this.inputs = inputs;
	}

	public Double getBias() {
		return bias;
	}

	public void setBias(Double bias) {
		this.bias = bias;
	}

	public DoubleUnaryOperator getActivation() {
		return activation;
	}

	public void setActivation(DoubleUnaryOperator f) {
		this.activation = f;
	}
	
	//HASH AND EQUALS
	
	@Override
	public int hashCode() {
		return Objects.hash(bias, activation, inputs);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perceptron other = (Perceptron) obj;
		return Objects.equals(bias, other.bias) && Objects.equals(activation, other.activation) && Objects.equals(inputs, other.inputs);
	}

	//toSTRING
	@Override
	public String toString() {
		return "[Perceptron (inputs: " + getInputs() + ", bias: " + getBias()
				+ ", activation: " + getActivation() + "), output: " + output() + "]";
	}
	
}
