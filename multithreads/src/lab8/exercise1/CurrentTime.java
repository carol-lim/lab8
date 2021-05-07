package lab8.exercise1;

import java.util.Date;

public class CurrentTime extends Thread{
	public void displayCurrentTime(String currentThreadName) {
		
		String currentDate = new Date().toString();
		for (int counter = 0; counter < 5; counter++) {

			System.out.println(currentThreadName+" -> #"+counter+" "+ currentDate);
		}
	}
	
	@Override
	public void run() {

		Thread currentThread = Thread.currentThread(); 
		displayCurrentTime(currentThread.getName());

	}
}
