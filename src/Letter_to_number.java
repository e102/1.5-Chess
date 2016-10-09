
public class Letter_to_number {
	
	public static int convert(String letter){
		switch(letter){
		case "a": return 0;
		case "b": return 1;
		case "c": return 2;
		case "d": return 3;
		case "e": return 4;
		case "f": return 5;
		case "g": return 6;
		case "h": return 7;
		default: System.out.println("Error in letter to number");System.exit(0); return 150;
		}
	}

}
