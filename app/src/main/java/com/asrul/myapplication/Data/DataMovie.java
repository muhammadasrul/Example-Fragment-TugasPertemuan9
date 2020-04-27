package com.asrul.myapplication.Data;

import com.asrul.myapplication.R;

import java.util.ArrayList;

public class DataMovie {
    private static String[] movieTitle = {
            "Ad Astra",
            "Sonic the Hedgehog",
            "Bloodshot",
            "365 Days",
            "Underwater",
            "Bad Boys for Life",
            "Exorcist: The Beginning",
            "Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)",
            "Star Wars: The Rise of Skywalker",
            "Onward",
            "A Rainy Day in New York",
            "Jumanji: The Next Level"
    };

    private static String[] movieDirector = {
            "James Gray",
            "Jeff Fowler",
            "Dave Wilson",
            "Barbara Bialowas",
            "William EubankT",
            "Bilall Fallah",
            "Renny Harlin",
            "Cathy Yan",
            "J.J. Abrams",
            "Dan Scanlon",
            "Woody Allen",
            "Jake Kasdan"
    };

    private static String[] movieReleaseDate = {
            "Sep 17, 2019",
            "Feb 12, 2020",
            "Mar 05, 2020",
            "Feb 07, 2020",
            "Jan 08, 2020",
            "Jan 15, 2020",
            "Aug 20, 2004",
            "Feb 05, 2020",
            "Dec 18, 2019",
            "Feb 29, 2020",
            "Jul 26, 2019",
            "Dec 04, 2019"
    };

    private static int[] moviePoster = {
            R.drawable.ad_astra,
            R.drawable.sonic,
            R.drawable.bloodshot,
            R.drawable.days365,
            R.drawable.underwater,
            R.drawable.badboys,
            R.drawable.exorcist,
            R.drawable.birdofpray,
            R.drawable.startwars,
            R.drawable.onward,
            R.drawable.a_rainy_day,
            R.drawable.jumanji
    };

    public static ArrayList<Movie> getMovieList() {
        ArrayList<Movie> list = new ArrayList<>();
        for (int position = 0; position < movieTitle.length; position++) {
            Movie movie = new Movie();
            movie.setTitle(movieTitle[position]);
            movie.setDirector(movieDirector[position]);
            movie.setRelease_date(movieReleaseDate[position]);
            movie.setPoster(moviePoster[position]);
            list.add(movie);
        }
        return list;
    }
}
