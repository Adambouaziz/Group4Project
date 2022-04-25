package at.ac.fhcampuswien;

public class App {
    public static void main(String[] args) throws Exception {
        /*Menu menu = new Menu();
        menu.start();*/

        /*GuiMenu guiMenu = new GuiMenu();
        guiMenu.pack();*/

        NewsApi news = new NewsApi();
        news.run();
    }
}