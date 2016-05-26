package map;


import java.awt.Component;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hcps-shehzadst
 */
public class ScreenCapture {
    public void captureComponent(Component component) {
        Rectangle rect = component.getBounds();

        try {
            String format = "png";
            String fileName = "results" + "." + format;
            BufferedImage captureImage =
                    new BufferedImage(rect.width, rect.height,
                                        BufferedImage.TYPE_INT_ARGB);
            component.paint(captureImage.getGraphics());

            ImageIO.write(captureImage, format, new File(fileName));

            System.out.printf("The screenshot of the results was saved!", component.getName());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
