/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author kevin0110w
 */
public class RatingRegister {
    private Map<Film, List<Rating>> ratings;
    private Map<Person, HashMap<Film, Rating>> personalRatings;
    public RatingRegister() {
        this.ratings = new HashMap<Film, List<Rating>>();
        this.personalRatings = new HashMap<Person, HashMap<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if (this.ratings.containsKey(film)) {
            this.ratings.get(film).add(rating);
        } else {
           List<Rating> r = new ArrayList<Rating>();
           r.add(rating);
           this.ratings.put(film, r);
        }
    }
    
    public List<Rating> getRatings(Film film) {
        return this.ratings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        Map<Film, List<Rating>> ratings = new HashMap<Film, List<Rating>>();
        Iterator<Film> it = this.ratings.keySet().iterator();
        while (it.hasNext()) {
            Film f = it.next();
            List<Rating> r = new ArrayList<Rating>();
            r = this.getRatings(f);
            ratings.put(f, r);
        }
        return ratings;
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if (this.personalRatings.containsKey(person)) {
            this.personalRatings.get(person).put(film, rating);
            
        } else {
        HashMap<Film, Rating> m = new HashMap<Film, Rating>();
        m.put(film, rating);
        this.personalRatings.put(person, m);
        }
        this.addRating(film, rating);
    }
    
    public Rating getRating(Person person, Film film) {
        Map<Film, Rating> m = this.personalRatings.get(person);
        Rating rating = m.get(film);
        if (rating == null) {
            rating = Rating.NOT_WATCHED;
        }
        return rating;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        Map<Film, Rating> m = this.personalRatings.get(person);
        return m;
    }
    
    public List<Person> reviewers() {
        List<Person> p = new ArrayList<Person>();
        for (Person person : this.personalRatings.keySet()) {
            p.add(person);
        }
        return p;
    }
    
    public static void main(String[] args) {
//        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
//        Film eraserhead = new Film("Eraserhead");
//
//        RatingRegister reg = new RatingRegister();
//        reg.addRating(eraserhead, Rating.BAD);
//        reg.addRating(eraserhead, Rating.BAD);
//        reg.addRating(eraserhead, Rating.GOOD);
//        reg.addRating(theBridgesOfMadisonCounty, Rating.GOOD);
//        reg.addRating(theBridgesOfMadisonCounty, Rating.FINE);
//    
//        System.out.println("All ratings: " + reg.filmRatings());
//        System.out.println("Ratings for Eraserhead: " + reg.getRatings(eraserhead));

    RatingRegister ratings = new RatingRegister();

    Film goneWithTheWind = new Film("Gone with the Wind");
    Film eraserhead = new Film("Eraserhead");

    Person matti = new Person("Matti");
    Person pekka = new Person("Pekka");

    ratings.addRating(matti, goneWithTheWind, Rating.BAD);
    ratings.addRating(matti, eraserhead, Rating.FINE);

    ratings.addRating(pekka, goneWithTheWind, Rating.GOOD);
    ratings.addRating(pekka, eraserhead, Rating.GOOD);

    System.out.println("Ratings for Eraserhead: " + ratings.getRatings(eraserhead));
    System.out.println("Matti's ratings: " + ratings.getPersonalRatings(matti));
    System.out.println("Reviewers: " + ratings.reviewers());
    }
}
