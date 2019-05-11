package Model;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

    private List<DatasetInput> inputs;

    public Dataset(){
        inputs = new ArrayList<>();
    }

    public void addInput(DatasetInput input){
        inputs.add(input);
    }

    public List<DatasetInput> getInputs() {
        return inputs;
    }

    public double[][] getInputsMatrix(){
        double[][] result = new double[inputs.size()][256];

        for (DatasetInput input : inputs)
            result[inputs.indexOf(input)] = input.getInput();

        return result;
    }
}
