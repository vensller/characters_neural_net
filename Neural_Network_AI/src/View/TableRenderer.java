package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TableRenderer extends DefaultTableCellRenderer {

    private Image image;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImageIcon imageIcon = ((TableModel)table.getModel()).getImage(row, column);
        this.image = imageIcon.getImage();
        setIcon(imageIcon);
        table.getColumnModel().getColumn(column).setMaxWidth(32);
        table.setRowHeight(row, 32);
        return this;
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(this.image, 0, 0, 32, 32, null);
        g.drawRect(0, 0, 32, 32);
    }
}
