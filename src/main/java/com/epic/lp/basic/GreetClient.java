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
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chanuka_g
 */
public class GreetClient {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }

    public static void main(String[] args) {

        GreetClient client = new GreetClient();
        try {
            client.startConnection("127.0.0.1", 6666);
            while (true) {

                Scanner input = new Scanner(System.in);
                System.out.println("Enter the Message :");
                String message = input.nextLine();
                String response = client.sendMessage(message);

                System.out.println("response : " + response);
                if ("good bye".equals(response)) {
                    break;
                }
            }
            client.stopConnection();

        } catch (IOException ex) {
            Logger.getLogger(GreetClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
