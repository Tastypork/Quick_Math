/* 	The Quick Math Calculator
 *  Author: Joshua O'Callaghan
 *  Jan 05 2018
 *  Description: The Quick Math calculator is a simple program designed
 *  to do simple operations on integers.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

public class QuickMath extends JPanel {
	
	// declares the components of the JPanel
	private JButton equalB;
	private JTextField input1, input2;
	private JComboBox<String> operator;
	private JLabel result;
	private static QuickMath qm1;
	
	public QuickMath() {

		// initializes the Layout as well as a border
		setLayout(new BorderLayout());
	    EmptyBorder eb = new EmptyBorder(5, 5, 5, 5);
	    SoftBevelBorder sbb = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	    setBorder(eb);
	    
	    // declares and initializes the JPanel
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout());		
		JPanel p2 = new JPanel();
		p2.setBorder(sbb);
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,4));
		
		// defines font used for the program and strings for JComboBox
	    Font font = new Font("TimesRoman", Font.BOLD, 48); 
		String[] opStrings = {"+", "-", "/", "*"};
		
		// initializes the components of the JPanel
		operator = new JComboBox<String>(opStrings);
		operator.setFont(font);
		equalB = new JButton("=");
		equalB.setPreferredSize(new Dimension(40, 40));
		equalB.setFont(font);
		input1 = new JTextField();
		input1.setFont(font);
		input2 = new JTextField();
		input2.setFont(font);
		result = new JLabel(" ");
		result.setFont(font);
		
		// adds the components to the panel
		p3.add(Box.createRigidArea(new Dimension(10, 0))); // rigid areas for spacing
		p3.add(input1);
		p3.add(operator);
		p3.add(input2);
		p3.add(equalB);		
		p3.add(Box.createRigidArea(new Dimension(10, 0)));		
		p2.add(Box.createRigidArea(new Dimension(0, 75)));
		p2.add(p3);
		p2.add(Box.createRigidArea(new Dimension(0, 25)));
		p2.add(result);
		p2.add(Box.createRigidArea(new Dimension(0, 100)));
		p1.add(p2);
		add(p1);
		
		// button listener
		equalB.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener
	{
		// when button is pressed, check JComboBox for operator then perform
		// operator with the integers in the JTextFields
		public void actionPerformed (ActionEvent event)
		{
			int first, second;
			String op;
			
			// makes sure that the text boxes are not empty
			if ((!input1.getText().isEmpty() && !input2.getText().isEmpty()))
			{
				// makes sure that the characters are not letters
				if ((!input1.getText().chars().allMatch(Character::isLetter) && 
						!input2.getText().chars().allMatch(Character::isLetter))) 
				{
					first = Integer.parseInt(input1.getText());
					second = Integer.parseInt(input2.getText());
					op = (String) operator.getSelectedItem();
					
					// decision making for which operator to use
					if(op.equals("+"))
					{
						result.setText(Integer.toString(first + second));
					}
					else if(op.equals("-"))
					{
						result.setText(Integer.toString(first - second));
					}
					else if(op.equals("*"))
					{
						result.setText(Integer.toString(first * second));
					}
					else if(op.equals("/"))
					{
						result.setText(Integer.toString(first / second));
					}
				}
				// error message if the string contains letters
				else
				{
					JOptionPane.showMessageDialog(qm1, "Please enter an integer");
				}
			}
			// error message if the string is empty
			else
			{
				JOptionPane.showMessageDialog(qm1, "Please enter an integer");
			}
			
		}
	}

	// main class which constructs the JFrame
	public static void main(String[] args) {
		
		QuickMath qm = new QuickMath();
		JFrame f = new JFrame("Quick Math Calculator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add("Center", qm);
		f.setSize(600, 400);
		f.setResizable(false);
		f.setVisible(true);
	}
}
