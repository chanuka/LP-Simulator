/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.bi;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chanuka_g
 */
public class Client implements Runnable {

    private static ObjectOutputStream toServer;
    private static ObjectInputStream fromServer;
    private static final int SERVERPORT = 4020;
    private static Socket socket = null;

    public static void connect() throws Exception {

        try {

            InetAddress serverHost = InetAddress.getByName("localhost");
            InetSocketAddress sockAddress = new InetSocketAddress(serverHost, 4020);
            System.out.println("Connecting to server on port " + SERVERPORT);

            socket = new Socket();
            socket.setKeepAlive(true);
            socket.connect(sockAddress, 60000);
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());

//            toServer = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//            Message msgToSend = new Message(number);
//            toServer.writeObject(msgToSend);
//            toServer.flush();
            // This will block until the corresponding ObjectOutputStream 
            // in the server has written an object and flushed the header
            fromServer = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

            while (true) {
//                synchronized (fromServer) {
                    Message msgFromReply = (Message) fromServer.readObject();
                    System.out.println("Message from Server is : " + msgFromReply.number);
//                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void send(int number) throws Exception {
        toServer.writeObject(new Message(number));
        toServer.flush();
    }

    @Override
    public void run() {
        try {
            connect();
        } catch (Exception ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
