package service;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import model.Movie;

public class MovieInfo {
    
    WebTarget target;
    String REST_URI = "http://www.omdbapi.com/?apikey=[MyApiKey]";
    javax.ws.rs.client.Client client = ClientBuilder.newClient();
    
    public Movie getMovie(String title) {
        title = title.replace(" ", "+");
        return client.target(REST_URI + "t=" + title).request(MediaType.APPLICATION_JSON).get(Movie.class);
    }
    
    public String getDirector(Movie dir) {
        return "Director: " + dir.getDirector();
    }
    
    public String getYearRelease(Movie year) {
        return "Release year: " + year.getYear();
    }
    
    public String getActors(Movie actor) {
        return "Actors: " + actor.getActors();
    }
    
    public String getIMDBRating(Movie rating) {
        return "IMDB Rating: " + rating.getImdbRating();
    }
    
    public String getPlot(Movie plot) {
        return "Plot: " + plot.getPlot();
    }
    
    public String getInfo(Movie info) {
        return "Title: " + info.getTitle() + "\nDirector: " + info.getDirector() + "\nYear: " + info.getYear() + "\nIMDB Rating: " + info.getImdbRating();
    }
}
