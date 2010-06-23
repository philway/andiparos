/*
 * Copyright (C) 2010, Compass Security AG
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/copyleft/
 * 
 */

package ch.csnc.extension.ui;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import ch.csnc.extension.util.DriverConfiguration;

public class DriversView extends javax.swing.JFrame {

	private static final long serialVersionUID = -4391634667519147940L;

	private DriverTableModel driverTableModel;
	private JTable driverTable;
	
	private JButton addButton;
	private JButton browseButton;
	private JButton closeButton;
	private JButton deleteButton;
	
	private JScrollPane driverScrollPane;
	
	private JLabel fileLabel;
	private JTextField fileTextField;
	
	private JLabel nameLabel;
	private JTextField nameTextField;
	
	private JLabel slotLabel;
	private JTextField slotTextField;
	
	
	/**
	 * Creates new form Drivers
	 * 
	 * @param driverConfig
	 */
	public DriversView(DriverConfiguration driverConfig) {
		this.driverTableModel = new DriverTableModel(driverConfig);
		initComponents();
		setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {
		fileLabel = new JLabel();
		fileTextField = new JTextField();
		browseButton = new JButton();
		nameLabel = new JLabel();
		nameTextField = new JTextField();
		slotLabel = new JLabel();
		slotTextField = new JTextField();
		addButton = new JButton();
		deleteButton = new JButton();
		closeButton = new JButton();
		driverScrollPane = new JScrollPane();
		driverTable = new JTable();

		setTitle("PKCS#11 drivers");
		fileLabel.setText("Path (Path to a DLL for PKCS#11 support"
			+ " - usually delivered with the smartcard software)");

		browseButton.setText("Browse");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				browseButtonActionPerformed(evt);
			}
		});

		nameLabel.setText("Name");

		slotLabel.setText("Slot");

		addButton.setText("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				addButtonActionPerformed(evt);
			}
		});

		deleteButton.setText("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});

		closeButton.setText("Close");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				closeButtonActionPerformed(evt);
			}
		});

		driverTable.setModel(driverTableModel);
		driverScrollPane.setViewportView(driverTable);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
			GroupLayout.Alignment.LEADING).addGroup(
			layout.createSequentialGroup().addContainerGap().addGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(fileLabel).addComponent(nameLabel)
						.addComponent(slotLabel).addGroup(
							layout.createSequentialGroup().addGroup(
								layout.createParallelGroup(
									GroupLayout.Alignment.TRAILING, false)
										.addComponent(nameTextField,
											GroupLayout.Alignment.LEADING)
										.addComponent(slotTextField,
											GroupLayout.Alignment.LEADING)
										.addComponent(fileTextField,
											GroupLayout.Alignment.LEADING,
											GroupLayout.DEFAULT_SIZE, 322,
											Short.MAX_VALUE))

							.addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(
										layout.createParallelGroup(
											GroupLayout.Alignment.LEADING)
												.addComponent(addButton,
													GroupLayout.DEFAULT_SIZE,
													80, Short.MAX_VALUE)
												.addComponent(browseButton))))
					.addContainerGap(165, Short.MAX_VALUE)).addGroup(
			GroupLayout.Alignment.TRAILING,
			layout.createSequentialGroup().addGap(499, 499, 499).addComponent(
				closeButton, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
					.addContainerGap()).addGroup(
			layout.createSequentialGroup().addContainerGap().addComponent(
				driverScrollPane, GroupLayout.DEFAULT_SIZE, 561,
				Short.MAX_VALUE).addContainerGap()).addGroup(
			GroupLayout.Alignment.TRAILING,
			layout.createSequentialGroup()
					.addContainerGap(499, Short.MAX_VALUE).addComponent(
						deleteButton).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
			GroupLayout.Alignment.LEADING).addGroup(
			GroupLayout.Alignment.TRAILING,
			layout.createSequentialGroup().addContainerGap()

			.addComponent(fileLabel).addPreferredGap(
				LayoutStyle.ComponentPlacement.RELATED).addGroup(
				layout
						.createParallelGroup(GroupLayout.Alignment.LEADING,
							false).addComponent(browseButton, 0, 0,
							Short.MAX_VALUE).addComponent(fileTextField))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)

					.addComponent(nameLabel).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(
							GroupLayout.Alignment.BASELINE).addComponent(
							nameTextField, GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE)).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED)

					.addComponent(slotLabel).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addGroup(
						layout.createParallelGroup(
							GroupLayout.Alignment.BASELINE).addComponent(
							slotTextField, GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE).addComponent(addButton,
							GroupLayout.PREFERRED_SIZE, 19,
							GroupLayout.PREFERRED_SIZE)).addGap(28, 28, 28)

					.addComponent(driverScrollPane, GroupLayout.PREFERRED_SIZE,
						195, GroupLayout.PREFERRED_SIZE).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addComponent(
						deleteButton).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED, 9,
						Short.MAX_VALUE).addComponent(closeButton,
						GroupLayout.PREFERRED_SIZE, 10,
						GroupLayout.PREFERRED_SIZE).addContainerGap()));

		layout.linkSize(SwingConstants.VERTICAL, new Component[] { addButton,
				browseButton, closeButton, deleteButton, fileTextField,
				nameTextField });
		pack();
	}

	private void browseButtonActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "DLL";
			}

			@Override
			public boolean accept(java.io.File f) {
				return f.isDirectory() || f.getName().toLowerCase().endsWith(".dll");
			}
		});

		int state = fc.showOpenDialog(null);

		if (state == JFileChooser.APPROVE_OPTION) {
			fileTextField.setText(fc.getSelectedFile().toString());
		}
	}

	private void addButtonActionPerformed(ActionEvent evt) {
		// TODO: Implement error handling for slot ID in case of non-numbers.
		driverTableModel.addDriver(nameTextField.getText(), fileTextField
				.getText(), Integer.parseInt(slotTextField.getText()));
		nameTextField.setText("");
		fileTextField.setText("");
		slotTextField.setText("0");
	}

	private void deleteButtonActionPerformed(ActionEvent evt) {
		driverTableModel.deleteDriver(driverTable.getSelectedRow());
		nameTextField.setText("");
		fileTextField.setText("");
		slotTextField.setText("0");
	}

	private void closeButtonActionPerformed(ActionEvent evt) {
		setVisible(false);
		dispose();
	}

}
