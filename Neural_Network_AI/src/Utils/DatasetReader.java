package Utils;

import Model.Dataset;
import Model.DatasetInput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DatasetReader {

    public static Dataset readDataset(String archive){
        Dataset dataset = null;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(archive));
            String str = null;
            dataset = new Dataset();

            while ((str = reader.readLine()) != null){
                String[] arrayStr = str.split(" ");
                double[] input = new double[256];
                double[] value = new double[10];


                for (int x = 0; x < arrayStr.length; x++){

                    if (x < 256)
                        input[x] = Double.parseDouble(arrayStr[x]);
                    else value[x-256] = Integer.parseInt(arrayStr[x]);
                }

                dataset.addInput(new DatasetInput(input, value));

            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
            dataset = null;
        } catch (IOException e) {
            e.printStackTrace();
            dataset = null;
        }

        if (dataset != null)
            dataset.createSubsets();

        return dataset;
    }
}
