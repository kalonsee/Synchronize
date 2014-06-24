package com.sync.ui.cloud;

import javax.swing.JPanel;
import java.awt.Color;

public class CloudServicePanel extends JPanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private LoginPanel			loginPanel			= null;

	/**
	 * Create the panel.
	 */

	public CloudServicePanel()
	{
		initialize ();
	}

	private void initialize ()
	{

		setForeground ( Color.GRAY );
		setBounds ( 0 , 0 , 800 , 580 );
		setLayout ( null );

		loginPanel = new LoginPanel ();
		add ( loginPanel );
	}
}
