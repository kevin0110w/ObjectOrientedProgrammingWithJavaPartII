/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author woohoo
 */
public class RatingRegister {

    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> personalRatings;

    public Map<Person, Map<Film, Rating>> getPersonalRatings() {
        return personalRatings;
    }

    public RatingRegister() {
        this.filmRatings = new HashMap<>();
        this.personalRatings = new HashMap<>();
    }

    public void addRating(Film film, Rating rating) {
        if (film == null) {
            return;
        }

        if (this.filmRatings.containsKey(film)) {
            this.filmRatings.get(film).add(rating);
        } else {
            List<Rating> newFilmRatings = new ArrayList<>();
            newFilmRatings.add(rating);
            this.filmRatings.put(film, newFilmRatings);
        }
    }

    public List<Rating> getRatings(Film film) {
        if (film == null) {
            return null;
        }

        return this.filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return this.filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (person == null || film == null) {
            return;
        }

        Map<Film, Rating> thisPersonsFilmRating = new HashMap<>();
        thisPersonsFilmRating.put(film, rating);
        if (this.personalRatings.containsKey(person)) {
            if (this.personalRatings.get(person).containsKey(film)) {
                return;
            } else {
                this.personalRatings.get(person).put(film, rating);
            }
        } else {
            this.personalRatings.put(person, thisPersonsFilmRating);
        }

        this.addRating(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        if (this.personalRatings.containsKey(person)) {
            if (this.personalRatings.get(person).containsKey(film)) {
                return this.personalRatings.get(person).get(film);
            } else {
                return Rating.NOT_WATCHED;
            }
        } else {
            return null;
        }
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (person == null) {
            return null;
        }
        
        if (this.personalRatings.containsKey(person)) {
            return this.personalRatings.get(person);
        } else {
            Map<Film, Rating> personRatings = new HashMap<Film, Rating>();
            return personRatings;
        }
    }

    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<>(this.personalRatings.keySet());
        return reviewers;
    }
}
