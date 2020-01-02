package client.ui.holder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class CurrentIngrdntHolder {
    public JPanel currentIngredientsPnl = new JPanel();
    public JLabel lblTitleCurrentIngredients = new JLabel("재료 재고 현황");
    public JButton btnBackCurrentIngredients = new JButton("뒤로가기");
    public Vector<String> colCurrentIngredient = new Vector<>();

    public Vector<String> rowCurrentIngredient;
    public JTable table;
    public DefaultTableModel model;

    private final static String[] columns = {"No", "재고", "재고수량"};

    public CurrentIngrdntHolder() {
        for (String col : columns) {
            colCurrentIngredient.addElement(col);
        }
    }
}
