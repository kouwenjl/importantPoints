package com.example.springcloudclient;

public class HandlerMy extends sun.net.www.protocol.jar.Handler {
    @Override
    public String checkNestedProtocol(String s) {
        System.out.println(55);
        return null;
    }
}
