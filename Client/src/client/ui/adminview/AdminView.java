package client.ui.adminview;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface AdminView {
    JPanel adminStartPanel = new JPanel(), btnAdminWhatToDo = new JPanel(), totalMoneyPnl = new JPanel(), totalSalesPnl = new JPanel(), currentIngredientsPnl = new JPanel(), buyIngredientsPnl = new JPanel(), AdminClientButtonPnl = new JPanel();
    JLabel lblTotalSales = new JLabel(), lblTotalSalesMoney = new JLabel();
    JLabel lblTitleTotalMoney = new JLabel("Total Money"), lblTitleCurrentIngredients = new JLabel("Current Ingredients"), lblTitleAddItem = new JLabel("Add Item");
    JButton btnTotalMoney = new JButton("Item Total Money"), btnCurrentIngredients = new JButton("Current Items"), btnBuyIngredients = new JButton("Buy Items"), btnAddItem = new JButton("Add Items"), btnAdminClient = new JButton();
    JButton btnBackBuyIngredients = new JButton("back"), btnBackCurrentIngredients = new JButton("back"), btnBackTotalMoney = new JButton("back"), btnBackAddItem = new JButton("Back");


    // buyIngredientsPnl
    JPanel decreaseMoneyPnl = new JPanel();
    JComboBox comboBox = new JComboBox();
    String[] str = {"재고선택"};
    JLabel lblIngredientsToAdd = new JLabel("추가할 재고"), lblQuantityToAdd = new JLabel("수량"), lblTitleDecreasedTotalMoney = new JLabel("총 액"), lblDecreasedTotalMoney = new JLabel("");
    JButton btnInsert = new JButton("등록"), btnModify = new JButton("수정"), btnDelete = new JButton("삭제");
    JTextField tfQuantityToAdd = new JTextField();


    // addItemPnl
    JPanel addItemPnl = new JPanel(), allBtnAddItemPnl = new JPanel(), newItemAddPnl = new JPanel();
    JLabel lblTitleItemToAdd = new JLabel("추가할 제품"), lblTitleNewItemPrice = new JLabel("가격");
    JTextField tfItemToAdd = new JTextField(20), tfNewItemPrice = new JTextField(20);
    JButton btnInsertAddItemPnl = new JButton("등록"), btnModifyAddItemPnl = new JButton("수정"), btnDeleteAddItemPml = new JButton("삭제");


    void addAdminListener(ActionListener listener);
}
