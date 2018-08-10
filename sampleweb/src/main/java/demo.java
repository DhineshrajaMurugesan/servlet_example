import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(value="/demo",initParams={
@WebInitParam(name="n1",value="hello"),
@WebInitParam(name="n2",value="world")
})
public class demo extends HttpServlet{
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
  {
      res.setContentType("text/html");
      PrintWriter out=res.getWriter();
      out.println(getInitParameter("n1"));
      out.println(getInitParameter("n2"));
      req.setAttribute("name", "krishna");
      HttpSession s=req.getSession();
      ServletContext obj=req.getServletContext();
      obj.setAttribute("number", "14");
      String n= req.getParameter("name");
     
    Cookie ck=new Cookie("uname",n);//creating cookie object  
    res.addCookie(ck);//adding cookie in the response  
   
    //creating submit button  
    out.print("<form action='/cookies'>");  
    out.print("<input type='submit' value='go'>");  
    out.print("</form>");  
           
    out.close();  
  }

    
}
