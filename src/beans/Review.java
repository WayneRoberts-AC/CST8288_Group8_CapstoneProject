package beans;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @author wbr
 * Describes a review of a restaurant created by a user. 
 * 
 *  
 */

public class Review {
	
	private int id;
	
	private User author;
	private Business business;
	private String content; 
	
	private Rating priceRating;
	private Rating overallRating;
	private Rating foodRating;
	private Rating serviceRating;
	private Rating atmosphereRating;
	
	private Date creationDate;
	private int helpfulCount;
	private final int MIN_HELPFUL_COUNT = 0;
	
	/**
	 * Constructs a new review with default values. 
	 */
	public Review() {
		helpfulCount = 0;
		priceRating = new Rating();
		overallRating = new Rating();
		foodRating = new Rating();
		serviceRating = new Rating();
		atmosphereRating = new Rating();
	}
	
	/**
	 * sets the ID for this review, used when reading a review for the database. 
	 * @param id the id. 
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * gets the id of this review. 
	 * @return the id. 
	 */
	public int getID() {
		return id;
	}
	
	/**
	 * Sets the author for this review
	 * @param author the author of this review
	 */
	public void setAuthor(User author) {
		this.author = author;
	}
	
	/**
	 * Gets the author of this review
	 * @return the author. 
	 */
	public User getAuthor() {
		return author;
	}
	
	/**
	 * Sets the business that is being reviewed. 
	 * @param business the business
	 */
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	/**
	 * Gets the business that is being reviewed. 
	 * @return the business
	 */
	public Business getBusiness() {
		return business;
	}
	
	/**
	 * Sets the content for this review
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the content of the review. 
	 * @return the content of the review. 
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the price rating for this review.
	 * @param rating the rating. 
	 */
	public void setPriceRating (int rating) {
		
		priceRating.setRating(rating);
	}
	
	/**
	 * Gets the price rating of this review. 
	 * @return the price rating. 
	 */
	public Rating getPriceRating() {
		return priceRating;
	}
	
	/**
	 * Sets the food rating for this review.
	 * @param rating the rating. 
	 */
	public void setFoodRating (int rating) {
		
		foodRating.setRating(rating);
		calculateOverallRating();
	}
	
	/**
	 * Gets the food rating of this review
	 * @return the food rating. 
	 */
	public Rating getFoodRating() {
		return foodRating;
	}
	
	/**
	 * Sets the service rating for this review.
	 * @param rating the service rating. 
	 */
	public void setServiceRating (int rating) {
		
		serviceRating.setRating(rating);
		calculateOverallRating();
	}
	
	/**
	 * gets the service rating for this review.
	 * @return the service rating
	 */
	public Rating getServiceRating() {
		return serviceRating;
	}
	
	/**
	 * Sets the atmosphere rating for this review.
	 * @param rating the rating. 
	 */
	public void setAtmosphereRating (int rating) {
		
		atmosphereRating.setRating(rating);
		calculateOverallRating();
	}
	
	/**
	 * gets the atmosphere rating for this review. 
	 * @return the atmosphere rating. 
	 */
	public Rating getAtmosphereRating() {
		return atmosphereRating;
	}
	
	/**
	 * Calculates the overall rating for the review based on food, service and atmosphere. 
	 * 
	 */
	private void calculateOverallRating() {
		int foodRatingValue = foodRating.getRating();
		int serviceRatingValue = serviceRating.getRating();
		int atmosphereRatingValue = atmosphereRating.getRating();
		
		int overallRatingValue = (foodRatingValue + serviceRatingValue + atmosphereRatingValue) / 3;
		overallRating.setRating(overallRatingValue);
	}
	
	/**
	 * gets the overall rating of the review
	 * @return the overall rating
	 */
	public int getOverallRating() {
		return overallRating.getRating();
	}
	

	/**
	 * gets the count of users who found the review helpful
	 * @return the the count of users who found the review helpful
	 */
	public int getHelpfulCount() {
		return helpfulCount;
	}
	
	/**
	 * Increases the count of users who found the review helpful by one. 
	 */
	public void increaseHelpfulCount() {
		helpfulCount += 1;
	}
	
	/**
	 * Decreases the count of users who found the review helpful by one. 
	 */
	public void decreaseHelpfulCount() {
		helpfulCount -= 1;
		if (helpfulCount < MIN_HELPFUL_COUNT ) {
			helpfulCount = MIN_HELPFUL_COUNT;
		} 
	}
	
	/**
	 * Posts this review, creates creationDate the time stamp 
	 */
	public void post() {
		setCreationDate();
		
		// TODO: Add post into Database. 
		
		// TODO: Get post ID from Database. 
		
	}
	
	/**
	 * sets the creation date for this post. 
	 */
	private void setCreationDate() {
		
		// Timestamp source https://mkyong.com/java/how-to-get-current-timestamps-in-java/
		Date tsDate = new Date();
		this.creationDate = new Timestamp(tsDate.getTime());	
	}
	
	/**
	 * gets the creation date for this post. 
	 * @return the creation date 
	 */
	public Date getCreationDate() {
		return creationDate;
	}
	
	
	
	
	
	
	
	
	

}
