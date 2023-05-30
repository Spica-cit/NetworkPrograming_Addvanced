package enshu7_2022;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Line extends Figure {
	int dx, dy;
	@Override public void paint(Graphics g) {
		g.setColor(new Color(color1,color2,color3));
		
		Graphics2D g2 =(Graphics2D)g;
		BasicStroke bs = new BasicStroke(10);
		g2.setStroke(bs);
		
		g.drawLine(x, y, x, y);
	}
}