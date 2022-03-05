package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {

    AppController controller = new AppController();

    private static final String INVALID_INPUT_MESSAGE = null;
    private static final String EXIT_MESSAGE = null;

    public void start(){
        printMenu();
        handleInput("");

    }

    private void handleInput(String input){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        s = input;
        if (input == "a"){

        }else if (input == "b"){

        }else if (input == "y"){

        }else if (input == "q"){

        }else{
            System.out.println(INVALID_INPUT_MESSAGE);
        }
    }

    private void getArticleCount(AppController ctrl){}

    private void getTopHeadlinesAustria(AppController ctrl){}

    private void getAllNewsBitcoin(AppController ctrl){}

    private static void printExitMessage(){}

    private static void printInvalidInputMessage(){}

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
