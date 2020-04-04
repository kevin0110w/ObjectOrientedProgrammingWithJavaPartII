/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author woohoo
 */
public class FilmComparator implements Comparator<Film>{
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    public double getAverageRating(Film film) {
        if (!this.ratings.containsKey(film)) {
            return 0.0;
        }
        int sum = 0;
        List<Rating> filmRatings = this.ratings.get(film);
        for (Rating r : filmRatings) {
            sum += r.getValue();
        }
        double average = (1.0 * sum) / filmRatings.size();
        return average;
    }
    
    @Override
    public int compare(Film o1, Film o2) {
        if (getAverageRating(o1) > getAverageRating(o2)) {
            return -1;
        } else if (getAverageRating(o2) > getAverageRating(o1)) {
            return 1;
        } else {
            return 0;
        }
    }
    
}
