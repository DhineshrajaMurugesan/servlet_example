import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginDao {

    public String authenticateUser(LoginBean loginBean) throws NamingException {
        String userName = loginBean.getUserName();
        String password = loginBean.getPassword();
        DataSource ds=null;
        Connection con = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String roleDB = "";

        try {
            ds= DBConnection.getMySQLDataSource();
            System.out.println("data source"+ds);
            con=ds.getConnection();
            System.out.println("connection"+con);
            statement = con.createStatement();
            resultSet = statement.executeQuery("select username,password,role from users");

            while (resultSet.next()) {
                userNameDB = resultSet.getString("username");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");

                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
                    return "Admin_Role";
                else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
                    return "Editor_Role";
                else if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
                    return "User_Role";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Invalid user credentials";
    }
}