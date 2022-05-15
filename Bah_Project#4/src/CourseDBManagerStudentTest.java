import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author alpha
 */
public class CourseDBManagerStudentTest {

  private CourseDBManagerInterface CDBMngr= new CourseDBManager();

    @BeforeEach
    public void setUP() throws Exception{
        CDBMngr= new CourseDBManager();
    }

    
    @AfterEach
    public void tearDown() throws Exception {
        CDBMngr = null;
    }

    
    @Test
    public void testAddToDB() {
        try {
            CDBMngr.add("CMSC204", 62771, 4, "SC150", "Alpha Bah");
            CDBMngr.add("cmsc140", 24581, 3, "HU200","Sanoussy Sow");//should throw an exception cmsc not equals CMSC case sensitive
            CDBMngr.add("CMSC207", 55555, 0, "MT012", "Amadou");//should throw an exception number of credits must be between 1 and 4
        }
        catch(Exception e) {
            assertTrue("ID must start with CMSC", true);
            assertTrue("credits hours must be between 1 and 4", true);
        }
    }

    
    @Test
    public void testShowAll() {
        CDBMngr.add("CMSC140", 11111, 1, "SC111","Alpha Bah");
        CDBMngr.add("CMSC202", 22222, 2, "SC222","Amadou");
        CDBMngr.add("CMSC203", 33333, 3, "SC333","Bah");
        CDBMngr.add("cmsc204", 44444, 4, "SC444","Sanoussy");//not added wrong ID
        CDBMngr.add("CMSC207", 77777, 7, "SC777", "Sow");//not added wrong Credits
        
        ArrayList<String> list = CDBMngr.showAll();

        assertEquals(list.size(),3);
        
        assertEquals(list.get(0),"\nCourse:CMSC140 CRN:11111 Credits:1 Instructor:Alpha Bah Room:SC111");
        assertEquals(list.get(1),"\nCourse:CMSC202 CRN:22222 Credits:2 Instructor:Amadou Room:SC222");
        assertEquals(list.get(2),"\nCourse:CMSC203 CRN:33333 Credits:3 Instructor:Bah Room:SC333");
    }

    
    @Test
    public void testRead() {
        try {
            File inputFile = new File("AlphaTest.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC140 11111 1 SC111 Alpha");
            inFile.print("CMSC204 44444 4 SC444 Amadou Bah");

            inFile.close();
            CDBMngr.readFile(inputFile);
            
        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}