/**
 * 
 * @author alpha bah
 *
 * The class Road that can represent the edges of a Graph
 */
public class Road extends Object implements Comparable<Road>{
	// Instance Vars
	private String roadName;
	private Town source;
	private Town destination;
	int distance;

	/**
	 * Constructor
	 * 
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param degrees - Weight of the edge, i.e., distance from one town to the other
	 * @param roadName - name of the road
	 */
	public Road(Town source, Town destination, int degrees, String roadName) {
		this.roadName = roadName;
		this.source = source;
		this.destination = destination;
		this.distance = degrees;
	}

	/**
	 * Constructor with weight preset at 1
	 * 
	 * @param source - One town on the road
	 * @param destination - Another town on the road
	 * @param name - name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.roadName = name;
		this.source = source;
		this.destination = destination;
		distance = 1;
	}

	/**
	 * This methods checks if a Road contain a town
	 * 
	 * @param town name of the given town
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town) {

		if(town==null)
			return false;
		
		if (getSource().getName().equals(town.getName()) || getDestination().getName().equals(town.getName()))
			return true;
		
		return false;
	}
	
	@Override
	public String toString() {
		return source.getName() + " via " + roadName + " to " + destination.getName() + " " + distance + " mi";
	}

	//getters
	public String getName() {
		return roadName;
	}
	
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * Specified by: compareTo in interface java.lang.Comparable<Road>
	 */
	@Override
	public int compareTo(Road otherRoad) {
		return (this.getName().compareTo(otherRoad.getName()));
	}
	
	//distance of the road
	public int getWeight() {
		return distance;
	}

	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road. 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Road other = (Road) obj;
		if (other.getSource().equals(getSource()) && other.getDestination().equals(getDestination()))
			return true;
		if (other.getDestination().equals(getSource()) && other.getSource().equals(getDestination()))
			return true;

		return false;
	}

	//first town on the road
	public Town getSource() {
		return source;
	}

}