package client.ui.adminview.holder;

import javax.swing.*;

public class AddItemHolder {
    public JPanel addItemPnl = new JPanel(), allBtnAddItemPnl = new JPanel(), newItemAddPnl = new JPanel();
    public JLabel lblTitleAddItem = new JLabel("제품 추가"), lblTitleItemToAdd = new JLabel("추가할 제품"), lblTitleNewItemPrice = new JLabel("가격");
    public JTextField tfItemToAdd = new JTextField(20), tfNewItemPrice = new JTextField(20);
    public JButton btnInsertAddItemPnl = new JButton("등록"), btnModifyAddItemPnl = new JButton("수정"), btnDeleteAddItemPml = new JButton("삭제"), btnBackAddItem = new JButton("뒤로가기");
}
