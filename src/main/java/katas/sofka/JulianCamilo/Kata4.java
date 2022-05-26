package katas.sofka.JulianCamilo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import katas.sofka.JulianCamilo.model.Movie;
import katas.sofka.JulianCamilo.util.DataUtil;
import katas.sofka.JulianCamilo.model.BoxArt;
import katas.sofka.JulianCamilo.model.MovieList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> listResultado = movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(listaVideos -> listaVideos.stream())
                .map(video -> {
                    return ImmutableMap.of("id", video.getId(),
                            "title", video.getTitle(),
                            "boxart", video.getBoxarts().stream()
                                    .filter(boxArt -> boxArt.getHeight() == 200 && boxArt.getWidth() == 150));
                })
                .collect(Collectors.toList());
        System.out.println(listResultado);
        return listResultado;

    }
}
