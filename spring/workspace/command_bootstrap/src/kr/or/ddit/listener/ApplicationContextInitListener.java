package kr.or.ddit.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ApplicationContextInitListener
 *
 */
@WebListener
public class ApplicationContextInitListener implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
    	String param = sce.getServletContext().getInitParameter("testParam");
    	System.out.println(param);
    }
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    }
}
