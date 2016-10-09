public class move_piece {

	public static void move(Chessmen[][] chessboard, String move_from, String move_to, String current_player){
		String from_x = move_from.substring(0, 1);	//a - h
		String from_y = move_from.substring(1);	// 1 - 8
		
		String to_x = move_to.substring(0, 1);	//a - h
		String to_y = move_to.substring(1);	// 1 - 8
		
		//Converting from chess notation to xy notation. i.e a1 --> 00
		int x1 = Letter_to_number.convert(from_x);
		int y1 = Integer.parseInt(from_y);
		y1--;
		
		int x2 = Letter_to_number.convert(to_x);
		int y2 = Integer.parseInt(to_y);
		y2--;
		
		if(Validate_move.is_valid(chessboard, x1, y1, x2, y2, current_player)){
			Chessmen current_piece = chessboard[x1][y1];
			chessboard[x1][y1] = Chessmen.EMPTY;
			chessboard[x2][y2] = current_piece;
		}
		else{
			//TODO
		}
	}

}
