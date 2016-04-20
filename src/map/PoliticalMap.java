/*
 * Political Map Project
 * Name:
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;

import edu.princeton.cs.introcs.*;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author
 */
public class PoliticalMap {
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\hcps-ananda\\Documents\\NetBeansProjects\\PurpleAmerica\\src\\data\\USA.txt");
        double[] ary1;
        double[] ary2;
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setPenColor(Color.decode("#3385ff"));
        Scanner scanner = new Scanner(file);
        /**
         * Rather messy code here, fill the nextDouble calls with variables.
         */
        scanner.nextDouble();
        scanner.nextDouble();
        scanner.nextDouble();
        scanner.nextDouble();
        //Unused, I don't know why we need this actually
        int regionNumber = scanner.nextInt();
        StdDraw.setXscale(-125.731216, -66.980385);
        StdDraw.setYscale(24.544102, 49.384365);
        scanner.next();
        while (scanner.hasNext() || scanner.hasNextDouble()) {
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
                StdDraw.filledPolygon(ary1, ary2);
            } else {
                StdDraw.filledPolygon(ary1, ary2);
            }
        }
        
    }
}
