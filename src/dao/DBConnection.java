/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author wbr
 * Creates a connection to the DataBase
 * Source for code
 *  https://www.linkedin.com/learning/java-ee-servlets-and-javaserver-pages-jsp/search-setting-up-a-database-connection?resume=false&u=2199673
 */
public class DBConnection {
	
	// TODO: Implement Singleton design pattern. 
	
	private static final String URL = "jdbc:mysql://localhost:3306/RestuarantReviews";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    

    /**
     * Creates and returns a connection the database
     * @return the connection. 
     */
    public static Connection getConnectionToDatabase() {
    	    	
       Connection connection = null;
       try {		
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}

		catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		if (connection != null) {
			//System.out.println("Connection made to DB!");
		}
        

        return connection;
    }

}
