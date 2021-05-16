/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.bi;

import java.io.Serializable;

/**
 *
 * @author chanuka_g
 */
public class Message implements Serializable{

    public int number;

    public Message(int number) {
        this.number = number;
    }

}
