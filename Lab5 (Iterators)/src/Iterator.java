/**
 * @author alpha bah
 */
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Iterator {

	public static ArrayList<Integer> RandomList=new ArrayList<Integer>();
	public static ListIterator<Integer> RandomList_iterator;
	
	public static void GenerateRandomList() {
		for(int i =0; i<20; i++) {
			int randomNum = (int) (Math.random() * (99 - 40)) + 40;
//			System.out.println(randomNum);
			RandomList.add(randomNum);
		}
//		System.out.println(RandomList);
		RandomList.listIterator();
//		return RandomList;
	}
	
	public static boolean Matching(int x, int y) {
		boolean status=false;
		String x_string=Integer.toString(x);
		String y_string=Integer.toString(y);
		
		for(int i=0; i<2; i++) {
			//for(int j=0; j<2; j++) {
				if(x_string.charAt(i)==y_string.charAt(i))
					status=true;
			//}
		}
		
		return status;
		
	}
	
	public static boolean removeMatching(ArrayList<Integer> RandomList) {
		boolean status=false;
		ListIterator RandomList_iterator=RandomList.listIterator();
		
		while(RandomList_iterator.hasNext()) {
			int x=Integer.parseInt(RandomList_iterator.next().toString());
			int y=Integer.parseInt(RandomList_iterator.next().toString());
				
			if (Matching(x,y )) {
					
				System.out.println("Removed: "+x+" "+y);
					
				RandomList_iterator.remove();
				RandomList_iterator.previous();
				RandomList_iterator.next();
				RandomList_iterator.remove();
				
				System.out.println("The new List: " +RandomList);
				
				status=true;
			}

		}
			
		return status;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateRandomList();
		//RandomList.add(10);RandomList.add(82);RandomList.add(43);RandomList.add(23);RandomList.add(89);RandomList.add(12);RandomList.add(43);RandomList.add(84);RandomList.add(23);RandomList.add(32);
		System.out.println("list: "+RandomList);
		
		while(removeMatching(RandomList)) {
			//System.out.println(RandomList);
			removeMatching(RandomList);
		}
		
	}

}
