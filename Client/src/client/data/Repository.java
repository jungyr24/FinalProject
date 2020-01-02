package client.data;

import client.data.dao.ProductModel;
import client.data.datasource.callback.GetTableCallback;
import client.data.datasource.callback.SelectItemCallback;
import client.data.datasource.callback.ServerConnectionCallback;

public interface Repository {
    void connectServer(ServerConnectionCallback callback);

    void selectItem(ProductModel item, SelectItemCallback callback);

    void minusItem(ProductModel item, SelectItemCallback callback);

    void exitItem(ProductModel item, int itemCount, SelectItemCallback callback);

    void buyItem(int total);

    void totalMoney(SelectItemCallback callback);

    void currentIngredients(GetTableCallback callback);

    void buyIngredient(GetTableCallback callback);


}
