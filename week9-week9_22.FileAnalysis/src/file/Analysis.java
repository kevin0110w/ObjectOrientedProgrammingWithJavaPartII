/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Freckles
 */
public class Analysis {
    private Scanner reader;
    private ArrayList<String> lines;
    
    public Analysis(File file) throws Exception {
        this.reader = new Scanner(file);
        this.lines = new ArrayList<String>();
        
        while (this.reader.hasNextLine()) {
            this.lines.add(this.reader.nextLine());
        }
    }
    
    public int lines() {
        return this.lines.size();
    }
    public int characters() throws Exception {
        int temp = 0;
        for (String x : this.lines) {
           temp += x.length() + 1;
        }
        return temp;
    }
}
