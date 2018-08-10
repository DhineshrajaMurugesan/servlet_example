import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
@WebServlet(value="/country",initParams={
@WebInitParam(name="test",value="servlet web init parameter"),
@WebInitParam(name="user",value="Gunavathi")
})
public class countryGetall extends HttpServlet {

private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

try {
    System.out.println(getInitParameter("url"));
    System.out.println(getInitParameter("user"));
    ServletContext ctx=getServletContext();  
    Connection jdbccon=(Connection)ctx.getAttribute("jdbcConnection");
    System.out.println("Jdbc connection"+jdbccon);
// Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/countries", "root","");
List<Country> listCountry = new ArrayList<Country>();
String sql = "SELECT * FROM country";
Statement statement = jdbccon.createStatement();
ResultSet resultSet = statement.executeQuery(sql);
System.out.println(resultSet);
while (resultSet.next()) {
int id = resultSet.getInt("Id");
String name = resultSet.getString("Name");
String abrrev = resultSet.getString("Abbrevation");
Country country = new Country(id, name, abrrev);
listCountry.add(country);
}
System.out.println(listCountry);
req.setAttribute("list", listCountry);
RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
dispatcher.forward(req, resp);

} 
catch (Exception e) {

System.out.println("Exception occurred");

}



}

}
