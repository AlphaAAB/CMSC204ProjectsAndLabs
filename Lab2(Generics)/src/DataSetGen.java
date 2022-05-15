import java.text.DecimalFormat;

public class DataSetGen<T extends Measurable>{
	
	private double sum;

	private T maximum;

	private int count;

	
	public DataSetGen() {
		sum = 0;
		count = 0;
		maximum = null;
	}

	public void add(T x) {
		sum = sum + x.getMeasure();

		if (count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum = x;
		count++;
	}

	public double getAverage() {
		
		double val=sum/count;
		if (count == 0) return 0;

		else return val;
	}

	public T getMaximum() {
	  
		return maximum;
	}
	
}