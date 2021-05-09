package lab8.exercise2;

import java.util.*;

public class TextPrinter implements Runnable{
	String[] textArr = {"It", "is", "recommended", "to", "use", "Calendar", "class."};
	
	
	/**
	 * extract portions of text in 10 repetition. 
	 * The extraction increases in every repetition
	 * @param threadName
	 */
	public void extractText(String threadName){
		// loop the line
		for(int counter1 = 0; counter1 < 10; counter1++){
			String text = "";
			
			// loop the text
			for(int counter2 = 0; counter2 < counter1; counter2++){
				int size = textArr.length;
				
			    // if the array haven't ended, continue the text 
				if(counter2 < size){
					text = text + textArr[counter2] + " ";
				}
				
				// if the array reaches the end, back to the first text 
				else{
					text = text + textArr[counter2-size] + " ";
			    }
			}
			// print the line
			System.out.println(threadName + ": " + text);
		}
		
	}
	
	/**
	 * To randomize the array order using arraylist
	 */
	public void randomText() {
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
		System.out.println(printList);
		
	}

	@Override
	public void run() {
		// Get the current thread
		Thread currentThread = Thread.currentThread();
				
		// Execute the tasks
		if(currentThread.getName()=="text") {
			extractText(currentThread.getName());
		} 
		
		else if(currentThread.getName()=="word1" || currentThread.getName()=="word2"){
			randomText();
		} 
		
		else{
			System.out.println("No such task.");
		}
		
	}
}
