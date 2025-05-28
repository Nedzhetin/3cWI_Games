package at.nejo.SemesterTest;

public class AudioBook extends AbstractBook{
    public AudioBook(int id, String title, float price, String description) {
        super(id, title, price, description);
    }

    public void playSample() {
        System.out.println("Playing sample of audiobook: " + getTitle());
    }
}
