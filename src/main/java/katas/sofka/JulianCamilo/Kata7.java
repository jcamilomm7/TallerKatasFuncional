package katas.sofka.JulianCamilo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.sofka.JulianCamilo.model.BoxArt;
import katas.sofka.JulianCamilo.util.DataUtil;
import katas.sofka.JulianCamilo.model.MovieList;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .flatMap(movieList -> movieList.getVideos().stream())
                .map(movie -> {
                    return ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "boxart", boxMenor(movie.getBoxarts()));
                })
                .collect(Collectors.toList());
    }

    public static String boxMenor(List<BoxArt> boxArtList) {
        Optional<BoxArt> result = boxArtList.stream()
                .reduce((x, y) -> x.getWidth() < y.getWidth() ? x : y);
        return result.get().getUrl();
    }
}
