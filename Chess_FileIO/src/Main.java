/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 11/11/13
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args){
        Reader reader = new Reader("Chess.txt");
        Translator translator = new Translator(reader.getMoveList());
        reader.printList();
        System.out.println("---------");
        translator.translateMoves();
    }
}