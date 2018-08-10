import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

 @WebServlet("/sample")
// Extend HttpServlet class
public class sample extends HttpServlet {

private static final long serialVersionUID = 1L;
public void sample(){}

public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
      // Set response content type
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("hell");
      }
    }