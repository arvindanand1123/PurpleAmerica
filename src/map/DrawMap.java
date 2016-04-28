package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DrawMap {

    File file;

    public DrawMap() {
        file = new File("C:\\Users\\hcps-ananda\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\USA-county.txt");

    }

    public void populateMap() throws FileNotFoundException, IOException {
        double[] ary1;
        double[] ary2;
        StdDraw.setCanvasSize(1000, 500);
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
                StdDraw.filledPolygon(ary1, ary2);
                StdDraw.setPenColor(Color.decode("#3385ff"));
                StdDraw.polygon(ary1, ary2);

            } else {
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.filledPolygon(ary1, ary2);
                StdDraw.setPenColor(Color.decode("#3385ff"));
                StdDraw.polygon(ary1, ary2);
            }
        }

    }
}
