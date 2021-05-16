/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author chanuka_g
 */
public class EchoBasicServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting;
        while ((greeting = in.readLine()) != null) {
            System.out.println("From Client :" + greeting);
            if ("hello server".equals(greeting)) {
                out.println("hello client");
            } else if (".".equals(greeting)) {
                out.println("good bye");
                break;
            } else {
                out.println("unrecognised greeting");
            }
        }
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
