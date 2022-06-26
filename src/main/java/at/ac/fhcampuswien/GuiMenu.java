package at.ac.fhcampuswien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuiMenu extends JFrame implements ActionListener{
    AppController app = AppController.getInstance();

    String[] choices = { "a", "b", "y", "q" };
    JComboBox box = new JComboBox(choices);

    TextArea area = new TextArea();
    JFrame frame = new JFrame();

    Color myColor = new Color(55, 37, 71);
    Color paneColor = new Color(175, 204, 250);
    Color areaColor = new Color(216, 184, 245);
    Font myFont = new Font("Send Flowers", Font.ITALIC, 40);
    Font areaFont = new Font("Area Font", Font.ROMAN_BASELINE, 20);

    private static final String EXIT_MESSAGE = "See ya later Alligator!";
    List<Article> text = new ArrayList<>();
    int count;

    public GuiMenu() throws Exception {
        Container pane = frame.getContentPane();
        JLabel welcome = new JLabel("**Welcome to this beautiful News App!**");
        JLabel label1 = new JLabel( "<html><h2>Choose what to do: </h2><html>" +
                "<html><p>To get all the top headlines in Austria choose -a-<p><html>" +
                "<html>To get all articles with the word Bitcoin in it's title choose -b-<br><html>" +
                "<html>To get the total sum of all articles choose -y-<br><html>" +
                "<html>To exit the News App choose -q-<br><html>");

        frame.setLocation(500, 250);
        frame.setTitle("** News App **");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        pane.add(box, BorderLayout.CENTER);
        pane.setBackground(paneColor);
        pane.add(area, BorderLayout.PAGE_END);
        pane.add(welcome, BorderLayout.PAGE_START);
        pane.add(label1, BorderLayout.LINE_START);

        Dimension d = new Dimension(3, 40);

        label1.setBorder(BorderFactory.createBevelBorder(4, Color.PINK, myColor));
        welcome.setBorder(BorderFactory.createMatteBorder(3,3,3,3,myColor));
        welcome.setBackground(Color.pink);
        welcome.setFont(myFont);


        area.setFont(areaFont);
        area.setBackground(areaColor);


        box.setSelectedIndex(3);
        box.setBorder(BorderFactory.createMatteBorder(0,2,2,2,myColor));
        box.setMaximumSize(d);
        box.addActionListener(this::actionPerformed);
        box.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = (String) box.getSelectedItem();

        if (Objects.equals(s, "a")){
            try {
                text = app.getTopHeadlinesAustria();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            area.setText(String.valueOf(text));

        }else if (Objects.equals(s, "b")){
            text = app.getAllNewsBitcoin();
            area.setText(String.valueOf(text));

        }else if (Objects.equals(s, "y")){
            count = app.getArticleCount();
            area.setText(String.valueOf(count));

        }else if (Objects.equals(s, "q")){
            area.setText(EXIT_MESSAGE);
            System.exit(0);
        }
    }
}
