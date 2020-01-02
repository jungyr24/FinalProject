package client.ui.userview;

import client.data.dao.ProductModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class UserViewImpl implements UserView {
    boolean isExist = false;

    public UserViewImpl() {
        setStartPnl();

    }

    public void setStartPnl() {
        // client View 전체를 담는 패널
        startPnl.setLayout(null);
        // Manager <-> User Button
        btnAdminClient.setText("Manager");
        btnAdminClient.setBounds(0, 0, 100, 30);
        startPnl.add(btnAdminClient);
        JLabel lblWhatToDo = new JLabel("Select Item");
        lblWhatToDo.setFont(new Font("맑은고딕", Font.BOLD, 20));
        lblWhatToDo.setBounds(400, 10, 200, 20);
        startPnl.add(lblWhatToDo);


        itemListPnl.setLayout(new GridLayout(4, 3, 15, 15));
        itemListPnl.setBackground(Color.orange);
        JScrollPane scroll = new JScrollPane(itemListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // ItemListPnl w 650(+15), h 600(+50)
        scroll.setBounds(15, 50, 650, 600);
        startPnl.add(scroll);


        // selectedListPnl w 315, h 500
        selectedListPnl.setLayout(new GridLayout(50, 1, 3, 3));
        selectedListPnl.setBackground(Color.green);
        JScrollPane selectedListPnlScroll = new JScrollPane(selectedListPnl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        selectedListPnlScroll.setBounds(670, 50, 400, 300);
        startPnl.add(selectedListPnlScroll);

        // total money
        JPanel totalMoneyPnl = new JPanel();
        totalMoneyPnl.setLayout(new BorderLayout());
        totalMoneyPnl.setBounds(670, 360, 400, 70);
        totalMoneyPnl.add(lblTotalMoney, BorderLayout.CENTER);
        totalMoneyPnl.setBackground(Color.lightGray);


        startPnl.add(totalMoneyPnl);


        // 구매 버튼
        btnPay.setBounds(830, 600, 100, 50);
        startPnl.add(btnPay);
    }


    @Override
    public void updateItemLists(Vector<ProductModel> lists) {
        itemLists.clear();
        itemListPnl.removeAll();
        for (int i = 0; i < lists.size(); i++) {
            ItemInfoPnl item = new ItemInfoPnl(lists.get(i), i);
            if (!item.productModel.IsSell) {
                item.btnItem.setBackground(Color.magenta);
                item.btnItem.setEnabled(false);
            }
            itemLists.add(item);
            itemListPnl.add(item);
        }
        itemListPnl.updateUI();
    }


    @Override
    public void updateSelectedLists(ProductModel productModel) { // 선택된 상품 목록
        for (SelectedItemPnl item : selectedItemLists) {
            if (productModel.PrName.equals(item.productModel.PrName)) {
                isExist = true;
                break;
            }
        }

        if (isExist) { //이름이 같은 친구가 있으면 새로 그리기
            selectedListPnl.removeAll();
            selectedItemLists.forEach(selectedListPnl::add);
            selectedListPnl.updateUI();
            isExist = false;
        } else { //이름이 같은 친구가 없으면 새로 만들어서 넣어주기
            selectedListPnl.removeAll();

            SelectedItemPnl item = new SelectedItemPnl(productModel);
            selectedItemLists.add(item);
            selectedItemLists.forEach(selectedListPnl::add);
            selectedListPnl.updateUI();
        }

        isExist = false;


    }

    @Override
    public void updateMoney() {
        AtomicInteger totalMoney = new AtomicInteger();
        selectedItemLists.forEach(item -> {
            totalMoney.addAndGet(item.productModel.PrPrice * item.itemCount);
        });
        lblTotalMoney.setText("총 금액 : " + totalMoney);
    }

    @Override
    public boolean plusItemCount(SelectedItemPnl item) {
        boolean returnValue = false;
        for (ItemInfoPnl list : itemLists) {
            if (list.productModel.PrName.equals(item.productModel.PrName)) {
                if (list.productModel.IsSell) {
                    item.addBtnClicked();
                    returnValue = true;
                    break;
                }
            }
        }
        return returnValue;
    }

    @Override
    public boolean minusItemCount(SelectedItemPnl item) {
        return item.minusBtnClicked();
    }

    @Override
    public void removeItem(SelectedItemPnl item) {
        selectedListPnl.remove(item);
        selectedItemLists.remove(item);
        selectedListPnl.updateUI();
    }

    @Override
    public void addListener(ActionListener listener) {
        btnAdminClient.addActionListener(listener); // Manager <-> User Switch Button
        btnPay.addActionListener(listener); // 구매 버튼
    }

    @Override
    public void addItemListListener(ActionListener listener) {
        itemLists.forEach(item -> {
            item.addListener(listener);
        });
    }

    @Override
    public void addSelectedItemListener(ActionListener listener) {
        selectedItemLists.forEach(selectedItem -> {
            selectedItem.addListener(listener);
        });
    }

    @Override
    public void clearItem() {
        selectedListPnl.removeAll();
        selectedItemLists.clear();
        selectedListPnl.updateUI();
    }
}
