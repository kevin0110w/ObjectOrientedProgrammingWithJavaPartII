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

    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratings) {
        this.ratingRegister = ratings;
    }

    public Film recommendFilm(Person person) {
        if (person == null) {
            return null;
        }

        Film recommendedFilm = null;

        Map<Person, Integer> personComparatorRef = new HashMap<>();

        Map<Film, List<Rating>> allFilmRatings = this.ratingRegister.filmRatings();

        List<Film> allFilms = new ArrayList<>();
        allFilms.addAll(allFilmRatings.keySet());

        List<Person> reviewers = this.ratingRegister.reviewers();

        Map<Person, Map<Film, Rating>> ratingsPerReviewer = new HashMap<Person, Map<Film, Rating>>();
        ratingsPerReviewer = this.ratingRegister.getPersonalRatings();

        Map<Film, Rating> theSpecificPersonsRatings = new HashMap<>();

        if (!this.ratingRegister.reviewers().contains(person)) {
            Collections.sort(allFilms, new FilmComparator(allFilmRatings));
            return allFilms.get(0);
        } else {
            theSpecificPersonsRatings = ratingsPerReviewer.get(person);
            personComparatorRef = getReviewersScore(person, ratingsPerReviewer);
        }

        reviewers.remove(person);
        Collections.sort(reviewers, new PersonComparator(personComparatorRef));

        for (Film f : ratingsPerReviewer.get(reviewers.get(0)).keySet()) {
            if (ratingsPerReviewer.get(reviewers.get(0)).get(f).getValue() > 1) {
                if (!theSpecificPersonsRatings.containsKey(f)) {
                    recommendedFilm = f;
                }
            }

        }
        return recommendedFilm;
    }

    private Map<Person, Integer> getReviewersScore(Person person, Map<Person, Map<Film, Rating>> ratingsPerReviewer) {
        int totalScore = 0;
        Map<Film, Rating> thisPersonsRatings = new HashMap<>();
        Map<Person, Integer> personRatingsComp = new HashMap<>();

        if (ratingsPerReviewer.containsKey(person)) {
            thisPersonsRatings = ratingsPerReviewer.get(person);
        }

        for (Person p : ratingsPerReviewer.keySet()) {
            if (p.equals(person)) {
                continue;
            }

            for (Film f : ratingsPerReviewer.get(p).keySet()) {
                if (thisPersonsRatings.containsKey(f)) {
                    totalScore += thisPersonsRatings.get(f).getValue() * ratingsPerReviewer.get(p).get(f).getValue();
                }
            }
            personRatingsComp.put(p, totalScore);
            totalScore = 0;
        }
        return personRatingsComp;
    }
}
