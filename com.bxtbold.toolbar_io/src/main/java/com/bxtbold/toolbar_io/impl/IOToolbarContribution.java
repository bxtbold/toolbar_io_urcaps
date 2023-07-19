package com.bxtbold.toolbar_io.impl;

import com.bxtbold.toolbar_io.communicator.*;
import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarContribution;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


class IOToolbarContribution implements SwingToolbarContribution {
	private static final int VERTICAL_SPACE = 10;
	private final ScriptSender sender;

	IOToolbarContribution() {
		this.sender = new ScriptSender();
	}

	@Override
	public void openView() {
	}

	@Override
	public void closeView() {
	}

	public void buildUI(JPanel jPanel) {
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

		jPanel.add(createOnButton());
		jPanel.add(createVerticalSpace());
		jPanel.add(createOffButton());
	}

	private Component createVerticalSpace() {
		return Box.createRigidArea(new Dimension(0, VERTICAL_SPACE));
	}

	private Box createOnButton() {
		Box box = Box.createVerticalBox();
		JButton button = new JButton("ON BUTTON");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onIO();
			}
		});
		box.add(button);
		return box;
	}

	private Box createOffButton() {
		Box box = Box.createVerticalBox();
		JButton button = new JButton("OFF BUTTON");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				offIO();
			}
		});
		box.add(button);
		return box;
	}

	public void onIO() {
		ScriptCommand onCommand = new ScriptCommand("onIOSend");
		onCommand.setAsSecondaryProgram();
		onCommand.appendLine("set_digital_out(0,True)");
		sender.sendScriptCommand(onCommand);
	}

	public void offIO() {
		ScriptCommand offCommand = new ScriptCommand("offIOSend");
		offCommand.setAsSecondaryProgram();
		offCommand.appendLine("set_digital_out(0,False)");
		sender.sendScriptCommand(offCommand);
	}
}
