package toadinone;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;

public class ShadowBorder extends AbstractBorder {

    private Color shadowColor;
    private int shadowSize;

    public ShadowBorder(Color shadowColor, int shadowSize) {
        this.shadowColor = shadowColor;
        this.shadowSize = shadowSize;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();

        int shadowOffset = shadowSize / 2;

        Area borderArea = new Area(new Rectangle2D.Double(x, y, width, height));
        Area shadowArea = new Area(new Rectangle2D.Double(x + shadowOffset, y + shadowOffset, width - shadowSize, height - shadowSize));

        // Subtract the shadow area from the border area
        borderArea.subtract(shadowArea);

        g2.setColor(shadowColor);
        g2.fill(borderArea);

        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return calculateInsets(c.getWidth(), c.getHeight());
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        int width = c.getWidth();
        int height = c.getHeight();
        Insets calculatedInsets = calculateInsets(width, height);
        insets.left = calculatedInsets.left;
        insets.top = calculatedInsets.top;
        insets.right = calculatedInsets.right;
        insets.bottom = calculatedInsets.bottom;
        return insets;
    }

    private Insets calculateInsets(int width, int height) {
        int left = shadowSize;
        int top = shadowSize;
        int right = shadowSize;
        int bottom = shadowSize;
        return new Insets(top, left, bottom, right);
    }
}
