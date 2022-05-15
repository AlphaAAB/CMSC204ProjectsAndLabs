import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
/**
 * 
 * @author alpha bah
 * 
 * Class to represent a graph of towns and their connections
 *
 */
public class Graph implements GraphInterface<Town, Road>{
	// Instance Vars
	private Set<Town> towns;
	private Set<Road> roads;
	private Map<Town, Road> shortestMap;
	
	/**
	 * Default Constructor
	 */
	public Graph()
	{
		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
	}
	/**
	 * Returns an edge connecting the source vertex to the target vertex
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		
		if (containsVertex(sourceVertex) == false || containsVertex(destinationVertex) == false )
			throw new IllegalArgumentException("One or both vertices are not in the graph.");
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException("One or both vertices are null.");
		
		
		for (Road road : roads)
		{
			if (road.contains(sourceVertex) && road.contains(destinationVertex))
				return new Road(sourceVertex, destinationVertex, road.getWeight(), road.getName());
		}
		return null;
	}
	/**
	 * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge.
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException("One or both vertices is null");
		
		if (!towns.contains(sourceVertex) || !towns.contains(destinationVertex))
			throw new IllegalArgumentException("One or both vertices are not found");
		
		Road newEdge = new Road(sourceVertex, destinationVertex, weight, description);
		if (containsEdge(sourceVertex, destinationVertex))
			return null;
		
		roads.add(newEdge);
		return newEdge;
	}
	
	/**
	 * Adds the specified vertex to this graph if not already present
	 */
	@Override
	public boolean addVertex(Town v) {
		//check if specified vertex is not already in the graph before adding
		if(!towns.contains(v)) {
			towns.add(v);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex.
	 */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road road : roads)
		{
			if (road.contains(sourceVertex) && road.contains(destinationVertex))	
			return true;
		}
		return false;
	}
	/**
	 * Returns true if this graph contains the specified vertex
	 */
	@Override
	public boolean containsVertex(Town v) {
		for (Town town : towns)
		{
			if (town.equals(v)) 
				return true;
		}
		return false;
	}
	
	/**
	 * Return edges 
	 */
	@Override
	public Set<Road> edgeSet() {
		return roads;
	}
	
	/**
	 * Return all edges containing given vertex
	 */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		if (vertex == null)
			throw new NullPointerException("vertex is null");
		if (!towns.contains(vertex))
			throw new IllegalArgumentException("vertex not found");
		
		Set<Road> adjacent = new HashSet<Road>();
		for (Road road : roads)
		{
			if (road.contains(vertex))
			{
				adjacent.add(road);
			}
		}
		return adjacent;
	}
	/**
	 * Removes edge from graph
	 */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		boolean valid;
		Road temp = new Road(sourceVertex, destinationVertex, weight, description);
		for (Road road : roads)
		{
			if (road.equals(temp))
			{
				valid = true;
				//Check weight
				if (weight > -1 && road.getWeight() != weight)
					valid = false;
				//Check description
				if (description != null && !road.getName().equals(description))
					valid = false;
				
				if (valid)
				{
					roads.remove(road);
					return road;
				}
			}
		}
		return null;
	}
	/**
	 * Removes vertex from graph, and all edges connected to it
	 */
	@Override
	public boolean removeVertex(Town v) {
		if (v == null)
			return false;
		return towns.remove(v);
	}
	/**
	 * Returns towns as set
	 */
	@Override
	public Set<Town> vertexSet() {
		return towns;
	}
	/**
	 * Uses dijkstraShortestPath(), formats and returns the results
	 */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> shortestArr = new ArrayList<String>();
		Town current = destinationVertex;
		Road data;
		while (!current.equals(sourceVertex))
		{
			data = shortestMap.get(current);
			shortestArr.add(0, data.getSource() + " via " + data.getName() + " to " + current + " " + data.getWeight() + " mi");
			current = data.getSource();
		}
		return shortestArr;
	}
	/**
	 * Uses Dijkstra's shortest path algorithm to calculate all shortest paths from a town
	 */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		shortestMap = new HashMap<Town, Road>();
		for (Town t : towns)
		{
			shortestMap.put(t, new Road(sourceVertex, t, Integer.MAX_VALUE, "placeholder"));
		}
	
		Queue<Town> queue = new LinkedList<Town>();
		Set<Town> searched = new HashSet<Town>();
	
		shortestMap.put(sourceVertex, new Road(sourceVertex, sourceVertex, 0, "reflexive"));
		queue.add(sourceVertex);
		searched.add(sourceVertex);
		
		while (queue.size() > 0)
		{
			Town current = queue.remove();
			
			for (Road r : roads)
			{
				if (r.contains(current))
				{
					Town source = current;
					Town destination;
					if (r.getSource().equals(current))
					{
						destination = r.getDestination();
					}
					else 
					{
						destination = r.getSource();
					}
					
					if (!searched.contains(destination))
					{
						queue.add(destination);
						searched.add(destination);
					}
					int upto = r.getWeight();
					Town temp = source;
					while (!temp.equals(sourceVertex))
					{
						upto += shortestMap.get(temp).getWeight();
						temp = shortestMap.get(temp).getSource();
					}
					int prev = 0;
					temp = destination;
					while (!temp.equals(sourceVertex))
					{
						prev += shortestMap.get(temp).getWeight();
						temp = shortestMap.get(temp).getSource();
					}
					if (upto < prev)
					{
						shortestMap.put(destination, new Road(source, destination, r.getWeight(), r.getName() ));
					}
				}
			}
		}
	}
}