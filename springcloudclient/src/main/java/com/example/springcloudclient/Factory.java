package com.example.springcloudclient;

import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

public class Factory implements URLStreamHandlerFactory {
    @Override
    public URLStreamHandler createURLStreamHandler(String protocol) {
        return new HandlerMy();
    }
}
