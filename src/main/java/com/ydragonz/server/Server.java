package com.ydragonz.server;
// Server.java
import java.io.*;
import java.net.*;
import java.util.Random;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private final Random random = new Random();

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if ("play".equals(inputLine)) {
                    out.println(play());
                } else {
                    out.println("unrecognized command");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String play() {
        int reel1 = random.nextInt(7) + 1;
        int reel2 = random.nextInt(7) + 1;
        int reel3 = random.nextInt(7) + 1;

        if(reel1 == reel2 && reel2 == reel3) {
            return "You win the jackpot! The result is " + reel1 + " " + reel2 + " " + reel3;

        }else if (reel1 == reel2 || reel2 == reel3 || reel1 == reel3) {
            return "You win! The result is " + reel1 + " " + reel2 + " " + reel3;
        } else {
            return "You lose. The result is " + reel1 + " " + reel2 + " " + reel3;
        }
    }
}