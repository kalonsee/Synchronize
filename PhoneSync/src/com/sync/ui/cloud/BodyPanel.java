package com.sync.ui.cloud;

import java.awt.Color;

import javax.swing.JPanel;
import java.awt.FlowLayout;

public class BodyPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Create the panel.
	 */
	public BodyPanel()
	{
		initialize ();
	}

	private void initialize ()
	{
		setForeground ( Color.GRAY );
		this.setBounds ( 80 , 190 , 640 , 300 );
		setLayout ( new FlowLayout ( FlowLayout.CENTER , 5 , 5 ) );
		setBounds ( 0 , 0 , 100 , 100 );
		JPanel panel = new JPanel ();

		add ( panel );
	}

}
