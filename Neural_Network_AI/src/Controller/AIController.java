package Controller;

import Model.Dataset;
import Utils.DatasetReader;
import org.encog.Encog;
import org.encog.engine.network.activation.ActivationLOG;
import org.encog.ml.data.MLData;
import org.encog.ml.data.MLDataSet;
import org.encog.ml.data.basic.BasicMLData;
import org.encog.ml.data.basic.BasicMLDataSet;
import org.encog.neural.networks.BasicNetwork;
import org.encog.neural.networks.layers.BasicLayer;
import org.encog.neural.networks.training.propagation.back.Backpropagation;

import javax.swing.*;

public class AIController {

    private Dataset dataset;
    private BasicNetwork network;


    public boolean readDataSet(String archive){
        dataset = DatasetReader.readDataset(archive);

        return dataset != null;
    }

    public void findNumber(boolean[][] selected){
        if (network != null){
            double[] inputCase = new double[256];
            int count = 0;

            for (int x = 0; x < selected.length; x++){
                for (int j = 0; j < selected[x].length; j++) {
                    if (selected[x][j])
                        inputCase[count] = 1;
                    else inputCase[count] = 0;

                    count ++;
                }
            }

            MLData inputData = new BasicMLData(inputCase);
            MLData outputData = network.compute(inputData);
            System.out.println(outputData);
        }else JOptionPane.showMessageDialog(null, "Rede neural não foi treinada, favor verificar o dataset selecionado!");
    }

    public void trainNeuralNetwork(int index){
        network = new BasicNetwork();

        network.addLayer(new BasicLayer(null, true, 256));
        network.addLayer(new BasicLayer(new ActivationLOG(), true, 100));
        network.addLayer(new BasicLayer(new ActivationLOG(), false, 10));

        network.getStructure().finalizeStructure();
        network.reset();

        MLDataSet traineeData = new BasicMLDataSet(dataset.getInputsMatrix(index), dataset.getOutputsMatrix(index));

        final Backpropagation trainee = new Backpropagation(network, traineeData);

        System.out.println("Training neural network");
        int count = 0;
        do{
            trainee.iteration();
            System.out.println("Season: " + count + ". Error: " + trainee.getError());
            count++;
        }while (trainee.getError() > 0.1);

        trainee.finishTraining();

        System.out.println("Foram executadas " + count + " épocas e a rede chegou a um erro de " + trainee.getError());
        Encog.getInstance().shutdown();
    }

    public void testNeuralNetwork(int index){

    }

}
