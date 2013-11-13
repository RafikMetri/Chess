import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: rmetri
 * Date: 11/11/13
 * Time: 2:04 PM
 * The purpose of the move reader is to read a file and create a list based on the given information
 */
public class Reader {
    private String fileName;
    private List<String> moveList = new ArrayList<String>();

    public Reader(String _fileName){
        fileName = _fileName;
        transferFileToList();
    }

    //Transfers each line of a file to moveList
    public String transferFileToList(){
        Scanner read = null;
        String text = null;

        try{
            read = new Scanner(new File(fileName));
            read.useDelimiter("$");

            while(read.hasNext()){
                moveList.add(read.nextLine());
            }
        }
        catch(Exception e){
            System.out.println("There was a problem scanning your file: " + e.toString());
        }

        return text;
    }

    //prints the contents of the moveList primary purpose is for testing
    public void printList(){
        for(int i = 0; i < moveList.size(); i++){
            System.out.println(moveList.get(i));
        }
    }

    //Getters:
    public List<String> getMoveList() {
        return moveList;
    }
}