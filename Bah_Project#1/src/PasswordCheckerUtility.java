/**
 * PasswordCheckerUtility Class
 * @author Alpha Bah
 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PasswordCheckerUtility {
	/**
	 * Compare equality of two passwords
	 * @param password: password string to be checked for
	 * @param passwordConfirm:  passwordConfirm string to be checked against password for
	 * @throws UnmatchedException: thrown if not same (case sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) 
									throws UnmatchedException
	{	
		if(!(password.equals(passwordConfirm))) {
			throw new UnmatchedException();
		}
		
	}
	
	/**
	 * Compare equality of two passwords
	 * @param password: password string to be checked for
	 * @param passwordConfirm: passwordConfirm string to be checked against password for
	 * @return true if both same (case sensitive)
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
	{
		boolean status=false;
		if (password.equals(passwordConfirm))
			status=true;
		return status;
	}
	
	/**
	 * Reads a file of passwords and the passwords that failed the check will be added to an invalidPasswords with the reason
	 * @param passwords: list of passwords read from a file
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String>passwords) {
		
		ArrayList <String> invalidPasswords = new ArrayList<>();
		for (String password : passwords) {
			try {
				isValidPassword(password);
			} catch (Exception e) {
				invalidPasswords.add(password);
			}
		}
		return invalidPasswords;
	}
	
	/**
	 * Weak password length check - Password contains 6 to 9 characters , still considers valid, just weak
	 * @param password--string to be checked for Sequence requirement
	 * @return true if password contains 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password)
	{
		boolean status=false;
		if(password.length()<=9 && password.length()>=6)
			status=true;
		return status;
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character
	 * @param password--string to be checked for Digit requirement
	 * @return true if meet Digit requirement
	 * @throws NoDigitException-thrown if does not meet Digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException
	{
		boolean hasDigit= false;
		char ch;
		
		for (int i=0; i<password.length(); i++)
		{
			ch=password.charAt(i);
		
			if (Character.isDigit(ch)) {
				hasDigit=true;
			}
		}
		
		if(Character.isDigit(password.charAt(0))) {
			throw new NoDigitException("Password cannot start with a digit.");
		}
		
		if (hasDigit==true) {
			return true;
		}
		else throw new NoDigitException();
	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain a lowercase alpha character
	 * @param password--string to be checked for lowercase
	 * @return true if meet lowercase requirement
	 * @throws NoLowerAlphaException-thrown if does not meet lowercase requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
	{
		boolean hasLowerAlpha=false;
		char ch;
		
		for (int i=0; i<password.length(); i++) {
			ch= password.charAt(i);
			if(Character.isLowerCase(ch))
				hasLowerAlpha=true;
		}
		
		if (hasLowerAlpha==true)
			return true;
		else throw new NoLowerAlphaException();
		
	}
	
	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password--string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException-thrown if does not meet Sequence requirement
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException
	{
		boolean hasSameCharInSequence= false;
		
		for (int i=0, j=(i+1), k=(j+1); i<password.length() && j<password.length() && k<password.length()
				; i++, j++, k++) {
			if (password.charAt(i)==(password.charAt(j)) && password.charAt(k)==password.charAt(i)) {
				hasSameCharInSequence= true;
			}
		}
		
		if (hasSameCharInSequence==true) {
			throw new InvalidSequenceException();
		}
		else return false;
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password--string to be checked for SpecialCharacter requirement
	 * @return true if meet SpecialCharacter requirement
	 * @throws NoSpecialCharacterException-thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
	{
		boolean hasSpecialChar=false;
		
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		//return (!matcher.matches());
		if(matcher.matches()==false)
		{
			hasSpecialChar=true;
			return hasSpecialChar;
		}
		else throw new NoSpecialCharacterException();

		
	}
	
	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password--string to be checked for alpha character requirement
	 * @return true if meet alpha character requirement
	 * @throws NoUpperAlphaException-thrown if does not meet alpha character requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
	{
		boolean hasUpperAlpha=false;
		char ch;
		
		for (int i=0; i<password.length(); i++) {
			ch= password.charAt(i);
			if(Character.isUpperCase(ch))
				hasUpperAlpha=true;
		}
		
		if (hasUpperAlpha==true)
			return true;
		else throw new NoUpperAlphaException();
		
	}
	
	/**
	 * Checks the password length requirement - – The password must be at least 6 characters long
	 * @param password--string to be checked for length
	 * @return true if meet min length requirement
	 * @throws LengthException-thrown if does not meet min length requirement
	 */
	public static boolean isValidLength(String password) throws LengthException
	{
		boolean ValidLength= false;
		int minLength = 6;
		
		if (password.length()>=minLength) {
			ValidLength= true;
			return ValidLength;
		}
		else {
			throw new LengthException();
		}
			
	}
	
	/**
	 * Return true if valid password (follows all rules from above), returns false if an invalid password
	 * @param password--string to be checked for validity
	 * @return true if valid password (follows all rules from above), false if an invalid password
	 * @throws NoDigitException-thrown if no digit
	 * @throws InvalidSequenceException-thrown if more than 2 of same character
	 * @throws NoLowerAlphaException-thrown if no lowercase alphabetic
	 * @throws NoSpecialCharacterException-thrown if does not meet SpecialCharacter requirement
	 * @throws NoUpperAlphaException-thrown if no uppercase alphabetic
	 */
	public static boolean isValidPassword(String password) throws NoDigitException, InvalidSequenceException, 
	NoLowerAlphaException, NoSpecialCharacterException, NoUpperAlphaException
	{
		boolean isValidPassword=false;
		
		boolean isValidLength = isValidLength(password);
		boolean hasLowerAlpha = hasLowerAlpha(password);
		boolean hasUpperAlpha = hasUpperAlpha(password);
		boolean hasDigit = hasDigit(password);
		boolean hasSpecialChar = hasSpecialChar(password);
		boolean hasSameCharInSequence = hasSameCharInSequence(password);
		
		
		
		
		if (hasDigit==true && hasLowerAlpha==true && hasUpperAlpha==true &&
				hasSpecialChar==true && isValidLength==true && hasSameCharInSequence==false)
		{
			isValidPassword= true;
			return true;
		}
		
		else 
		{
			if(isValidLength==false)
				throw new LengthException();
			
			else if(hasLowerAlpha==false)
				throw new NoLowerAlphaException();
			
			else if (hasUpperAlpha==false)
				throw new NoUpperAlphaException();
			
			else if (hasDigit==false)
				throw new NoDigitException();
			
			else if (hasSpecialChar==false)
				throw new NoSpecialCharacterException();
			
			else 
				throw new InvalidSequenceException();
		}
		
	}
	
	/**
	 * Checks if password is valid but between 6 -9 characters
	 * @param password--string to be checked if weak password
	 * @return true if length of password is between 6 and 9 (inclusive).
	 * @throws WeakPasswordException
	 */
	public static boolean isWeakPassword (String password) throws WeakPasswordException
	{
		boolean isWeakPassword=false;
		boolean isValidLength = isValidLength(password);
		boolean hasBetweenSixAndNineChars = hasBetweenSixAndNineChars(password);
		
		if (isValidLength==true && hasBetweenSixAndNineChars==true) {
			isWeakPassword=true;
			return true;
		}
		else
			throw new WeakPasswordException();
			
		
	}
}
