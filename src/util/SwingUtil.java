package util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

public final class SwingUtil {
	
    public static void centralize(final Component comp) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int width = comp.getWidth();
        int height = comp.getHeight();
        int x = (screenSize.width - width) / 2;
        int y = (screenSize.height - height) / 2;

        Rectangle bounds = new Rectangle(x, y, width, height);
        comp.setBounds(bounds);
    }

}
