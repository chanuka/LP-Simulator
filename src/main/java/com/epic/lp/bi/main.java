/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.bi;

import com.epic.lp.iso.PackISOMessage;
import java.util.Scanner;

/**
 *
 * @author chanuka_g
 */
public class main {

    public static void main(String[] args) {
        try {
            new Thread(new Server()).start();
            Thread.sleep(2000);
//            new Thread(new Client()).start();
            PackISOMessage iso = new PackISOMessage();

            byte[] message = iso.buildISOMessage();
            Scanner in = new Scanner(System.in);

            while (!in.equals("exit") && in.hasNext()) {
                int num = in.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("Case1: Value is: " + num);
                        Server.send(message);
                        break;
                    case 2:
                        System.out.println("Case2: Value is: " + num);
                        Server.send(message);
                        break;
                    case 3:
                        System.out.println("Case3: Value is: " + num);
                        Server.send(message);
                        break;
                    default:
                        System.out.println("Default: Value is: " + num);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendCustomMessage(int num) {

//        Thread thread2 = new Thread(new Runnable() {
//            public void run() {
//                String threadName = Thread.currentThread().getName();
//                System.out.println("Hello " + threadName);
//            }
//        });
//        thread2.start();
//        System.out.println("Done!");
//        Runnable task = () -> {
//            String threadName = Thread.currentThread().getName();
//            System.out.println("Hello " + threadName);
//        };
//        Thread thread = new Thread(task);
//        thread.start();
    }

}
