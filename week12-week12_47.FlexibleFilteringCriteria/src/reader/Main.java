package reader;

import reader.criteria.AllLines;
import reader.criteria.Criterion;
import reader.criteria.ContainsWord;

public class Main {

    public static void main(String[] args) {
        String address = "http://www.gutenberg.org/files/2554/2554-0.txt";
        GutenbergReader book = new GutenbergReader(address);

        Criterion criterion = new AllLines();

        for (String line : book.linesWhichComplyWith(criterion)) {
            System.out.println(line);
        }
    }
}
