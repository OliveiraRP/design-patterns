package com.es2.decorator;

public class Auth extends Object implements AuthInterface {

    public Auth() {}

    @Override
    public void auth(String username, String password) throws AuthException {
        if(password == "admin" && username == "admin"){
        }
        else{
            throw new AuthException();
        }
    }
}
