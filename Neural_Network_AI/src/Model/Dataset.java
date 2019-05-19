package Model;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

    private List<DatasetInput> inputs;
    private List<List<DatasetInput>> subsets;

    public Dataset(){
        inputs = new ArrayList<>();
        subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        subsets.add(new ArrayList<>());
        subsets.add(new ArrayList<>());
        subsets.add(new ArrayList<>());
        subsets.add(new ArrayList<>());
    }

    public void addInput(DatasetInput input){
        inputs.add(input);
    }

    public void createSubsets(){
        int[] examples = new int[10];

        for (int x = 0; x < examples.length; x++){
            for (DatasetInput input : inputs)
                if (input.getDecimalValue() == x)
                    examples[x]++;

            int exampleSize = examples[x] / 5;
            int count = 0;
            int index = 0;

            for (DatasetInput input : inputs){
                if (input.getDecimalValue() == x){
                    subsets.get(index).add(input);

                    if (count == exampleSize) {
                        count = 0;

                        if (index < 5)
                            index++;

                    }else count++;
                }
            }
        }
    }

    public double[][] getInputsMatrix(int testIndex){
        List<double[]> result = new ArrayList<>();

        for (List<DatasetInput> list : subsets) {
            if (subsets.indexOf(list) != testIndex)
                for (DatasetInput input : subsets.get(subsets.indexOf(list)))
                    result.add(input.getInput());
        }

        double[][] resultMatrix = new double[result.size()][256];

        for (double[] vec : result)
            resultMatrix[result.indexOf(vec)] = vec;

        return resultMatrix;
    }

    public double[][] getOutputsMatrix(int testIndex){
        List<double[]> result = new ArrayList<>();

        for (List<DatasetInput> list : subsets) {
            if (subsets.indexOf(list) != testIndex)
                for (DatasetInput input : subsets.get(subsets.indexOf(list)))
                    result.add(input.getValue());
        }

        double[][] resultMatrix = new double[result.size()][10];

        for (double[] vec : result)
            resultMatrix[result.indexOf(vec)] = vec;

        return resultMatrix;
    }

    public double[][] getTestOutput(int testIndex){
        double[][] result = new double[subsets.get(testIndex).size()][10];

        for (DatasetInput input : subsets.get(testIndex))
            result[subsets.get(testIndex).indexOf(input)] = input.getValue();

        return result;
    }

    public double[][] getTestInput(int testIndex){
        double[][] result = new double[subsets.get(testIndex).size()][256];

        for (DatasetInput input : subsets.get(testIndex))
            result[subsets.get(testIndex).indexOf(input)] = input.getInput();

        return result;
    }
}
