import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintNumber {

	public static void main(String[] args) throws IOException{
		int number =0;
		 String input = null;
		do{
			  try {
			      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			     System.out.println("Please enter a number ");
			      input = br.readLine();
			      number = Integer.parseInt(input);
			    } catch (NumberFormatException ex) {
			       System.out.println("Not a number ! Please check");
			    } 
		}while(number == 0);
		    System.out.println("The number entered is "+number);
		/*//   method 1 : Not required for now // for inputs less than 20
		    long s=0,i;
		    for (i = 1; i <= number; ++i)                        
		    {
		     s = s * 10 + 1;
		     System.out.println(s);
		    }     */
		   
		//  Method 2 : Using string builder works for more than 1000 characters
		    StringBuilder sb = new StringBuilder(number);
		    for(int i=0;i<number;i++){
		    	sb.append("1");
		    	System.out.println(sb.toString());
		    }
	}
}
