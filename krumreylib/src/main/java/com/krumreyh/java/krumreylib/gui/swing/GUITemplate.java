package com.krumreyh.java.krumreylib.gui.swing;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class that extends Swing's JFrame and has methods that simplify the adding of
 * GUI objects.
 * @author Hermann Krumrey
 * @version 1.0
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
	 * Adds a checkbox to the GUI
	 * @param text - the text to be displayed next to the checkbox
	 * @param xPos - the position on the x axis of the window
	 * @param yPos - the position on the y axis of the window
	 * @param width - the width of the checkbox
	 * @param height - the height of the checkbox
	 * @return the Checkbox object in case it's needed later on
	 */
	protected Checkbox addCheckBox(String text, int xPos, int yPos, int width, int height) {
		Checkbox checkbox = new Checkbox(text);
		checkbox.setLocation(xPos, yPos);
		checkbox.setSize(width, height);
		this.add(checkbox);
		return checkbox;
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
	 * Changes the appearance of a JComponent
	 * @param component - the component whose appearance should be changed
	 * @param fontSize - the new font size
	 * @param fontStyle - the new font style
	 * @param fontType - the new font type
	 * @param backGround - the new background
	 * @param foreGround - the new foreground
	 */
	protected void changeComponentAppearance(JComponent component, int fontSize, int fontStyle, String fontType,
																			Color backGround, Color foreGround) {
		component.setFont(new Font(fontType, fontStyle, fontSize));
		component.setBackground(backGround);
		component.setForeground(foreGround);
	}
	
	/**
	 * Changes the appearance of multiple JComponents
	 * @param components - the component whose appearance should be changed
	 * @param fontSize - the new font size
	 * @param fontStyle - the new font style
	 * @param fontType - the new font type
	 * @param backGround - the new background
	 * @param foreGround - the new foreground
	 */
	protected void changeComponentAppearance(JComponent[] components, int fontSize, int fontStyle, String fontType,
																			Color backGround, Color foreGround) {
		for (int i = 0; i < components.length; i++) {
			changeComponentAppearance(components[i], fontSize, fontStyle, fontType, backGround, foreGround);
		}
	}

	/**
	 * Opens a new popup message contining a short message
	 * @param message - the text to be displayed in the message box
	 */
	protected void showPopUpMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	/**
	 * Starts a new Confirmation dialog
	 * @param message - the message to be displayed
	 * @param title - the  title of the confirmation dialog box
	 * @return true, if the user entered OK, false otherwise
	 */
	protected boolean showConfirmationDialog(String message, String title) {
		int confirmed = JOptionPane.YES_NO_OPTION;
		confirmed = JOptionPane.showConfirmDialog(this, message, title, confirmed);
		return (confirmed == 0);
	}
	
	/**
	 * Shows an input dialog box
	 * @param title - the title of the inputbox
	 * @param message - the message to be displayed to the user
	 * @return the input string (by the user)
	 */
	protected String showInputDialog(String title, String message) {
		JFrame frame = new JFrame(title);
		return JOptionPane.showInputDialog(frame, message);
	}
	
	/**
	 * Class that implements an ActionListener that opens a file open/load dialog
	 */
	protected class LoadSaveDialog implements ActionListener {
		
		private String[] allowedFileTypes;
		private String dialogMessage;
		private String type;
		
		//TODO Replace String with enum for load or save
		/**
		 * Constructor that defines the settings for the save/load dialog
		 * @param allowedFileTypes - the allowed file types as a String array
		 * @param dialogMessage - the dialog message to be displayed
		 * @param type - the type of dialog - load or save
		 */
		public LoadSaveDialog(String[] allowedFileTypes, String dialogMessage, String type) {
			this.allowedFileTypes = allowedFileTypes;
			this.dialogMessage = dialogMessage;
			this.type = type;
		}
		
		/**
		 * The action performed by the button press
		 * Opens a new Save/Load Dialog
		 * @param e - the button-press event
		 */
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
					System.out.println("");
				} else if (this.type.toLowerCase().equals("load")) {
					GUITemplate.this.currentFile =  chooser.getSelectedFile();
				}
			}
		}
	}
}

//TODO Use Vererbung with JComponent where possible