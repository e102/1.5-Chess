
public class Determine_Colour {
	public static String B_or_W(Chessmen x){
		switch(x){
		case BLACK_BISHOP:
		case BLACK_KING:
		case BLACK_KNIGHT:
		case BLACK_PAWN:
		case BLACK_QUEEN:
		case BLACK_ROOK: 
			return "black";
		case WHITE_BISHOP:
		case WHITE_KING:
		case WHITE_KNIGHT:
		case WHITE_PAWN:
		case WHITE_QUEEN:
		case WHITE_ROOK: 
			return "white";
		case EMPTY:System.err.println("Something wrong.A piece is not black or white.");
		default: 
			return "error";
		}
	}
}
