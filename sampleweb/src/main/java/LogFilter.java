import java.io.IOException; 
import javax.servlet.annotation.WebFilter; 
import javax.servlet.annotation.WebInitParam; 
import javax.servlet.*; 
import java.util.*;  


@WebFilter(urlPatterns = {"/*"}, initParams = { 
   @WebInitParam(name = "test-param", value = "Initialization Paramter")}) 
public class LogFilter implements Filter {
    FilterConfig config; 
   
   public void init(FilterConfig config) throws ServletException { 
       System.out.println("Init Starts");
       this.config=config;
   } 

   public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException { 
	  
      // Log the current timestamp. 
      String testParam = config.getInitParameter("test-param");
      System.out.println("Filter Param: " + testParam);  
      System.out.println("Time " + new Date().toString());  
         
      // Pass request back down the filter chain 
      chain.doFilter(request,response); 
   }

   public void destroy( ) {
      /* Called before the Filter instance is removed  
      from service by the web container*/ 
   } 
}