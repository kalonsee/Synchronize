package com.sync.ui.home;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sync.adapter.FrameDragg;
import com.sync.ui.cloud.CloudServicePanel;
import com.sync.ui.phone.PhonePanel;

public class Application extends JPanel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private PanelManager panelManager = null;
	private JPanel menuPanel = null;
	private PhonePanel phonePanel = null;
	private CloudServicePanel csPanel = null;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args )
	{
		EventQueue.invokeLater( new Runnable()
		{
			public void run()
			{
				try
				{
					Application window = new Application();
					window.frame.setVisible( true );
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the application.
	 */
	public Application()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds( 100 , 100 , 900 , 580 );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().setLayout( null );
		frame.setUndecorated( true );
		panelManager = new PanelManager();
		new FrameDragg( frame );// 添加拖拽事件

		memuPanelInit();

		phonePanel = new PhonePanel();
		frame.getContentPane().add( phonePanel );
		panelManager.add( "phonePanel" , phonePanel );
	}

	public void memuPanelInit()
	{

		menuPanel = new JPanel();
		menuPanel.setBackground( new Color( 0 , 153 , 255 ) );
		menuPanel.setBounds( 800 , 0 , 100 , 580 );
		frame.getContentPane().add( menuPanel );
		menuPanel.setLayout( null );

		JLabel phoneLabel = new JLabel( "手机" );
		phoneLabel.setForeground( Color.WHITE );
		phoneLabel.setHorizontalAlignment( SwingConstants.CENTER );
		phoneLabel.setBounds( 0 , 80 , 100 , 45 );
		menuPanel.add( phoneLabel );

		JLabel cloudLabel = new JLabel( "云服务" );
		cloudLabel.setForeground( Color.WHITE );
		cloudLabel.setHorizontalAlignment( SwingConstants.CENTER );
		cloudLabel.setBounds( 0 , 125 , 100 , 45 );
		cloudLabel.addMouseListener( new MouseAdapter()
		{
			@Override
			public void mouseClicked( MouseEvent e )
			{
				if( csPanel == null )
				{
					csPanel = new CloudServicePanel(frame);
					frame.getContentPane().add( csPanel );
					panelManager.add( "csPanel" , csPanel );
				}
				else
				{
					panelManager.show( "csPanel" );
				}
			}
		} );
		menuPanel.add( cloudLabel );

		JLabel appLabel = new JLabel( "应用" );
		appLabel.setForeground( Color.WHITE );
		appLabel.setHorizontalAlignment( SwingConstants.CENTER );
		appLabel.setBounds( 0 , 170 , 100 , 45 );
		menuPanel.add( appLabel );

		JLabel gameLabel = new JLabel( "游戏" );
		gameLabel.setForeground( Color.WHITE );
		gameLabel.setHorizontalAlignment( SwingConstants.CENTER );
		gameLabel.setBounds( 0 , 215 , 100 , 45 );
		menuPanel.add( gameLabel );

		JLabel downloadLabel = new JLabel( "下载管理" );
		downloadLabel.setForeground( Color.WHITE );
		downloadLabel.setBackground( Color.WHITE );
		downloadLabel.setHorizontalAlignment( SwingConstants.CENTER );
		downloadLabel.setBounds( 0 , 535 , 90 , 45 );
		menuPanel.add( downloadLabel );

	}

}
