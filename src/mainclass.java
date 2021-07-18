import java.util.*;
import java.lang.*;

public class mainclass {
	// Pattern finder: Using Java Regex, find phone numbers and email addresses in the 100 text
	public static void main(String[] args) {
		List<String> dataitems = new ArrayList<>(); 
		System.out.println("Enter 5 data : ");
		Scanner scan = new Scanner(System.in);
		
		for (int x=0; x<5;x++) {
			dataitems.add(scan.next().trim());
		}
		
		scan.close(); 
		
		System.out.println("Valid Email items :"); 
		isEmail(dataitems);
		System.out.println("Valid Phone Numbers :"); 
		isPhoneNumber(dataitems);
		System.out.println("Valid Url :");
		isUrlValid(dataitems);
	}
	
	public static void isEmail(List<String> dataitems) {
		String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+[a-zA-Z0-9]{2,4}$";
	    
		for(String data : dataitems) {
		   boolean result = data.matches(regex);
		   
		   if(result) {
			   System.out.format(" - %s \n", data);
		   }
		}
		
		/*^ matches the starting of the sentence.
		[a-zA-Z0-9+_.-] matches one character from the English alphabet (both cases), digits, “+”, “_”, “.” and, “-” before the @ symbol.
		+ indicates the repetition of the above-mentioned set of characters one or more times.
		@ matches itself.
		[a-zA-Z0-9.-] matches one character from the English alphabet (both cases), digits, “.” and “–” after the @ symbol.
		$ indicates the end of the sentence.*/
	}
	
	public static void isPhoneNumber(List<String> dataitems){
		/* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn
		    ^\\(? : May start with an option "(" .
		    (\\d{3}): Followed by 3 digits.
		    \\)? : May have an optional ")" 
		    [- ]? : May have an optional "-" after the first 3 digits or after optional ) character. 
		    (\\d{3}) : Followed by 3 digits. 
		     [- ]? : May have another optional "-" after numeric digits.
		     (\\d{4})$ : ends with four digits.
		         Examples: Matches following phone numbers:
		         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890
		*/
		//Initialize reg ex for phone number. 
		String regex = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
		
		for(String data : dataitems) {
			   boolean result = data.matches(regex);
			   
			   if(result) {
				   System.out.format(" - %s \n", data);
			   }
		}
	}
	
	public static void isUrlValid(List<String> dataitems){
		String regex = "^(http|https?|ftp|file):\\/\\/?(www)[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|]";
		for(String data : dataitems) {
			   boolean result = data.matches(regex);
			   
			   if(result) {
				   System.out.format(" - %s \n", data);
			   }
		}
	}
}
