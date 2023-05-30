package enshu7_2022;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Figure {
	int size;
	Circle(int i){
		if(i % 2 == 0) {
			size = 10;
		}else if(i % 2 == 1) {
			size = 30;
		}else {
			
		}
	}
	@Override public void paint(Graphics g) {
		g.setColor(new Color(color1,color2,color3));
		g.fillOval(x - size/2, y - size/2, size, size);
	}
}
