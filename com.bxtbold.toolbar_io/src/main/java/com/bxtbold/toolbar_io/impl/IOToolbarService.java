package com.bxtbold.toolbar_io.impl;

import com.ur.urcap.api.contribution.toolbar.ToolbarConfiguration;
import com.ur.urcap.api.contribution.toolbar.ToolbarContext;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarService;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class IOToolbarService implements SwingToolbarService {

	@Override
	public Icon getIcon() {
		return new ImageIcon(getClass().getResource("/icons/github-icon.png"));
	}

	@Override
	public void configureContribution(ToolbarConfiguration configuration) {
		configuration.setToolbarHeight(400);
	}

	@Override
	public SwingToolbarContribution createToolbar(ToolbarContext context) {
		return new IOToolbarContribution();
	}
}
