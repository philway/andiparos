/*
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
package org.parosproxy.paros.model;

import java.io.File;
import java.util.Vector;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.parosproxy.paros.Constant;
import org.parosproxy.paros.common.AbstractParam;
import org.parosproxy.paros.core.proxy.ProxyParam;
import org.parosproxy.paros.extension.option.OptionsParamCertificate;
import org.parosproxy.paros.extension.option.OptionsParamFonts;
import org.parosproxy.paros.extension.option.OptionsParamHttpHeader;
import org.parosproxy.paros.extension.option.OptionsParamView;
import org.parosproxy.paros.network.ConnectionParam;

public class OptionsParam extends AbstractParam {

	private ProxyParam proxyParam = new ProxyParam();
	private ConnectionParam connectionParam = new ConnectionParam();
	private OptionsParamView viewParam = new OptionsParamView();
	private OptionsParamHttpHeader httpHeaderParam = new OptionsParamHttpHeader();
	private OptionsParamCertificate certificateParam = new OptionsParamCertificate();
	// Andiparos: Dynamically resize fonts
	private OptionsParamFonts fontsParam = new OptionsParamFonts();

	private Vector<AbstractParam> paramSetList = new Vector<AbstractParam>();
	private XMLConfiguration config = null;
	private boolean gui = true;
	private File userDirectory = null;

	
	public OptionsParam() {

	}
	
	/**
	 * @return Returns the connectionParam.
	 */
	public ConnectionParam getConnectionParam() {
		return connectionParam;
	}
	
	/**
	 * @param connectionParam
	 *            The connectionParam to set.
	 */
	public void setConnectionParam(ConnectionParam connectionParam) {
		this.connectionParam = connectionParam;
	}
	

	/**
	 * @return Returns the proxyParam.
	 */
	public ProxyParam getProxyParam() {
		return proxyParam;
	}

	/**
	 * @param proxyParam
	 *            The proxyParam to set.
	 */
	public void setProxyParam(ProxyParam proxyParam) {
		this.proxyParam = proxyParam;
	}
	
	
	/**
	 * @return Returns the viewParam.
	 */
	public OptionsParamView getViewParam() {
		return viewParam;
	}

	/**
	 * @param viewParam
	 *            The viewParam to set.
	 */
	public void setViewParam(OptionsParamView viewParam) {
		this.viewParam = viewParam;
	}
	
	
	/**
	 * @return Returns the httpHeaderParam.
	 */
	public OptionsParamHttpHeader getHttpHeaderParam() {
		return httpHeaderParam;
	}
	
	/**
	 * @param httpHeaderParam
	 *            The httpHeaderParam to set.
	 */
	public void setHttpHeaderParam(OptionsParamHttpHeader httpHeaderParam) {
		this.httpHeaderParam = httpHeaderParam;
	}

	
	/**
	 * @return Returns the certificateParam.
	 */
	public OptionsParamCertificate getCertificateParam() {
		return certificateParam;
	}
	
	/**
	 * @param certificateParam
	 *            The certificateParam to set.
	 */
	public void setCertificateParam(OptionsParamCertificate certificateParam) {
		this.certificateParam = certificateParam;
	}
	
	// Andiparos: Dynamically resize fonts
	/**
	 * @return Returns the fontsParam.
	 */
	public OptionsParamFonts getFontsParam() {
		return fontsParam;
	}
	
	/**
	 * @param fontsParam
	 *            The fontsParam to set.
	 */
	public void setFontsParam(OptionsParamFonts fontsParam) {
		this.fontsParam = fontsParam;
	}
	
	

	/**
	 * @return Returns the currentFolder.
	 */
	public File getUserDirectory() {
		return userDirectory;
	}

	/**
	 * @param currentFolder
	 *            The currentFolder to set.
	 */
	public void setUserDirectory(File currentDirectory) {
		this.userDirectory = currentDirectory;
	}
	
	
	public void addParamSet(AbstractParam paramSet) {
		paramSetList.add(paramSet);
		paramSet.load(getConfig());
	}

	@SuppressWarnings("unchecked")
	public AbstractParam getParamSet(Class className) {

		AbstractParam result = null;
		for (int i = 0; i < paramSetList.size(); i++) {
			Object obj = paramSetList.get(i);
			if (obj.getClass().equals(className)) {
				try {
					result = (AbstractParam) obj;
					break;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public FileConfiguration getConfig() {
		if (config == null) {
			try {
				config = new XMLConfiguration(Constant.getInstance().FILE_CONFIG);
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
		}
		return config;
	}

	protected void parse() {
		getConnectionParam().load(getConfig());
		getProxyParam().load(getConfig());
		getCertificateParam().load(getConfig());
		getViewParam().load(getConfig());
		getHttpHeaderParam().load(getConfig());
		getFontsParam().load(getConfig());
	}

	public boolean isGUI() {
		return gui;
	}

	public void setGUI(boolean gui) {
		this.gui = gui;
	}

	

}
