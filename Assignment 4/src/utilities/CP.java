package utilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CP {
    public static Connection getC(String database) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/" + database;
        String user = "root";
        String password = "Root@12345";
        return DriverManager.getConnection(url, user, password);
    }
}
