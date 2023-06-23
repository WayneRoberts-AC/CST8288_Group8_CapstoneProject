package beans;

import java.sql.Date;

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
	 * Constructs a new review
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
	 * Sets the author for this review
	 * @param author the author of this review
	 */
	public void setAuthor(User author) {
		this.author = author;
	}
	
	/**
	 * Sets the business that is being reviewed. 
	 * @param business the business
	 */
	public void setBusiness(Business business) {
		this.business = business;
	}
	
	/**
	 * Sets the content for this review
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Sets the price rating for this review.
	 * @param rating the rating. 
	 */
	public void setPriceRating (int rating) {
		
		priceRating.setRating(rating);
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
	 * Sets the service rating for this review.
	 * @param rating the rating. 
	 */
	public void setServiceRating (int rating) {
		
		serviceRating.setRating(rating);
		calculateOverallRating();
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
	
	
	
	
	
	
	
	
	

}