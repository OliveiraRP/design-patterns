package com.es2.objectpool;

import com.es2.singleton.Registry;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ReusablePool {

    ArrayList<HttpURLConnection> connFree = new ArrayList<>();
    ArrayList<HttpURLConnection> connUsed = new ArrayList<>();

    public int maxPoolSize = 10;
    private static ReusablePool instance = null;

    private ReusablePool() {}

    public static ReusablePool getInstance() {
        if(instance == null)
            instance = new ReusablePool();

        return instance;
    }

    public synchronized HttpURLConnection acquire() throws IOException, PoolExhaustedException {

        HttpURLConnection conn;

        if(connFree.isEmpty()) {
            if (connUsed.size() < maxPoolSize) {
                URL url = new URL("http://www.estgv.ipv.pt");
                conn = (HttpURLConnection) url.openConnection();
                connUsed.add(conn);
            } else
                throw new PoolExhaustedException();
        } else {
            conn = connFree.get(0);
            connUsed.add(conn);
            connFree.remove(conn);
        }

        return conn;
    }

    public synchronized void release(HttpURLConnection conn) throws ObjectNotFoundException {

        if(connUsed.contains(conn)) {
            conn.disconnect();
        }
        else
            throw new ObjectNotFoundException();

        connUsed.remove(conn);
        connFree.add(conn);
    }

    public synchronized void resetPool() {
        instance = null;
    }

    public synchronized void setMaxPoolSize(int size) {
        this.maxPoolSize = size;
    }
}
