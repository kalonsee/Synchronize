package com.sync.adapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelAdapter extends MouseAdapter{

	private JLabel label;
	private String mouseEntered;
	private String mousePressed;
	private String normal;
	
	public void setMouseEntered(String mouseEntered) {
		this.mouseEntered = mouseEntered;
	}
	public void setMousePressed(String mousePressed) {
		this.mousePressed = mousePressed;
	}
	public void setNormal(String normal) {
		this.normal = normal;
	}
	public LabelAdapter(){}
	public LabelAdapter(String mouseEntered,String mousePressed,String normal){
		this.mouseEntered = mouseEntered;
		this.mousePressed = mousePressed;
		this.normal = normal;
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		label = (JLabel) e.getSource();
		label.setIcon(new ImageIcon(LabelAdapter.class.getResource(mouseEntered)));
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		label = (JLabel) e.getSource();
		label.setIcon(new ImageIcon(LabelAdapter.class.getResource(normal)));
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		label = (JLabel) e.getSource();
		label.setIcon(new ImageIcon(LabelAdapter.class.getResource(mousePressed)));
	}
}
