package com.es2.decorator;

import java.io.IOException;

public class Decorator extends Object implements AuthInterface {

    AuthInterface authInt;

    public Decorator(AuthInterface auth) {
        this.authInt = auth;
    }

    @Override
    public void auth(String username, String password) throws AuthException, IOException {
        try{
            authInt.auth(username, password);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
