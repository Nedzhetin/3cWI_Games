package at.nejo.SemesterTest;

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();

        AudioBook audioBook = new AudioBook(1, "beste Audiobook", 9.99f, "Ein Hörbuch");

        libraryManager.addMedia(new Roman(1, "Der Prozess", 12.99f, "Ein Roman von Nedzhetin Nedzhetin", "Drama"));
        libraryManager.addMedia(new Roman(2, "Der Roman", 15.99f, "Ein Roman von Manasek", "Drama"));
        libraryManager.addMedia(audioBook);

        audioBook.playSample();
        GUI1 gui1 = new GUI1(libraryManager, "GUI1");
        GUI2 gui2 = new GUI2(libraryManager, "GUI2");

        gui2.start();

    }
}
