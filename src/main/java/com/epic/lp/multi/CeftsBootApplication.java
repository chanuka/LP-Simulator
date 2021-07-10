package com.epic.lp.multi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CeftsBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CeftsBootApplication.class, args);
        EchoMultiServer server = new EchoMultiServer();
        try {
            server.start(5555);

        } catch (IOException ex) {
            Logger.getLogger(CeftsBootApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
