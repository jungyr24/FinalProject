package client.ui;

import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public interface UserView {
    JPanel startPnl = new JPanel(), itemListPnl = new JPanel(), selectedListPnl = new JPanel();
    JButton btnAdminClient = new JButton(), btnPay= new JButton("구매"), btnMinus= new JButton("-"), btnPlus= new JButton("+"), btnX= new JButton("x");
    JLabel lblInsertMoney = new JLabel("투입 금액 "), lblTotalMoney = new JLabel("총 금액 "), lblChangeMoney= new JLabel("거스름돈 "), lblItemQuantity= new JLabel("3");

    // TODO: 2019-12-31 파라미터
    void updateItemLists(Vector<ProductModel> lists);

    // TODO: 2019-12-31 파라미터, 여기 i 어떻게?
    void updateSelectedLists(Vector<ProductModel> selectedItem);

    void updateInsertMoney(String money);

    void updateChangesMoney(String money);

    void updateTotalMoney(String money);

    void showAdminDialog();

    void showUserInterface();

    void addListener(ActionListener listener);

}
