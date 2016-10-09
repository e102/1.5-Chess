import java.util.Scanner;

public class Chess_Base {
	public static void main(String[] args) {
		Chessmen[][] chessboard = Board_Initialize.setup();
		Board_DIsplay.print(chessboard);
		
		String current_player = "white";
		String next_player;
		String move_from;
		String move_to;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Hey. If you want to quit at any time, type exit instead of your normal command.");
		while(true){
			if(current_player == "white"){
				System.out.println("White plays");
				next_player = "black";
			}
			else{
				System.out.println("Black plays");
				next_player = "white";
			}
			
			System.out.println("Enter the location of the piece you want to move. (i.e: b6)");
			move_from = s.nextLine();
			System.out.println("Where to?");
			move_to = s.nextLine();
			
			if(move_from.equals("exit")|| move_to.equals("exit")){
				System.out.println("Goodbye.");
				System.exit(0);
			}
			
			move_piece.move(chessboard,move_from,move_to,current_player);
			Board_DIsplay.print(chessboard);
			
			current_player = next_player;
		}
	}
}