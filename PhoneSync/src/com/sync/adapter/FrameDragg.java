package com.sync.adapter;

import java.awt.Point;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class FrameDragg{
	
	static Point origin = new Point();
	
	public FrameDragg(Window window){
		window.addMouseListener(mpress);
		window.addMouseMotionListener(mmotion);
	}
	
	MouseAdapter mpress = new MouseAdapter(){

		public void mousePressed(MouseEvent e) {

			origin.x = e.getX();
			origin.y = e.getY();
		}
	};
	
	MouseMotionAdapter mmotion = new MouseMotionAdapter(){
		
		
		public void mouseDragged(MouseEvent e) {
			
			Window window = (Window) e.getSource();
			Point p = window.getLocation();
			
			window.setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y);
		}
	};
	
}