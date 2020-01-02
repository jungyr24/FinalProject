package client.ui.userview;

import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public interface UserView {
    JPanel startPnl = new JPanel(), itemListPnl = new JPanel(), selectedListPnl = new JPanel();
    JButton btnAdminClient = new JButton(), btnPay = new JButton("구매");
    JLabel lblTotalMoney = new JLabel("총 금액 ");
    List<ItemInfoPnl> itemLists = new LinkedList<>();
    List<SelectedItemPnl> selectedItemLists = new LinkedList<>();


    void updateItemLists(Vector<ProductModel> lists);

    void updateSelectedLists(ProductModel productModel);

    void updateTotalMoney(String money);

    void plusItemCount();

    void addListener(ActionListener listener);

    void addItemListListener(ActionListener listener);

    void addSelectedItemListener(ActionListener listener);

}
