package at.ac.fhcampuswien;

import Enums.Category;
import Enums.Country;
import Enums.Language;

public class App {
    public static void main(String[] args) throws Exception {
        /*Menu menu = new Menu();
        menu.start();*/

        NewsApi newsApi = new NewsApi();
        System.out.println(newsApi.response(newsApi.howToUrlTopHeadlines(Language.GERMAN, Category.GENERAL, Country.AUSTRIA)));

        /*GuiMenu guiMenu = new GuiMenu();
        guiMenu.pack();*/

    }
}