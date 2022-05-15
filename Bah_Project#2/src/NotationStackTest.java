
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationStackTest {
	public NotationStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public NotationStack<Double> doubleS;
	public double first=0, second=1, third=2, fourth=3, fifth=4;
	public ArrayList<Double> fillDouble= new ArrayList<Double>();
	// STUDENT: add variables as needed for your student tests
	
	@Before
	public void setUp() throws Exception {
		stringS = new NotationStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS=new NotationStack<Double>(4);
		doubleS.push(first);
		doubleS.push(second);
		doubleS.push(third);
		
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringS.isEmpty());
		try {
			stringS.pop();
			stringS.pop();
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, stringS.isEmpty());
		
		assertEquals(false, doubleS.isEmpty());
		try {
			doubleS.pop();
			doubleS.pop();
			doubleS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(true, doubleS.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringS.isFull());
		try {
			stringS.push(d);
			stringS.push(e);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals(true, stringS.isFull());
		
		assertEquals(false, doubleS.isFull());
		try {
			doubleS.push(fourth);
			
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		assertEquals(true, doubleS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	// GARY | @Test
	public void testPopStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		
		
	}
	
	@Test
	public void testTop() throws StackUnderflowException, StackOverflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	@Test
	public void testSize() throws StackOverflowException, StackUnderflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	// GARY | @Test
	public void testPushStudent() {
		//Use the doubleQ for student tests
		fail("Not yet implemented");
	}
	
	@Test
	public void testToString() {
		assertEquals("abc", stringS.toString());
	try {
			stringS.push(d);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("abcd", stringS.toString());
//		try {
//			stringS.push(e);
//		} catch (StackOverflowException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		assertEquals("abcde", stringS.toString());
	}

	// GARY | @Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
		fail("Not yet implemented");
	}
	
	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringS.toString("%"));
		try {
			stringS.push(d);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("a&b&c&d", stringS.toString("&"));
		try {
			stringS.push(e);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new NotationStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
