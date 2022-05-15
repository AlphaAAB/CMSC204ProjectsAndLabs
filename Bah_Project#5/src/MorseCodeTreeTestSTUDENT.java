import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author alpha bah
 *
 */
 public class MorseCodeTreeTestSTUDENT {
	 @Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}

		@Test
		public void testConvertToEnglishString() {	
			String converter1 = MorseCodeConverter.convertToEnglish("-- -.-- / -. .- -- . / .. ... / .- .-.. .--. .... .- / -... .- ....");
			assertEquals("my name is alpha bah",converter1);
		}
		
		@Test
		public void testConvertToEnglishFile() {
			File inputFile = new File("AlphaTest.txt");
            PrintWriter inFile;
			try {
				inFile = new PrintWriter(inputFile);
				inFile.println(".. / .- -- / . -..- -.-. .. - . -.. / - --- / - . .-.. .-.. / -.-- --- ..- / - .... .- - / .. / .... .- ...- . / -. --- - .... .. -. --. / - --- / ... .- -.-- / - --- / -.-- --- ..-");
				inFile.close();
				String str= MorseCodeConverter.convertToEnglish(inputFile);
				assertEquals(str, "i am excited to tell you that i have nothing to say to you");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
		}
}