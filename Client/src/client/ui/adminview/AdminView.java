package client.ui.adminview;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface AdminView {
    JPanel adminStartPanel = new JPanel(), btnAdminWhatToDo = new JPanel(), totalMoneyPnl = new JPanel(), totalSalesPnl = new JPanel(), currentIngredientsPnl = new JPanel(), buyIngredientsPnl = new JPanel(), AdminClientButtonPnl = new JPanel();
    JLabel lblTotalSales = new JLabel(), lblTotalSalesMoney = new JLabel();
    JLabel lblTitleTotalMoney = new JLabel("Total Money"), lblTitleCurrentIngredients = new JLabel("Current Ingredients"),
            lblTitleBuyIngredients = new JLabel("Buy Ingredients"), lblTitleAddItem = new JLabel("Add Item");
    JButton btnTotalMoney = new JButton("Item Total Money"), btnCurrentIngredients = new JButton("Current Items"), btnBuyIngredients = new JButton("Buy Items"), btnAddItem = new JButton("Add Items"), btnAdminClient = new JButton(), btnBack = new JButton("Back");
    JButton btnBackBuyIngredients = new JButton("back"), btnBackCurrentIngredients = new JButton("back"), btnBackTotalMoney = new JButton("back");

    void addAdminListener(ActionListener listener);
}
