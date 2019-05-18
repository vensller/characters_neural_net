package View;

import Controller.AIController;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharacterView extends JFrame {

    private JButton btnChooseArch;
    private JPanel rootPanel;
    private JTable tblCharacter;
    private JButton btnFindNumber;
    private JButton btnReset;
    private TableRenderer tableRenderer;
    private TableModel tableModel;
    private AIController controller;
    private boolean[][] selected;

    public CharacterView(){
        add(rootPanel);
        setTitle("Number finder");
        setSize(550, 600);
        initData();
        initListeners();
    }

    private void initData(){
        controller = new AIController();
        tableRenderer = new TableRenderer();
        tableModel = new TableModel(this);
        tblCharacter.setDefaultRenderer(Object.class, tableRenderer);
        tableModel.dataChanged();
        tblCharacter.setModel(tableModel);
        selected = new boolean[16][16];
        tblCharacter.setVisible(true);
    }

    private void initListeners(){
        btnChooseArch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
                int retorno = fileChooser.showOpenDialog(tblCharacter);

                if (retorno == JFileChooser.APPROVE_OPTION){
                    if (controller.readDataSet(fileChooser.getSelectedFile().getAbsolutePath())) {
                        JOptionPane.showMessageDialog(null, "Dataset importado com sucesso! Rede neural será treinada neste momento, aguarde...");
                        controller.trainNeuralNetwork();
                    }
                    else JOptionPane.showMessageDialog(null, "Erro ao importar o dataset, favor verifique o arquivo!");
                }
            }
        });

        btnFindNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.findNumber(selected);
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                selected = new boolean[16][16];
                tableModel.dataChanged();
            }
        });

        tblCharacter.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                selected[tblCharacter.getSelectedRow()][tblCharacter.getSelectedColumn()] = !selected[tblCharacter.getSelectedRow()][tblCharacter.getSelectedColumn()];
                tableModel.dataChanged();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });
    }

    public boolean isSelected(int row, int column){
        return selected[row][column];
    }

}
