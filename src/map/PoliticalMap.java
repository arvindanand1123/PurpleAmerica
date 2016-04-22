/*
 * Political Map Project
 *
 * Name: Arvind Anand, Christian Womack, Tahir(Syed) Shezad
 * Block:7
 *
 * Program Purpose:
 *  vAlpha 1.1: Prints map of USA. Map is blue. Paints with borders.
 *
 * Algorithm:
 *  vAlpha 1.1: Basic algorithm; prints
 * Future/possible improvements: Only a working map, need to build project off of this template
 *
 */
package map;

import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author
 */
public class PoliticalMap extends JFrame {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PoliticalMap().setVisible(true);
            }
        });
        try {
            populateMap();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PoliticalMap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//For Commit
    public static void populateMap() throws FileNotFoundException {
        File file = new File("C:\\Users\\hcps-womackcz\\Documents\\PurpleAmerica_Anand_Shezad_Womack\\src\\data\\USA-county.txt");
        double[] ary1;
        double[] ary2;
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setPenColor(Color.decode("#3385ff"));
        Scanner scanner = new Scanner(file);
        double latMin = scanner.nextDouble();
        double longMin = scanner.nextDouble();
        double latMax = scanner.nextDouble();
        double longMax = scanner.nextDouble();
        int regionNumber = scanner.nextInt();
        StdDraw.setXscale(latMin - 1, latMax + 1);
        StdDraw.setYscale(longMin - 1, longMax + 1);
        scanner.next();
        for (int x = 0; x < regionNumber; x++) {
            //Found no use for these two variables quite yet
            String state = scanner.nextLine();
            String district = scanner.nextLine();
            int pointNumber = scanner.nextInt();
            ary1 = new double[pointNumber];
            ary2 = new double[pointNumber];
            int i = 0;
            while (scanner.hasNextDouble() || scanner.hasNextInt()) {
                ary1[i] = scanner.nextDouble();
                ary2[i] = scanner.nextDouble();
                i++;
            }
            if (scanner.hasNext()) {
                scanner.next();
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.polygon(ary1, ary2);
                StdDraw.setPenColor(Color.decode("#3385ff"));
                StdDraw.filledPolygon(ary1, ary2);

            } else {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.polygon(ary1, ary2);
                StdDraw.setPenColor(Color.decode("#3385ff"));
                StdDraw.filledPolygon(ary1, ary2);

            }
        }

    }

}
