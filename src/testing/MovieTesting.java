/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import models.Movies;

/**
 * @author michealdunne14
 *
 */
public class MovieTesting {
	private Movies movie1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		movie1 = new Movies("Jaws","action","hello", 2007, 122, null, 5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link models.Movies#getTitle()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetTitle() {
		Assert.assertEquals(movie1.getTitle(), "Jaws");
	}

	/**
	 * Test method for {@link models.Movies#setTitle(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetTitle() {
		String a = "House";
		movie1.setTitle(a);
		String value = movie1.getTitle();
		Assert.assertEquals(value,a);
	}

	/**
	 * Test method for {@link models.Movies#getGenre()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetGenre() {
		Assert.assertEquals(movie1.getGenre(), "action");
	}

	/**
	 * Test method for {@link models.Movies#setGenre(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetGenre() {
		String a = "adventure";
		movie1.setGenre(a);
		String value = movie1.getGenre();
		Assert.assertEquals(value,a);
	}

	/**
	 * Test method for {@link models.Movies#getDescription()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetDescription() {
		Assert.assertEquals(movie1.getDescription(), "hello");
	}

	/**
	 * Test method for {@link models.Movies#setDescription(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetDescription() {
		String a = "house";
		movie1.setDescription(a);
		String value = movie1.getDescription();
		Assert.assertEquals(value,a);
	}

	/**
	 * Test method for {@link models.Movies#getYear()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetYear() {
		Assert.assertEquals(movie1.getYear(), 2007);
	}

	/**
	 * Test method for {@link models.Movies#setYear(int)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetYear() {
		int a = 5;
		movie1.setYear(a);
		int value = movie1.getYear();
		Assert.assertEquals(value,a);
	}

	/**
	 * Test method for {@link models.Movies#getRunTime()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetRunTime() {
		Assert.assertEquals(movie1.getRunTime(), 122);
	}

	/**
	 * Test method for {@link models.Movies#setRunTime(int)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetRunTime() {
		int a = 121;
		movie1.setRunTime(a);
		int value = movie1.getRunTime();
		Assert.assertEquals(value,a);
	}

}
