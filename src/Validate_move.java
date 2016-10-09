
public class Validate_move {
	public static Boolean is_valid(Chessmen[][] chessboard, int x1, int y1, int x2, int y2, String current_player){
		Chessmen current_piece = chessboard[x1][y1];
		Chessmen target_piece = chessboard[x2][y2];
		
		if(x1<0 || x1>7 || x2<0 || x2>7 || y1<0 || y1>7 || y2<0 || y2>7){	//players cannot select locations outside of the board
			return false;
		}
		
		if(current_piece == Chessmen.EMPTY){	//can't move a space without a piece
			return false;
		}
		
		String piece_colour = Determine_Colour.B_or_W(current_piece);
		String target_piece_colour = Determine_Colour.B_or_W(target_piece);
		if(!piece_colour.equals(current_player)){	//players can only move their own pieces
			return false;
		}
		
		if(current_player.equals(target_piece_colour)){	//players can only take opposing pieces (no castling implemented)
			return false;
		}
		
		
		//piece specific checks
		if(current_piece == Chessmen.WHITE_PAWN){
			if(y2 <= y1){	//cannot move backwards or stay in place
				return false;
			}
			if((y1+2) < y2){	//cannot move more than 2 spaces
				return false;
			}
			if((y1+2) == y2 && y1 != 1){	//can only move 2 spaces from starting position.
				return false;
			}
			if((x1 + 1 == x2 || x1 - 1 == x2) && target_piece != Chessmen.EMPTY && !target_piece_colour.equals(piece_colour) && (y1+1) == y2){	//can only move in same column unless capturing another piece
				return true;
			}
			if(x1 != x2){	//cannot move diagonally unless capturing
				return false;
			}
			return true;
		}
		
		if(current_piece == Chessmen.BLACK_PAWN){
			if(y2 >= y1){	//cannot move backwards or stay in place
				return false;
			}
			if((y1-2) < y2){	//cannot move more than 2 spaces
				return false;
			}
			if((y1-2) == y2 && y1 != 6){	//can only move 2 spaces from starting position.
				return false;
			}
			if((x1 + 1 == x2 || x1 - 1 == x2) && target_piece != Chessmen.EMPTY && !target_piece_colour.equals(piece_colour) && (y1-1) == y2){	//can only move in same column unless capturing another piece
				return true;
			}
			if(x1 != x2){	//cannot move diagonally unless capturing
				return false;
			}
			return true;
		}
		
		if(current_piece == Chessmen.BLACK_ROOK || current_piece == Chessmen.WHITE_ROOK){
			if(y1 != y2 && x1 != x2){
				return false;
			}
		}
		
		
	}
}
