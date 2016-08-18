import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Repeat {

	public static void main(String[] args) throws IOException{
		String sentence = null;
		do{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    System.out.println("Enter Sentence");
		    sentence = br.readLine();
		    sentence =  sentence.replaceAll("\\s+","");
		}while(sentence.isEmpty());
		     System.out.println("The sentecnce entered is "+sentence);
	 	     Map<Character, Integer> charMap = new HashMap<Character, Integer>();
	  	     char[] arr = sentence.toCharArray();
    	     for (char value: arr) {
	  	         if (Character.isAlphabetic(value)) {  // check for characters only leaving numbers or special characters
	  	            if (charMap.containsKey(value)) {
	  	                charMap.put(value, charMap.get(value) + 1);
	  	            } else {
	  	                charMap.put(value, 1); // single occurrence
	  	            }
	  	          }
	  	       }
	  	    // System.out.println(charMap); to find occurrence of all characters 
	  	    Iterator it = charMap.entrySet().iterator();
	  	    while (it.hasNext()) {
	  	        Map.Entry pair = (Map.Entry)it.next();
	  	        if(Integer.parseInt(pair.getValue().toString()) >= 2){
	  	        	System.out.println(pair.getKey() + " -> " + pair.getValue());
	  	        }
	  	       it.remove(); // avoids Exception
	  	    }
	   }
}
