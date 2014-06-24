package com.sync.ui.cloud;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import com.sync.adapter.LabelAdapter;

public class HeadPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel nickNameLabel = null;
	public JLabel statusLabel = null;

	/**
	 * Create the panel.
	 */
	public HeadPanel() {
		initialize();
	}

	private void initialize() {

		setForeground(Color.GRAY);
		this.setBounds(80, 90, 640, 100);
		setLayout(null);

		JLabel headP = new JLabel("头像");
		headP.setHorizontalAlignment(SwingConstants.CENTER);
		headP.setBounds(10, 10, 80, 80);
		headP.setIcon(new ImageIcon(HeadPanel.class
				.getResource("/com/sync/ui/cloud/res/head_p.jpg")));
		add(headP);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(100, 65, 220, 14);
		add(progressBar);

		nickNameLabel = new JLabel("| 注销");
		nickNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nickNameLabel.setBounds(100, 21, 200, 34);
		add(nickNameLabel);

		String mouseEntered_sync = "/com/sync/ui/cloud/res/sync_done_entered.png";
		String mousePressed_sync = "/com/sync/ui/cloud/res/sync_done_pressed.png";
		String normal_sync = "/com/sync/ui/cloud/res/sync_done_normal.png";
		JLabel syncButton = new JLabel("");
		syncButton.setIcon(new ImageIcon(HeadPanel.class
				.getResource(normal_sync)));
		syncButton.addMouseListener(new LabelAdapter(mouseEntered_sync,
				mousePressed_sync, normal_sync));
		syncButton.setHorizontalAlignment(SwingConstants.CENTER);
		syncButton.setBounds(465, 42, 165, 38);
		add(syncButton);

		statusLabel = new JLabel("同步中...|");
		statusLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		statusLabel.setBounds(330, 57, 125, 22);
		add(statusLabel);
	}
}
