package katas.sofka.JulianCamilo;

import katas.sofka.JulianCamilo.util.DataUtil;
import katas.sofka.JulianCamilo.model.Movie;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Movie>max = movies.stream()
                .reduce((acumu,rating)->{
                    if (acumu.getRating() > rating.getRating())
                        return acumu;
                    else if (acumu.getRating() == rating.getRating())
                        return acumu;

                    return rating;
                })
                .stream().collect(Collectors.toList());

        Double MAX = max.get(0).getRating();
        System.out.println(MAX);
        return (MAX);
    }
}