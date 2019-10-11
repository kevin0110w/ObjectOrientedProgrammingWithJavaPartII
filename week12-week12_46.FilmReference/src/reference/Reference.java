/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author woohoo
 */
public class Reference {
    private RatingRegister ratings;
    
    public Reference(RatingRegister ratings) {
        this.ratings = ratings;
    }
    
    public Film recommendFilm(Person person) {
        // get all films and sort based on the average ratings. if the person hasn't seen any
        // movies, return the best on average
        Map<Film, List<Rating>> films = this.ratings.filmRatings();
        List<Film> filmList = new ArrayList<Film> (films.keySet());
        Collections.sort(filmList, new FilmComparator(films));
        
        if (this.ratings.getPersonalRatings(person).isEmpty()) {
            return filmList.get(0);
        }
        
        Map<Film, Rating> thisPersonsRating = this.ratings.getPersonalRatings(person);
        Map<Person, Map<Film, Rating>> otherPersonsRating = new HashMap<Person, Map<Film, Rating>>();
        List<Person> reviewers = this.ratings.reviewers();
        
        if (reviewers.isEmpty()) {
            return null;
        }
        
        // Work out the similarity scores
        Map<Person, Integer> similarities = new HashMap<Person, Integer>();
        int similarity = 0;
        
        for (Person p : reviewers) {
                otherPersonsRating.put(p, this.ratings.getPersonalRatings(p));
                if (thisPersonsRating.isEmpty()) {
                    similarities.put(p, similarity);
                } else {
                for (Film f : thisPersonsRating.keySet()) {
                    if (otherPersonsRating.get(p).containsKey(f)) {
                    similarity = similarity + (thisPersonsRating.get(f).getValue() * otherPersonsRating.get(p).get(f).getValue());
            }
                similarities.put(p, similarity);
        }
                }
            similarity = 0;
    }
        
        // sort the reviewers list such that the most similiar is at the beginning of reviewers
        Collections.sort(reviewers, new PersonComparator(similarities));
        
        Film recommendThis = null;
        
        // remove the person we're considering from the list of reviewers
        reviewers.remove(person);
        Map<Film, Rating> similarPersonsRating = this.ratings.getPersonalRatings(reviewers.get(0));
        for (Film f : similarPersonsRating.keySet()) {     
            if ((!thisPersonsRating.containsKey(f)) && (getNotDownvoted(f,  similarPersonsRating))) {
                recommendThis = f;
            }
        }
        return recommendThis;
    }

    public boolean getNotDownvoted(Film m, Map<Film, Rating> otherPersonRatings) {
        if (!(otherPersonRatings.containsKey(m))) {
            return false;
        } else {
            return otherPersonRatings.get(m).getValue() > 1;
        }
    }
}
