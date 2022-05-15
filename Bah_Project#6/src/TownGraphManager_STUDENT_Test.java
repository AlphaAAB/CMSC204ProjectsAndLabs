import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author alpha bah
 *
 */
class TownGraphManager_STUDENT_Test {

	private TownGraphManagerInterface graph;
	private String[] town;
	
	@BeforeEach
	void setUp() throws Exception {
		graph = new TownGraphManager();
		town = new String [5];
		
		for (int i = 1; i < 5; i++) {
			town[i] = ("Town_" + i);
			graph.addTown(town[i]);
		}
		
		graph.addRoad(town[1], town[2], 1, "Road_1_2");
		graph.addRoad(town[1], town[3], 2, "Road_1_3");
		graph.addRoad(town[1], town[4], 10, "Road_1_4");
		graph.addRoad(town[2], town[4], 1, "Road_2_4");
	}

	@AfterEach
	void tearDown() throws Exception {
		graph=null;
	}

	@Test
	void testAddRoad() {
//		fail("Not yet implemented");
		ArrayList<String> roads = graph.allRoads();
		assertEquals(4, roads.size());
		assertEquals("Road_1_2", roads.get(0));
		assertEquals("Road_1_3", roads.get(1));
		assertEquals("Road_1_4", roads.get(2));
		assertEquals("Road_2_4", roads.get(3));
		graph.addRoad(town[3], town[4], 1, "Road_3_4");
		roads = graph.allRoads();
		assertEquals(5, roads.size());
		assertEquals("Road_3_4", roads.get(4));
	}

	@Test
	void testGetRoad() {
//		fail("Not yet implemented");
		assertEquals("Road_1_4", graph.getRoad(town[1], town[4]));
		assertEquals("Road_2_4", graph.getRoad(town[2], town[4]));
	}

	@Test
	void testAddTown() {
//		fail("Not yet implemented");
		assertEquals(false, graph.containsTown("Test"));
		graph.addTown("Test");
		assertEquals(true, graph.containsTown("Test"));
	}

	@Test
	void testContainsTown() {
//		fail("Not yet implemented");
		assertEquals(false, graph.containsTown("Test"));
		assertEquals(true, graph.containsTown(town[1]));
		
	}

	@Test
	void testContainsRoadConnection() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsRoadConnection(town[2], town[4]));
		assertEquals(false, graph.containsRoadConnection(town[3], town[4]));
	}

	@Test
	void testAllRoads() {
//		fail("Not yet implemented");
		ArrayList<String> roads = graph.allRoads();
		assertEquals("Road_1_2", roads.get(0));
		assertEquals("Road_1_3", roads.get(1));
		assertEquals("Road_1_4", roads.get(2));
	}

	@Test
	void testDeleteRoadConnection() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsRoadConnection(town[2], town[4]));
		graph.deleteRoadConnection(town[2], town[4], "Road_2_4");
		assertEquals(false, graph.containsRoadConnection(town[2], town[4]));
	}

	@Test
	void testDeleteTown() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsTown(town[2]));
		graph.deleteTown(town[2]);
		assertEquals(false, graph.containsTown(town[2]));
	}

	@Test
	void testAllTowns() {
//		fail("Not yet implemented");
		ArrayList<String> roads = graph.allTowns();
		assertEquals(4, roads.size());
		assertEquals("Town_1", roads.get(0));
		assertEquals("Town_2", roads.get(1));
		assertEquals("Town_3", roads.get(2));
	}

	@Test
	void testGetPath() {
//		fail("Not yet implemented");
		ArrayList<String> path = graph.getPath(town[1],town[4]);
	    assertNotNull(path);
	    assertTrue(path.size() == 2);
	    assertEquals("Town_1 via Road_1_2 to Town_2 1 mi",path.get(0).trim());
	    assertEquals("Town_2 via Road_2_4 to Town_4 1 mi",path.get(1).trim());
	}

}
