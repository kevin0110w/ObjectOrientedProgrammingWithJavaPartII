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
import reference.domain.Rating;
import reference.domain.Person;

/**
 *
 * @author woohoo
 */
public class RatingRegister {
    private Map<Film, List<Rating>> allMovieRatings;
    private Map<Person, Map<Film, Rating>> personalRatings;
    
    public RatingRegister() {
        this.allMovieRatings = new HashMap<Film, List<Rating>>();
        this.personalRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public Map<Person, Map<Film, Rating>> returnPersonalRatings() {
        return this.personalRatings;
    }
    /**
     * adds a new rating to the parameter film. The same film can have various same allMovieRatings.
     * @param film
     * @param rating 
     */
    public void addRating(Film film, Rating rating) {
        List<Rating> aFilmRating = new ArrayList<Rating>();
        
        if (this.allMovieRatings.containsKey(film)) {
            aFilmRating.addAll(this.allMovieRatings.get(film));  
        } 
        
        aFilmRating.add(rating);
        this.allMovieRatings.put(film, aFilmRating);
    }
    
    /**
     * returns a list of the allMovieRatings which were added in connection to a film.
     * @param film
     * @return 
     */
    public List<Rating> getRatings(Film film) { 
        return this.allMovieRatings.get(film);
    }
    
    /**
     * returns a map whose keys are the evaluated films. 
     * Each film is associated to a list containing the allMovieRatings for that film.
     * @return 
     */
    public Map<Film, List<Rating>> filmRatings() { 
        
        return this.allMovieRatings;
    }
    
    /**
     *  adds the rating of a specific film to the parameter person. 
     * The same person can recommend a specific film only once. 
     * The person rating has also to be added to the ratings connected to all the films.
     * @param person
     * @param film
     * @param rating 
     */
    public void addRating(Person person, Film film, Rating rating) {
       Map<Film, Rating> filmRatings = new HashMap<Film, Rating>();
        if (this.personalRatings.containsKey(person)) {
           filmRatings = this.personalRatings.get(person);
           filmRatings.put(film, rating);
           }
        else {
            filmRatings.put(film, rating);
           this.personalRatings.put(person, filmRatings);
        }
        this.addRating(film, rating);
    }
    
    /**
     * returns the rating the paramater person has assigned to the parameter film. 
     * If the person hasn't evaluated such film, the method returns Rating.NOT_WATCHED.
     * @param person
     * @param film
     * @return 
     */
    public Rating getRating(Person person, Film film) { 
        if (!this.personalRatings.containsKey(person)) {
            return null;
        } 
        if (!(this.personalRatings.get(person).containsKey(film))) {
            return Rating.NOT_WATCHED;
        }  else {
            Rating r = this.personalRatings.get(person).get(film);
            return r;
        }
    }
    
    /**
     * returns a HashMap which contains the person's ratings. 
     * The HashMap keys are the evaluated films, and their values are the ratings of these films.
     * @param person
     * @return 
     */
    public Map<Film, Rating> getPersonalRatings(Person person) { 
        if (!(this.personalRatings.containsKey(person))) {
            Map<Film, Rating> x = new HashMap<Film, Rating>();
            this.personalRatings.put(person, x);            
        }
        return this.personalRatings.get(person);
    }
    
    /**
     * returns a list of the people who have evaluate the films.
     * @return 
     */
    public List<Person> reviewers() { 
        List<Person> reviewers = new ArrayList<Person> (this.personalRatings.keySet());
        return reviewers;
    }    
}
