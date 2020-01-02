package client.ui.adminview;

import client.ui.holder.AddItemHolder;
import client.ui.holder.BuyIngredientsHolder;
import client.ui.holder.CurrentIngrdntHolder;
import client.ui.holder.TotalMoneyHolder;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface AdminView {
    TotalMoneyHolder TOTAL_MONEY_HOLDER = new TotalMoneyHolder();
    BuyIngredientsHolder BUY_INGREDIENTS_HOLDER = new BuyIngredientsHolder();
    CurrentIngrdntHolder CURRENT_INGRDNT_HOLDER = new CurrentIngrdntHolder();
    AddItemHolder ADD_ITEM_HOLDER = new AddItemHolder();
    JPanel adminStartPanel = new JPanel(), btnAdminWhatToDo = new JPanel();


    JPanel AdminClientButtonPnl = new JPanel();
    JButton btnTotalMoney = new JButton("Item Total Money"), btnCurrentIngredients = new JButton("Current Items"),
            btnBuyIngredients = new JButton("Buy Items"), btnAddItem = new JButton("Add Items"), btnAdminClient = new JButton("사용자");

    void addAdminListener(ActionListener listener);
}
