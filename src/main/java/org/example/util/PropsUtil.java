package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author admin
 */
public class PropsUtil {

    private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);


    public static Properties loadProps(String filename) {
        Properties properties = null;

        try(InputStream ins = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)) {

            if (ins == null) {
                throw new FileNotFoundException(filename + " file is not found");
            }

            properties = new Properties();
            properties.load(ins);

        }catch (Exception e){
            logger.error("load properties file failure", e);
        }

        return properties;
    }


}
