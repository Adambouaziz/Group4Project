package at.ac.fhcampuswien;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    AppController controller = new AppController();

    private static final String INVALID_INPUT_MESSAGE = "No<3";
    private static final String EXIT_MESSAGE = "See ya later Alligator<3!";
    String scan;


    public void start() throws IOException {
        for (int i = 1; i > 0; i++){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Choose your fighter: ");
            scan = scanner.next();
            handleInput(scan);
        }

    }

    private void handleInput(String input) throws IOException {
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

        }else if (Objects.equals(input, "ab1") && controller.getArticles() != null){

            getMostCommonSources(controller);

        }else if (Objects.equals(input, "ab2") && controller.getArticles() != null){

            getLongestAuthorName(controller);

        }else if (Objects.equals(input, "ab3") && controller.getArticles() != null){

            getNewYorkTimesArticleCount(controller);

        }else if (Objects.equals(input, "ab4") && controller.getArticles() != null) {

            getShortHeadlines(controller);

        }else if (Objects.equals(input, "ab5") && controller.getArticles() != null) {

            getDescriptionSorted(controller);

        }else{
            printInvalidInputMessage();
        }
    }

    private void getArticleCount(AppController ctrl){

        System.out.println("Article Count seems to be: "+ctrl.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl) {

        System.out.println(ctrl.getTopHeadlinesAustria());
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        System.out.println(ctrl.getAllNewsBitcoin());
    }

    private void getMostCommonSources(AppController ctrl){
        System.out.println(ctrl.getMostCommonSources());
    }

    private void getLongestAuthorName(AppController ctrl){
        System.out.println(ctrl.getLongestAuthorName());
    }

    private void getNewYorkTimesArticleCount(AppController ctrl){
        System.out.println(ctrl.getNewYorkTimesArticleCount());
    }

    private void getShortHeadlines(AppController ctrl){
        System.out.println(ctrl.getShortHeadlines());
    }

    private void getDescriptionSorted(AppController ctrl){
        System.out.println(ctrl.getDescriptionSorted());
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
        System.out.println("  ab1: Get most popular sources");
        System.out.println("  ab2: Get longest author name");
        System.out.println("  ab3: Get NewYorkTimes article count");
        System.out.println("  ab4: Get short articles");
        System.out.println("  ab5: Get your article descriptions sorted");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }
}
