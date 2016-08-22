package me.mushen.athena.java.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Desc
 * @Author Remilia
 * @Create 2016-08-03
 */
public class Foo {
    public static final Logger LOGGER = LogManager.getFormatterLogger("Foo");

    public static void main(String[] args){
        String name = "Remilia";
        Calendar calendar = new GregorianCalendar();

        LOGGER.debug("Logging in user %s with birthday %s", name, calendar);
        LOGGER.debug("Logging in user %1$s with birthday %2$tm %2$te,%2$tY", name, calendar);
        LOGGER.debug("Integer.MAX_VALUE = %,d", Integer.MAX_VALUE);
        LOGGER.debug("Long.MAX_VALUE = %,d", Long.MAX_VALUE);
    }

}
