package enshu10_2022;

import java.awt.Color;
import java.awt.Graphics;

public class Polygon extends Figure{
	int color, tipe;
	Polygon(int a, int b){
		color = a;
		tipe = b;
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
		
		if(tipe == 1)		g.drawPolygon(new int[] {x,x-w,x+w}, new int[] {y-h,y+h,y+h},3);
		else if(tipe == 2)	g.fillPolygon(new int[] {x,x-w,x+w}, new int[] {y-h,y+h,y+h},3);
	}
}
