package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Snake implements ActionListener {

    public JFrame jframe;
    public RenderPanel renderPanel;
    public Timer timer = new Timer(20, this);
    public static Snake snake;
    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
    public int ticks = 0, direction = DOWN;
    public Point head, cherry;
    public Random random;
    public boolean over = false;
    public Dimension dim;
    public int score;

    public Snake() {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(600, 600);
        jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2,
                dim.height / 2 - jframe.getHeight() / 2);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        head = new Point(0, 0);
        random = new Random();
        cherry = new Point(dim.width / SCALE, dim.height / SCALE);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        renderPanel.repaint();
        ticks++;

        if (ticks % 10 == 0 && head != null && !over) {
            if (direction == UP)
                if (head.y - 1 > 0)
                    snakeParts.add(new Point(head.x, head.y - 1));
                else
                    over = true;
            if (direction == DOWN)
                if (head.y + 1 < dim.height / SCALE)
                    snakeParts.add(new Point(head.x, head.y + 1));
                else
                    over = true;
            if (direction == LEFT)
                if (head.x - 1 > 0)
                    snakeParts.add(new Point(head.x - 1, head.y));
                else
                    over = true;
            if (direction == RIGHT)
                if (head.y + 1 < dim.width / SCALE)
                    snakeParts.add(new Point(head.x + 1, head.y));
                else
                    over = true;
            if (cherry != null) {
                if (head.equals(cherry)) {
                    score++;
                    cherry.setLocation(dim.width / SCALE, dim.height / SCALE);

                }

            }

        }

    }

    public static void main(String[] args) {
        snake = new Snake();
    }

}

