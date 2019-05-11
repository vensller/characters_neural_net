package Controller;

import Model.Dataset;
import Utils.DatasetReader;

import javax.swing.*;

public class AIController {

    private Dataset dataset;

    public void readDataSet(String archive){
        dataset = DatasetReader.readDataset(archive);

        if (dataset == null)
            JOptionPane.showMessageDialog(null, "Erro ao importar o dataset, favor verifique o arquivo!");
        else JOptionPane.showMessageDialog(null, "Dataset importado com sucesso!");
    }

    public void findNumber(boolean[][] selected){

    }

}
