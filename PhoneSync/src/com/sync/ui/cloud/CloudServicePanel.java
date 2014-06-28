package com.sync.ui.cloud;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.sync.adapter.LabelAdapter;
import com.sync.ui.home.PanelManager;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CloudServicePanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private LoginPanel loginPanel = null;
	private static PanelManager panelManager = null;
	private JFrame frame = null;

	/**
	 * Create the panel.
	 */

	public CloudServicePanel( JFrame frame )
	{
		this.frame = frame;
		panelManager = new PanelManager();
		initialize();
	}

	private void initialize()
	{

		setForeground( Color.GRAY );
		setBounds( 0 , 0 , 800 , 580 );
		setLayout( null );

		loginPanel = new LoginPanel(panelManager);
		add( loginPanel );
		//panelManager.add( "loginPanel" , loginPanel );

		JLabel closeLabel = new JLabel( "" );
		String mouseEntered_close = "/com/sync/ui/cloud/res/MouseEntered_Close.png";
		String mousePressed_close = "/com/sync/ui/cloud/res/MousePressed_Close.png";
		String normal_close = "/com/sync/ui/cloud/res/Normal_Close.png";
		closeLabel.addMouseListener( new LabelAdapter( mouseEntered_close ,
				mousePressed_close , normal_close ) );
		closeLabel.addMouseListener( new MouseAdapter()
		{
			public void mouseClicked( MouseEvent e )
			{
				// frame.dispose();
				System.exit( 0 );
			}
		} );
		closeLabel.setIcon( new ImageIcon( CloudServicePanel.class
				.getResource( normal_close ) ) );
		closeLabel.setHorizontalAlignment( SwingConstants.CENTER );
		closeLabel.setBounds( 3 , 3 , 29 , 24 );
		add( closeLabel );

		JLabel minimaizeLabel = new JLabel( "" );
		String mouseEntered_min = "/com/sync/ui/cloud/res/MouseEntered_Min.png";
		String mousePressed_min = "/com/sync/ui/cloud/res/MousePressed_Min.png";
		String normal_min = "/com/sync/ui/cloud/res/Normal_Min.png";
		minimaizeLabel.addMouseListener( new LabelAdapter( mouseEntered_min ,
				mousePressed_min , normal_min ) );
		minimaizeLabel.addMouseListener( new MouseAdapter()
		{
			public void mouseClicked( MouseEvent e )
			{
				frame.setExtendedState( JFrame.ICONIFIED );
			}
		} );
		minimaizeLabel.setIcon( new ImageIcon( CloudServicePanel.class
				.getResource( normal_min ) ) );
		minimaizeLabel.setHorizontalAlignment( SwingConstants.CENTER );
		minimaizeLabel.setBounds( 32 , 3 , 29 , 24 );
		add( minimaizeLabel );

		/*JLabel settingLabel = new JLabel( "" );
		settingLabel.setHorizontalAlignment( SwingConstants.CENTER );
		settingLabel.setBounds( 61 , 3 , 29 , 24 );
		add( settingLabel );*/
	}
}
