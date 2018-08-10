import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;

import com..pool.PooledConnectionDataSource;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBConnection {

    public static DataSource getMySQLDataSource() {
        
            Connection con = null;
            MysqlDataSource mysqlDS = null;
            Properties props = new Properties();
            ClassLoader c1=Thread.currentThread().getContextClassLoader();
            InputStream inputstream= c1.getResourceAsStream("db.properties");
            try {

                PooledConnectionDataSource ds = new PooledConnectionDataSource();

                props.load(inputstream);
                mysqlDS = new MysqlDataSource();
                mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
                mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
                mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
            return mysqlDS;
        }
       }
       
    // Connection con = null;
    // String url = "jdbc:mysql://localhost:3306/customers";
    // String username = "root";
    // String password = "";

//     try
//     {
//         try {
//             Class.forName("com.mysql.jdbc.Driver");
//         } catch (ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//         con = DataSource.System.out.println("Post establishing a DB connection - " + con);
//     }catch(
//     Exception e)
//     {
//         e.printStackTrace();
//     }

//     return con;
// }}