import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author alpha
 *
 */
class SortedDoubleLinkedList_ALPHA_Test {

	SortedDoubleLinkedList<Phone> sortedlinkedPhone;
	PhoneComparator Phonecomparator;
	
	public Phone i=new Phone("Iphone", 2005);
	public Phone s=new Phone("Samsumg", 2005);
	public Phone z=new Phone("ZTE", 2005);
	public Phone m=new Phone("Motorola", 2005);
	
	public ArrayList<Phone> fill = new ArrayList<Phone>();
	
	@BeforeEach
	void setUp() throws Exception {
		Phonecomparator= new PhoneComparator();
		sortedlinkedPhone= new SortedDoubleLinkedList<Phone>(Phonecomparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		sortedlinkedPhone = null;
		Phonecomparator=null;
	}

	@Test
	void testAddToEnd() {
//		fail("Not yet implemented");
		try {
			sortedlinkedPhone.addToEnd(i);
		}catch(UnsupportedOperationException e){
			assertTrue("Invalid operation for sorted list", true);
		}
	}

	@Test
	void testAddToFront() {
//		fail("Not yet implemented");
		try {
			sortedlinkedPhone.addToFront(i);
		}catch(UnsupportedOperationException e){
			assertTrue(e.getMessage(), true);
		}
	}

	@Test
	void testAddPhone() {
//		fail("Not yet implemented");
		//alphabetical order: i m s z
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		assertEquals(i, sortedlinkedPhone.getFirst());
		assertEquals(s, sortedlinkedPhone.getLast());
		sortedlinkedPhone.add(m);
		assertEquals(s, sortedlinkedPhone.getLast());
	}

	@Test
	void testRemoveFirstPhone() {
//		fail("Not yet implemented");
		//alphabetical order: i m s z
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		sortedlinkedPhone.add(z);
		assertEquals(i, sortedlinkedPhone.getFirst());
		sortedlinkedPhone.remove(i, Phonecomparator);
		assertEquals(s, sortedlinkedPhone.getFirst());
		assertEquals(2, sortedlinkedPhone.getSize());
	}


	@Test
	void testGetFirst() {
//		fail("Not yet implemented");
		//alphabetical order: i m s z
		sortedlinkedPhone.add(s);
//		sortedlinkedPhone.add(i);
		assertEquals(s, sortedlinkedPhone.getFirst());
		sortedlinkedPhone.add(i);
		sortedlinkedPhone.add(m);
		assertEquals(i, sortedlinkedPhone.getFirst());
	}

	@Test
	void testGetLast() {
//		fail("Not yet implemented");
		//alphabetical order: i m s z
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		assertEquals(i, sortedlinkedPhone.getFirst());
		sortedlinkedPhone.add(m);
		assertEquals(i, sortedlinkedPhone.getFirst());
	
	}

	@Test
	void testRemoveLastElement() {
//		fail("Not yet implemented");
		//alphabetical order: i m s z
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		sortedlinkedPhone.add(z);
		assertEquals(z, sortedlinkedPhone.getLast());
		sortedlinkedPhone.remove(z, Phonecomparator);
		assertEquals(s, sortedlinkedPhone.getLast());
		assertEquals(2, sortedlinkedPhone.getSize());
	}
	
	@Test
	void testUnsupportedOperationException() {
		try {
			sortedlinkedPhone.addToFront(i);
			sortedlinkedPhone.addToEnd(m);
		}catch(UnsupportedOperationException e){
			assertTrue(e.getMessage(), true);
		}
	}

	@Test
	public void testIteratorNoSuchElementExceptionPreviousAndNext() {
		//alphabetical order: i m s z;
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		sortedlinkedPhone.add(z);
		ListIterator<Phone> iterator = sortedlinkedPhone.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(i, iterator.next() );
		assertEquals(s, iterator.next());
		assertEquals(z, iterator.next());
		assertEquals(false, iterator.hasNext());
		
		try {
			iterator.next();
			
		}catch(NoSuchElementException e){
			assertTrue(e.getMessage(), true);
		}
		
		assertEquals(true, iterator.hasPrevious());
		assertEquals(z, iterator.previous());
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
	void testRetrieveLastElement() {
//		fail("Not yet implemented")
		//alphabetical order: i m s z;
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		sortedlinkedPhone.add(z);
		sortedlinkedPhone.retrieveFirstElement();
		assertEquals(s, sortedlinkedPhone.getFirst());
		assertEquals(2, sortedlinkedPhone.getSize());
	}
//
	@Test
	void testToArrayList() {
//		fail("Not yet implemented");
		//alphabetical order: i m s z;
		ArrayList<Phone> list;
		sortedlinkedPhone.add(s);
		sortedlinkedPhone.add(i);
		sortedlinkedPhone.add(z);
		list=sortedlinkedPhone.toArrayList();
		assertEquals(i, list.get(0));
		assertEquals(s, list.get(1));
		assertEquals(z, list.get(2));
	}
//	
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
