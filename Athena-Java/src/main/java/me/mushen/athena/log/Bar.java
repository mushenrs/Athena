package me.mushen.athena.log;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-03
 */
public class Bar {
    private static final Logger logger = LogManager.getLogger("Bar");

    public static void main(String[] args){
        String name = "Remilia";
        Calendar calendar = new GregorianCalendar();

        logger.debug("Opening connection to {}...", "someDataSource");
        logger.printf(Level.INFO, "Logging in user %1$s with birthday %2$tm %2$te,%2$tY", name, calendar);

    }

}
