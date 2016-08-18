import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Palindrome {
	public static void main(String[] args) throws IOException{
		String sentence = null;
		do{
			try{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			    System.out.println("Enter Sentence to check for palindrome");
			    sentence = br.readLine();
			    String regex = "^[\\p{L} .'-]+$"; // to make user input proper sentence (can input spaces too). can be changed to accept special characters 
                if(!sentence.matches(regex))
                	throw new Exception();
                }
			catch(Exception e){
				System.out.println("Please do not enter Special characters or numbers");
				sentence = "";
			}
			sentence =  sentence.replaceAll("\\s+","");
		}while(sentence.isEmpty());
		    StringBuilder sb = new StringBuilder();
		    sb.append("!");
		    for (char ch: sentence.toCharArray())
		    	sb.append("#"+ch);
		    sb.append("#@");
		    checkPalindrome(sb.toString().toCharArray(),sentence); // pass the string removing spaces
	
	}

	private static void checkPalindrome(char[] ds, String s) {
		int[] p= new int[ds.length];
		int c=0,r=0;
		for(int i=1;i<ds.length-1;i++){
			int mirror = 2*c - i;
			if(i<r)
				p[i] = Math.min(r-i,p[mirror]);
			while(ds[i+(1+p[i])] == ds[i-(1+p[i])])
				p[i]++;
			if((i+p[i])>r){
				c=i; // changing the center of required palindrome
				r=i+p[i]; // shift the right boundary
			}
		}
		int max = Arrays.stream(p).max().getAsInt();
		 /*if the given sentence have more than 1 longest palindromes (single characters can also be palindromes)
		   map can also be used to store multiple palindromes of different lengths*/
		Map<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 
		for (int i = 0; i < p.length; i++){
		   if(p[i] == max)
		   hmap.put(i,max);
		} 
		// print the longest palindrome(s)
		  Iterator it = hmap.entrySet().iterator();
		  c=r=0;
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        c = (Integer.parseInt(pair.getKey().toString())/2)-1;
		        r = (Integer.parseInt(pair.getValue().toString())-1)/2;
		        System.out.println("The Longest palindrome is "+ s.substring(c-r,c+r+1));
		        it.remove(); 
		    }
		}
}
