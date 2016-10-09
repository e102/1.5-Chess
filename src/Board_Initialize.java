public class Board_Initialize {
	public static Chessmen[][] setup(){
		Chessmen[][] chessboard = new Chessmen[8][8];
		//x = columns, y = rows
		for (int x = 0; x < chessboard.length; x++) {
			for (int y = 0; y < chessboard.length; y++) {
				// java does not support multi-variable switch statement. hence if used.
				
				// middle rows are empty
				if(y >= 2 && y <= 5){	
					chessboard[x][y] = Chessmen.EMPTY;
					continue;
				}
				
				// second and penultimate rows contain only pawns
				if(y == 1){
					chessboard[x][y] = Chessmen.WHITE_PAWN;
					continue;
				}
				if(y == 6){
					chessboard[x][y] = Chessmen.BLACK_PAWN;
					continue;
				}
				
				//Rooks
				if(x == 0 || x == 7){
					if(y == 0){
						chessboard[x][y] = Chessmen.WHITE_ROOK;
						continue;
					}
					if(y == 7){
						chessboard[x][y] = Chessmen.BLACK_ROOK;
						continue;
					}
				}
				
				//Knights
				if(x == 1 || x == 6){
					if(y == 0){
						chessboard[x][y] = Chessmen.WHITE_KNIGHT;
						continue;
					}
					if(y == 7){
						chessboard[x][y] = Chessmen.BLACK_KNIGHT;
						continue;
					}
				}
				
				//Bishops
				if(x == 2 || x == 5){
					if(y == 0){
						chessboard[x][y] = Chessmen.WHITE_BISHOP;
						continue;
					}
					if(y == 7){
						chessboard[x][y] = Chessmen.BLACK_BISHOP;
						continue;
					}
				}
				
				//Kings
				if(x == 4 && y == 0){
					chessboard[x][y] = Chessmen.WHITE_KING;
					continue;
				}
				if(x == 3 && y == 7){
					chessboard[x][y] = Chessmen.BLACK_KING;
					continue;

				}
				
				//Queens
				if(x == 3 && y == 0){
					chessboard[x][y] = Chessmen.WHITE_QUEEN;
					continue;
				}
				if(x == 4 && y == 7){
					chessboard[x][y] = Chessmen.BLACK_QUEEN;
					continue;

				}
			}
		}
		return chessboard;
	}
}
