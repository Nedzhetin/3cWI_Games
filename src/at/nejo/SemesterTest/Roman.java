package at.nejo.SemesterTest;

public class Roman extends AbstractBook{
    private String genre;

    public Roman(int id, String title, float price, String description, String genre) {
        super(id, title, price, description);
        this.genre = genre;
    }


    public String getGenre() {
        return genre;
    }
}
