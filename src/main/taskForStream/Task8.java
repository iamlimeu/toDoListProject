package main.taskForStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Task8 {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", 2010),
                new Movie("The Dark Knight", 2008),
                new Movie("Interstellar", 2014),
                new Movie("Dunkirk", 2017)
        );

        movies.stream()
                .sorted(Comparator.comparingInt(Movie::getReleaseYear).reversed())
                .map(Movie::getTitle)
                .forEach(System.out::println);


    }
}

class Movie {
    String title;
    int releaseYear;

    public Movie(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
}