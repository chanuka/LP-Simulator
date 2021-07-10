/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.iso;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

/**
 *
 * @author chanuka_g
 */
public class UnpackISOMessage {

    public static void main(String[] args) {
        UnpackISOMessage iso = new UnpackISOMessage();
        try {
//            ISOMsg isoMsg = iso.parseISOMessage();
//            iso.printISOMessage(isoMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ISOMsg parseISOMessage(byte[] message) throws Exception {
//        String message = "02003220000000808000000010000000001500120604120000000112340001840";
        System.out.printf("Message = %s%n", message);
        try {

//            InputStream myInputStream = new ByteArrayInputStream(message);
            byte[] HD = new byte[4];
            DataInputStream in3 = new DataInputStream(
                    new ByteArrayInputStream(message));
            in3.readFully(HD, 0, 4);
            int HD_LEN = Integer.parseInt(ISOUtil.hexString(HD), 16);
            byte BUFF[] = new byte[HD_LEN];
            in3.readFully(BUFF, 0, HD_LEN);

            byte ceftHeader[] = new byte[20];
            byte ceftMsg[] = new byte[BUFF.length - 20];
            for (int i = 0; i < BUFF.length; i++) {

                if (i < 20) {
                    ceftHeader[i] = BUFF[i];
                } else {
                    ceftMsg[i - 20] = BUFF[i];
                }
            }

            // Load package from resources directory.
            InputStream is = getClass().getResourceAsStream("/iso87binary.xml");
            GenericPackager packager = new GenericPackager(is);
            ISOMsg isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.unpack(ceftMsg);
            printISOMessage(isoMsg);
            return isoMsg;
        } catch (ISOException e) {
            throw new Exception(e);
        }
    }

    public void printISOMessage(ISOMsg isoMsg) {
        try {
            System.out.printf("MTI = %s%n", isoMsg.getMTI());
            for (int i = 1; i <= isoMsg.getMaxField(); i++) {
                if (isoMsg.hasField(i)) {
                    System.out.printf("Field (%s) = %s%n", i, isoMsg.getString(i));
                }
            }
        } catch (ISOException e) {
            e.printStackTrace();
        }
    }
}
