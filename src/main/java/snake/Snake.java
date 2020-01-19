package snake;

import javax.swing.*;
import java.awt.*;

public class Snake {

    public JFrame jFrame;

    public static Snake snake;

    public Snake() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame = new JFrame("Snake");
        jFrame.setVisible(true);
        jFrame.setSize(800, 600);
        jFrame.setLocation(dim.width / 2 * jFrame.getWidth() / 2, dim.height / 2 * jFrame.getHeight() / 2);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        snake = new Snake();


    }

}
