package Services;

import Entities.Movie;
import Entities.Screen;
import Entities.Show;
import Enums.City;
import Entities.Theatre;

import java.time.LocalDate;
import java.util.*;

public class TheatreService {
    Map<City, List<Theatre>> cityTheatreList = new HashMap<>();

    public void addTheatre(Theatre theatre){
        cityTheatreList.computeIfAbsent(theatre.getCity(), c -> new java.util.ArrayList<>()).add(theatre);
    }

    public Set<Movie> getMoviesByCity(City city, LocalDate date){
        Set<Movie> movies = new HashSet<>();
        List<Theatre> theatres = cityTheatreList.getOrDefault(city, List.of());

        for (Theatre theatre : theatres){
            for (Screen screen: theatre.getScreenList()){
                for (Show show : screen.getShowsByDate(date)){
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }

    public List<Theatre> getTheatres(City city, Movie movie, LocalDate date){
        List<Theatre> theatres = cityTheatreList.getOrDefault(city, List.of());

        //Give me all theatres that have at least one screen which has at least one show on the given date where the movie matches the requested movie.
        return theatres.stream()
                .filter(t-> t.getScreenList().stream()
                        .anyMatch(screen -> screen.getShowsByDate(date).stream()
                                .anyMatch(show -> show.getMovie().equals(movie)))).toList();
    }

    public List<Show> getShows(Movie movie, LocalDate date, Theatre theatre){
        List<Show> shows = new ArrayList<>();

        for (Screen screen: theatre.getScreenList()){
            for (Show show : screen.getShowsByDate(date)){
                if(show.getMovie().equals(movie)){
                    shows.add(show);
                }
            }
        }
        return shows;
    }
}
