
public class Customer {
	int transactionTime;
	int arrivalTime, customerNumber;
	
	public Customer() {
		arrivalTime=0;
		transactionTime=0;
		customerNumber=0;
	}
	
	public Customer(int clock, int transactionTime, int NumOfArrivals) {
		arrivalTime=clock;
		this.transactionTime=transactionTime;
		customerNumber=NumOfArrivals;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public int getTransactionTime() {
		return transactionTime;
	}
	public int getCustomerNumber() {
		return customerNumber;
	}
}
