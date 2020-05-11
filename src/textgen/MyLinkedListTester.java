/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 * Edited by Kaiyang Yao on 05/2020
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());

		try {
			longerList.remove(LONG_LIST_LENGTH + 1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd() throws Exception {
		// Implemented in week 3
		setUp();
		try {
			longerList.add(null);
			fail("Check null");
		}
		catch (NullPointerException e) {
		}

		assertEquals(10, longerList.size());
		longerList.add(3);
		assertEquals("3", longerList.tail.prev.data.toString());
		assertEquals(11, longerList.size);
		longerList.add(10);
		assertEquals("10", longerList.tail.prev.data.toString());
		assertEquals(12, longerList.size);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize() throws Exception {
		// Implemented in week 3
		setUp();
		assertEquals(2, shortList.size());
		assertEquals(10, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex() throws Exception {
		// Implemented in week 3
		setUp();
		try {
			longerList.add(-1, 3);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			longerList.add(LONG_LIST_LENGTH + 1, 3);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		assertEquals(2, shortList.size);
		shortList.add(0, "Front");
		assertEquals("Front", shortList.head.next.data);


	}

	/** Test setting an element in the list */
	@Test
	public void testSet() throws Exception {
		// Implemented in week 3
	    setUp();
		try {
			longerList.set(-1, 3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			longerList.set(LONG_LIST_LENGTH + 1, 3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}

		try {
			longerList.set(0, null);
			fail("Check null");
		}
		catch (NullPointerException e) {
		}

	    assertEquals(2, shortList.size);
	    shortList.set(0, "C");
		assertEquals("C", shortList.head.next.data);
		assertEquals(2, shortList.size);
	}

}
