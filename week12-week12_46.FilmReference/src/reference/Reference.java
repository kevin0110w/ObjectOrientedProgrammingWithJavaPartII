/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author kevin0110w
 */
public class Reference {
    private RatingRegister register;
    
    public Reference(RatingRegister register) {
        this.register = register;
    }
    
    public Film recommendFilm(Person person) {
        Map<Film, List<Rating>> ratings = register.filmRatings();
        Iterator<Film> it = ratings.keySet().iterator();
        List<Film> films = new ArrayList<Film>();
        while (it.hasNext()) {
            Film f = it.next();
            films.add(f);
        }
        Collections.sort(films, new FilmComparator(ratings));
        return films.get(0);
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

    Reference ref = new Reference(ratings);
    Film recommended = ref.recommendFilm(mikke);
    System.out.println("The film recommended to Michael is: " + recommended);
    }
}
