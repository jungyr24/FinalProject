package client.ui.holder;

import javax.swing.*;

public class CurrentIngrdntHolder {
    public JPanel currentIngredientsPnl = new JPanel();
    public JLabel lblTitleCurrentIngredients = new JLabel("재료 재고 현황");
    public JButton btnBackCurrentIngredients = new JButton("뒤로가기");
    public String colCurrentIngredient[] = {};
    public String rowCurrentIngredient[][] = {};
    public JTable table;
}
