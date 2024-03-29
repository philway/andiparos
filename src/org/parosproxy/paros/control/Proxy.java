/*
 * Created on May 30, 2004
 *
 * Paros and its related class files.
 * 
 * Paros is an HTTP/HTTPS proxy for assessing web application security.
 * Copyright (C) 2003-2004 Chinotec Technologies Company
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the Clarified Artistic License
 * as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Clarified Artistic License for more details.
 * 
 * You should have received a copy of the Clarified Artistic License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.parosproxy.paros.control;

import org.parosproxy.paros.core.proxy.CacheProcessingItem;
import org.parosproxy.paros.core.proxy.ProxyListener;
import org.parosproxy.paros.core.proxy.ProxyServer;
import org.parosproxy.paros.core.proxy.ProxyServerSSL;
import org.parosproxy.paros.model.Model;

public class Proxy {

	// private View view = null;
	private Model model = null;
	private ProxyServer proxyServer = null;
	private ProxyServerSSL proxyServerSSL = null;
	private boolean reverseProxy = false;
	private String reverseProxyHost = "";

	public Proxy(Model model) {

		this.model = model;

		proxyServer = new ProxyServer();
		proxyServerSSL = new ProxyServerSSL();

	}

	public void startServer() {

		// setProxyParam put in here so restart can reread param.
		proxyServer.setProxyParam(model.getOptionsParam().getProxyParam());
		proxyServer.setConnectionParam(model.getOptionsParam().getConnectionParam());

		proxyServerSSL.setProxyParam(model.getOptionsParam().getProxyParam());
		proxyServerSSL.setConnectionParam(model.getOptionsParam().getConnectionParam());

		if (model.getOptionsParam().getProxyParam().isUseReverseProxy()) {

			proxyServerSSL.startServer(
					model.getOptionsParam().getProxyParam().getReverseProxyIp(),
					model.getOptionsParam().getProxyParam().getReverseProxyHttpsPort(),
					false);

			proxyServer.startServer(
					model.getOptionsParam().getProxyParam().getReverseProxyIp(),
					model.getOptionsParam().getProxyParam().getReverseProxyHttpPort(),
					false);

		} else {

			proxyServer.startServer(
					model.getOptionsParam().getProxyParam().getProxyIp(),
					model.getOptionsParam().getProxyParam().getProxyPort(),
					false);

		}
	}

	public void stopServer() {
		if (model.getOptionsParam().getProxyParam().isUseReverseProxy()) {
			proxyServerSSL.stopServer();
			proxyServer.stopServer();

		} else {
			proxyServer.stopServer();
		}
	}

	public void setSerialize(boolean serialize) {
		proxyServer.setSerialize(serialize);
		proxyServerSSL.setSerialize(serialize);
	}

	public void addProxyListener(ProxyListener listener) {
		proxyServer.addProxyListener(listener);
		proxyServerSSL.addProxyListener(listener);

	}

	public void removeProxyListener(ProxyListener listener) {
		proxyServer.removeProxyListener(listener);
		proxyServerSSL.removeProxyListener(listener);
	}

	/**
	 * @return Returns the reverseProxy.
	 */
	public boolean isReverseProxy() {
		return reverseProxy;
	}

	/**
	 * @param reverseProxy
	 *            The reverseProxy to set.
	 */
	public void setReverseProxy(boolean reverseProxy) {
		this.reverseProxy = reverseProxy;
	}

	/**
	 * @return Returns the reverseProxyHost.
	 */
	public String getReverseProxyHost() {
		return reverseProxyHost;
	}

	/**
	 * @param reverseProxyHost
	 *            The reverseProxyHost to set.
	 */
	public void setReverseProxyHost(String reverseProxyHost) {
		this.reverseProxyHost = reverseProxyHost;
	}

	/**
	 * @param enableCacheProcessing
	 *            The enableCacheProcessing to set.
	 */
	public void setEnableCacheProcessing(boolean enableCacheProcessing) {
		if (proxyServer != null) {
			proxyServer.setEnableCacheProcessing(enableCacheProcessing);
		}

		if (proxyServerSSL != null) {
			proxyServerSSL.setEnableCacheProcessing(enableCacheProcessing);
		}

	}

	public void addCacheProcessingList(CacheProcessingItem item) {
		if (proxyServer != null) {
			proxyServer.addCacheProcessingList(item);
		}

		if (proxyServerSSL != null) {
			proxyServerSSL.addCacheProcessingList(item);
		}

	}
}
