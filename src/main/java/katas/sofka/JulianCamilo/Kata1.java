package katas.sofka.JulianCamilo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.sofka.JulianCamilo.model.Movie;
import katas.sofka.JulianCamilo.util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Map> resultado =movies.stream()
                .map(movie ->{
                    return ImmutableMap.of("id", movie.getId(), "title", movie.getTitle());
                })
                .collect(Collectors.toList());

        return  resultado;
    }
}
