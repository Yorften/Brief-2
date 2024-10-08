package src.presentation.menus;

import java.util.Scanner;

import src.presentation.interfaces.Menu;

public class MainMenu implements Menu {
    private Menu userMenu;
    private Menu documentMenu;
    private Menu reservatioMenu;

    Scanner in = new Scanner(System.in).useDelimiter(System.lineSeparator());

    public MainMenu(Menu userMenu, Menu documentMenu, Menu reservatioMenu) {
        this.userMenu = userMenu;
        this.documentMenu = documentMenu;
        this.reservatioMenu = reservatioMenu;
    }

    @Override
    public void display() {
        System.out.println("\n\t\t+----------------------------------------+");
        System.out.println("\t\t|                MAIN MENU               |");
        System.out.println("\t\t+----------------------------------------+");
        System.out.println("\t\t|                                        |");
        System.out.println("\t\t|     1- Manage Users                    |");
        System.out.println("\t\t|     2- Manage Documents                |");
        System.out.println("\t\t|     3- Manage Reservations             |");
        System.out.println("\t\t|     4- Exit                            |");
        System.out.println("\t\t|                                        |");
        System.out.println("\t\t+----------------------------------------+");
        System.out.print("Pick your choice : ");
    }

    @Override
    public int getChoice() {
        int input = -1;
        try {
            input = in.nextInt();
            if (input < 1 || input > 4) {
                System.out.println("Please pick a choice between 1 and 4...");
                in.next();
            }
        } catch (Exception e) {
            System.out.println("Please pick a valid number...");
            in.next();
        }
        return input;
    }

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                userMenuLoop();
                break;
            case 2:
                documentMenuLoop();
                break;
            case 3:
                reservationMenuLoop();
                break;
            case 4:
                System.out.println("Exiting...");
                break;
            default:
                break;
        }
    }

    private void userMenuLoop() {
        int choice;
        do {
            userMenu.display();
            choice = userMenu.getChoice();
            userMenu.handleChoice(choice);
        } while (choice != 5);
    }

    private void documentMenuLoop() {
        int choice;
        do {
            documentMenu.display();
            choice = documentMenu.getChoice();
            documentMenu.handleChoice(choice);
        } while (choice != 4);
    }

    private void reservationMenuLoop() {
        int choice;
        do {
            reservatioMenu.display();
            choice = reservatioMenu.getChoice();
            reservatioMenu.handleChoice(choice);
        } while (choice != 3);
    }

}
