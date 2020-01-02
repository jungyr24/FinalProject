package client.ui.adminview;

import client.data.dao.IngredientModel;
import client.data.dao.ProductModel;
import client.ui.holder.AddItemHolder;
import client.ui.holder.BuyIngredientsHolder;
import client.ui.holder.CurrentIngrdntHolder;
import client.ui.holder.TotalMoneyHolder;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public interface AdminView {
    TotalMoneyHolder TOTAL_MONEY_HOLDER = new TotalMoneyHolder();
    BuyIngredientsHolder BUY_INGREDIENTS_HOLDER = new BuyIngredientsHolder();
    CurrentIngrdntHolder CURRENT_INGRDNT_HOLDER = new CurrentIngrdntHolder();
    AddItemHolder ADD_ITEM_HOLDER = new AddItemHolder();
    JPanel adminStartPanel = new JPanel(), btnAdminWhatToDo = new JPanel();


    JPanel AdminClientButtonPnl = new JPanel();
    JButton btnTotalMoney = new JButton("총 매출"), btnCurrentIngredients = new JButton("재고 현황"),
            btnBuyIngredients = new JButton("재고 구매"), btnAddItem = new JButton("제품 추가"), btnAdminClient = new JButton("사용자");

    void updateCurrentTable(Vector<IngredientModel> ingredientModels);
    void updateBuyIngredientTable(Vector<IngredientModel> ingredientModels);
    void totalMoneyTable(Vector<ProductModel> productModels);

    void addAdminListener(ActionListener listener);
}
