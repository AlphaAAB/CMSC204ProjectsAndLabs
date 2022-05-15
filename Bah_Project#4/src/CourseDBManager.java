import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author alpha
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure database= new CourseDBStructure(100);
	
	/**
     * to add an element into the CDS
     * @param id
     * @param crn
     * @param credits
     * @param roomNum
     * @param instructor
     */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		// TODO Auto-generated method stub
		try {
			if(id.length()<4)
				throw new InvalidException("Invalid format of ID's length");
			
			if(id.substring(0, 4).equals("CMSC") && credits<=4 && credits>=1 && crn!=0 && instructor!=null) {
				CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
				database.add(element);
			}
			else {
				if(!id.substring(0, 4).equals("CMSC")) {
					throw new InvalidException("ID must start with CMSC") ;
				}
				if(!(credits<=4 && credits>=1))
					throw new InvalidException("credits hours must be between 1 and 4") ;
			}
		}catch(InvalidException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * Get an entry using CourseDBStructure's get method.
	 * @param crn
     * @return the element at with the specified crn
	 */
	@Override
	public CourseDBElement get(int crn) {
		// TODO Auto-generated method stub
		try {
			return database.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	
	/**
     * a method to read the information of a file
     * @param input
     * @throws FileNotFoundException
     */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(input);
		try {
			FileWriter write = new FileWriter("Invalid_Passwords.txt");
			
			while(in.hasNext()) {
				//try {
					String id, Room;
					String instructor=null;
					int crn, credits;
					
					String line=in.nextLine();
					
					if(line.charAt(0)=='#') {
						continue;
					}
					//System.out.println(line);
					String arrayLine[]=line.split(" +");
					
					
					
					String temp[] = new String[5];
					
					for (int i =0; i<=3; i++) {
						temp[i]=arrayLine[i];
					}
					
					String str="";
					for(int i=4; i<arrayLine.length; i++) {
						str+= arrayLine[i]+" ";
					}
					temp[4]=str;
					
//					for(int i=0; i<temp.length; i++) {
//						System.out.print(temp[i]+ "+ ");
//						
//					}
//					System.out.println();
					
					if(temp[0].substring(0, 4).equals("CMSC")) {
						id=temp[0];
					}
					else if(temp[0].length()!=7) {
						write.write(line +"\n");
						continue;
					}
					else {
						write.write(line+"\n");
						continue;
						
					}
					
					if(Integer.parseInt(arrayLine[2])>=1 && Integer.parseInt(arrayLine[2])<=4) {
						credits=Integer.parseInt(arrayLine[2]);
					}
					else {
						write.write(line+"\n");
						continue;
					}
					
					crn=Integer.parseInt(temp[1]);
					
					Room=temp[3];
					
					instructor=temp[4];
					
					CourseDBElement element = new CourseDBElement(id, crn, credits, Room, instructor);
					
					database.add(element);
				
			}
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
     * shows all the element
     * @return elements
     */
	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		ArrayList<String> elements = new ArrayList<String>();
		for (LinkedList<CourseDBElement> list : database.hashTable) {
			if(list != null) {
				for (int i = 0; i < list.size(); i++) {
					String course = list.get(i).toString();
					elements.add(course);
				}
			}
		}
		return elements;
	}

}
