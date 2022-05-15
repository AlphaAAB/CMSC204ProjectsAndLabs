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
public class Road_STUDENT_Test {
    private Road road_1_2;
    private Road road_2_3;
    private Road road_2_1;
    
    private Town town1;
    private Town town2;
    private Town town3;
    private int distance;

    private String name1;
    private String name2;

    @Before
    public void setup(){

        town1= new Town("Alpha");
        town2= new Town("Amadou");
        town3= new Town("Bah");

        name1="Al_Am";
        name2= "Am_Ba";
        distance =1;

        road_1_2= new Road(town1, town2, distance, name1);
        road_2_3= new Road(town2,town3, 2, "Am_Ba");
        road_2_1= new Road(town2,town1, name1);
    }

    @After
    public void tearDown(){

        road_1_2=null;
        road_2_3=null;
        road_2_1=null;
    }

    @Test
    public void TestContains(){
    	assertEquals(true, road_1_2.contains(town1));
    	assertEquals(true, road_1_2.contains(town2));
        assertEquals(true, road_2_3.contains(town2));
        assertEquals(true, road_2_3.contains(town3));
        assertEquals(true, road_2_1.contains(town2));
        assertEquals(true, road_2_1.contains(town1));
        
        assertEquals(false, road_2_3.contains(town1));
        assertEquals(false, road_2_1.contains(town3));
        assertEquals(false, road_1_2.contains(town3));
    }
    
    @Test
    public void compareTo(){

        assertEquals(0, road_1_2.compareTo(road_2_1));
        assertNotEquals(0,road_2_3.compareTo(road_2_1));
    }

    @Test
    public void equals(){
        assertEquals(true, road_1_2.equals(road_2_1));
        assertEquals(false, road_1_2.equals(road_2_3));
        assertEquals(false, road_2_3.equals(road_2_1));
    }
}
