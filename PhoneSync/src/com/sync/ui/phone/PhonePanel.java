package com.sync.ui.phone;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JSeparator;

public class PhonePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PhonePanel() {
		initialize();
	}
	
	private void initialize() {
	
		this.setBounds(0, 0, 800, 580);
		this.setLayout(null);
		
		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		separator.setBounds(310, 0, 1, 580);
		separator.setBackground(new Color(0, 153, 255));
		
		this.add(separator);
	}

}
