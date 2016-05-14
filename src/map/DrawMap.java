package map;

import edu.princeton.cs.introcs.StdDraw;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DrawMap {

    String path;

    public DrawMap(String s) {
        path = s;

    }

    public void populateMap(String dataPath) throws FileNotFoundException, IOException {
        double[] ary1;
        double[] ary2;
        StdDraw.setCanvasSize(1000, 500);
        File file = new File(path);
        File data = new File(dataPath);
        Scanner dataScan = new Scanner(data.getAbsoluteFile());
        dataScan.useDelimiter("[^\\\\p{Alnum},\\\\.-]");
        Scanner scanner = new Scanner(file.getAbsoluteFile());
        double latMin = scanner.nextDouble();
        double longMin = scanner.nextDouble();
        double latMax = scanner.nextDouble();
        double longMax = scanner.nextDouble();
        int regionNumber = scanner.nextInt();
        StdDraw.setXscale(latMin - 1, latMax + 1);
        StdDraw.setYscale(longMin - 1, longMax + 1);
        dataScan.nextLine();
        scanner.next(); 
        double[] r = new double[50];
        double[] g = new double[50];
        double[] b = new double[50];
        int p = 0;
        while (dataScan.hasNextLine()) {
            if(dataScan.hasNextInt()){
                System.out.println(dataScan.nextInt());
            } else{
                System.out.println(false);
            }
        }
        for (int x = 0; x < regionNumber; x++) {
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
                //Color color = new Color((int) Math.ceil(100.0 * r), (int) Math.ceil(100.0 * g), (int) Math.ceil(100.0 * b));
                StdDraw.setPenColor(Color.blue);
                StdDraw.filledPolygon(ary1, ary2);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.polygon(ary1, ary2);

            } else {
                //Color color = new Color((int) Math.ceil(100.0 * r), (int) Math.ceil(100.0 * g), (int) Math.ceil(100.0 * b));
                StdDraw.setPenColor(Color.blue);
                StdDraw.filledPolygon(ary1, ary2);
                StdDraw.setPenColor(Color.BLACK);
                StdDraw.polygon(ary1, ary2);
            }

        }
    }
}
