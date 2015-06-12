package com.krumreyh.java.krumreylib.gui.swing;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class that extends Swing's JFrame and has methods that simplify the adding of
 * GUI objects.
 * @author Hermann Krumrey
 * @version 0.1
 */
public class GUITemplate extends JFrame {
	
	protected File currentFile;
	
	/**
	 * Main method that starts the GUI
	 * @param args - command line parameters
	 */
	public static void main(String[] args) {
		new GUITemplate();
	}
	
	/**
	 * Constructor of the GUI, constructs an empty window
	 */
	public GUITemplate() {
	}
	
	/**
	 * Sets the outer parameters of the GUI
	 * @param title - the title of the windows
	 * @param xLocation - the initial location on the x-Axis of the screen
	 * @param yLocation - the initial location on the y-axis of the screen
	 * @param xSize - the (initial) width of the window
	 * @param ySize - the (initial) height of the window
	 * @param layoutManager - the layoutManager used
	 * @param closeOp - the default operation when closing the program
	 * @param resizable - sets if the windows is resizeable or not
	 */
	protected void setGUISettings(String title, int xLocation, int yLocation, int xSize, int ySize, 
									LayoutManager layoutManager, int closeOp, boolean resizable) {
		this.setTitle(title);
		this.setLocation(xLocation, yLocation);
		this.setSize(xSize, ySize);
		this.setLayout(layoutManager);
		this.setDefaultCloseOperation(closeOp);
		this.setResizable(resizable);
	}
	
	/**
	 * Starts the GUI
	 */
	protected void startGUI() {
		this.setVisible(true);
	}
	
	/**
	 * adds a label to the GUI with the specified parameters.
	 * @param text - the text to be displayed
	 * @param xPos - the x-position of the field
	 * @param yPos - the y-position of the field
	 * @param width - the width of the field
	 * @param height - the height of the field
	 * @return the generated JLabel object in case it is needed afterwards
	 */
	protected JLabel addLabel(String text, int xPos, int yPos, int width, int height) {
		JLabel label = new JLabel(text);
		label.setLocation(xPos, yPos);
		label.setSize(width, height);
		this.add(label);
		return label;
	}
	
	
	/**
	 * adds a text field to the GUI with the specified parameters.
	 * @param text - the text to be displayed initially
	 * @param xPos - the x-position of the field
	 * @param yPos - the y-position of the field
	 * @param width - the width of the field
	 * @param height - the height of the field
	 * @return the JTextField object created, so that it's content can be used later on
	 */
	protected JTextField addTextField(String text, int xPos, int yPos, int width, int height) {
		JTextField textField = new JTextField(text);
		textField.setLocation(xPos, yPos);
		textField.setSize(width, height);
		this.add(textField);
		return textField;
	}
	
	/**
	 * Adds a button to the GUI
	 * @param text - the text to be displayed on the button
	 * @param xPos - the x-position of the button
	 * @param yPos - the y-position of the button
	 * @param width - the width of the button
	 * @param height - the height of the button
	 * @param listener - the command to be executed when the button is pressed
	 * @return the generated JButton object in case it is needed later on.\
	 */
	protected JButton addButton(String text, int xPos, int yPos, int width, int height, ActionListener listener) {
		JButton button = new JButton(text);
		button.setLocation(xPos, yPos);
		button.setSize(width, height);
		button.addActionListener(listener);
		this.add(button);
		return button;
	}
	
	/**
	 * Class that implements an ActionListener that opens a file open/load dialog
	 */
	protected class LoadSaveDialog implements ActionListener {
		
		private String[] allowedFileTypes;
		private String dialogMessage;
		private String type;
		
		//TODO Replace String with enum for load or save
		public LoadSaveDialog(String[] allowedFileTypes, String dialogMessage, String type) {
			this.allowedFileTypes = allowedFileTypes;
			this.dialogMessage = dialogMessage;
			this.type = type;
		}
		
		public void actionPerformed(ActionEvent e) {
			JFileChooser chooser = new JFileChooser();
			//TODO Find a way for variable amount of file extensions in filter
			FileNameExtensionFilter filter = new FileNameExtensionFilter(this.dialogMessage, allowedFileTypes[0]);
			chooser.setFileFilter(filter);
			int returnVal = 0;
			if (this.type.toLowerCase().equals("save")) {
				returnVal = chooser.showOpenDialog(null);
			} else if (this.type.toLowerCase().equals("load")) {
				returnVal = chooser.showSaveDialog(null);
			}
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				if (this.type.toLowerCase().equals("save")) {
					//TODO Figure out how to save something
				} else if (this.type.toLowerCase().equals("load")) {
					GUITemplate.this.currentFile =  chooser.getSelectedFile();
				}
			}
		}
	}
}
