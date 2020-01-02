package client.ui.adminview;

import client.data.dao.IngredientModel;
import client.data.dao.ProductModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminViewImpl implements AdminView {

    public AdminViewImpl() {
        setBtnAdminWhatToDoPnl();
        setTotalMoneyPnl();
        setCurrentIngredients();
        setBuyIngredients();
        setAddItem();
    }

    // 판매총액, 재고현황, 재고구매, 제품추가
    public void setBtnAdminWhatToDoPnl() {
        adminStartPanel.setLayout(new BorderLayout());
        btnAdminWhatToDo.setLayout(new GridLayout(2, 2, 50, 50));
        btnAdminWhatToDo.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        // 버튼 4개 생성


        // 버튼 set
        btnTotalMoney.setFont(new Font("맑은고딕", Font.PLAIN, 30));
        btnCurrentIngredients.setFont(new Font("맑은고딕", Font.PLAIN, 30));
        btnBuyIngredients.setFont(new Font("맑은고딕", Font.PLAIN, 30));
        btnAddItem.setFont(new Font("맑은고딕", Font.PLAIN, 30));

        btnAdminWhatToDo.add(btnTotalMoney);
        btnAdminWhatToDo.add(btnCurrentIngredients);
        btnAdminWhatToDo.add(btnBuyIngredients);
        btnAdminWhatToDo.add(btnAddItem);
        adminStartPanel.add(btnAdminWhatToDo, BorderLayout.CENTER);

        // Admin <-> User Btn
        AdminClientButtonPnl.setLayout(new BorderLayout());
        btnAdminClient.setBounds(0, 0, 100, 30);
        AdminClientButtonPnl.add(btnAdminClient, BorderLayout.WEST);
        adminStartPanel.add(AdminClientButtonPnl, BorderLayout.NORTH);

    }


    public void setTotalMoneyPnl() {
        TOTAL_MONEY_HOLDER.totalMoneyPnl.setLayout(null);
        TOTAL_MONEY_HOLDER.lblTitleTotalMoney.setText("Total Money");
        TOTAL_MONEY_HOLDER.lblTitleTotalMoney.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        TOTAL_MONEY_HOLDER.lblTitleTotalMoney.setBounds(480, 10, 200, 30);

        // 총매출

        TOTAL_MONEY_HOLDER.totalSalesPnl.setBackground(Color.orange);
        TOTAL_MONEY_HOLDER.totalSalesPnl.setBounds(40, 490, 1000, 70);
        TOTAL_MONEY_HOLDER.totalSalesPnl.setLayout(null);

        TOTAL_MONEY_HOLDER.lblTotalSales.setText("총 매출 ");
        TOTAL_MONEY_HOLDER.lblTotalSales.setBounds(10, 5, 100, 50);
        TOTAL_MONEY_HOLDER.lblTotalSales.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        TOTAL_MONEY_HOLDER.lblTotalSalesMoney.setBounds(150, 5, 200, 50);
        TOTAL_MONEY_HOLDER.lblTotalSalesMoney.setFont(new Font("맑은고딕", Font.PLAIN, 20));

        TOTAL_MONEY_HOLDER.totalSalesPnl.add(TOTAL_MONEY_HOLDER.lblTotalSales);
        TOTAL_MONEY_HOLDER.totalSalesPnl.add(TOTAL_MONEY_HOLDER.lblTotalSalesMoney);


        // table
        TOTAL_MONEY_HOLDER.table = new JTable(TOTAL_MONEY_HOLDER.rowTotalMoney, TOTAL_MONEY_HOLDER.colTotalMoney);
        JScrollPane jsp = new JScrollPane(TOTAL_MONEY_HOLDER.table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // btnBack
        TOTAL_MONEY_HOLDER.btnBackTotalMoney.setBounds(940, 580, 100, 50);
        TOTAL_MONEY_HOLDER.totalMoneyPnl.add(TOTAL_MONEY_HOLDER.lblTitleTotalMoney);
        TOTAL_MONEY_HOLDER.totalMoneyPnl.add(jsp);
        TOTAL_MONEY_HOLDER.totalMoneyPnl.add(TOTAL_MONEY_HOLDER.btnBackTotalMoney);
        TOTAL_MONEY_HOLDER.totalMoneyPnl.add(TOTAL_MONEY_HOLDER.totalSalesPnl);

    }


    public void setCurrentIngredients() { // 제품 재고 현황
        CURRENT_INGRDNT_HOLDER.currentIngredientsPnl.setLayout(null);

        CURRENT_INGRDNT_HOLDER.lblTitleCurrentIngredients.setText("Current Items");
        CURRENT_INGRDNT_HOLDER.lblTitleCurrentIngredients.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        CURRENT_INGRDNT_HOLDER.lblTitleCurrentIngredients.setBounds(480, 10, 200, 30);

        JScrollPane jsp = new JScrollPane(CURRENT_INGRDNT_HOLDER.table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.setBounds(40, 70, 1000, 400);

        // btnBack
        CURRENT_INGRDNT_HOLDER.btnBackCurrentIngredients.setBounds(940, 580, 100, 50);
        CURRENT_INGRDNT_HOLDER.currentIngredientsPnl.add(CURRENT_INGRDNT_HOLDER.lblTitleCurrentIngredients);
//        CURRENT_INGRDNT_HOLDER.currentIngredientsPnl.add(jsp);
        CURRENT_INGRDNT_HOLDER.currentIngredientsPnl.add(CURRENT_INGRDNT_HOLDER.btnBackCurrentIngredients);

    }

    public void setBuyIngredients() { // 재고 구매
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.setLayout(null);
        BUY_INGREDIENTS_HOLDER.lblIngredientsToAdd.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        BUY_INGREDIENTS_HOLDER.lblIngredientsToAdd.setBounds(480, 10, 200, 30);

        // combo box


        // 재고 수량 label
        BUY_INGREDIENTS_HOLDER.lblQuantityToAdd.setBounds(100, 250, 100, 70);
        BUY_INGREDIENTS_HOLDER.tfQuantityToAdd.setBounds(250, 250, 250, 70);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.lblQuantityToAdd);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.tfQuantityToAdd);

        // 등록, 수정, 삭제 btn
        BUY_INGREDIENTS_HOLDER.btnInsert.setBounds(110, 350, 100, 50);
        BUY_INGREDIENTS_HOLDER.btnModify.setBounds(220, 350, 100, 50);
        BUY_INGREDIENTS_HOLDER.btnDelete.setBounds(330, 350, 100, 50);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.btnInsert);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.btnModify);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.btnDelete);

        // 총액감소 label
        BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl.setLayout(new BorderLayout());
        BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl.setBounds(100, 410, 350, 100);
        BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl.setBackground(Color.orange);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl);

        BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl.add(BUY_INGREDIENTS_HOLDER.lblTitleDecreasedTotalMoney, BorderLayout.WEST);
        BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl.add(BUY_INGREDIENTS_HOLDER.lblDecreasedTotalMoney, BorderLayout.CENTER);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.decreaseMoneyPnl);

        // table


        // btnBack
        BUY_INGREDIENTS_HOLDER.btnBackBuyIngredients.setBounds(940, 580, 100, 50);

        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.lblIngredientsToAdd);
        BUY_INGREDIENTS_HOLDER.buyIngredientsPnl.add(BUY_INGREDIENTS_HOLDER.btnBackBuyIngredients);
    }

    public void setAddItem() { // 제품 추가
        ADD_ITEM_HOLDER.addItemPnl.setLayout(null);
        ADD_ITEM_HOLDER.lblTitleAddItem.setFont(new Font("맑은고딕", Font.PLAIN, 25));
        ADD_ITEM_HOLDER.lblTitleAddItem.setBounds(480, 10, 200, 30);
        ADD_ITEM_HOLDER.addItemPnl.add(ADD_ITEM_HOLDER.lblTitleAddItem);


        // item list panel


        ADD_ITEM_HOLDER.newItemAddPnl.setLayout(new FlowLayout());
        ADD_ITEM_HOLDER.newItemAddPnl.add(ADD_ITEM_HOLDER.lblTitleItemToAdd);
        ADD_ITEM_HOLDER.newItemAddPnl.add(ADD_ITEM_HOLDER.tfItemToAdd);
        ADD_ITEM_HOLDER.newItemAddPnl.add(ADD_ITEM_HOLDER.lblTitleNewItemPrice);
        ADD_ITEM_HOLDER.newItemAddPnl.add(ADD_ITEM_HOLDER.tfNewItemPrice);

        ADD_ITEM_HOLDER.allBtnAddItemPnl.setLayout(new FlowLayout());
        ADD_ITEM_HOLDER.allBtnAddItemPnl.add(ADD_ITEM_HOLDER.btnInsertAddItemPnl);
        ADD_ITEM_HOLDER.allBtnAddItemPnl.add(ADD_ITEM_HOLDER.btnModifyAddItemPnl);
        ADD_ITEM_HOLDER.allBtnAddItemPnl.add(ADD_ITEM_HOLDER.btnDeleteAddItemPml);

        ADD_ITEM_HOLDER.newItemAddPnl.setBounds(0, 480, 1100, 50);
        ADD_ITEM_HOLDER.allBtnAddItemPnl.setBounds(0, 530, 1100, 50);

        ADD_ITEM_HOLDER.addItemPnl.add(ADD_ITEM_HOLDER.newItemAddPnl);
        ADD_ITEM_HOLDER.addItemPnl.add(ADD_ITEM_HOLDER.allBtnAddItemPnl);

        // btnBack
        ADD_ITEM_HOLDER.btnBackAddItem.setBounds(940, 580, 100, 50);
        ADD_ITEM_HOLDER.addItemPnl.add(ADD_ITEM_HOLDER.btnBackAddItem);


    }


    @Override
    public void addAdminListener(ActionListener listener) {
        btnAdminClient.addActionListener(listener);

        btnTotalMoney.addActionListener(listener);
        btnCurrentIngredients.addActionListener(listener);
        btnBuyIngredients.addActionListener(listener);
        btnAddItem.addActionListener(listener);


        TOTAL_MONEY_HOLDER.btnBackTotalMoney.addActionListener(listener);
        CURRENT_INGRDNT_HOLDER.btnBackCurrentIngredients.addActionListener(listener);
        BUY_INGREDIENTS_HOLDER.btnBackBuyIngredients.addActionListener(listener);
        ADD_ITEM_HOLDER.btnBackAddItem.addActionListener(listener);
    }

    @Override
    public void updateCurrentTable(Vector<IngredientModel> lists) {
        // table


        CURRENT_INGRDNT_HOLDER.rowCurrentIngredient = new String[lists.size()][3];
        for (int i = 0; i < lists.size(); i++) {
            CURRENT_INGRDNT_HOLDER.rowCurrentIngredient[i][0] = Integer.toString(lists.get(i).IgCode);
            CURRENT_INGRDNT_HOLDER.rowCurrentIngredient[i][1] = (lists.get(i).IgName);
            CURRENT_INGRDNT_HOLDER.rowCurrentIngredient[i][2] = Integer.toString(lists.get(i).IgNumber);
        }
        CURRENT_INGRDNT_HOLDER.model = new DefaultTableModel();
        CURRENT_INGRDNT_HOLDER.table = new JTable(CURRENT_INGRDNT_HOLDER.model);

        

        CURRENT_INGRDNT_HOLDER.table.updateUI();
    }

    @Override
    public void updateBuyIngredientTable(Vector<IngredientModel> lists) {
        BUY_INGREDIENTS_HOLDER.colBuyIngredient[0] = "No";
        BUY_INGREDIENTS_HOLDER.colBuyIngredient[1] = "재고";
        BUY_INGREDIENTS_HOLDER.colBuyIngredient[2] = "재고수량";

        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < 3; j++) {
                BUY_INGREDIENTS_HOLDER.rowBuyIngredient[i][j] = Integer.toString(lists.get(i).IgCode);
                BUY_INGREDIENTS_HOLDER.rowBuyIngredient[i][j] = lists.get(i).IgName;
                BUY_INGREDIENTS_HOLDER.rowBuyIngredient[i][j] = Integer.toString(lists.get(i).IgNumber);
            }
        }
        BUY_INGREDIENTS_HOLDER.table = new JTable(BUY_INGREDIENTS_HOLDER.rowBuyIngredient, BUY_INGREDIENTS_HOLDER.colBuyIngredient);
    }

    @Override
    public void totalMoneyTable(Vector<ProductModel> lists, int totalMoney) {

    }
}
