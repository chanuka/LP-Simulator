package com.epic.lp.basic;

///*
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOUtil;

// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.epic.lp;
//
//import java.util.Scanner;
//
///**
// *
// * @author chanuka_g
// */
public class Test {
//

    public static void main(String[] args) {
//
//        System.out.println("Enter expression to solve");
//        Scanner input = new Scanner(System.in);
//        String expression = input.nextLine();
//
//        System.out.println(expression);
//        String operators[] = expression.split("[0-9]+");
//        String operands[] = expression.split("[/*+-]");
//
//        
//        calculate_expression(operands, operators);
//
//    }
//
//    public static void calculate_expression(String[] operands, String[] operators) {
//
//        int result = Integer.parseInt(operands[0]);
//
//        for (int i = 0; i < operands.length; i++) {
//
//            if (operators[i].equals("+")) {
//                result += Integer.parseInt(operands[i]);
//            } else if (operators[i].equals("-")) {
//                result -= Integer.parseInt(operands[i]);
//            } else if (operators[i].equals("*")) {
//                result *= Integer.parseInt(operands[i]);
//            } else if (operators[i].equals("/")) {
//                result /= Integer.parseInt(operands[i]);
//            }
//
//        }
//        System.out.println(result);
        byte[] SD = {'T', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5', '3', '6', 'S', '5',
            '3', '6', 'S', '5', '6', '6', 'S', '5', '3', '6', 'S', '6', 'S', '5', '3', '6', 'S', '6', 'S', '5', '3', '6', '6', '6', '6', '6', '6'};

        byte[] HD = {0, 0, 1, 127};
        for (int i = 0; i < HD.length; i++) {
            System.out.print(HD[i] + " ");
        }
        System.out.println("Length : " + Integer.parseInt(ISOUtil.hexString(HD), 16));

        try {
            getHexLength(SD, 4);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static byte[] getHexLength(byte[] message, int lengthBufferSize) throws Exception {

        lengthBufferSize = lengthBufferSize * 2;
        int requestLen = message.length;
        System.out.println("requestLen:" + requestLen);
        String len = Integer.toHexString(requestLen);
        System.out.println("len:" + len);

        len = ISOUtil.zeropad(len, lengthBufferSize);
        System.out.println("Zero Padded len:" + len);

        byte[] test = ISOUtil.hex2byte(len);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + " ");
        }
        return ISOUtil.concat(ISOUtil.hex2byte(len), message);

    }
}
