import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class LoginDao {
 
public String authenticateUser(LoginBean loginBean)
{
 String userName = loginBean.getUserName();
 String password = loginBean.getPassword();
 
 Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 String userNameDB = "";
 String passwordDB = "";
 String roleDB = "";
 
 try
 {
 con = DBConnection.createConnection();
 statement = con.createStatement();
 resultSet = statement.executeQuery("select Username,Password,role from login");
 
 while(resultSet.next())
 {
 userNameDB = resultSet.getString("Username");
 passwordDB = resultSet.getString("Password");
 roleDB = resultSet.getString("role");
 System.out.print(userNameDB+passwordDB+roleDB);
 
 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
 return "Admin_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
 return "Editor_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
 return "User_Role";
 }
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials";
}
}