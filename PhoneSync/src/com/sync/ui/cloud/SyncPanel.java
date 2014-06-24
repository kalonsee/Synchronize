package com.sync.ui.cloud;

import javax.swing.JPanel;

public class SyncPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public HeadPanel headp = null;
	public BodyPanel bodyp = null;

	/**
	 * Create the panel.
	 */
	public SyncPanel() {
		initialize();
	}
	
	private void initialize() {
		setBounds(100, 0,800,580);
		setLayout(null);
		headp = new HeadPanel();
		bodyp = new BodyPanel();
	}

}
