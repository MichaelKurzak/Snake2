package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Snake implements ActionListener {

    public JFrame jframe;

    public RenderPanel renderPanel;

    public Timer timer = new Timer(20, this);

    public static Snake snake;

    public ArrayList<Point> snakeParts = new ArrayList<Point>();

    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;

    public int ticks = 0, direction = DOWN;

    public Point head;

    public Snake() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(600, 600);
        jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2,
                dim.height / 2 - jframe.getHeight() / 2);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        head = new Point(0, 0);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        renderPanel.repaint();
        ticks++;

        if (ticks % 10 == 0) {
            if (direction == UP)
            snakeParts.add(new Point(head.x, head.y - 1));
            if (direction == DOWN)
            snakeParts.add(new Point(head.x, head.y + 1));
            if (direction == LEFT)
            snakeParts.add(new Point(head.x - 1, head.y));
            if (direction == RIGHT)
            snakeParts.add(new Point(head.x  + 1, head.y));
        }
    }

    public static void main(String[] args) {
        snake = new Snake();
    }

}

