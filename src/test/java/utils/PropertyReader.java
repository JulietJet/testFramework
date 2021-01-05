package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static Properties prop;


    public static String readProperty(String property) {
        loadRunProperty();
        return prop.getProperty(property);
    }


    private static void loadRunProperty() {
        try {
            prop = new Properties();
            File configFile = new File("src/resources/Run.properties");
            InputStream stream = new FileInputStream(configFile);
            prop.load(stream);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
