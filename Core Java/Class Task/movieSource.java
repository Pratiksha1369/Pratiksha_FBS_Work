class Movie {
    String title;
    String genre;
    int duration;
    double rating;

    void setTitle(String title) {
        this.title = title;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    void setDuration(int duration) {
        this.duration = duration;
    }

    void setRating(double rating) {
        this.rating = rating;
    }
} //Movie ends here

class MovieTest {
    public static void main(String[] args) {
        Movie m1;
        m1 = new Movie();
        m1.setTitle("Inception");
        m1.setGenre("Sci-Fi");
        m1.setDuration(148);
        m1.setRating(8.8);

        System.out.println("Title: " + m1.title);
        System.out.println("Genre: " + m1.genre);
        System.out.println("Duration: " + m1.duration + " mins");
        System.out.println("Rating: " + m1.rating);
    } //main ends here
} //MovieTest ends here
