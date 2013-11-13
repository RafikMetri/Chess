import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 11/12/13
 * Time: 1:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Translator {
    List<String> moveList = new ArrayList<String>();

    public Translator(List<String> _list){
        moveList = _list;
    }


    //Translates each line in the moveList into english
    public void translateMoves(){
        Pattern regex = null; //Pattern.compile("", Pattern.CASE_INSENSITIVE);
        Matcher search = null; //regex.matcher("kdh5 d5 f4 d1 b1 a1 c1");

        for(int i = 0; i < moveList.size(); i++){
            try{
                //Searches to make sure that a line fits with the criteria and seperates the 3 different moves into groups
                regex = Pattern.compile("([KQBNRP][dl][A-H][1-8])\\s+([A-H][1-8]\\s+[A-H][1-8])\\s+([A-H][1-8]\\s+[A-H][1-8]\\s+[A-H][1-8]\\s+[A-H][1-8])", Pattern.CASE_INSENSITIVE);
                search = regex.matcher(moveList.get(i));

                //if(search.find()){
                    while(search.find()){
                        System.out.println("-----");
                        translatePlacePiece(search.group(1));
                        translateMoveOnePiece(search.group(2));
                        translateMoveTwoPieces(search.group(3));
                    }
                //}
                //else
                //    System.out.println("No match was found or the given move was invalid.");
            }
            catch(Exception e){
                System.out.println("There was a problem matching your search: " + e.toString());
            }
        }
    }

    //Takes the first group of a line and places a piece
    public void translatePlacePiece(String text){
        //System.out.println(text);
        Pattern regex = null;
        Matcher search = null;
        ChessPiece piece = null;

        try{
            //Makes sure that the first group follows the criteria and seperates the piece and placement into two groups
            regex = Pattern.compile("([KQBNRP][dl])([A-H][1-8])", Pattern.CASE_INSENSITIVE);
            search = regex.matcher(text);

            //Translates which piece is being used
            while(search.find()){
                //System.out.println(search.group(1));
                if(search.group(1).equals("Kd"))
                    piece = ChessPiece.DARKKING;
                else if(search.group(1).equals("Kl"))
                    piece = ChessPiece.LIGHTKING;

                else if(search.group(1).equals("Qd"))
                    piece = ChessPiece.DARKQUEEN;
                else if(search.group(1).equals("Ql"))
                    piece = ChessPiece.LIGHTQUEEN;

                else if(search.group(1).equals("Bd"))
                    piece = ChessPiece.DARKBISHOP;
                else if(search.group(1).equals("Bl"))
                    piece = ChessPiece.LIGHTBISHOP;

                else if(search.group(1).equals("Nd"))
                    piece = ChessPiece.DARKKNIGHT;
                else if(search.group(1).equals("Nl"))
                    piece = ChessPiece.LIGHTKNIGHT;

                else if(search.group(1).equals("Rd"))
                    piece = ChessPiece.DARKROOK;
                else if(search.group(1).equals("Rl"))
                    piece = ChessPiece.LIGHTROOK;

                else if(search.group(1).equals("Pd"))
                    piece = ChessPiece.DARKPAWN;
                else if(search.group(1).equals("Pl"))
                    piece = ChessPiece.LIGHTPAWN;

                else
                    piece = ChessPiece.UNKNOWN;

                System.out.println(piece.getPieceName() + " has been moved to " + search.group(2));
            }
        }
        catch(Exception e){
            System.out.println("There was a problem matching your search: " + e.toString());
        }
    }

    //takes the second group of a line and moves one piece
    public void translateMoveOnePiece(String text){
        Pattern regex = null;
        Matcher search = null;
        //System.out.println(text);

        try{
            //Makes sure that the group fits the criteria and seperates the original position and the new position into two groups
            regex = Pattern.compile("([A-H][1-8])\\s+([A-H][1-8])", Pattern.CASE_INSENSITIVE);
            search = regex.matcher(text);

            while(search.find()){
                System.out.println("The piece at " + search.group(1) + " has been moved to " + search.group(2));
            }
        }
        catch(Exception e){
            System.out.println("There was a problem matching your search: " + e.toString());
        }
    }

    //takes the second group of a line and move two pieces
    public void translateMoveTwoPieces(String text){
        Pattern regex = null;
        Matcher search = null;
        //System.out.println(text);

        try{
            //Makes sure that the group fits the criteria and seperates the 4 positions into groups
            regex = Pattern.compile("([A-H][1-8])\\s+([A-H][1-8])\\s+([A-H][1-8])\\s+([A-H][1-8])", Pattern.CASE_INSENSITIVE);
            search = regex.matcher(text);

            while(search.find()){
                System.out.println("The king at " + search.group(1) + " has been moved to " + search.group(2) + " and the rook at " + search.group(3) + " has been moved to " + search.group(4));
            }
        }
        catch(Exception e){
            System.out.println("There waas a problem matching your search: " + e.toString());
        }
    }
}
