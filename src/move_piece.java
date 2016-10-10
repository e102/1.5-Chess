public class move_piece {

	public static void move(Chessmen[][] chessboard, int x1, int y1, int x2, int y2, String current_player){
		if(Validate_move.is_valid(chessboard, x1, y1, x2, y2, current_player)){
			Chessmen current_piece = chessboard[x1][y1];
			chessboard[x1][y1] = Chessmen.EMPTY;
			chessboard[x2][y2] = current_piece;
		}
	}
}
