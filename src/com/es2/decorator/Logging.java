package com.es2.decorator;

import java.io.IOException;

public class Logging extends Decorator {

    public Logging(AuthInterface auth) {
        super(auth);
    }

}
