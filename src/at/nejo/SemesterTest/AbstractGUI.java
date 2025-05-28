package at.nejo.SemesterTest;

import java.util.Scanner;

public abstract class AbstractGUI {
    private LibraryManager libraryManager;
    private Scanner scanner = new Scanner(System.in);
    private String name;

    public AbstractGUI(LibraryManager libraryManager, String name) {
        this.libraryManager = libraryManager;
        this.name = name;
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }

    public void showUI() {
        System.out.println("Welcome to the " + name);
        System.out.println("1. Get all media");
        System.out.println("2. Calculate total media value");
    }

    public void start(){
        while (true) {
            showUI();
            System.out.println("---------------------------------");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    libraryManager.getAllMedia();
                    break;
                case 2:
                    libraryManager.calculateTotalMediaValue();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


}
