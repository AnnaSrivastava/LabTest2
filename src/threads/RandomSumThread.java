package threads;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab test 2
 * Package: threads
 * Class: RandomSumThread
 * Description: Implement threads using Runnable and generate the random numbers and print the sum afterwards using main thread
 * Created On:20 August 2021
 * @author Ananya Srivastava
 */
import java.util.Random;

//class to implement Runnable and generate random numbers
class RandomSumThread implements Runnable {
	private int sum;
	
	//constructor
	RandomSumThread(int sum) {
		this.sum = sum;	
	}
	
	//overriding run method
	@Override
	public void run() {
		this.addRandomVal();
		
	}
	
	//getter for sum
	public int getSum() {
		return sum;
	}

	//setter for sum
	public void setSum(int sum) {
		this.sum = sum;
	}

	//method to generate random number and add to sum
	private void addRandomVal() {
		Random random = new Random();
		int num = random.nextInt(10) + 1;
		System.out.println("Number generated: " + num);
			this.sum += num;
	}
}
