
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

@WebListener
public class StartStopAppListener implements ServletContextListener {

 public void contextInitialized(ServletContextEvent servletContextEvent) {

  System.out.println("Servlet Context Initialized ... ");

 }

 public void contextDestroyed(ServletContextEvent servletContextEvent) {

  System.out.println("Servlet Context Destroyed ... ");

 }

}
