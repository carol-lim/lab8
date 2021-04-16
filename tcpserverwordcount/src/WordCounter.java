
public class WordCounter {
	
	/**
	 * A method to count words by checking the space between characters
	 * 
	 * @param words
	 * @return stringWordCount
	 */
	
	public String getWordCount(String words) {
		int wordCount = 0;
	      
		char charArr[]= new char[words.length()]; 
		
		for(int i=0; i<words.length(); i++){  
			
			charArr[i]= words.charAt(i);  
		    
			if(((i>0)&&(charArr[i]!=' ')&&(charArr[i-1]==' ')) || ((charArr[0]!=' ')&&(i==0)) )  
		    	wordCount++;  
		}  
		
		String stringWordCount = Integer.toString(wordCount);

		return stringWordCount;
		
	}
}
