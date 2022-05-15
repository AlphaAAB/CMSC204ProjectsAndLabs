/**
 * 
 * @author alpha
 *
 */
public class CourseDBElement {

	String courseID, roomNum, instructorName;
	int crn, NumOfCredits;
	
	/**
	 * No-arg constructor
	 */
	public CourseDBElement() {
		courseID=null;
		roomNum=null;
		instructorName=null;
		crn=0;
		NumOfCredits=0;
	}
	
	/**
	 * 
	 * @param courseID
	 * @param crn
	 * @param NumOfCredits
	 * @param roomNum
	 * @param instructorName
	 */
	public CourseDBElement(String courseID, int crn, int NumOfCredits, String roomNum, String instructorName) {
		this.courseID=courseID;
		this.crn=crn;
		this.NumOfCredits=NumOfCredits;
		this.roomNum=roomNum;
		this.instructorName=instructorName;
	}
	
	 //CourseID 
    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    //number of credits field
    public int getNumOfCredits() {
        return NumOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.NumOfCredits = numOfCredits;
    }


    //roomNum
    public String getRoomNumber() {
        return roomNum;
    }

    public void setRoomNumber(String roomNum) {
        this.roomNum = roomNum;
    }

    //instructor name 
    public String getInstructorName(){
        return this.instructorName;
    }

    public void setInstructorName(String instructorName){
        this.instructorName=instructorName;
    }

	public void setCRN(int crn) {
		this.crn=crn;
	}
	public int getCRN() {
		// TODO Auto-generated method stub
		return crn;
	}
	
	/**
	 * convert an string of the CRN into a hashcode
	 * @return hashCode
	 */
	public int hashCode() {
		String code= Integer.toString(crn);
		return code.hashCode();
	}
	
	/**
	 * CompareTo: to compare 2elements of CDE
	 * @param item
	 * @return
	 */
	public int compareTo(CourseDBElement item) {
		return this.compareTo(item);
	}
	
	public String toString() {
		return "\nCourse:"+courseID+" CRN:"+crn+" Credits:"+NumOfCredits+" Instructor:"+instructorName+ " Room:" +roomNum;
	}
}
