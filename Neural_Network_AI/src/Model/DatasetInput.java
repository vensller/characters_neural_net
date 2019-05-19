package Model;

import Utils.DecimalClassifier;

public class DatasetInput {

    private double[] input;
    private double[] value;

    public DatasetInput(double[] input, double[] value) {
        this.input = input;
        this.value = value;
    }

    public double[] getInput() {
        return input;
    }

    public void setInput(double[] input) {
        this.input = input;
    }

    public double[] getValue() {
        return value;
    }

    public int getDecimalValue(){
        return DecimalClassifier.getDecimalValue(value);
    }

    public void setValue(double[] value) {
        this.value = value;
    }
}
