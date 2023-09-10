package com;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.vastpro.jdbc.conutil.ConnectionUtility1;

/**
 * Application Lifecycle Listener implementation class WebInitContextListener
 *
 */
@WebListener
public class WebInitContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public WebInitContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("context destroyed...");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	try {
         System.out.println("context initialized....");
         ServletContext application=sce.getServletContext();
         
         //Static properties load
         String path=application.getRealPath("/WEB-INF/config.properties");         
         Properties prop=new Properties();
         prop.load(new FileInputStream(path));
         //application.setInitParameter("prop", prop);
         application.setAttribute("prop", prop);
         
         //DB properties load
         Connection conn = ConnectionUtility1.getConnection();
         application.setAttribute("conn", conn);
         
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
	
}
