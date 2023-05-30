package enshu10_2022;

import java.awt.Color;
import java.awt.Graphics;

public class Dot extends Figure{
	int color, tipe, dw, dh, sw, sh;
	Dot(int a, int b){
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
		
		sw = Math.abs(w);
		sh = Math.abs(h);
		
		dw = (int)((double)Math.sqrt(2) * sw);
		dh = (int)((double)Math.sqrt(2) * sh);
		
		if(tipe == 1) {
			if(w>0 && h>0) {
				if(w>h) 			g.drawOval(x-dw, y-dw*h/w, dw*2, 2*dw*h/w);
				else				g.drawOval(x-dh*w/h, y-dh, dh*w*2/h, dh*2);
			}else if(w<0 && h>0) {
				if(sw>h)			g.drawOval(x-dw, y-dw*h/sw, dw*2, 2*dw*h/sw);
				else				g.drawOval(x-dh*sw/h, y-dh, dh*sw*2/h, dh*2);
			}else if(w>0 && h<0) {
				if(w>sh)			g.drawOval(x-dw, y-dw*sh/w, dw*2, 2*dw*sh/w);
				else				g.drawOval(x-dh*w/sh, y-dh, dh*w*2/sh, dh*2);
			}else if(w<0 && h<0) {
				if(sw>sh)			g.drawOval(x-dw, y-dw*sh/sw, dw*2, 2*dw*sh/sw);
				else				g.drawOval(x-dh*sw/sh, y-dh, dh*sw*2/sh, dh*2);
			}
		}else if(tipe == 2) {
			if(w>0 && h>0) {
				if(w>h) 			g.fillOval(x-dw, y-dw*h/w, dw*2, 2*dw*h/w);
				else				g.fillOval(x-dh*w/h, y-dh, dh*w*2/h, dh*2);
			}else if(w<0 && h>0) {
				if(sw>h)			g.fillOval(x-dw, y-dw*h/sw, dw*2, 2*dw*h/sw);
				else				g.fillOval(x-dh*sw/h, y-dh, dh*sw*2/h, dh*2);
			}else if(w>0 && h<0) {
				if(w>sh)			g.fillOval(x-dw, y-dw*sh/w, dw*2, 2*dw*sh/w);
				else				g.fillOval(x-dh*w/sh, y-dh, dh*w*2/sh, dh*2);
			}else if(w<0 && h<0) {
				if(sw>sh)			g.fillOval(x-dw, y-dw*sh/sw, dw*2, 2*dw*sh/sw);
				else				g.fillOval(x-dh*sw/sh, y-dh, dh*sw*2/sh, dh*2);
			}
		}
	}
}