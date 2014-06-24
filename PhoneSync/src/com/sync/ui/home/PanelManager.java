package com.sync.ui.home;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class PanelManager {
	
	private Map<String, JPanel> panelMap = null;
	private String showingPanel = null; 
	public PanelManager(){
		panelMap = new HashMap<String, JPanel>();
	}
	
	public void add(String key,JPanel panel){
		panelMap.put(key, panel);
		show(key);
	}
	
	public void show(String panelName){
		if(showingPanel != null)
			panelMap.get(showingPanel).setVisible(false);
		panelMap.get(panelName).setVisible(true);
		showingPanel = panelName;
	}

}
