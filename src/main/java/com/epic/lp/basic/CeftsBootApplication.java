package com.epic.lp.basic;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CeftsBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeftsBootApplication.class, args);
        EchoBasicServer server = new EchoBasicServer();
        try {
            server.start(6666);

        } catch (IOException ex) {
            Logger.getLogger(CeftsBootApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
