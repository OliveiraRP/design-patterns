package com.es2.singleton;

public class Registry {

    private String connectionString;
    private String path;
    private static Registry instance = null;

    private Registry() {
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Registry getInstance() {
        if(instance == null)
            instance = new Registry();

        return instance;
    }
}