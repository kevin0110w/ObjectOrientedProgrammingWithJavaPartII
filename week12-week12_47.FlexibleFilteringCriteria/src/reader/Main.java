package reader;

import reader.criteria.AllLines;
import reader.criteria.Both;
import reader.criteria.Criterion;
import reader.criteria.ContainsWord;
import reader.criteria.EndsWithQuestionOrExclamationMark;

public class Main {

    public static void main(String[] args) {
//        String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
//        GutenbergReader book = new GutenbergReader(address);
//
//        Criterion criterion = new ContainsWord("beer");
//
//        for (String line : book.linesWhichComplyWith(criterion)) {
//            System.out.println(line);
//        }
    
//String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
//    GutenbergReader book = new GutenbergReader(address);
//
//    Criterion criterion = new AllLines();
//
//    for (String line : book.linesWhichComplyWith(criterion)) {
//        System.out.println(line);
//        }

//String address = "http://www.gutenberg.myebook.bg/2/5/5/2554/2554-8.txt";
//    GutenbergReader book = new GutenbergReader(address);
//
//     Criterion criterion = new EndsWithQuestionOrExclamationMark();
//
//    for (String line : book.linesWhichComplyWith(criterion)) {
//        System.out.println(line);
//    }

        Criterion criterion = new Both(new ContainsWord("maito"), new ContainsWord("vesi") );
        System.out.println(criterion.complies("vesi vanhin voitehista, maito myös hyvä"));

    }
}
