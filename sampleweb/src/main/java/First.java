import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/first")
 
public class First extends HttpServlet{
ServletConfig config=null;
 
public void init(ServletConfig config){
this.config=config;
System.out.println("servlet is initialized");
}
 
public void service(HttpServletRequest req,HttpServletResponse res)
throws IOException,ServletException{
 
res.setContentType("text/html");

 
PrintWriter out=res.getWriter();
String name=req.getParameter("name");
int port=req.getServerPort();
int len=req.getContentLength();
String sername=req.getServerName();
String enc=req.getCharacterEncoding();


out.print("welcome"    +name+     "to the webpage");
out.println("<br>"+name); 
out.println("<br>"+port); 
out.println("<br>"+len); 
out.println("<br>"+sername); 
out.println("<br>"+enc); 

}
public ServletConfig getServletConfig(){return config;}
public String getServletInfo(){return "copyright 2007-1010";}
public void destroy(){System.out.println("servlet is destroyed");}

 
}