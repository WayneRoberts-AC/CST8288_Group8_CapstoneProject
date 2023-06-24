/**
 * 
 */
package beans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Review Class 
 */
class ReviewTester {
	
	Review testReview = new Review();

	/**
	 * Test the increase helpful count function
	 */
	@Test
	void testIncreaseHelpfulCount() {
		testReview.increaseHelpfulCount();
		assertEquals(1, testReview.getHelpfulCount());
	}
	
	/**
	 * Test the decrease helpful count function below the minimum (0)
	 */
	@Test
	void testdecreaseHelpfulCount() {
		testReview.decreaseHelpfulCount();
		assertEquals(0, testReview.getHelpfulCount());
	}
	
	/**
	 * Test both the increase and decrease helpful count functions
	 */
	@Test
	void testIncreaseAndDecreaseHelpfulCount() {
		testReview.increaseHelpfulCount();
		testReview.increaseHelpfulCount();
		testReview.increaseHelpfulCount();
		testReview.decreaseHelpfulCount();
		testReview.decreaseHelpfulCount();
		testReview.increaseHelpfulCount();
		assertEquals(2, testReview.getHelpfulCount());
	}
	
	/**
	 * Test getting the default overall rating
	 */
	@Test
	void testDefaultOverallRating() {
		
		assertEquals(0, testReview.getOverallRating());
	}
	
	/**
	 * Test the calculating the overall rating
	 */
	@Test
	void testCalculateOverallRating3() {
		
		testReview.setFoodRating(3);
		testReview.setAtmosphereRating(3);
		testReview.setServiceRating(3);
		
		assertEquals(3, testReview.getOverallRating());
	}
	
	/**
	 * Test the calculating the overall rating
	 */
	@Test
	void testCalculateOverallRating0() {
		
		testReview.setFoodRating(0);
		testReview.setAtmosphereRating(0);
		testReview.setServiceRating(0);
		
		assertEquals(0, testReview.getOverallRating());
	}
	
	/**
	 * Test the calculating the overall rating
	 */
	@Test
	void testCalculateOverallRating5() {
		
		testReview.setFoodRating(5);
		testReview.setAtmosphereRating(5);
		testReview.setServiceRating(5);
		
		assertEquals(5, testReview.getOverallRating());
	}
	
	/**
	 * Test the calculating the overall rating
	 */
	@Test
	void testCalculateOverallRating4() {
		
		testReview.setFoodRating(5);
		testReview.setAtmosphereRating(4);
		testReview.setServiceRating(4);
		
		assertEquals(4, testReview.getOverallRating());
	}
	
	/**
	 * Test the calculating the overall rating
	 */
	@Test
	void testCalculateOverallRating4_1() {
		
		testReview.setFoodRating(5);
		testReview.setAtmosphereRating(5);
		testReview.setServiceRating(4);
		
		assertEquals(4, testReview.getOverallRating());
	}
	
	/**
	 * Test the calculating the overall rating
	 */
	@Test
	void testCalculateOverallRating3_1() {
		
		testReview.setFoodRating(5);
		testReview.setAtmosphereRating(3);
		testReview.setServiceRating(1);
		
		assertEquals(3, testReview.getOverallRating());
	}
	
	
	/**
	 * Test setting a rating too high
	 */
	@Test
	void testTooHighRatingValue() {
		assertThrows(IllegalArgumentException.class, () ->testReview.setFoodRating(6));

	}
	
	/**
	 * Test setting a rating too low
	 */
	@Test
	void testTooLowRatingValue() {
		assertThrows(IllegalArgumentException.class, () ->testReview.setFoodRating(-1));

	}
	
	
	

}
