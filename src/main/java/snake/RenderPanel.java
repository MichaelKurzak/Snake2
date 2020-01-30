package snake;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    public static int curColor = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(curColor));
        g.fillRect(0, 0, 600, 600);
        curColor++;
        Snake snake = Snake.snake;
        g.setColor(Color.BLUE);
        for (Point point : snake.snakeParts) {
            g.fillRect(point.x * Snake.SCALE, point.y * Snake.SCALE,
                    Snake.SCALE, Snake.SCALE);
        }
        g.fillRect(snake.head.x * Snake.SCALE, snake.head.y * Snake.SCALE,
                Snake.SCALE, Snake.SCALE);
        g.setColor(Color.RED);
        g.fillRect(snake.cherry.x * Snake.SCALE, snake.cherry.y * Snake.SCALE,
                Snake.SCALE, Snake.SCALE);
        String string = "Score: " + snake.score + ", Length: " + snake.tailLength + ", Time: " + snake.time / 20;
        g.setColor(Color.WHITE);
        g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

    }
}
