package test;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void test() {

        Properties props = new Properties();
        try(InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties")) {

            props.load(is);
            props.list(System.out);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
