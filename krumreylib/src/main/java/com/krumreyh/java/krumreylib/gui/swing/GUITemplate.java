package com.krumreyh.java.krumreylib.gui.swing;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.krumreyh.java.krumreylib.arrayops.GenericArray;

/**
 * Class that extends Swing's JFrame and has methods that simplify the adding of
 * GUI objects.
 * @author Hermann Krumrey
 * @version 1.0
 */
public class GUITemplate extends JFrame {
	
	@SuppressWarnings("rawtypes")
	private GenericArray<GenericArray> components = new GenericArray<GenericArray>();
	private GenericArray<JLabel> labels = new GenericArray<JLabel>();
	private GenericArray<JButton> buttons = new GenericArray<JButton>();
	private GenericArray<Checkbox> checkBoxes = new GenericArray<Checkbox>();
	private GenericArray<JTextField> textFields = new GenericArray<JTextField>();
	private GenericArray<JComboBox<String>> dropDowns = new GenericArray<JComboBox<String>>();
	
	/**
	 * Main method that starts the GUI
	 * @param args - command line parameters
	 */
	public static void main(String[] args) {
		new GUITemplate();
	}
	
	/**
	 * Constructor of the GUI, initializes Arrays of GUI Components
	 */
	public GUITemplate() {
		this.components.extend(5);
		this.components.setElement(0, this.labels);
		this.components.setElement(1, this.buttons);
		this.components.setElement(2, this.checkBoxes);
		this.components.setElement(3, this.textFields);
		this.components.setElement(4, this.dropDowns);
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
		this.getContentPane().setPreferredSize(new Dimension(xSize, ySize));
		this.setLayout(layoutManager);
		this.setDefaultCloseOperation(closeOp);
		this.setResizable(resizable);
		this.pack();
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
	@SuppressWarnings("unchecked")
	protected JLabel addLabel(String text, int xPos, int yPos, int width, int height) {
		JLabel label = new JLabel(text);
		label.setLocation(xPos, yPos);
		label.setSize(width, height);
		this.add(label);
		this.components.getElement(0).pushBack(label);
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
	@SuppressWarnings("unchecked")
	protected Checkbox addCheckBox(String text, int xPos, int yPos, int width, int height) {
		Checkbox checkbox = new Checkbox(text);
		checkbox.setLocation(xPos, yPos);
		checkbox.setSize(width, height);
		this.add(checkbox);
		this.components.getElement(2).pushBack(checkbox);
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
	@SuppressWarnings("unchecked")
	protected JTextField addTextField(String text, int xPos, int yPos, int width, int height) {
		JTextField textField = new JTextField(text);
		textField.setLocation(xPos, yPos);
		textField.setSize(width, height);
		this.add(textField);
		this.components.getElement(3).pushBack(textField);
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
	@SuppressWarnings("unchecked")
	protected JButton addButton(String text, int xPos, int yPos, int width, int height, ActionListener listener) {
		JButton button = new JButton(text);
		button.setLocation(xPos, yPos);
		button.setSize(width, height);
		button.addActionListener(listener);
		this.add(button);
		this.components.getElement(1).pushBack(button);
		return button;
	}
	
	/**
	 * Adds a dropdown menu to the GUI. It provides String selection.
	 * @param entries - the entries in the dropdown menu
	 * @param xPos - the x position of the item
	 * @param yPos - the y position of the item
	 * @param width - the width of the item
	 * @param height - the height of the item
	 * @return the created dropdown menu in case it is used later on in the program
	 */
	@SuppressWarnings("unchecked")
	protected JComboBox<String> addDropDownMenu(String[] entries, int xPos, int yPos, int width, int height) {
		JComboBox<String> dropDown = new JComboBox<String>(entries);
		dropDown.setLocation(xPos, yPos);
		dropDown.setSize(width, height);
		this.add(dropDown);
		this.components.getElement(4).pushBack(dropDown);
		return dropDown;
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
	
	protected void setGUIStyle(int fontSize, int fontStyle, String fontType, Color backGround, Color foreGround) {
		for (int i = 0; i < this.components.length(); i++) {
			for (int j = 0; j < this.components.getElement(i).length(); j++) {
				changeComponentAppearance((JComponent)this.components.getElement(i).getElement(j), fontSize, fontStyle, fontType, backGround, foreGround);
			}
		}
	}
}