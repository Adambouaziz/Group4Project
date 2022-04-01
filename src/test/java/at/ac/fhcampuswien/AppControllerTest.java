package at.ac.fhcampuswien;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppControllerTest {
    List<Article> mock = null;

    @BeforeEach
    void setup(){
        mock = new ArrayList<>();
        Article bitcoinRave = new Article("Steve Smith", "The Bitcoins are raving");
        Article deadCat = new Article("Liliane Haider", "My poor cat, omg...");
        Article floridaMan = new Article("Franz Jospeh", "Florida man burned down house with spaghetti sauce");
        Article transformers = new Article("Shia Lebouf", "Cars are able to speak now...?");
        Article encanto = new Article("Mirabel Madrigal", "I blew out my family's special candle");
        Article cyborgs = new Article("Chris Baker", "Why Cyborgs will endanger our species.");
        Article running = new Article("Ham Middleton", "Is running really healthy?");
        Article doomsday = new Article("Pam Jackson", "Bitcoin doomsday: Why it will fall to 0.");
        Article invest = new Article("Wojak Trapper", "What you should invest all your money in RIGHT NOW!!");
        Article chalamet = new Article("Kitty Kat", "Why is Timothée Chalamet so hot???");
        Article dogs = new Article ("Heute", "Wir suchen die beliebten Hunderassen");
        Article kaliumJod = new Article ("Kleine Zeitung", "Wann man KaliumJod einnehmen sollte");
        Article minister = new Article ("ATV", "Johannes Rauch: Neuer Gesundheitsminister");
        Article boerse = new Article ("Der Standard", " Börsen im freien Fall");
        Article hanf = new Article ("Schaufenster", "Ist Hanf das Bessere Holz?");

        mock.add(bitcoinRave);
        mock.add(deadCat);
        mock.add(floridaMan);
        mock.add(transformers);
        mock.add(encanto);
        mock.add(cyborgs);
        mock.add(running);
        mock.add(doomsday);
        mock.add(invest);
        mock.add(chalamet);
        mock.add(dogs);
        mock.add(kaliumJod);
        mock.add(minister);
        mock.add(boerse);
        mock.add(hanf);
    }

    @Test
    @DisplayName("should filter out every Article where title contains bitcoin")
    public void testFilterList(){
        AppController con = new AppController();
        con.setArticles(mock);

        String test = String.valueOf((con.filterList("Bitcoin", mock)));
        String result = "[Article{author='Steve Smith', title='The Bitcoins are raving'}, Article{author='Pam Jackson', title='Bitcoin doomsday: Why it will fall to 0.'}]";

        assertNotNull(con.filterList("Bitcoin", mock));
        assertEquals(test, result);
    }

    @Test
    @DisplayName("should implement filterList and therefore do the same")
    public void testAllNewsBitcoin(){
        AppController tro = new AppController();
        tro.setArticles(mock);

        String test = String.valueOf(tro.getAllNewsBitcoin());
        String result = String.valueOf(tro.filterList("Bitcoin", mock));

        assertNotNull(test);
        assertEquals(test, result);

    }

    @Test
    @DisplayName("test to see if Article count is right number")
    public void testGetArticleCount(){
        AppController app = new AppController();
        int test = 0;

        test = app.getArticleCount();
        assertNotNull(test);
        assertEquals(15, test);
    }

    @Test
    @DisplayName("should contain Articles")
    public void testSetArticle(){
        AppController app = new AppController();
        app.setArticles(mock);
        assertNotNull(mock);
        assertEquals(mock ,mock);
    }

    @Test
    @DisplayName("should contain a static list of all Articles")
    public void testTopHeadlinesAustria(){
        AppController app = new AppController();
        app.setArticles(mock);
        assertNotNull(mock);

        assertEquals(mock, mock);
    }


}
