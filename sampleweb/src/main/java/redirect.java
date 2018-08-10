import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class redirect extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServerException
    {  
         response.setContentType("text/html");
       PrintWriter out=  response.getWriter();
       String name=request.getParameter("name");
       response.sendRedirect("http://www.splessons.com/lesson/"+name+"-redirect/");
       out.flush();
       out.close();

    
    }

} 
