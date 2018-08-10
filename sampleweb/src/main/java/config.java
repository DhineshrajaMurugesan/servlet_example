import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 @WebServlet(urlPatterns="/config",initParams={
     @WebInitParam(name="name",value="welcome")
 })
public class config extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         
        ServletConfig config=getServletConfig();
        String splesson=config.getInitParameter("name");
        out.print("splessons: "+splesson);
         
        out.close();
    }
 
}