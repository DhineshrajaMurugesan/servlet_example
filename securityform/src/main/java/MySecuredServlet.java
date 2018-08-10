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
import java.security.Principal;
import java.time.LocalDateTime;

@WebServlet(name = "securedServlet", urlPatterns = {"/"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "employee"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "employee"
                })
        })
public class MySecuredServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException {

    
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("Welcome to the secured app!");
        writer.printf("<br/>User: " + req.getRemoteUser());
        writer.printf("<br/>time: " + LocalDateTime.now());
        writer.println("<br/><a href='/logout'>Logout</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}

 
