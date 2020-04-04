
import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author woohoo
 */
public class Printer {

    private String fileName;
    private Scanner s;

    public Printer(String fileName) throws Exception {
        this.fileName = fileName;
        
    }

    public void printLinesWhichContain(String word) throws Exception{
        File f = new File(this.fileName);
        this.s = new Scanner(f);
        while (this.s.hasNext()) {
            String line = this.s.nextLine();
            if (line.contains(word) || word.length()==0) {
                System.out.println(line);
            }

        }
    }
}
