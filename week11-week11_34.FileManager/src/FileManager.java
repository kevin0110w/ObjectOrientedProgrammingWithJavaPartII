
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public ArrayList<String> read(String file) throws FileNotFoundException {
        File f = new File(file);
        ArrayList<String> lines = new ArrayList<String>();
        Scanner reader = new Scanner(f);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public void save(String file, String text) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (String s : texts) {
            writer.write(s+"\n");
        }
        writer.close();
    }
        public static void main(String[] args) throws FileNotFoundException, IOException {
        FileManager f = new FileManager();

        for (String line : f.read("src/testinput1.txt")) {
            System.out.println(line);
        }
    }
}
