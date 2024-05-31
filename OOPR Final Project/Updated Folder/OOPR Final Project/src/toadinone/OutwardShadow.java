package toadinone;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

public class OutwardShadow implements Border {
    private int shadowSize;

    public OutwardShadow(int shadowSize) {
        this.shadowSize = shadowSize;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, shadowSize, shadowSize);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Color shadowColor = new Color(0, 0, 0, 150);
        g.setColor(shadowColor);

        // Draw right shadow
        for (int i = 0; i < shadowSize; i++) {
            g.drawLine(width - i, i, width - i, height - 1 - i);
        }

        // Draw bottom shadow
        for (int i = 0; i < shadowSize; i++) {
            g.drawLine(i, height - i, width - 1 - i, height - i);
        }
    }
}
