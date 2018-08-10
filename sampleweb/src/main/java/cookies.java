import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies")
public class cookies extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException {
     try{
         res.setContentType("text/html");
         PrintWriter out=res.getWriter();
         Cookie ck[]=req.getCookies();
         out.println("hello"+ck[0].getValue());
         out.close();
     }catch(Exception e){
         System.out.println(e);
     }
    }

}