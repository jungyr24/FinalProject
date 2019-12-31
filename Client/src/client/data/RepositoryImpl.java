package client.data;

import client.data.dao.ProductModel;
import client.data.datasource.ServerConnection;

import java.util.Vector;

public class RepositoryImpl implements Repository {
    private static Repository INSTANCE = null;
    private ServerConnection serverConnection;

    private RepositoryImpl(ServerConnection serverConnection) {
        this.serverConnection = serverConnection;
    }

    public static Repository getInstance(ServerConnection serverConnection) {
        if (INSTANCE == null) INSTANCE = new RepositoryImpl(serverConnection);
        return INSTANCE;
    }

    @Override
    public void connectServer(ServerConnectionCallback callback) {
        //TODO Server와 연결하는 동작
        // serverConnection
        serverConnection.send(/*Login */);
        serverConnection.login(new ServerConnectionCallback() {
            @Override
            public void accept(Vector<ProductModel> lists) {
                callback.accept(lists);
            }

            @Override
            public void error(String error) {
                callback.error(error);
            }
        });

    }

    public interface ServerConnectionCallback {
        void accept(Vector<ProductModel> lists);

        void error(String error);
    }
}
