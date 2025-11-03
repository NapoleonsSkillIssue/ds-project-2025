package de.luh.vss.chat.client;


import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) throws Exception {
        var serverPort = 4444;

        System.out.println("Connecting to server on port " + serverPort);
        var socket = new Socket("0.0.0.0", serverPort);
        System.out.println("Connected.");

        var reader = new DataInputStream(
            new BufferedInputStream(
                socket.getInputStream()
            )
        );

        for (var i = 0; i < 5; i++) {
            var msg = reader.readUTF();
            System.out.println("Received message from server: " + msg);
        }

        Thread.sleep(500);

        System.out.println("Disconnecting");
        socket.close();
    }
}
