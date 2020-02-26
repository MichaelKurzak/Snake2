package snake;

import javax.swing.*;
import java.awt.*;

public class Snake extends Key {

    public JFrame jframe;
    public int score, tailLength = 10, time;
    public Dimension dim;

    public Snake() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(617, 639);
        jframe.setResizable(false);
        jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2,
                dim.height / 2 - jframe.getHeight() / 2);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addKeyListener(this);
        startGame();
    }


}




