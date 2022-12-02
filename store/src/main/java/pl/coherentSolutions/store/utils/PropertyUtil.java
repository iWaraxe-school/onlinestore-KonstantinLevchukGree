package pl.coherentSolutions.store.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
    public static Properties getProperties(String fileName) {
        Properties propertiesDriver;
        InputStream inputStreamDriver = PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
        propertiesDriver = new Properties();
        try {
            propertiesDriver.load(inputStreamDriver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertiesDriver;
    }
}
