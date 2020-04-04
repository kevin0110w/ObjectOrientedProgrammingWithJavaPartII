
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String file) throws FileNotFoundException {
        File f = new File(file);
        Scanner s = new Scanner(f);
        String line = "";
        List<String> lines = new ArrayList<String>();
        while (s.hasNext()) {
            line = s.nextLine();
            lines.add(line);
        }
        return lines;
    }

    public void save(String file, String text) throws IOException {
        File f = new File(file);
        FileWriter writer = new FileWriter(f, true);
        writer.write(text);
        writer.close();
    }

    public void save(String file, List<String> texts) throws IOException {
        File f = new File(file);
        FileWriter writer = new FileWriter(f, true);
        for (String line : texts) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}
