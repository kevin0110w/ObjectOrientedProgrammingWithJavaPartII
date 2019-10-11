/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author woohoo
 */
public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = new HashMap<Film, List<Rating>>(ratings);
    }
    
    @Override
    public int compare(Film t, Film t1) {
        int counterT = 0; 
        int counterT1 = 0;
        int totalFilmRatingT = 0;
        int totalFilmRatingT1 = 0;

        for (Rating r : this.ratings.get(t)) {
                totalFilmRatingT += r.getValue();
                counterT++;
            }
        
        for (Rating r : this.ratings.get(t1)) {
                totalFilmRatingT1 += r.getValue();
                counterT1++;
            }
        
        double averageFilmRatingT = totalFilmRatingT / counterT;
        double averageFilmRatingT1 = totalFilmRatingT1 / counterT1;
        
        if (averageFilmRatingT < averageFilmRatingT1) {
            return 1;
        } else if (averageFilmRatingT > averageFilmRatingT1) {
            return -1;
        } else {
            return 0;
        }
    }
}
