import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author alpha
 *
 */

class BasicDoubleLinkedList_ALPHA_Test {

	BasicDoubleLinkedList<Phone> linkedPhone;
	PhoneComparator Phonecomparator;
	
	public Phone i=new Phone("Iphone", 2005);
	public Phone s=new Phone("Samsumg", 2005);
	public Phone z=new Phone("ZTE", 2005);
	public Phone m=new Phone("Motorola", 2005);
	
	public ArrayList<Phone> fill = new ArrayList<Phone>();
	
	@BeforeEach
	void setUp() throws Exception {
		linkedPhone= new BasicDoubleLinkedList<Phone>();
		linkedPhone.addToEnd(i);
		linkedPhone.addToEnd(s);
		Phonecomparator= new PhoneComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedPhone = null;
	}

	@Test
	void testGetSize() {
//		fail("Not yet implemented");
		assertEquals(2,linkedPhone.getSize());
	}

	@Test
	void testAddToEnd() {
//		fail("Not yet implemented");
		assertEquals(s,linkedPhone.getLast());
		linkedPhone.addToEnd(m);
		assertEquals(m,linkedPhone.getLast());
	}

	@Test
	void testAddToFront() {
//		fail("Not yet implemented");
		assertEquals(i,linkedPhone.getFirst());
		linkedPhone.addToFront(z);
		assertEquals(z,linkedPhone.getFirst());
	}

	@Test
	void testGetFirst() {
//		fail("Not yet implemented");
		assertEquals(i,linkedPhone.getFirst());
	}

	@Test
	void testGetLast() {
//		fail("Not yet implemented");
		assertEquals(s,linkedPhone.getLast());
	}

	@Test
	void testIteratorSuccessfulNext() {
		linkedPhone.addToEnd(z);
		linkedPhone.addToFront(m);
		ListIterator<Phone> iterator = linkedPhone.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(m, iterator.next());
		assertEquals(i, iterator.next());
		assertEquals(s, iterator.next());
		assertEquals(z, iterator.next());
		assertEquals(false, iterator.hasNext());
	}
	
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedPhone.addToEnd(z);
		linkedPhone.addToFront(m);
		ListIterator<Phone> iterator = linkedPhone.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(m, iterator.next());
		assertEquals(i, iterator.next());
		assertEquals(s, iterator.next());
		assertEquals(z, iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(z, iterator.previous());
		assertEquals(s, iterator.previous());
		assertEquals(i, iterator.previous());
		assertEquals(m, iterator.previous());
		assertEquals(false, iterator.hasPrevious());
		
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		ListIterator<Phone> iterator = linkedPhone.iterator();
		assertEquals(i, iterator.next());
		assertEquals(s, iterator.next());
		assertEquals(false, iterator.hasNext());
		
		try {
			iterator.next();
		}catch(NoSuchElementException e){
			assertTrue(e.getMessage(), true);
		}
	}
	
	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		ListIterator<Phone> iterator = linkedPhone.iterator();
		assertEquals(i, iterator.next());
		assertEquals(s, iterator.next());
		assertEquals(false, iterator.hasNext());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(s, iterator.previous());
		assertEquals(i, iterator.previous());
		assertEquals(false, iterator.hasPrevious());
		
		try {
			iterator.previous();
		}catch(NoSuchElementException e){
			assertTrue(e.getMessage(), true);
		}
	}

	@Test
	void testRemove() {
//		fail("Not yet implemented");
		assertEquals(i, linkedPhone.getFirst());
		assertEquals(s, linkedPhone.getLast());
		assertEquals(2, linkedPhone.getSize());
		linkedPhone.remove(i, Phonecomparator);
		assertEquals(s, linkedPhone.getFirst());
		assertEquals(1, linkedPhone.getSize());
		
		linkedPhone.addToEnd(z);
		assertEquals(z, linkedPhone.getLast());
	}

	@Test
	void testRetrieveFirstElement() {
//		fail("Not yet implemented");
		assertEquals(i, linkedPhone.getFirst());
		assertEquals(s, linkedPhone.getLast());
		assertEquals(2, linkedPhone.getSize());
		linkedPhone.addToEnd(z);
		assertEquals(3, linkedPhone.getSize());
		linkedPhone.retrieveFirstElement();
		assertEquals(s, linkedPhone.getFirst());
		assertEquals(z, linkedPhone.getLast());
		assertEquals(2, linkedPhone.getSize());
	}

	@Test
	void testRetrieveLastElement() {
//		fail("Not yet implemented");
		assertEquals(i, linkedPhone.getFirst());
		assertEquals(s, linkedPhone.getLast());
		assertEquals(2, linkedPhone.getSize());
		linkedPhone.addToEnd(z);
		assertEquals(3, linkedPhone.getSize());
		linkedPhone.retrieveLastElement();
		assertEquals(i, linkedPhone.getFirst());
		assertEquals(s, linkedPhone.getLast());
		assertEquals(2, linkedPhone.getSize());
		
	}

	@Test
	void testToArrayList() {
//		fail("Not yet implemented");
		ArrayList<Phone> list;
		linkedPhone.addToFront(m);
		//linkedCar.addToEnd(d);
		list = linkedPhone.toArrayList();
		assertEquals(m,list.get(0));
		assertEquals(i,list.get(1));
		assertEquals(s,list.get(2));
	}

	private class PhoneComparator implements Comparator<Phone>
	{

		@Override
		public int compare(Phone arg0, Phone arg1) {
			// Phone's brands by alphabetical order
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Phone{
		String brand;
		int year;
		
		public Phone(String brand, int year){
			this.brand = brand;
			this.year = year;
		}
		
		public String getBrand(){
			return brand;
		}
		
		public int getYear(){
			return year;
		}
		
		public String toString() {
			return (getBrand()+" "+getYear());
		}
	}
}
