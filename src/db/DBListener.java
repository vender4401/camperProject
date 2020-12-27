package db;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBListener
 *
 */
@WebListener
public class DBListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	System.out.println("연결 해제");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
    	
    	String url = application.getInitParameter("jdbcUrl");
    	String user = application.getInitParameter("jdbcUser");
    	String pw = application.getInitParameter("jdbcPassword");
    	
    	System.out.println(url);
    	System.out.println(user);
    	System.out.println(pw);
    	
    	// 1. 클래스 로딩
    	try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
    	
    	// 2. drivermanager에서 connection
    	// 3. close();
    	try (
    			Connection con = DriverManager.getConnection(url, user, pw);
			) {
    			System.out.println("연결 성공");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	
    	ConnectionProvider.setUrl(url);
    	ConnectionProvider.setUser(user);
    	ConnectionProvider.setPassword(pw);
    	
    	// context root 경로 
    	String contextPath = application.getContextPath();
    	application.setAttribute("root", contextPath);
    }
    
	
}
