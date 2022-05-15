import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

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
class Graph_STUDENT_Test {

	private GraphInterface<Town,Road> graph;
	private Town[] town;
	
	@BeforeEach
	void setUp() throws Exception {
		graph = new Graph();
		town = new Town[5];
		
		for (int i = 1; i < 5; i++) {
			town[i] = new Town(("Town_" + i));
			graph.addVertex(town[i]);
		}
		
		graph.addEdge(town[1], town[2], 1, "Road_1_2");
		graph.addEdge(town[1], town[3], 2, "Road_1_3");
		graph.addEdge(town[1], town[4], 10, "Road_1_4");
		graph.addEdge(town[2], town[4], 1, "Road_2_4");
		  
		  
	}

	@AfterEach
	void tearDown() throws Exception {
		graph=null;
	}

	@Test
	void testGetEdge() {
//		fail("Not yet implemented");
		assertEquals(new Road(town[1], town[2], 1, "Road_1_2"), graph.getEdge(town[1], town[2]));
		assertEquals(new Road(town[2], town[4],1, "Road_2_4"), graph.getEdge(town[2], town[4]));
	}

	@Test
	void testAddEdge() {
//		fail("Not yet implemented");
		assertEquals(false, graph.containsEdge(town[2], town[3]));
		graph.addEdge(town[2], town[3], 1, "Road_2_3");
		assertEquals(true, graph.containsEdge(town[2], town[3]));
	}

	@Test
	void testAddVertex() {
//		fail("Not yet implemented");
		Town test = new Town("Test");
		assertEquals(false, graph.containsVertex(test));
		graph.addVertex(test);
		assertEquals(true, graph.containsVertex(test));
	}

	@Test
	void testContainsEdge() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsEdge(town[2], town[4]));
		assertEquals(false, graph.containsEdge(town[3], town[4]));
	}

	@Test
	void testContainsVertex() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsVertex(new Town("Town_1")));
		assertEquals(false, graph.containsVertex(new Town("Test")));
	}

	@Test
	void testEdgeSet() {
//		fail("Not yet implemented");
		Set<Road> roads = graph.edgeSet();
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1_2", roadArrayList.get(0));
		assertEquals("Road_1_3", roadArrayList.get(1));
		assertEquals("Road_1_4", roadArrayList.get(2));
		assertEquals("Road_2_4", roadArrayList.get(3));
	}

	@Test
	void testEdgesOf() {
//		fail("Not yet implemented");
		Set<Road> roads = graph.edgesOf(town[1]);
		ArrayList<String> roadArrayList = new ArrayList<String>();
		for(Road road : roads)
			roadArrayList.add(road.getName());
		Collections.sort(roadArrayList);
		assertEquals("Road_1_2", roadArrayList.get(0));
		assertEquals("Road_1_3", roadArrayList.get(1));
		assertEquals("Road_1_4", roadArrayList.get(2));
	}

	@Test
	void testRemoveEdge() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsEdge(town[2], town[4]));
		graph.removeEdge(town[2], town[4], 1, "Road_2_4");
		assertEquals(false, graph.containsEdge(town[2], town[4]));
	}

	@Test
	void testRemoveVertex() {
//		fail("Not yet implemented");
		assertEquals(true, graph.containsVertex(town[2]));
		graph.removeVertex(town[2]);
		assertEquals(false, graph.containsVertex(town[2]));
	}

	@Test
	void testVertexSet() {
//		fail("Not yet implemented");
		Set<Town> roads = graph.vertexSet();
		assertEquals(true,roads.contains(town[1]));
		assertEquals(true, roads.contains(town[2]));
		assertEquals(true, roads.contains(town[3]));
		assertEquals(true, roads.contains(town[4]));
	}
	

}
