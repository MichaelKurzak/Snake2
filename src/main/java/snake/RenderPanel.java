package snake;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    public static int curColor = 0;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color (curColor));
        g.fillRect(0,0,600,600);
        curColor++;
    }
}
