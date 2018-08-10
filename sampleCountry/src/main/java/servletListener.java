import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@WebListener
public class servletListener  implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce)
    {
     ServletContext ctx = sce.getServletContext();
    //  String url = ctx.getInitParameter("DBURL");
    //  String u = ctx.getInitParameter("DBUSER");
    //  String p = ctx.getInitParameter("DBPWD");
    //  System.out.print("servlet context"+url+u+p);
    System.out.println("Database connection initialized for Application.");
     try
     {
     Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/countries", "root","");
     ctx.setAttribute("jdbcConnection",jdbcConnection);
     }
     catch(SQLException eSqlException)
     {
         System.out.println("SQL Exception Occured");
     }   
    }
    public void contextDestroyed(ServletContextEvent sce)
    {
        System.out.println("Event Destroyed");
    }

}