package synchronizedtest;

class Counter {
	int i = 0;

	public synchronized void add(int val, String name) {
		this.i += val;
		System.out.println(name + " CounterThread.run() counter : " + this.i);
	}
	
	public int getCounter() {
		return this.i;
	}
}

class CounterThread extends Thread {
	
	private Counter counter;
	
	public CounterThread(Counter counter) {
		this.counter = counter;
	}
	
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.counter.add(i, this.getName());
		}
	}
}

public class SynchronizedTest {
	public static void main(String[] args) {
		Counter c = new Counter();
		CounterThread ct1 = new CounterThread(c);
		CounterThread ct2 = new CounterThread(c);
		CounterThread ct3 = new CounterThread(c);
		CounterThread ct4 = new CounterThread(c);
		CounterThread ct5 = new CounterThread(c);
		
		ct1.start();
		ct2.start();
		ct3.start();
		ct4.start();
		ct5.start();
	}
}
