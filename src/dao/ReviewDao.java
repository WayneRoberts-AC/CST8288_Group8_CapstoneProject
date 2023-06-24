/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.DBConnection;

import beans.Review;

/**
 * Manages interactions to the Review Table in the database 
 */
public class ReviewDao {
	
	
	/**
	 * Creates a new review in the database, Returns the number of rows added to the database. 
	 * If the number of rows = 0 then the creation failed. 
	 * @param review the review to be added 
	 * @return the number of rows added to the database. 
	 */
	public synchronized int createReview(Review review) {
		
		try (
    			// Create DB Connection
    			Connection connection = DBConnection.getConnectionToDatabase();	
    			// Create insert statement for adding a new TextLog.
    			PreparedStatement newReview = connection.prepareStatement(
    					"INSERT INTO review "
    					+"(user_ID, business_ID, Date, Content, PriceRating, OverallRating, FoodRating, ServiceRating, AtmosphereRating, UsefulCount)" 
    					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");						
				
    			){		
			newReview.setInt(1, review.getAuthor().getId());
			newReview.setInt(2, review.getBusiness().getId());
			
			// Source for converting to sql date 
			// https://stackoverflow.com/questions/16645724/how-to-insert-date-into-mysql-database-table-in-java
//			newReview.setDate(3, new java.sql.Date(review.getCreationDate().getTime()));
			newReview.setString(4, review.getContent());
			newReview.setInt(5, review.getPriceRating().getRating());
			newReview.setInt(6, review.getOverallRating());
			newReview.setInt(7, review.getFoodRating().getRating());
			newReview.setInt(8, review.getServiceRating().getRating());
			newReview.setInt(9, review.getAtmosphereRating().getRating());
			newReview.setInt(10, review.getHelpfulCount());
			
	
			return newReview.executeUpdate();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
			return 0;
		}  
		
	}
	
	

}
