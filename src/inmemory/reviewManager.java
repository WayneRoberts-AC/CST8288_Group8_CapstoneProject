/**
 * 
 */
package inmemory;

import java.util.ArrayList;

import beans.Review;
import dao.ApplicationDao;

/**
 *  Manages the reviews stored in memory to be displayed to the user. 
 */
public class reviewManager {
	
	
	public static String ATTRIBUTE_NAME = "Review_Manager";
	private ArrayList<Review> reviewList = new ArrayList<>();
	private ApplicationDao appDao = new ApplicationDao();
	
	

}
