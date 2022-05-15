
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This is your test file.  Complete the following test cases to test your project where they make sense.
 * Include additional test cases if you like.  
 *
 * STUDENT tests for the methods of PasswordChecker
 * @author Alpha Bah
 *
 */
public class PasswordCheckerSTUDENT_Test {

	public PasswordCheckerUtility passwordV;;
	String message="Aaabbaa@123";
	
	@Before
	public void setUp() throws Exception {
		//String message="AAAbb@123";
		passwordV= new PasswordCheckerUtility();
	}

	@After
	public void tearDown() throws Exception {
		passwordV=null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		//fail("Not implemented by student yet");
		try{
		assertTrue(passwordV.hasBetweenSixAndNineChars("Aaaba@1"));
		assertFalse(passwordV.hasBetweenSixAndNineChars("alpha"));
		}catch(LengthException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 * @throws  
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		//fail("Not implemented by student yet");
		try {
			assertTrue(passwordV.hasUpperAlpha(message));
			assertFalse(passwordV.hasUpperAlpha("alpha"));
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 * @throws NoLowerAlphaException 
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		//fail("Not implemented by student yet");
		try {
			assertTrue(passwordV.hasLowerAlpha(message));
			assertFalse(passwordV.hasLowerAlpha("ALPHA"));
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		//fail("Not implemented by student yet");
		try {
			assertFalse(passwordV.isWeakPassword(message));
			assertTrue(passwordV.isWeakPassword("Alphaab"));
		} catch (WeakPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		//fail("Not implemented by student yet");
		try {
			assertFalse(passwordV.hasSameCharInSequence(message));
			assertTrue(passwordV.hasSameCharInSequence("Alpppha"));
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		//fail("Not implemented by student yet");
		try {
			assertTrue(passwordV.hasDigit(message));
			assertFalse(passwordV.hasDigit("Alpha"));
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception 
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		//fail("Not implemented by student yet");
		try {
			assertTrue(passwordV.isValidPassword(message));
		} catch (NoDigitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidSequenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoLowerAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSpecialCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoUpperAlphaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		//fail("Not implemented by student yet");
		ArrayList<String> passwords=new ArrayList<>();
		passwords.add(message);
		passwords.add("3kdk");
		ArrayList<String> invalid= new ArrayList<>();
		invalid.add("3kdk");
		assertTrue(passwordV.getInvalidPasswords(passwords).equals(invalid));
	}
	
}
