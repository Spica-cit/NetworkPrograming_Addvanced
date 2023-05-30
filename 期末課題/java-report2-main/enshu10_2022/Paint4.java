package enshu10_2022;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Paint4 extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	
	int x, y;
	ArrayList<Figure> objList;
	ArrayList<Figure> subList;
	CheckboxGroup cbg, cbg2, cbg3;
	Checkbox c1, c2, c3, c4, c5, c6;
	Checkbox red, green, blue, black, cyan, gray, magenta, orange, white, yellow, pink, darkgray;
	Checkbox draw, fill;
	Button end, back, save, load, clear, go, sample;
	int mode = 0;
	Figure obj, sub;
	public static void main(String[] args) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w = screenSize.width * 4 / 5;
		int h = screenSize.height * 4 / 5;
		
		Paint4 f = new Paint4(w,h);
		
		f.setSize(w,h);
		f.setTitle("Paint Sample");
		f.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				System.exit(0);
			}});
		f.setVisible(true);
	}
	Paint4(int a, int b){
		objList = new ArrayList<Figure>();
		subList = new ArrayList<Figure>();
		setLayout(null);
		
		int w = a;
		int h = b;
		
		cbg = new CheckboxGroup();
		c1 = new Checkbox("楕円", cbg, true);
		c1.setBounds(w-160, 30, 80, 30);
		add(c1);
		c2 = new Checkbox("円", cbg, false);
		c2.setBounds(w-80, 30, 80, 30);
		add(c2);
		c3 = new Checkbox("四角形", cbg, false);
		c3.setBounds(w-160, 60, 80, 30);
		add(c3);
		c4 = new Checkbox("三角形", cbg, false);
		c4.setBounds(w-80, 60, 80, 30);
		add(c4);
		c5 = new Checkbox("折れ線", cbg, false);
		c5.setBounds(w-160, 90, 80, 30);
		add(c5);
		c6 = new Checkbox("直線", cbg, false);
		c6.setBounds(w-80, 90, 80, 30);
		add(c6);
		
		cbg2 = new CheckboxGroup();
		red = new Checkbox("赤", cbg2, true);
		red.setBounds(w-160, 300, 80, 30);
		add(red);
		green = new Checkbox("緑", cbg2, false);
		green.setBounds(w-80, 300, 80, 30);
		add(green);
		blue = new Checkbox("青", cbg2, false);
		blue.setBounds(w-160, 330, 80, 30);
		add(blue);
		black = new Checkbox("黒",cbg2, false);
		black.setBounds(w-80, 330, 80, 30);
		add(black);
		cyan = new Checkbox("水",cbg2, false);
		cyan.setBounds(w-160, 360, 80, 30);
		add(cyan);
		gray = new Checkbox("灰",cbg2, false);
		gray.setBounds(w-80, 360, 80, 30);
		add(gray);
		magenta = new Checkbox("紅紫",cbg2, false);
		magenta.setBounds(w-160, 390, 80, 30);
		add(magenta);
		orange = new Checkbox("橙",cbg2, false);
		orange.setBounds(w-80, 390, 80, 30);
		add(orange);
		white = new Checkbox("白",cbg2, false);
		white.setBounds(w-160, 420, 80, 30);
		add(white);
		yellow = new Checkbox("黄",cbg2, false);
		yellow.setBounds(w-80, 420, 80, 30);
		add(yellow);
		pink = new Checkbox("桃",cbg2, false);
		pink.setBounds(w-160, 450, 80, 30);
		add(pink);
		darkgray = new Checkbox("黒灰",cbg2, false);
		darkgray.setBounds(w-80, 450, 80, 30);
		add(darkgray);

		
		cbg3 = new CheckboxGroup();
		draw = new Checkbox("塗りつぶしなし", cbg3, true);
		draw.setBounds(w-160, h-250, 100,30);
		add(draw);
		fill = new Checkbox("塗りつぶしあり", cbg3, false);
		fill.setBounds(w-160, h-220, 100,30);
		add(fill);
		
		end = new Button("End");
		end.setBounds(w-80, h-60, 60, 30);
		add(end);
		save = new Button("Save");
		save.setBounds(w-160,h-60,60,30);
		add(save);
		load = new Button("Load");
		load.setBounds(w-240,h-60,60,30);
		add(load);
		back = new Button("Undo");
		back.setBounds(w-80,h-100,60,30);
		add(back);
		go = new Button("Redo");
		go.setBounds(w-160,h-100,60,30);
		add(go);
		clear = new Button("Delete");
		clear.setBounds(w-240,h-100,60,30);
		add(clear);
		sample = new Button("Sample");
		sample.setBounds(w-80,h-140,60,30);
		add(sample);
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		end.addActionListener(this);
		back.addActionListener(this);
		go.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		clear.addActionListener(this);
		sample.addActionListener(this);
	}
	
	public void save(String fname) {
		try {
			FileOutputStream fos = new FileOutputStream(fname);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(objList);
			oos.close();
			fos.close();
		}catch(IOException e) {
		}
	}
	@SuppressWarnings("unchecked")
	public void load(String fname) {
		try {
			FileInputStream fis = new FileInputStream(fname);
			ObjectInputStream ois = new ObjectInputStream(fis);
			objList = (ArrayList<Figure>)ois.readObject();
			ois.close();
			fis.close();
		}catch(IOException e) {
		}catch(ClassNotFoundException e) {
		}
		repaint();
	}
	
	@Override public void paint(Graphics g) {
		Figure f;
		for(int i = 0; i < objList.size(); i++) {
			f = objList.get(i);
			f.paint(g);
		}
		if(mode >= 1)	obj.paint(g);
	}
	@Override public void actionPerformed(ActionEvent e) {
		if(e.getSource() == end) {
			System.exit(0);
		}else if(e.getSource() == back && objList.size() > 0) {
			sub = objList.get(objList.size() - 1);
			subList.add(sub);
			sub = null;
			objList.remove(objList.size() - 1);
			repaint();
		}else if(e.getSource() == go && subList.size() > 0) {
			obj = subList.get(subList.size() - 1);
			objList.add(obj);
			obj = null;
			subList.remove(subList.size() - 1);
			repaint();
		}else if(e.getSource() == save) {
			FileDialog f_dialog = new FileDialog(new Frame(),"FileDialog",FileDialog.SAVE);
			f_dialog.setVisible(true);
			save(f_dialog.getFile());
		}else if(e.getSource() == load) {
			FileDialog f_dialog = new FileDialog(new Frame(),"FileDialog",FileDialog.LOAD);
			f_dialog.setVisible(true);
			load(f_dialog.getFile());
		}else if(e.getSource() == clear) {
			objList.clear();
			repaint();
		}else if(e.getSource() == sample) {
			int i = (int)Math.ceil(Math.random() * 3);
			if(i == 1)		load("sample");
			else if(i == 2)	load("sample2");
			else if(i == 3)	load("sample3");
		}
	}
	@Override public void mousePressed(MouseEvent e) {
		Checkbox c, color, tipe;
		x = e.getX();
		y = e.getY();
		c = cbg.getSelectedCheckbox();
		color = cbg2.getSelectedCheckbox();
		tipe = cbg3.getSelectedCheckbox();
		
		subList.clear();
		
		obj = null;
		if(c == c1) {
			mode = 2;
			if(tipe == draw) {
				if(color == red)			obj = new Dot(1,1);
				else if(color == green)		obj = new Dot(2,1);
				else if(color == blue)		obj = new Dot(3,1);
				else if(color == black)		obj = new Dot(4,1);
				else if(color == cyan)		obj = new Dot(5,1);
				else if(color == gray)		obj = new Dot(6,1);
				else if(color == magenta)	obj = new Dot(7,1);
				else if(color == orange)	obj = new Dot(8,1);
				else if(color == white)		obj = new Dot(9,1);
				else if(color == yellow)	obj = new Dot(10,1);
				else if(color == pink)		obj = new Dot(11,1);
				else if(color == darkgray)	obj = new Dot(12,1);
			}else if(tipe == fill) {
				if(color == red)			obj = new Dot(1,2);
				else if(color == green)		obj = new Dot(2,2);
				else if(color == blue)		obj = new Dot(3,2);
				else if(color == black)		obj = new Dot(4,2);
				else if(color == cyan)		obj = new Dot(5,2);
				else if(color == gray)		obj = new Dot(6,2);
				else if(color == magenta)	obj = new Dot(7,2);
				else if(color == orange)	obj = new Dot(8,2);
				else if(color == white)		obj = new Dot(9,2);
				else if(color == yellow)	obj = new Dot(10,2);
				else if(color == pink)		obj = new Dot(11,2);
				else if(color == darkgray)	obj = new Dot(12,2);
			}
		}else if(c == c2) {
			mode = 2;
			if(tipe == draw) {
				if(color == red)			obj = new Circle(1,1);
				else if(color == green)		obj = new Circle(2,1);
				else if(color == blue)		obj = new Circle(3,1);
				else if(color == black)		obj = new Circle(4,1);
				else if(color == cyan)		obj = new Circle(5,1);
				else if(color == gray)		obj = new Circle(6,1);
				else if(color == magenta)	obj = new Circle(7,1);
				else if(color == orange)	obj = new Circle(8,1);
				else if(color == white)		obj = new Circle(9,1);
				else if(color == yellow)	obj = new Circle(10,1);
				else if(color == pink)		obj = new Circle(11,1);
				else if(color == darkgray)	obj = new Circle(12,1);
			}else if(tipe == fill) {
				if(color == red)			obj = new Circle(1,2);
				else if(color == green)		obj = new Circle(2,2);
				else if(color == blue)		obj = new Circle(3,2);
				else if(color == black)		obj = new Circle(4,2);
				else if(color == cyan)		obj = new Circle(5,2);
				else if(color == gray)		obj = new Circle(6,2);
				else if(color == magenta)	obj = new Circle(7,2);
				else if(color == orange)	obj = new Circle(8,2);
				else if(color == white)		obj = new Circle(9,2);
				else if(color == yellow)	obj = new Circle(10,2);
				else if(color == pink)		obj = new Circle(11,2);
				else if(color == darkgray)	obj = new Circle(12,2);
			}
		}else if(c == c3) {
			mode = 2;
			if(tipe == draw) {
				if(color == red)			obj = new Rect(1,1);
				else if(color == green)		obj = new Rect(2,1);
				else if(color == blue)		obj = new Rect(3,1);
				else if(color == black)		obj = new Rect(4,1);
				else if(color == cyan)		obj = new Rect(5,1);
				else if(color == gray)		obj = new Rect(6,1);
				else if(color == magenta)	obj = new Rect(7,1);
				else if(color == orange)	obj = new Rect(8,1);
				else if(color == white)		obj = new Rect(9,1);
				else if(color == yellow)	obj = new Rect(10,1);
				else if(color == pink)		obj = new Rect(11,1);
				else if(color == darkgray)	obj = new Rect(12,1);
			}else if(tipe == fill) {
				if(color == red)			obj = new Rect(1,2);
				else if(color == green)		obj = new Rect(2,2);
				else if(color == blue)		obj = new Rect(3,2);
				else if(color == black)		obj = new Rect(4,2);
				else if(color == cyan)		obj = new Rect(5,2);
				else if(color == gray)		obj = new Rect(6,2);
				else if(color == magenta)	obj = new Rect(7,2);
				else if(color == orange)	obj = new Rect(8,2);
				else if(color == white)		obj = new Rect(9,2);
				else if(color == yellow)	obj = new Rect(10,2);
				else if(color == pink)		obj = new Rect(11,2);
				else if(color == darkgray)	obj = new Rect(12,2);
			}
		}else if(c == c4) {
			mode = 2;
			if(tipe == draw) {
				if(color == red)			obj = new Polygon(1,1);
				else if(color == green)		obj = new Polygon(2,1);
				else if(color == blue)		obj = new Polygon(3,1);
				else if(color == black)		obj = new Polygon(4,1);
				else if(color == cyan)		obj = new Polygon(5,1);
				else if(color == gray)		obj = new Polygon(6,1);
				else if(color == magenta)	obj = new Polygon(7,1);
				else if(color == orange)	obj = new Polygon(8,1);
				else if(color == white)		obj = new Polygon(9,1);
				else if(color == yellow)	obj = new Polygon(10,1);
				else if(color == pink)		obj = new Polygon(11,1);
				else if(color == darkgray)	obj = new Polygon(12,1);
			}else if(tipe == fill) {
				if(color == red)			obj = new Polygon(1,2);
				else if(color == green)		obj = new Polygon(2,2);
				else if(color == blue)		obj = new Polygon(3,2);
				else if(color == black)		obj = new Polygon(4,2);
				else if(color == cyan)		obj = new Polygon(5,2);
				else if(color == gray)		obj = new Polygon(6,2);
				else if(color == magenta)	obj = new Polygon(7,2);
				else if(color == orange)	obj = new Polygon(8,2);
				else if(color == white)		obj = new Polygon(9,2);
				else if(color == yellow)	obj = new Polygon(10,2);
				else if(color == pink)		obj = new Polygon(11,2);
				else if(color == darkgray)	obj = new Polygon(12,2);
			}
		}else if(c == c5) {
			mode = 2;
			if(color == red)			obj = new Line(1);
			else if(color == green)		obj = new Line(2);
			else if(color == blue)		obj = new Line(3);
			else if(color == black)		obj = new Line(4);
			else if(color == cyan)		obj = new Line(5);
			else if(color == gray)		obj = new Line(6);
			else if(color == magenta)	obj = new Line(7);
			else if(color == orange)	obj = new Line(8);
			else if(color == white)		obj = new Line(9);
			else if(color == yellow)	obj = new Line(10);
			else if(color == pink)		obj = new Line(11);
			else if(color == darkgray)	obj = new Line(12);
		}else if(c == c6) {
			mode = 2;
			if(color == red)			obj = new Straight(1);
			else if(color == green)		obj = new Straight(2);
			else if(color == blue)		obj = new Straight(3);
			else if(color == black)		obj = new Straight(4);
			else if(color == cyan)		obj = new Straight(5);
			else if(color == gray)		obj = new Straight(6);
			else if(color == magenta)	obj = new Straight(7);
			else if(color == orange)	obj = new Straight(8);
			else if(color == white)		obj = new Straight(9);
			else if(color == yellow)	obj = new Straight(10);
			else if(color == pink)		obj = new Straight(11);
			else if(color == darkgray)	obj = new Straight(12);
		}
		if(obj != null) {
			obj.moveto(x, y);
			repaint();
		}
	}
	@Override public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(mode == 1)		obj.moveto(x, y);
		else if(mode == 2)	obj.setWH(x - obj.x, y - obj.y);
		if(mode >= 1) {
			objList.add(obj);
			obj = null;
		}
		mode = 0;
		repaint();
	}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(mode == 1) {
			obj.moveto(x,  y);
		}else if(mode == 2) {
			obj.setWH(x - obj.x, y - obj.y);
		}
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}
}
