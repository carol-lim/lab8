package lab8.exercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TextSuspendPrinter implements Runnable {
	String[] textArr = {"It", "is", "recommended", "to", "use", "Calendar", "class."};
	
	/**
	 * To randomize the array order using arraylist
	 */
	public void randomText(String threadName) {
		
		if(threadName=="word1"){
			try {
				Thread.sleep(5000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("["+threadName+" suspended 5 secs]");
		} 
		
		// Create a new list
		List<String> randomTextList = new ArrayList<>();
		
			// insert text from arr to list
			for (int i = 1; i <= 6; i++) {
				randomTextList.add(textArr[i]);
			}
			
			// Randomly permutes the list using a default source of randomness
			Collections.shuffle(randomTextList);
			
			// remove the special characters created by shuffle()
			String printList = Arrays.toString(randomTextList.toArray()).replace("[", "").replace("]", "").replace(",", " ");
			
			// print the random ordered list
			System.out.println(threadName+": "+printList);
			

	}
	
	@Override
	public void run() {
		// Get the current thread
		Thread currentThread = Thread.currentThread();
		randomText(currentThread.getName());
	}
}
