import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
@WebServlet("/attri")
public class attri extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        out.println("attribute value:"+req.getAttribute("name"));
       ServletContext obj= getServletContext();
        out.println("atrribut context:"+obj.getAttribute("number"));
        out.flush();
        out.close();
        

    }
}