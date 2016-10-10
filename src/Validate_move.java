/**
 * 
 * @author Srdjan Miletic
 * <p>Validates movement. </p>
 * 
 * For all pieces, class validates:
 * 
 */
public class Validate_move {
	public static Boolean is_valid(Chessmen[][] chessboard, int x1, int y1, int x2, int y2, String current_player){
		Chessmen current_piece = chessboard[x1][y1];
		Chessmen target_piece = chessboard[x2][y2];
		
		if(x1<0 || x1>7 || x2<0 || x2>7 || y1<0 || y1>7 || y2<0 || y2>7){	//players cannot select locations outside of the board
			System.out.println("Illegal move. Location selected is not on board. Turn forfitted.");
			return false;
		}
		
		if(current_piece == Chessmen.EMPTY){	//can't move a space without a piece
			System.out.println("Illegal move. Location selected does not contain a piece. Turn forfitted.");
			return false;
		}
		
		if(x1 == x2 && y1 == y2){
			System.out.println("Illegal move. You cannot move a piece to it's current location. Turn forfitted");
		}
		
		String piece_colour = Determine_Colour.B_or_W(current_piece);
		String target_piece_colour = Determine_Colour.B_or_W(target_piece);
		
		if(!piece_colour.equals(current_player)){	//players can only move their own pieces
			System.out.println("Illegal move. Piece selected is not yours to move. Turn forfitted.");
			return false;
		}
		
		if(current_player.equals(target_piece_colour)){	//players can only take opposing pieces (no castling implemented)
			System.out.println("Illegal move. You cannot take your own pieces. Turn forfitted.");
			return false;
		}
		
		
		//piece specific checks
		if(current_piece == Chessmen.WHITE_PAWN){
			if(y2 < y1){	//cannot move backwards
				return false;
			}
			if((y1+2) < y2){	//cannot move more than 2 spaces
				return false;
			}
			if((y1+2) == y2 && y1 == 1 && target_piece_colour == "empty"){	//can only move 2 spaces from starting position.
				return true;
			}
			if((x1 + 1 == x2 || x1 - 1 == x2) && target_piece_colour != "empty" && (y1+1) == y2){	//can only capture diagonally
				return true;
			}
			if(x1 != x2){	//cannot move diagonally unless capturing
				return false;
			}
			if(x1 == x2 && y1 + 1 == y2 && target_piece_colour == "empty"){	//standard forward move
				return true;
			}
			return false;
		}
		
		if(current_piece == Chessmen.BLACK_PAWN){	//in progress
			if(y2 > y1){	//cannot move backwards
				return false;
			}
			if((y1-2) > y2){	//cannot move more than 2 spaces
				return false;
			}
			if((y1-2) == y2 && y1 == 6 && target_piece_colour == "empty"){	//can only move 2 spaces from starting position.
				return true;
			}
			if((x1 + 1 == x2 || x1 - 1 == x2) && target_piece_colour != "empty" && (y1-1) == y2){	//can only move in same column unless capturing another piece
				return true;
			}
			if(x1 != x2){	//cannot move diagonally unless capturing
				return false;
			}
			if(x1 == x2 && y1 - 1 == y2 && target_piece_colour == "empty"){	//standard forward move
				return true;
			}
			return false;
		}
		
		
		if(current_piece == Chessmen.BLACK_ROOK || current_piece == Chessmen.WHITE_ROOK){
			if(y1 != y2 && x1 != x2){	//can only move in straight lines
				return false;
			}
			if(x1+1 == x2 || x1-1 == x2 || y1+1 == y2 || y1-1 == y2){	//moving one space already accounted for by general conditions
				return true;
			}
			if(y1 == y2 && x1 < x2){	//moving right more than 1 space
				for(int i = x1+1; i<x2; i++ ){
					if(chessboard[i][y1] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			if(y1 == y2 && x1 > x2){	//moving left more than 1 space
				for(int i = x1-1; i>x2; i-- ){
					if(chessboard[i][y1] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			if(y1 < y2 && x1 == x2){	//moving up more than 1 space
				for(int i = y1+1; i<y2; i++ ){
					if(chessboard[x1][i] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			if(y1 > y2 && x1 == x2){	//moving down more than 1 space
				for(int i = y1-1; i>y2; i-- ){
					if(chessboard[x1][i] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			return true;
		}
		
		if(current_piece == Chessmen.BLACK_KNIGHT || current_piece == Chessmen.WHITE_KNIGHT){
			//nothing needed for knight. Knight jumps over intervening pieces.
		}
		
		if(current_piece == Chessmen.BLACK_BISHOP || current_piece == Chessmen.WHITE_BISHOP){
			if(Math.abs(x1 - x2) != Math.abs(y1 - y2)){	//must be diagonal
				return false;
			}
			if(Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 1){	//moving one space diagonally is fine
				return true;
			}
			
			//checking spaces being moved through are empty
			if(x2 > x1 && y2 > y1){	//up and right
				for(int a = x1 + 1; a < x2; a++){
					for(int b = y1 + 1; b < y2; b++){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			if(x1 > x2 && y2 > y1){	//up and left
				for(int a = x1 - 1; a > x2; a--){
					for(int b = y1 + 1; b < y2; b++){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			if(x2 > x1 && y1 > y2){	//down and right
				for(int a = x1 + 1; a < x2; a++){
					for(int b = y1 - 1; b > y2; b--){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			if(x1 > x2 && y1 > y2){	//down and left
				for(int a = x1 - 1; a > x2; a--){
					for(int b = y1 - 1; b > y2; b--){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			return true;
		}
		
		if(current_piece == Chessmen.WHITE_KING || current_piece == Chessmen.BLACK_KING){
			return true; //kings movement already accounted for by basic rules
		}
		
		if(current_piece == Chessmen.BLACK_QUEEN || current_piece == Chessmen.WHITE_QUEEN){
			if(x1+1 == x2 || x1-1 == x2 || y1+1 == y2 || y1-1 == y2){	//moving one space straight accounted for by general conditions
				return true;
			}
			if(Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 1){	//moving one space diagonally is fine
				return true;
			}
			
			//diagonal movement
			if(x2 > x1 && y2 > y1){	//up and right
				for(int a = x1 + 1; a < x2; a++){
					for(int b = y1 + 1; b < y2; b++){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			if(x1 > x2 && y2 > y1){	//up and left
				for(int a = x1 - 1; a > x2; a--){
					for(int b = y1 + 1; b < y2; b++){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			if(x2 > x1 && y1 > y2){	//down and right
				for(int a = x1 + 1; a < x2; a++){
					for(int b = y1 - 1; b > y2; b--){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			if(x1 > x2 && y1 > y2){	//down and left
				for(int a = x1 - 1; a > x2; a--){
					for(int b = y1 - 1; b > y2; b--){
						if(chessboard[a][b] != Chessmen.EMPTY){
							return false;
						}
					}
				}
			}
			
			
			
			//straight movement
			if(y1 == y2 && x1 < x2){	//moving right more than 1 space
				for(int i = x1+1; i<x2; i++ ){
					if(chessboard[i][y1] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			if(y1 == y2 && x1 > x2){	//moving left more than 1 space
				for(int i = x1-1; i>x2; i-- ){
					if(chessboard[i][y1] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			if(y1 < y2 && x1 == x2){	//moving up more than 1 space
				for(int i = y1+1; i<y2; i++ ){
					if(chessboard[x1][i] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			if(y1 > y2 && x1 == x2){	//moving down more than 1 space
				for(int i = y1-1; i>y2; i-- ){
					if(chessboard[x1][i] != Chessmen.EMPTY){
						return false;
					}
				}
			}
			return true;
		}
		System.out.println("Serious error. Validation check did not return a result");
		return false; //has to be here to avoid "must return boolean" error. Shouldn't ever be used
	}
}
