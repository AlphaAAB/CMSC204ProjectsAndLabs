import java.util.Arrays;
/**
 * 
 * @author alpha
 *
 */
public class Lab9{
	public static void main(String[] args) {
		int array[]= {5, 22, 9, 76, 63, 81, 48, 92, 54, 28};
		
		heapSort(array);
		
		System.out.println(Arrays.toString(array));
	}
	
	public static void heapify(int[] array, int length, int i) {
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;
	    int largest = i;
	    if (left < length && array[left] > array[largest]) {
	        largest = left;
	    }
	    if (right < length && array[right] > array[largest]) {
	        largest = right;
	    }
	    if (largest != i) {
	        int tmp = array[i];
	        array[i] = array[largest];
	        array[largest] = tmp;
	        heapify(array, length, largest);
	    }
	}

	public static void heapSort(int[] array) {
	    if (array.length == 0) {
	        return;
	    }
	    
	    int length = array.length;
	    
	    // Moving from the first element that isn't a leaf towards the root
	    for (int i = length / 2 - 1; i >= 0; i--) {
	        heapify(array, length, i);
	    }
	    
	    for (int i = length - 1; i >= 0; i--) {
	        int tmp = array[0];
	        array[0] = array[i];
	        array[i] = tmp;
	        heapify(array, i, 0);
	    }
	}
}
