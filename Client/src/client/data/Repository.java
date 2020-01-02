package client.data;

import client.data.dao.ProductModel;
import client.data.datasource.callback.ServerConnectionCallback;

public interface Repository {
    void connectServer(ServerConnectionCallback callback);

    void selectItem(ProductModel item, ServerConnectionCallback.SelectItemCallback callback);

    void minusItem(ProductModel item, ServerConnectionCallback.SelectItemCallback callback);

    void exitItem(ProductModel item, int itemCount, ServerConnectionCallback.SelectItemCallback callback);

    void buyItem(int total);

    void currentIngredients(ServerConnectionCallback.GetTableCallback callback);

    void buyIngredient(ServerConnectionCallback.GetTableCallback callback);

    void totalMoney(ServerConnectionCallback.TotalMoneyCallback callback);



}
