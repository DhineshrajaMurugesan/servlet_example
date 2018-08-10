import java.io.IOException;
import java.io.PrintWriter;
  
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  @WebServlet("/example")
public class example extends HttpServlet
{ 
     
    public example()
    {    
        System.out.println("Default constructor");
    }
  
    public void init(ServletConfig config)
    {
        System.out.println("Init method...!");
    }
  
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {    
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("Hello, Welcome to splessons...!");
        pw.close();
    
    }    
  
    public void destroy()
    {
        System.out.println("Destroy method");
    }
  
}