
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Printer {
    private File fileName;
    private Scanner s;
    private ArrayList<String> lines;
    
    /*
    receives a String standing for the file name
    If the file is not found, the constructor delegates the exception
    */
    public Printer(String fileName) throws Exception {
        this.fileName = new File (fileName);
        this.s = new Scanner(this.fileName);
        this.lines = new ArrayList<String>();
        
        while(this.s.hasNextLine()) {
            String line = s.nextLine();
            this.lines.add(line);
        }
    }
    
    /*
    prints the file lines which contain the parameter word (lower and upper case        make difference in this excercise; for instance, "test" and "Test" are not          the considered the same);
    */
    public void printLinesWhichContain(String word) {
        
//        String string = "";
//        while (s.hasNextLine()) {
//            String line = s.nextLine();
//            string += line;
//            string += "\n";
//            
//            if (line.contains(word)) {
//                System.out.println(line);
//            } else if (word.equals("")){
//                System.out.println(string);
//            }

        for (String x : this.lines) {
            if (x.contains(word)) {
                System.out.println(x);
            } else if (word.equals("")) {
                System.out.println(x);
            }
        }
    }
}
    