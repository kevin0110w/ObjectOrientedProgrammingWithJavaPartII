/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.RatingRegister;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author kevin0110w
 */
public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        List<Rating> list1 = ratings.get(o1);
        List<Rating> list2 = ratings.get(o2);
        int num1 = 0;
        int num2 = 0;
        for (Rating r : list1) {
           num1 += r.getValue();
        }
        for (Rating r : list2) {
            num2 += r.getValue();
        }
        int ave1 = num1 / list1.size();
        int ave2 = num2 / list2.size();
        return ave2 - ave1;
    }
    public static void main(String[] args) {
        RatingRegister ratings = new RatingRegister();

    Film goneWithTheWind = new Film("Gone with the Wind");
    Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
    Film eraserhead = new Film("Eraserhead");

    Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");
    Person mikke = new Person("Mikke");

    ratings.addRating(matti, goneWithTheWind, Rating.BAD);
    ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
    ratings.addRating(matti, eraserhead, Rating.FINE);

    ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
    ratings.addRating(pekka, theBridgesOfMadisonCounty, Rating.BAD);
    ratings.addRating(pekka, eraserhead, Rating.MEDIOCRE);

    ratings.addRating(mikke, eraserhead, Rating.BAD);

    Map<Film, List<Rating>> filmRatings = ratings.filmRatings();

    List<Film> films = Arrays.asList(goneWithTheWind, theBridgesOfMadisonCounty, eraserhead);
    System.out.println("The films before sorting: " + films);

    Collections.sort(films, new FilmComparator(filmRatings));
    System.out.println("The films after sorting: " + films);
    }
}
