package katas.sofka.JulianCamilo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.sofka.JulianCamilo.model.BoxArt;
import katas.sofka.JulianCamilo.model.InterestingMoment;
import katas.sofka.JulianCamilo.util.DataUtil;
import katas.sofka.JulianCamilo.model.MovieList;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> resultado = movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> {
                    return ImmutableMap.of("id",movie.getId(), "title", movie.getTitle(), "time", tiempo(movie.getInterestingMoments()), "url", boxMenor(movie.getBoxarts()));
                })
                .collect(Collectors.toList());

        return resultado;

    }

    public static Date tiempo(List<InterestingMoment> momentList){
        List<InterestingMoment> resultado = momentList.stream()
                .filter(interestingMoment -> interestingMoment.getType().equals("Middle"))
                .collect(Collectors.toList());
        return resultado.get(0).getTime();
    }


    public static String boxMenor(List<BoxArt> boxArtList) {
        Optional<BoxArt> resultado = boxArtList.stream()
                .reduce((x, y) -> x.getWidth() < y.getWidth() ? x : y);
        return resultado.get().getUrl();
    }



}