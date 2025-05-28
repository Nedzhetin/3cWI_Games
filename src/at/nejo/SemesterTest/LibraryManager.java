package at.nejo.SemesterTest;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<AbstractBook> books = new ArrayList<AbstractBook>();



    public void addMedia(AbstractBook book) {
        if (books == null) {
            return;
        }
        books.add(book);
    }

    public void getAllMedia() {
        System.out.println("");
        if (books == null || books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (AbstractBook book : books) {
            System.out.println("Title: " + book.getTitle());

        }
        System.out.println("");
    }

    public void calculateTotalMediaValue() {
        System.out.println("");
        if (books == null || books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        float totalValue = 0;
        for (AbstractBook book : books) {
            totalValue += book.getPrice();
        }
        System.out.println("Total value of all books: " + totalValue);
        System.out.println("");
    }
}

