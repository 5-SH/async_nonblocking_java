package asynchronizedtest.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlokcingQueue {
	public static void main(String[] args) {
		int BOUND = 10;
		int N_PRODUCERS = 4;
		
		int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
		System.out.println("BlokcingQueue.main() N_CONSUMERS : " + N_CONSUMERS);
		
		int poisonPill = Integer.MAX_VALUE;
		int poisonPillPerProducer = N_CONSUMERS / N_PRODUCERS;
		System.out.println("BlokcingQueue.main() poisonPillPerProducer : " + poisonPillPerProducer);
		
		int mod = N_CONSUMERS % N_PRODUCERS;
		System.out.println("BlokcingQueue.main() mod : " + mod);
		
		 
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(BOUND);
		 
		for (int i = 1; i < N_PRODUCERS; i++) {
		    new Thread(new Producer(queue, poisonPill, poisonPillPerProducer)).start();
		}
		 
		for (int j = 0; j < N_CONSUMERS; j++) {
		    new Thread(new Consumer(queue, poisonPill)).start();
		}
		 
		new Thread(new Producer(queue, poisonPill, poisonPillPerProducer + mod)).start();

	}
}
