package me.mushen.athena.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-15
 */
public class HelloWorld {
    private static final Logger LOGGER = LogManager.getLogger("HelloWorld");

    public static void main(String[] args){
        LOGGER.info("Hello, World.{}", "Remilia");
    }
}
