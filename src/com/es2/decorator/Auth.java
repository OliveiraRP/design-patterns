package com.es2.decorator;

import java.io.IOException;

public class Auth extends Object implements AuthInterface {

    public Auth() {}

    @Override
    public void auth(String username, String password) throws AuthException, IOException {
    }
}
