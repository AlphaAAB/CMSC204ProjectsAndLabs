import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {

	Queue<Integer> queue = new ArrayDeque<Integer>();

	Random ramdonNum = new Random();
	
	public CarQueue(){
		
		for(int i = 0; i<5;i++){
			queue.add(ramdonNum.nextInt(4));
		}
	}
	
	public int deleteQueue() {
		// TODO Auto-generated method stub
//		return 0;
		if(queue.isEmpty()){
			return 0;
		}

		else return queue.remove();
	}

	public void addToQueue() {
		// TODO Auto-generated method stub
		class myRunnable implements Runnable{
			
			@Override
			public void run() {

				try{
					queue.add(ramdonNum.nextInt(4));
					queue.add(ramdonNum.nextInt(4));
					queue.add(ramdonNum.nextInt(4));
					queue.add(ramdonNum.nextInt(4));
					queue.add(ramdonNum.nextInt(4));

					Thread.sleep(100);
				}catch (InterruptedException exception){

				}

			}

		}

		Runnable run = new myRunnable();
		Thread myThread = new Thread(run);
		myThread.start();
	}

}
