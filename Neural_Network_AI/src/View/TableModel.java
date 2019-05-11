package View;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.HashMap;

public class TableModel extends AbstractTableModel {

    private HashMap<Boolean, ImageIcon> images;
    private CharacterView view;

    public TableModel(CharacterView view){
        this.view = view;
        this.images = new HashMap<>();
        images.put(true, new ImageIcon("Images/Black.png"));
        images.put(false, new ImageIcon("Images/White.png"));
    }

    @Override
    public int getRowCount() {
        return 16;
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return getImage(rowIndex, columnIndex);
    }

    public ImageIcon getImage(int row, int column){
        Boolean selected = view.isSelected(row, column);
        return images.get(selected);
    }

    public void dataChanged(){
        fireTableDataChanged();
    }
}
