package at.ac.fhcampuswien;

import java.util.Objects;
import java.util.Scanner;

public class Menu {

    AppController controller = new AppController();

    private static final String INVALID_INPUT_MESSAGE = "No<3";
    private static final String EXIT_MESSAGE = "See ya later Alligator!";
    String scan;

    public Menu() throws Exception {
    }

    public void start() throws Exception {
        for (int i = 1; i > 0; i++){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose your fighter: ");
            scan = scanner.next();
            handleInput(scan);
        }

    }

    private void handleInput(String input) throws Exception {
        scan = input;
        if (Objects.equals(input, "a")){

            getTopHeadlinesAustria(controller);

        }else if (Objects.equals(input, "b")) {
            getAllNewsBitcoin(controller);
        }else if (Objects.equals(input, "y")){

            getArticleCount(controller);

        }else if (Objects.equals(input, "q")){
            printExitMessage();
            System.exit(0);
        }else{
            printInvalidInputMessage();
        }
    }

    private void getArticleCount(AppController ctrl){

        System.out.println("Article Count seems to be: "+ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl) throws Exception {

        System.out.println(ctrl.getTopHeadlinesAustria());
    }

    private void getAllNewsBitcoin(AppController ctrl){
        System.out.println(ctrl.getAllNewsBitcoin());
    }

    private static void printExitMessage(){System.out.println(EXIT_MESSAGE);}

    private static void printInvalidInputMessage(){System.out.println(INVALID_INPUT_MESSAGE);}

    private static void printMenu(){

        for (int i = 0; i < 30; i++){
            System.out.print("*");
        }

        System.out.println();
        System.out.println("*   Welcome to NewsApp    *");

        for (int i = 0; i < 30; i++){
            System.out.print("*");
        }

        System.out.println();
        System.out.println("Enter what you wanna do:");
        System.out.println("a: Get top headlines Austria");
        System.out.println("b: Get all news about about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}
