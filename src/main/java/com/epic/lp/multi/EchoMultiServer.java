/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.multi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chanuka_g
 */
public class EchoMultiServer {

    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            new EchoClientHandler(serverSocket.accept()).start();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class EchoClientHandler extends Thread {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Thread number : "+Thread.currentThread().getId()+"-From Client :" + inputLine);
                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(EchoMultiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
