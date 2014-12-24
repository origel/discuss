package org.rigelos.discuss.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

    private static final Font font = new Font("Tahoma", Font.PLAIN, 24);
     public static final BufferedImage getImage(char ch, int size) { 
            BufferedImage newPic = new BufferedImage(size, size, BufferedImage.TYPE_3BYTE_BGR); 

            Graphics2D g = newPic.createGraphics();
            g.setColor(Color.WHITE);
            //g.fillRect(0, 0, size, size);

            g.setFont(font);
            FontMetrics fm = g.getFontMetrics();
            int strWidth = fm.stringWidth(String.valueOf(ch)); // 这样可以得到字符串的长度(像素),字符串的高度一般是字体的大小
            int height = fm.getHeight();
            System.out.println(fm.getAscent());
            System.out.println(fm.getDescent());
            System.out.println(fm.getLeading());
            g.drawString(String.valueOf(ch), (size - strWidth) / 2, (size - height) / 2 + fm.getAscent() + 1); 
            return newPic; 
        }

     public static void main(String[] args) {
        try {
            ImageIO.write(getImage('C', 32), "png", new File("d:\\1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
