package threads;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab test 2
 * Package: threads
 * Class: TesterMainThreads
 * Description: Tester for RandomSumThreads.class
 * Created On:20 August 2021
 * @author Ananya Srivastava
 */
//tester class
public class TesterMainThreads {
	//tester method
		public static void main(String[] args) {
			RandomSumThread randomSumThread = new RandomSumThread(0);
			Thread thread1 = new Thread(randomSumThread);
			Thread thread2 = new Thread(randomSumThread);
			Thread thread3 = new Thread(randomSumThread);
			Thread thread4 = new Thread(randomSumThread);
			Thread thread5 = new Thread(randomSumThread);
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			thread5.start();
			
			try {
		        thread1.join();
		        thread2.join();
		        thread3.join();
		        thread4.join();
		        thread5.join();
		    } catch (InterruptedException e) {
		    	System.out.println("Interruption Occured");
		        e.printStackTrace();
		    }
			System.out.println("Total Sum: " + randomSumThread.getSum());
		}//end-of-main
}//end-of-class
