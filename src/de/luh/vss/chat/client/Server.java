package de.luh.vss.chat.client;
import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) throws Exception {
        var port = 4444;
        
        var server = new ServerSocket(port);
        System.out.println("Server listening on port " + port);

        for (;;) {
            var client = server.accept();
            System.out.println("We got a client: " + client.getInetAddress() + ":" + client.getPort());

            var writer = new DataOutputStream(client.getOutputStream());

            for (var i = 0; i < 5; i++) {
                var msg = "Hello from VSS!";
                writer.writeUTF(msg);
                Thread.sleep(500);

                System.out.println("Sent message to client");
            }
        }

        // System.out.println("Good night");
        // server.close();
    }
}
