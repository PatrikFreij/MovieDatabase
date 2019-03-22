package menu;

import service.MovieInfo;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Movie;

public class Menu {

    Scanner sc = new Scanner(System.in);
    MovieInfo movieInfo = new MovieInfo();
    int choice;

    public void menu() {
        try {
            while (true) {
                menuMsg();
                System.out.print("Input: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        System.out.println("Goodbye");
                        System.exit(1);
                        break;
                    case 1:
                        sc.nextLine();
                        System.out.print("What movie are you looking for? ");
                        Movie m = movieInfo.getMovie(sc.nextLine());
                        try {
                            if (m.getTitle().equals(null)) {
                            } else {
                                subMenu(m);
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Nu such film, try again");
                        }
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input valid number");
        }
    }

    public void subMenu(Movie title) {
        try {
            while (true) {
                System.out.println("----------------------------" + title.getTitle() + "----------------------------");
                subMenuMsg();
                System.out.print("Input: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 0:
                        menu();
                        break;
                    case 1:
                        System.out.println(movieInfo.getDirector(title));
                        break;
                    case 2:
                        System.out.println(movieInfo.getYearRelease(title));
                        break;
                    case 3:
                        System.out.println(movieInfo.getIMDBRating(title));
                        break;
                    case 4:
                        System.out.println(movieInfo.getPlot(title));
                        break;
                    case 5:
                        System.out.println(movieInfo.getInfo(title));
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input valid number");
        }
    }

    public void menuMsg() {
        System.out.println("0. EXIT \n1. Search Movie by title");
    }

    public void subMenuMsg() {
        System.out.println("0. Back to main menu \n1. Get director \n2. Get year of release \n3. Get rating \n4. Get plot \n5. Get all info");
    }

}
