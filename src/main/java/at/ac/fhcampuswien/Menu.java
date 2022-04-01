package at.ac.fhcampuswien;

import java.util.Objects;
import java.util.Scanner;

public class Menu {

    AppController controller = new AppController();

    private static final String INVALID_INPUT_MESSAGE = "No<3";
    private static final String EXIT_MESSAGE = "See ya later Alligator!";
    String scan;

    public void start(){
        for (int i = 1; i > 0; i++){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose your fighter: ");
            scan = scanner.next();
            handleInput(scan);
        }

    }

    private void handleInput(String input){
        scan = input;
        if (Objects.equals(input, "a")){

        }else if (Objects.equals(input, "b")) {
            getAllNewsBitcoin(controller);



        }else if (Objects.equals(input, "y")){

        }else if (Objects.equals(input, "q")){
            printExitMessage();
            System.exit(0);
        }else{
            printInvalidInputMessage();
        }
    }

    private void getArticleCount(AppController ctrl){}

    private void getTopHeadlinesAustria(AppController ctrl){}

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
        System.out.println("*   Welcome to Newsapp    *");

        for (int i = 0; i < 30; i++){
            System.out.print("*");
        }

        System.out.println();
        System.out.println("Enter what you want to do:");
        System.out.println("a: Get top headlines Austria");
        System.out.println("b: Get all news about about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}
