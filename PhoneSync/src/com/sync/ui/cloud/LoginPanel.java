package com.sync.ui.cloud;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import cm.MD5.MD5;

import com.sync.adapter.HintTextFieldUI;
import com.sync.adapter.LabelAdapter;
import com.sync.ui.home.PanelManager;

public class LoginPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	protected JTextField accountField;
	
	private PanelManager panelManager = null;
	private HintTextFieldUI accountUI = new HintTextFieldUI(" 邮箱/电话/其他",true,Color.GRAY);
	private HintTextFieldUI pwdUI = new HintTextFieldUI("",true,Color.RED);

	/**
	 * Create the panel.
	 */
	public LoginPanel(PanelManager panelManager)
	{
		panelManager.add( "loginPanel" , this );
		this.panelManager = panelManager;
		
		initialize();
	}

	private void initialize()
	{

		setForeground( Color.GRAY );
		this.setBounds( 182 , 15 , 460 , 534 );
		setLayout( null );

		passwordField = new JPasswordField();
		passwordField.setBounds( 75 , 308 , 305 , 48 );
		add( passwordField );

		accountField = new JTextField();
		accountField.setUI( accountUI );
		accountField.setBounds( 75 , 245 , 305 , 48 );
		accountField.setColumns( 10 );
		add( accountField );

		String mouseEntered_login = "/com/sync/ui/cloud/res/login_bt_entered.png";
		String mousePressed_login = "/com/sync/ui/cloud/res/login_bt_pressed.png";
		String normal_login = "/com/sync/ui/cloud/res/login_bt_normal.png";
		JLabel loginLabel = new JLabel( "登录" );
		loginLabel.setBounds( 75 , 387 , 305 , 48 );
		loginLabel.setIcon( new ImageIcon( LoginPanel.class
				.getResource( normal_login ) ) );
		loginLabel.addMouseListener( new LabelAdapter( mouseEntered_login ,
				mousePressed_login , normal_login ) );
		loginLabel.addMouseListener( new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e) {
				String pwd = passwordField.getText();
				String account = accountField.getText();
				LoginService ls = new LoginService(account,pwd);
				ls.start();
			}
		} );
		add( loginLabel );

		JRadioButton radioButton = new JRadioButton( "记住密码" );
		radioButton.setBounds( 75 , 448 , 73 , 23 );
		add( radioButton );

		JRadioButton radioButton_1 = new JRadioButton( "自动登录" );
		radioButton_1.setBounds( 150 , 448 , 73 , 23 );
		add( radioButton_1 );
		String registerhtml = "<html><a href='http://www.baidu.com' target='_blank'>注册账号</a></html>";
		JLabel registerLabel = new JLabel( registerhtml );
		registerLabel.setBounds( 257 , 446 , 54 , 23 );
		add( registerLabel );

		JSeparator separator = new JSeparator( JSeparator.VERTICAL );
		separator.setBounds( 314 , 450 , 1 , 21 );
		separator.setBackground( Color.GRAY );
		add( separator );

		String pwdhtml = "<html><a href='http://www.baidu.com' target='_blank'>忘记密码</a></html>";
		JLabel pwdLabel = new JLabel( pwdhtml );
		pwdLabel.setBounds( 321 , 446 , 54 , 23 );
		add( pwdLabel );

		JLabel cloudLabel = new JLabel();
		cloudLabel.setHorizontalAlignment( SwingConstants.CENTER );
		cloudLabel.setBounds( 137 , 65 , 150 , 112 );
		cloudLabel.setIcon( new ImageIcon( CloudServicePanel.class
				.getResource( "/com/sync/ui/cloud/res/cloud.png" ) ) );
		add( cloudLabel );

		JLabel account_p = new JLabel();
		account_p.setHorizontalAlignment( SwingConstants.CENTER );
		account_p.setBounds( 25 , 245 , 45 , 45 );
		account_p.setIcon( new ImageIcon( CloudServicePanel.class
				.getResource( "/com/sync/ui/cloud/res/account_icon3.png" ) ) );
		add( account_p );

		JLabel pwd_p = new JLabel();
		pwd_p.setHorizontalAlignment( SwingConstants.CENTER );
		pwd_p.setBounds( 25 , 308 , 45 , 45 );
		pwd_p.setIcon( new ImageIcon( CloudServicePanel.class
				.getResource( "/com/sync/ui/cloud/res/pwd_icon3.png" ) ) );
		add( pwd_p );

		JLabel nameLabel = new JLabel( "信雅达云服务" );
		nameLabel.setHorizontalAlignment( SwingConstants.CENTER );
		nameLabel.setBounds( 137 , 186 , 150 , 40 );
		add( nameLabel );
	}
	
	class LoginService extends Thread
	{

		public static final String url = "http://localhost:8080/SyncService/login!login.do";
		private String account = null;
		private String password = null;

		public LoginService( String account , String password )
		{
			this.account = account;
			this.password = new MD5( password ).getSummary();
		}

		@Override
		public void run()
		{
			CloseableHttpResponse httpresponse = null;
			CloseableHttpClient httpclient = HttpClients.createDefault();// HTTP
			try
			{
				HttpPost post = new HttpPost( url );
				List<NameValuePair> namevaluepairs = new ArrayList<NameValuePair>();
				namevaluepairs.add( new BasicNameValuePair( "account" , account ) );
				namevaluepairs
						.add( new BasicNameValuePair( "password" , password ) );

				post.setEntity( new UrlEncodedFormEntity( namevaluepairs ,
						HTTP.UTF_8 ) );
				httpresponse = httpclient.execute( post );

				if( httpresponse.getStatusLine().getStatusCode() == 200 )
				{

					String result = httpresponse.getEntity().toString();//
					if( result.equals( "ae" ) )
					{
						accountUI.setColor(  Color.RED );
						accountUI.setHint( " 用户不存在！" );
						accountField.setText( null );
					}
					else if( result.equals( "pe" ) )
					{
						pwdUI.setHint( " 密码错误！" );
						passwordField.setText( null );
					}
					else
					{
						SyncPanel sp = new SyncPanel();
						LoginPanel.this.setVisible( false );
						panelManager.add( "syncPanel" , sp );
					}
				}
				else
				{
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					if( httpresponse != null )
					{
						httpresponse.close();
						httpresponse = null;
					}

					if( httpclient != null )
					{
						httpclient.close();
						httpclient = null;
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}


