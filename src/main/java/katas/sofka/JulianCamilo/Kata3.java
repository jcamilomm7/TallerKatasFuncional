package katas.sofka.JulianCamilo;

import com.google.common.collect.ImmutableList;
import katas.sofka.JulianCamilo.model.MovieList;
import katas.sofka.JulianCamilo.util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Integer> resultado = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(video -> video.stream())
                .map(movie -> movie.getId())
                .collect(Collectors.toList())
                ;
        return resultado;
    }
}