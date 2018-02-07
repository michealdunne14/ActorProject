/**
 * 
 */
package testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import models.Actors;

/**
 * @author michealdunne14
 *
 */
public class ActorTesting {
	private Actors actor1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		actor1 = new Actors("micheal", "male", "Irish", 5, 5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link models.Actors#getName()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetName() {
		Assert.assertEquals(actor1.getName(), "micheal");
	}

	/**
	 * Test method for {@link models.Actors#setName(java.lang.String)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testSetName() {
		String a = "house";
		actor1.setName(a);
		String value = actor1.getName();
		Assert.assertEquals(value,a);
	}

	/**
	 * Test method for {@link models.Actors#getGender()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetGender() {
		Assert.assertEquals(actor1.getGender(), "male");
	}

	/**
	 * Test method for {@link models.Actors#setGender(java.lang.String)}.
	 */
	@Test
	public final void testSetGender() {
		String a = "female";
		actor1.setGender(a);
		String value = actor1.getGender();
		Assert.assertEquals(actor1.getGender(), "female");
	}

	/**
	 * Test method for {@link models.Actors#getNationality()}.
	 */
	@Test
	public final void testGetNationality() {
		Assert.assertEquals(actor1.getNationality(), "Irish");
	}

	/**
	 * Test method for {@link models.Actors#setNationality(java.lang.String)}.
	 */
	@Test
	public final void testSetNationality() {
		String a = "Irish";
		actor1.setNationality(a);
		String value = actor1.getNationality();
		Assert.assertEquals(actor1.getNationality(),"Irish");
	}

	/**
	 * Test method for {@link models.Actors#getDateOfBirth()}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public final void testGetDateOfBirth() {
		Assert.assertEquals(actor1.getDateOfBirth(),5);
	}

	/**
	 * Test method for {@link models.Actors#setDateOfBirth(int)}.
	 */
	@Test
	public final void testSetDateOfBirth() {
		int a = 121212;
		actor1.setDateOfBirth(a);
		int value = actor1.getDateOfBirth();
		Assert.assertEquals(actor1.getDateOfBirth(),121212);
	}

	/**
	 * Test method for {@link models.Actors#getCount()}.
	 */
	@Test
	public final void testGetCount() {
		Assert.assertEquals(actor1.getCount(), 5);
	}

	/**
	 * Test method for {@link models.Actors#setCount(int)}.
	 */
	@Test
	public final void testSetCount() {
		int a = 8;
		actor1.setCount(a);
		int value = actor1.getCount();
		Assert.assertEquals(actor1.getCount(),8);
	}

}
