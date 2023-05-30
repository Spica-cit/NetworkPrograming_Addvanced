package enshu7_2022;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;

public class Paint2 extends Frame implements MouseListener, MouseMotionListener {
	int x, y;
	public static int i, j, k;
	ArrayList<Figure> objList;
	Figure obj;	
	public static void main(String[] args) {
		
		i = Integer.parseInt(args[0]);
		k = Integer.parseInt(args[1]);
		
		Figure.color1 = Integer.parseInt(args[2]);
		Figure.color2 = Integer.parseInt(args[3]);
		Figure.color3 = Integer.parseInt(args[4]);
		
		Paint2 f = new Paint2();
		f.setSize(640,480);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);
	}
	Paint2(){
		objList = new ArrayList<Figure>();
		
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	@Override public void paint(Graphics g) {
		Figure f;
		for(int i = 0; i < objList.size(); i++) {
			f = objList.get(i);					
			f.paint(g);							
		}
		if(obj != null)	obj.paint(g);			
	}
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(k == 1) 		obj = new Circle(j);
		else if(k == 2)	obj = new Rect(j);
		else if(k == 3)	obj = new Line();
		obj.moveto(x,y);
		repaint();
		
		System.out.println(j + 1);
		
		if(objList.size() >= i && k != 3) {
			objList.remove(0);
		}
		j++;
	}
	public void mouseReleased(MouseEvent e) {	
		x = e.getX();
		y = e.getY();
		obj.moveto(x,y);
		objList.add(obj);
		obj = null;
		repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {
		Random ran = new Random();
		Figure.color1 = ran.nextInt(256) + 0;
		Figure.color2 = ran.nextInt(256) + 0;
		Figure.color3 = ran.nextInt(256) + 0;
	}
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(obj != null)	obj.moveto(x,y);
		if(k == 3) {
			obj = new Line();
			objList.add(obj);
		}
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
}
