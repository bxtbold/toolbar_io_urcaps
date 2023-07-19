package com.bxtbold.toolbar_io.impl;

import com.ur.urcap.api.contribution.toolbar.swing.SwingToolbarService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		bundleContext.registerService(SwingToolbarService.class, new IOToolbarService(), null);
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	}
}


