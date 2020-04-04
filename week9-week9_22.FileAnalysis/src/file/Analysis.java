/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author woohoo
 */
public class Analysis {
    private File file;
    private int lines;
    private int characters;
    private Scanner reader;
    
    public Analysis(File file) throws Exception {
        this.file = file;
        this.lines = 0;
        this.characters = 0;
        this.reader = new Scanner(file);
        readFile();
    }
    
    public int lines(){
        return this.lines;
    }
    
    public int characters() {
        return this.characters;
    }

    private void readFile() {
       while (this.reader.hasNext()) {
           String line = this.reader.nextLine();
           this.lines++;
           for (int i = 0; i <= line.length(); i++) {
               this.characters++;
           }
       }
    }
}
