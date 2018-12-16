package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

public class JdbcApplication {

    public static void main(String[] args) throws SQLException {
        OracleDriverManager oracleDriverManager = new OracleDriverManager();
        Locale.setDefault(Locale.ENGLISH);
        Connection connection = oracleDriverManager.openPostgresConnection();
        
        SimpleExample simpleExample = new SimpleExample(connection);
        simpleExample.selectExample();
    }
}


