package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class OracleDriverManager {

    public Connection openPostgresConnection() {
        try {
            Driver driver = createPostgresDriver();
            DriverManager.registerDriver(driver);

            Properties properties = loadProperties();
            Connection connection = getConnection(properties);

            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Driver createPostgresDriver() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Driver) Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    }

    private Properties loadProperties() {
        String resourceName = "postgres.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    private Connection getConnection(Properties properties) {
        try {
            return DriverManager.getConnection(properties.getProperty("url"),
                                               properties.getProperty("user"), properties.getProperty("pass"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
