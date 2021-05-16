/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.bi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chanuka_g
 */
public class Server implements Runnable {

    private static ObjectOutputStream toClient;
    private static ObjectInputStream fromClient;
    private static Socket socket;
    private static final int SERVERPORT = 4020;
    private static ServerSocket serverSocket;

    public static void start() throws InterruptedException {

        try {
            serverSocket = new ServerSocket(SERVERPORT);

            socket = serverSocket.accept();
            System.out.println("Just connected to " + socket.getRemoteSocketAddress());

            toClient = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            fromClient = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
//            Message msgRequest;
//            while ((msgRequest= (Message) fromClient.readObject()) != null) {
//                int number = msgRequest.number;
//                toClient.writeObject(new Message(number * number));
//                toClient.flush();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void send(int number) throws Exception {
        toClient.writeObject(new Message(number * number));
        toClient.flush();
    }

    @Override
    public void run() {
        try {
            start();
            
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
