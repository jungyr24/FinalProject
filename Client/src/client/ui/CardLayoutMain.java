package client.ui;

import client.ui.adminview.AdminView;
import client.ui.userview.UserView;

import javax.swing.*;
import java.awt.*;

public class CardLayoutMain extends JFrame {
    public UserView userView;
    public AdminView adminView;
    CardLayout cardLayout;
    Container tab;

    public CardLayoutMain(UserView userView, AdminView adminView) {
        setResizable(false);
        cardLayout = new CardLayout();
        tab = new JPanel();
        tab.setSize(1100, 700);
        tab.setLayout(cardLayout);

        this.userView = userView;
        this.adminView = adminView;

        tab.add(UserView.startPnl, "Start");
        tab.add(AdminView.adminStartPanel, "Admin");
        tab.add(AdminView.TOTAL_MONEY_HOLDER.totalMoneyPnl, "TotalMoney");
        tab.add(AdminView.CURRENT_INGRDNT_HOLDER.currentIngredientsPnl, "CurrentIngredients");
        tab.add(AdminView.BUY_INGREDIENTS_HOLDER.buyIngredientsPnl, "BuyIngredients");
        tab.add(AdminView.ADD_ITEM_HOLDER.addItemPnl, "AddItem");

        cardLayout.show(tab, "Start");

        add(tab, BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);
    }

    public void changeDialog(String panelName) {
        cardLayout.show(tab, panelName);
    }

}
