import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author alpha
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{

	public LinkedList<CourseDBElement>[] hashTable;
	int size; 

	 /**
     * a constructor that initialize the field
     */
	public CourseDBStructure(int size) {
		// TODO Auto-generated constructor stub
		this.size=size;
		hashTable= new LinkedList[size];
	}

	//Testing
	public CourseDBStructure(String Testing, int size) {
		// TODO Auto-generated constructor stub
		this.size=size;
		hashTable=new LinkedList[size];
	}

	/** 
	* Use the hashcode of the CourseDatabaseElement to see if it is 
	* in the hashtable.
	* 
	* If the CourseDatabaseElement does not exist in the hashtable,
	* add it to the hashtable.
	* 
	* @param element the CDE to be added
	*/
	@Override
	public void add(CourseDBElement element) {
		// TODO Auto-generated method stub
		int pos = element.hashCode()%hashTable.length;
		if(hashTable[pos]==null) {
			LinkedList<CourseDBElement> input = new LinkedList<CourseDBElement>();
			input.add(element);
			hashTable[pos]=input;
		}
//		else {
//			hashTable[pos].add(element);
//		}
		
	}

	/** 
	*  
	* If the CourseDatabaseElement is in the hashtable, return it
	* If not, throw an IOException
	* 
	* @param crn of the element (to be returned)
	* @throws IOException 
	*/
	@Override
	public CourseDBElement get(int crn) throws IOException {
		// TODO Auto-generated method stub
		String code = Integer.toString(crn);
		int index = code.hashCode()%hashTable.length;
//		if (hashTable[index]==null) {
//			throw new IOException();
//		}else {
//			for (int i = 0; i < hashTable[index].size(); i++) {
//				if (hashTable[index].get(i).getCRN()==crn) {
//					return hashTable[index].get(i);
//				}
//			}
//			throw new IOException();
//		}
		
		for(int i=0; i<hashTable[index].size(); i++) {
			if(hashTable[index].get(i).getCRN()==crn) {
				return hashTable[index].get(i);
			}
			else
				throw new IOException();
		}
		return null;
	}

	 /**
     * Returns the size of the CDS
     */
	@Override
	public int getTableSize() {
		// TODO Auto-generated method stub
		return hashTable.length;
	}

}
