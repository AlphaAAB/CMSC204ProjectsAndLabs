import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/**
 * 
 * @author alpha bah
 *
 */
public class Town_STUDENT_Test {

    Town town;
    Town town1;
    Town town2;
    String name="Alpha";

    @Before
    public void set(){
        town= new Town(name);
        town1= new Town("Amadou");
        town2= new Town(town);
    }

    @After
    public void tearDown(){
        town=null;
        town1=null;
    }

    @Test
    public void TestCompareTo(){
        assertEquals(0, town.compareTo(town2));
        assertNotEquals(0, town.compareTo(town1));

    }

    @Test
    public void TestEquals(){
        assertEquals(true, town.equals(town2));
        assertEquals(false, town1.equals(town2));
    }


}
