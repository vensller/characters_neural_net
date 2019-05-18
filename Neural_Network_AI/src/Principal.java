import Controller.AIController;
import View.CharacterView;

import javax.swing.*;

public class Principal {

    public static void main(String[] args) {

        if (args.length > 0) {
            AIController controller = new AIController();

            if (controller.readDataSet(args[0])){
                controller.trainNeuralNetwork(0);
                controller.testNeuralNetwork(0);

                controller.trainNeuralNetwork(1);
                controller.testNeuralNetwork(1);

                controller.trainNeuralNetwork(2);
                controller.testNeuralNetwork(2);

                controller.trainNeuralNetwork(3);
                controller.testNeuralNetwork(3);

                controller.trainNeuralNetwork(4);
                controller.testNeuralNetwork(4);
            }else System.out.println("Erro ao importar dataset, verifique o caminho informado!");

        }else{
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            new CharacterView().setVisible(true);
        }
    }
}
