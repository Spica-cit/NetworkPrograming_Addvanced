package enshu10_2022;

import java.awt.Graphics;

public class Figure extends Coord{
	int color;
	int w, h;
	Figure(){
		w = h = 0;
	}
	public void paint(Graphics g) {}
	public void setWH(int w, int h) {
		this.w = w;
		this.h = h;
	}
}