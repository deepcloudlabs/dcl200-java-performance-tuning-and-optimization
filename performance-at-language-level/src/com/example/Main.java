package com.example;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger;

	public static void main(String[] args) {
        logger = null;
        for (int i=0;i<100;++i){
            if (logger.isLoggable(Level.INFO))
                logger.info("Log message "+ i);
            //logger.info(String.format("Log message %d",i));

        }
        System.gc(); // HotSpot -> Full GC
        // -XX:+DisableExplicitGC

    }
}
