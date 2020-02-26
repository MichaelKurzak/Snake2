package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Action implements ActionListener {

    public RenderPanel renderPanel;
    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    public static final int SCALE = 10, UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    public int ticks = 0, direction = DOWN, score, tailLength = 10, time;
    public Point head, cherry;
    public Random random;
    public boolean over = false, paused;
    public static Snake snake;

    @Override
    public void actionPerformed(ActionEvent arg0) {
        renderPanel.repaint();
        ticks++;

        if (ticks % 2 == 0 && head != null && !over && !paused) {
            time++;
            snakeParts.add(new Point(head.x, head.y));
            if (direction == UP)
                if (head.y - 1 >= 0 && noTailAt(head.x, head.y - 1))
                    head = new Point(head.x, head.y - 1);
                else
                    over = true;
            if (direction == DOWN)
                if (head.y + 1 < 60 && noTailAt(head.x, head.y + 1))
                    head = new Point(head.x, head.y + 1);
                else
                    over = true;
            if (direction == LEFT)
                if (head.x - 1 >= 0 && noTailAt(head.x - 1, head.y))
                    head = new Point(head.x - 1, head.y);
                else
                    over = true;
            if (direction == RIGHT)
                if (head.x + 1 < 60 && noTailAt(head.x + 1, head.y))
                    head = new Point(head.x + 1, head.y);
                else
                    over = true;
            if (snakeParts.size() > tailLength)
                snakeParts.remove(0);
            if (cherry != null) {
                if (head.equals(cherry)) {
                    score += 10;
                    tailLength++;
                    cherry.setLocation(random.nextInt(60), random.nextInt(60));
                }
            }
        }

    }

    public boolean noTailAt(int x, int y) {
        for (Point point : snakeParts) {
            if (point.equals(new Point(x, y))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        snake = new Snake();
    }
}
