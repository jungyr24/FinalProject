package client.controller;

import client.data.Repository;
import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;
import client.ui.CardLayoutMain;
import kotlin.jvm.Volatile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Controller implements ActionListener {

    private Repository repository;
    private CardLayoutMain cardLayoutMain;
    @Volatile
    private boolean changeDialogFlag = true;


    public Controller(CardLayoutMain cardLayoutMain, Repository repository) {
        this.cardLayoutMain = cardLayoutMain;
        this.repository = repository;
    }

    public void connectServer() {
        repository.connectServer(new ServerConnectionCallback() {
            @Override
            public void accept(Vector<ProductModel> lists) {
                cardLayoutMain.userView.updateItemLists(lists);
                cardLayoutMain.userView.addItemListListener(Controller.this::actionPerformed);
                cardLayoutMain.userView.addListener(Controller.this::actionPerformed);
                cardLayoutMain.adminView.addAdminListener(Controller.this::actionPerformed);
            }

            @Override
            public void error(String error) {
                System.out.println("에러 발생 : " + error);
            }
        });
    }


    @Override
    public synchronized void actionPerformed(ActionEvent actionEvent) {
        Object obj = actionEvent.getSource();
        if (cardLayoutMain.userView.btnPay.equals(obj)) {
            repository.buyItem(Integer.parseInt(cardLayoutMain.userView.totalMoney.toString()));
            cardLayoutMain.userView.clearItem();
            cardLayoutMain.userView.updateMoney();
        } else if (cardLayoutMain.userView.btnAdminClient.equals(obj) || cardLayoutMain.adminView.btnAdminClient.equals(obj)) {
            if (changeDialogFlag) {
                System.out.println("Admin");
                cardLayoutMain.changeDialog("Admin");
            } else {
                System.out.println("Start");
                cardLayoutMain.changeDialog("Start");
            }
            changeDialogFlag = !changeDialogFlag;
        } else if (cardLayoutMain.adminView.btnCurrentIngredients.equals(obj)) {
            cardLayoutMain.changeDialog("CurrentIngredients");
        } else if (cardLayoutMain.adminView.btnBuyIngredients.equals(obj)) {
            cardLayoutMain.changeDialog("BuyIngredients");
        } else if (cardLayoutMain.adminView.btnTotalMoney.equals(obj)) {
            cardLayoutMain.changeDialog("TotalMoney");
        } else if (cardLayoutMain.adminView.btnAddItem.equals(obj)) {
            cardLayoutMain.changeDialog("AddItem");
        } else if (cardLayoutMain.adminView.btnBackTotalMoney.equals(obj) || cardLayoutMain.adminView.btnBackBuyIngredients.equals(obj)
                || cardLayoutMain.adminView.btnBackCurrentIngredients.equals(obj) || cardLayoutMain.adminView.btnBackAddItem.equals(obj)) {
            cardLayoutMain.changeDialog("Admin");
        } else {
            cardLayoutMain.userView.itemLists.forEach(item ->
            {
                if (obj.equals(item.btnItem)) {
                    repository.selectItem(item.productModel, (productModelVector) -> {
                        cardLayoutMain.userView.updateSelectedLists(item.productModel);
                        updateItemView(productModelVector);
                    });
                }
            });
            cardLayoutMain.userView.selectedItemLists.forEach(item -> {
                if (obj.equals(item.btnMinus)) {
                    if (cardLayoutMain.userView.minusItemCount(item)) {
                        repository.minusItem(item.productModel, (productModelVector) -> {
                            cardLayoutMain.userView.updateSelectedLists(item.productModel);
                            updateItemView(productModelVector);
                        });
                    }

                } else if (obj.equals(item.btnPlus)) {
                    if (cardLayoutMain.userView.plusItemCount(item)) {
                        repository.selectItem(item.productModel, (productModelVector) -> {
                            cardLayoutMain.userView.updateSelectedLists(item.productModel);
                            updateItemView(productModelVector);
                        });
                    }
                } else if (obj.equals(item.btnX)) {
                    repository.exitItem(item.productModel, item.itemCount, (productModelVector) -> {
                        cardLayoutMain.userView.removeItem(item);
                        updateItemView(productModelVector);
                    });
                }
            });
        }
    }


    private void updateItemView(Vector<ProductModel> productModelVector) {
        cardLayoutMain.userView.updateItemLists(productModelVector);
        cardLayoutMain.userView.addItemListListener(Controller.this::actionPerformed);
        cardLayoutMain.userView.addSelectedItemListener(this::actionPerformed);
        cardLayoutMain.userView.updateMoney();
    }


}
