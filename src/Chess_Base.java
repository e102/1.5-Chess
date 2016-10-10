import java.util.Scanner;

public class Chess_Base {
	public static void main(String[] args) {
		Chessmen[][] chessboard = Board_Initialize.setup();
		Board_DIsplay.print(chessboard);
		
		String current_player = "white";
		String next_player = "black";
		String move_from;
		String move_to;
		
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Hey. If you want to quit at any time, type exit instead of your normal command.");
		while(true){
			if(current_player == "white"){
				System.out.println();
				System.out.println("White plays");
				next_player = "black";
			}
			else if(current_player == "black"){
				System.out.println();
				System.out.println("Black plays");
				next_player = "white";
			}
			else{
				System.out.println("ERRRRROOOOOORRRRRR");
			}
			
			System.out.println("Enter the location of the piece you want to move. (i.e: b6)");
			move_from = s.nextLine();
			
			if(!Input_Validation.valid(move_from)){
				System.out.println("Bad input. Please try again");
				continue;
			}
			
			System.out.println("Where to?");
			move_to = s.nextLine();
			
			if(!Input_Validation.valid(move_to)){
				System.out.println("Bad input. Please try again");
				continue;
			}
			
			if(move_from.equals("exit")|| move_to.equals("exit")){
				System.out.println("Goodbye.");
				System.exit(0);
			}
			
			//converting strings entered to xy coordinates
			String from_x = move_from.substring(0, 1);	//a - h
			String from_y = move_from.substring(1);	// 1 - 8
			
			String to_x = move_to.substring(0, 1);	//a - h
			String to_y = move_to.substring(1);	// 1 - 8
			
			int x1 = Letter_to_number.convert(from_x);
			int y1 = Integer.parseInt(from_y);
			y1--;
			
			int x2 = Letter_to_number.convert(to_x);
			int y2 = Integer.parseInt(to_y);
			y2--;
			
			
			move_piece.move(chessboard, x1, y1, x2, y2, current_player);
			Board_DIsplay.print(chessboard);
			
			current_player = next_player;
		}
	}
}