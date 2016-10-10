
public class Input_Validation {
	public static boolean valid(String a){
		if(a.length() != 2){
			System.err.println("Enter only 2 characters with no spaces.");
			return false;
		}
		
		String from_x = a.substring(0, 1);	//a - h
		String from_y = a.substring(1);	// 1 - 8
		
		int x1 = Letter_to_number.convert(from_x);
		if(x1 == 150){	//150 is an error code returned if the letter is not a - h
			System.err.println("The first character must be a letter from a to h. Use lowercase letters only.");
			return false;
		}
		
		try{
		int y1 = Integer.parseInt(from_y);
		if(y1 > 8 || y1 < 1){
			System.err.println("The number must be between 1 and 8 (inclusive).");
			return false;
		}
		}
		catch(NumberFormatException z){
			System.err.println("The second character must be a number.");
			return false;
		}
		
		return true;
	}
}
