package client.data.datasource.callback;

import client.data.dao.IngredientModel;

import java.util.Vector;

public interface GetTableCallback {
    void IgSuccess(Vector<IngredientModel> lists);
}
