package com.es2.decorator;

import java.io.IOException;

public class Decorator extends Object implements AuthInterface {

    @Override
    public void auth(String username, String password) throws AuthException, IOException {

    }

    public Decorator(AuthInterface auth) {}

}
