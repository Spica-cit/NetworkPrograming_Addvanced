package enshu10_2022;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Figure{
	int color, dw;
	Line(int a){
		color = a;
	}
	@Override public void paint(Graphics g) {
		if(color == 1)			g.setColor(Color.red);
		else if(color == 2)		g.setColor(Color.green);
		else if(color == 3)		g.setColor(Color.blue);
		else if(color == 4)		g.setColor(Color.black);
		else if(color == 5)		g.setColor(Color.cyan);
		else if(color == 6)		g.setColor(Color.gray);
		else if(color == 7)		g.setColor(Color.magenta);
		else if(color == 8)		g.setColor(Color.orange);
		else if(color == 9)		g.setColor(Color.white);
		else if(color == 10)	g.setColor(Color.yellow);
		else if(color == 11)	g.setColor(Color.pink);
		else if(color == 12)	g.setColor(Color.darkGray);
		
		g.drawLine(x, y, x+(w*1/8), y+h);
		g.drawLine(x+(w*1/8), y+h, x+(w/4), y);
		g.drawLine(x+(w/4), y, x+(w*3/8), y+h);
		g.drawLine(x+(w*3/8), y+h, x+(w/2), y);
		g.drawLine(x+(w/2), y, x+(w*5/8), y+h);
		g.drawLine(x+(w*5/8), y+h, x+(w*3/4), y);
		g.drawLine(x+(w*3/4), y, x+(w*7/8), y+h);
		g.drawLine(x+(w*7/8), y+h, x+w, y);
	}
}