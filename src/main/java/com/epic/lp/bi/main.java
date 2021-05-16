/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.bi;

/**
 *
 * @author chanuka_g
 */
public class main {

    public static void main(String[] args) {
        try {
            new Thread(new Server()).start();
            Thread.sleep(20000);

//            new Thread(new Client()).start();
//            Thread.sleep(5000);

//            Server.send(20);
//            Server.send(40);

            for (int i = 1; i < 10; i++) {
                Server.send(i);
//                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
