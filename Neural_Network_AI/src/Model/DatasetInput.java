package Model;

public class DatasetInput {

    private double input[];
    private int[] value;

    public DatasetInput(double[] input, int[] value) {
        this.input = input;
        this.value = value;
    }

    public double[] getInput() {
        return input;
    }

    public void setInput(double[] input) {
        this.input = input;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }
}
