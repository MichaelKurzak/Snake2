package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;


public class Key extends Action implements KeyListener {

    public Timer timer = new Timer(20, this);

    public void startGame() {
        over = false;
        paused = false;
        time = 0;
        score = 0;
        tailLength = 1;
        ticks = 0;
        direction = DOWN;
        head = new Point(0, -1);
        random = new Random();
        snakeParts.clear();
        cherry = new Point(random.nextInt(60), random.nextInt(60));
        System.out.println(cherry.x + ", " + cherry.y);
        for (int i = 0; i < tailLength; i++) {
            snakeParts.add(new Point(head.x, head.y));
        }
        timer.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_A && direction != RIGHT)
            direction = LEFT;
        if (i == KeyEvent.VK_D && direction != LEFT)
            direction = RIGHT;
        if (i == KeyEvent.VK_W && direction != DOWN)
            direction = UP;
        if (i == KeyEvent.VK_S && direction != UP)
            direction = DOWN;
        if (i == KeyEvent.VK_SPACE)
            if (over)
                startGame();
            else
                paused = !paused;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
