package katas.sofka.JulianCamilo;

import katas.sofka.JulianCamilo.util.DataUtil;
import katas.sofka.JulianCamilo.model.Movie;

import java.util.List;

import static java.util.stream.Collectors.toList;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Movie> moviesFiltradas = movies.stream()
                .filter(element -> element.getRating() == 5)
                .collect(toList());

        List<Integer> listEnteros = moviesFiltradas.stream()
                .map(element -> element.getRating().intValue())
                .collect(toList());

        return listEnteros;
    }
}
