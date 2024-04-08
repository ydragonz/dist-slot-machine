package com.ydragonz.server;

import com.ydragonz.server.Server;

public class MainServer {

    public static void main(String[] args) {
        Server server = new Server();
        server.start(3829);
    }
}