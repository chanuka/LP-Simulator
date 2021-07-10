/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epic.lp.iso;

import java.io.InputStream;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.GenericPackager;

/**
 *
 * @author chanuka_g
 */
public class PackISOMessage {

    public static void main(String[] args) {
        PackISOMessage iso = new PackISOMessage();
        UnpackISOMessage unpack_iso = new UnpackISOMessage();

        try {
            byte[] message = iso.buildISOMessage();
//            System.out.printf("Message = %s", message);

            unpack_iso.parseISOMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] buildISOMessage() throws Exception {
        try {
            // Load package from resources directory.
            InputStream is = getClass().getResourceAsStream("/iso87binary.xml");
            GenericPackager packager = new GenericPackager(is);

            ISOMsg isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.setMTI("0200");

            isoMsg.set(2, "001107000242");
            isoMsg.set(3, "480000");
            isoMsg.set(4, "000000001200");
            isoMsg.set(5, "000000100000");
            isoMsg.set(7, "1028103055");
            isoMsg.set(11, "000010");
            isoMsg.set(12, "143556");
            isoMsg.set(13, "1028");
            isoMsg.set(15, "1028");
            isoMsg.set(17, "1028");
            isoMsg.set(18, "6015");
            isoMsg.set(22, "000");
            isoMsg.set(23, "000");
            isoMsg.set(32, "600337");
            isoMsg.set(37, "000000000140");
            isoMsg.set(41, "800CEFT");
            isoMsg.set(43, "0000000000000000000000000000000000000000");
            isoMsg.set(49, "144");
            isoMsg.set(90, "0200000005112412555500000006454112414493095");
            isoMsg.set(102, "001107000242");
            isoMsg.set(103, "3636363636");
            isoMsg.set(120, "0020281601000000050001731100071111004010007642289600500467280060046010009015ABERATHNA M M R01300252");

            printISOMessage(isoMsg);

            byte[] result = ISOUtil.concat("ISO198700           ".getBytes(), isoMsg.pack());
//            byte[] result = isoMsg.pack();

            int lengthBufferSize = 4 * 2;
            int requestLen = result.length;
            String len = Integer.toHexString(requestLen);
            len = ISOUtil.zeropad(len, lengthBufferSize);

            return ISOUtil.concat(ISOUtil.hex2byte(len), result);
//            return new String(ISOUtil.concat(ISOUtil.hex2byte(len), result));
//            return new String(result);
//            return result;
            
        } catch (ISOException e) {
            throw new Exception(e);
        }
    }

    private void printISOMessage(ISOMsg isoMsg) {
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
