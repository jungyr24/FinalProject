package client.data.datasource.callback;

import client.data.dao.ProductModel;

import java.util.Vector;

public interface TotalMoneyCallback {
    void success(Vector<ProductModel> lists, int totalMoney);
}
