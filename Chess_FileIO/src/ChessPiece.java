/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 11/12/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public enum ChessPiece implements ChessPieceInterface{

    DARKKING("DarkKing"),
    DARKQUEEN("DarkQueen"),
    DARKBISHOP("DarkBishop"),
    DARKKNIGHT("DarkKnight"),
    DARKROOK("DarkRook"),
    DARKPAWN("DarkPawn"),
    LIGHTKING("LightKing"),
    LIGHTQUEEN("LightQueen"),
    LIGHTBISHOP("LightBishop"),
    LIGHTKNIGHT("LightKnight"),
    LIGHTROOK("LightRook"),
    LIGHTPAWN("LightPawn"),
    UNKNOWN("PieceNotFound");

    private String pieceName;

     ChessPiece(String name) {
         this.pieceName = name;
    }

    public String getPieceName(){
        return pieceName;
    }
}
