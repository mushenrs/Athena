package me.mushen.athena.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-03
 */
public class LoggerHierarchy {
    private static final Logger ROOTLOGGER1 = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private static final Logger ROOTLOGGER2 = LogManager.getRootLogger();

    public static void main(String[] args){
        System.out.println(ROOTLOGGER1 == ROOTLOGGER2);

        Logger test1 = LogManager.getLogger("test");
        Logger test2 = LogManager.getLogger("test");
        System.out.println(test1 == test2);
    }
}
