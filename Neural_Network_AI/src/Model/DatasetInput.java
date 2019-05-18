package Model;

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
        if (value[0] == 1)
            return 0;
        else if (value[1] == 1)
            return 1;
        else if (value[2] == 1)
            return 2;
        else if (value[3] == 1)
            return 3;
        else if (value[4] == 1)
            return 4;
        else if (value[5] == 1)
            return 5;
        else if (value[6] == 1)
            return 6;
        else if (value[7] == 1)
            return 7;
        else if (value[8] == 1)
            return 8;
        else if (value[9] == 1)
            return 9;

        return -1;
    }

    public void setValue(double[] value) {
        this.value = value;
    }
}
