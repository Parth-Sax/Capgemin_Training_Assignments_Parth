package callable_and_storedpro_and_properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtil {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("E:\\coding\\CapgeminiJava\\src\\CallableStatement\\db.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
            properties.getProperty("db.url"),
            properties.getProperty("db.user"),
            properties.getProperty("db.password")
        );
    }
}
