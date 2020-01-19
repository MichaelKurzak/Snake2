package snake;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class RenderPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(0));
        g.fillRect(0,0,600,600);
        super.paintComponent(g);
    }
}
