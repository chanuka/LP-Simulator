package com.epic.lp.basic;

///*
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
//public class Test {
//
//    public static void main(String[] args) {
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
//    }
//}
