package client.data.datasource.callback;

import client.data.dao.IngredientModel;
import client.data.dao.ProductModel;

import java.util.Vector;

public interface ServerConnectionCallback {
    void accept(Vector<ProductModel> lists);

    void error(String error);

    interface GetTableCallback {
        void IgSuccess(Vector<IngredientModel> lists);
    }

    interface SelectItemCallback {
        void success(Vector<ProductModel> lists);

    }

    interface TotalMoneyCallback {
        void success(Vector<ProductModel> lists, int totalMoney);
    }
}