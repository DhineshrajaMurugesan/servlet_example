import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "appController", urlPatterns = {"/app"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "employee","admin"
                }),
        httpMethodConstraints = {
                // @HttpMethodConstraint(value = "GET", rolesAllowed = {"employee","admin"}),
                 @HttpMethodConstraint(value="POST",rolesAllowed={  "admin" }),
                 @HttpMethodConstraint(value="GET",rolesAllowed={"employee","admin"})
         }        

         )       
  
        
public class AppController extends HttpServlet {
    private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        writer.println("app controller accessed " + req.getUserPrincipal());
        resp.sendRedirect("form.html");
    
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
        {
            PrintWriter out=resp.getWriter();
           String name=req.getParameter("t1");
           out.print(name);

        }
      
            
    }
