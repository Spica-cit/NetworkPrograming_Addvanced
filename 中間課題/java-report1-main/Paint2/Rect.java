package enshu7_2022;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Figure {
	int size;
	Rect(int i){
		if(i % 2 == 0) {
			size = 10;
		}else {
			size = 30;
		}
	}
	@Override public void paint(Graphics g) {
		g.setColor(new Color(color1,color2,color3));
		g.fillRect(x - size/2, y - size/2, size, size);
	}
}
