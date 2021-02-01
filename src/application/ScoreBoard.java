package application;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Andrew
 * Class creates an ArrayList of Points, that is used to create methods that addpoints, save to file and read from file.
 */
public class ScoreBoard {
    private static ArrayList<Points> scores = new ArrayList<Points>();
    public static boolean closed = false;

    /**
     * Method to add points for each player and add it to file
     */
    public static void addPoints (Points playerPoints) {
        scores.add(playerPoints);

        savePointsToFile();
    }

    public static ArrayList<Points> getScores() {
        return scores;
    }
    /**
     * Method saves name and points to file via a PrintWriter
     */
    private static void savePointsToFile() {
        try {
            File f = new File("points.txt");
            PrintWriter p = new PrintWriter(new
                    FileOutputStream(f));
            if (!f.exists()) {
                f.createNewFile();
            } else {
                for (int i = 0; i < scores.size(); i ++){
                    Points score = scores.get(i);
                    p.println(score.getName() + " " + score.getPoints());
                }
            }
            p.close();
            closed = true;
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Method reads points from file, is used to create file and store points for multiple games.
     */
    public static void readPointsFile() {
        try {
            File f = new File("points.txt");
            if (!f.exists()) {
                f.createNewFile();
            }

            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String[] line = in.nextLine().split(" ");
                Points score = new Points(line[0], Integer.parseInt(line[1]));
                scores.add(score);
            }
            in.close();
            closed = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
