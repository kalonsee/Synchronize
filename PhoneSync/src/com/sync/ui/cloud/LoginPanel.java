package com.sync.ui.cloud;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import com.sync.adapter.LabelAdapter;

public class LoginPanel extends JPanel
{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPasswordField		passwordField;
	private JTextField			accountField;

	/**
	 * Create the panel.
	 */
	public LoginPanel()
	{
		initialize ();
	}

	private void initialize ()
	{

		setForeground ( Color.GRAY );
		this.setBounds ( 182 , 15 , 425 , 534 );
		setLayout ( null );

		passwordField = new JPasswordField ();
		passwordField.setBounds ( 75 , 308 , 305 , 48 );
		add ( passwordField );

		accountField = new JTextField ();
		accountField.setBounds ( 75 , 245 , 305 , 48 );
		add ( accountField );
		accountField.setColumns ( 10 );

		String mouseEntered_login = "/com/sync/ui/cloud/res/login_bt_entered.png";
		String mousePressed_login = "/com/sync/ui/cloud/res/login_bt_pressed.png";
		String normal_login = "/com/sync/ui/cloud/res/login_bt_normal.png";
		JLabel loginLabel = new JLabel ( "登录" );
		loginLabel.setBounds ( 75 , 387 , 305 , 48 );
		loginLabel.setIcon ( new ImageIcon ( LoginPanel.class
				.getResource ( normal_login ) ) );
		loginLabel.addMouseListener ( new LabelAdapter ( mouseEntered_login ,
				mousePressed_login , normal_login ) );
		add ( loginLabel );

		JRadioButton radioButton = new JRadioButton ( "记住密码" );
		radioButton.setBounds ( 75 , 448 , 73 , 23 );
		add ( radioButton );

		JRadioButton radioButton_1 = new JRadioButton ( "自动登录" );
		radioButton_1.setBounds ( 150 , 448 , 73 , 23 );
		add ( radioButton_1 );
		String registerhtml = "<html><a href='http://www.baidu.com' target='_blank'>注册账号</a></html>";
		JLabel registerLabel = new JLabel ( registerhtml );
		registerLabel.setBounds ( 257 , 446 , 54 , 23 );
		add ( registerLabel );

		JSeparator separator = new JSeparator ( JSeparator.VERTICAL );
		separator.setBounds ( 314 , 450 , 1 , 21 );
		separator.setBackground ( Color.GRAY );
		add ( separator );

		String pwdhtml = "<html><a href='http://www.baidu.com' target='_blank'>忘记密码</a></html>";
		JLabel pwdLabel = new JLabel ( pwdhtml );
		pwdLabel.setBounds ( 321 , 446 , 54 , 23 );
		add ( pwdLabel );

		JLabel cloudLabel = new JLabel ();
		cloudLabel.setHorizontalAlignment ( SwingConstants.CENTER );
		cloudLabel.setBounds ( 137 , 65 , 150 , 112 );
		cloudLabel.setIcon ( new ImageIcon ( CloudServicePanel.class
				.getResource ( "/com/sync/ui/cloud/res/cloud.png" ) ) );
		add ( cloudLabel );

		JLabel account_p = new JLabel ();
		account_p.setHorizontalAlignment ( SwingConstants.CENTER );
		account_p.setBounds ( 25 , 245 , 45 , 45 );
		account_p.setIcon ( new ImageIcon ( CloudServicePanel.class
				.getResource ( "/com/sync/ui/cloud/res/account_icon3.png" ) ) );
		add ( account_p );

		JLabel pwd_p = new JLabel ();
		pwd_p.setHorizontalAlignment ( SwingConstants.CENTER );
		pwd_p.setBounds ( 25 , 308 , 45 , 45 );
		pwd_p.setIcon ( new ImageIcon ( CloudServicePanel.class
				.getResource ( "/com/sync/ui/cloud/res/pwd_icon3.png" ) ) );
		add ( pwd_p );

		JLabel nameLabel = new JLabel ( "信雅达云服务" );
		nameLabel.setHorizontalAlignment ( SwingConstants.CENTER );
		nameLabel.setBounds ( 137 , 186 , 150 , 40 );
		add ( nameLabel );
	}

}
