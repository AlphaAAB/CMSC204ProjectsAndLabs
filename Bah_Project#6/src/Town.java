import java.util.ArrayList;
/**
 * 
 * @author alpha bah
 * 
 * Represents an town as a node of a graph
 */
public class Town extends Object implements Comparable<Town>{
	// Instance Vars
	private String nameOfTown;
	private ArrayList<Town> adjacentTowns;
	
	
	/**
	 * Constructor
	 * @param name - name of the town
	 */
	public Town(String name) {
		this.nameOfTown = name;
	}
	
	/**
	 * Constructor
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown) {
		nameOfTown = templateTown.getName();
	}
	
	//town's name
	public String getName() {
		return nameOfTown;
	}
	
	//Specified by: compareTo in interface java.lang.Comparable<Town>
	public int compareTo(Town townToBeCompareTo) {
		return nameOfTown.compareTo(townToBeCompareTo.getName());
	}

	@Override
	public String toString() {
		return getName();
	}
	
	//the hashcode for the name of the town
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
	

	/**
	 * 
	 * @param obj
	 * @return true if the town names are equal, false if not
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) //doesn't take null
			return false;
		
		Town other = (Town) obj;
		return (getName().equals(other.getName()));
	}
	
}