public class Board_DIsplay {
	public static void print(Chessmen[][] board){
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for (int y = 7; y >= 0; y--) {
			System.out.println();
			System.out.print(y+1 + "\t");
			for (int x = 0; x < board.length; x++) {
				switch(board[x][y]){
				case BLACK_BISHOP:System.out.print("\u265D\t");
					break;
				case BLACK_KING:System.out.print("\u265A\t");
					break;
				case BLACK_KNIGHT:System.out.print("\u265E\t");
					break;
				case BLACK_PAWN:System.out.print("\u265F\t");
					break;
				case BLACK_QUEEN:System.out.print("\u265B\t");
					break;
				case BLACK_ROOK:System.out.print("\u265C\t");
					break;
				case EMPTY: System.out.print("#\t");	//print ## rather than empty space. Makes comprehension easier.
					break;
				case WHITE_BISHOP:System.out.print("\u2657\t");
					break;
				case WHITE_KING:System.out.print("\u2654\t");
					break;
				case WHITE_KNIGHT:System.out.print("\u2658\t");
					break;
				case WHITE_PAWN:System.out.print("\u2659\t");
					break;
				case WHITE_QUEEN:System.out.print("\u2655\t");
					break;
				case WHITE_ROOK:System.out.print("\u2656\t");
					break;
				default:
					break;
				}
			}
		}
		System.out.println();
	}
}
