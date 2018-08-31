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
	
	private JButton equalB;
	private JTextField input1, input2;
	private JComboBox operator;
	private JLabel result;
	
	public QuickMath() {

		setLayout(new BorderLayout());
	    EmptyBorder eb = new EmptyBorder(5, 5, 5, 5);
	    SoftBevelBorder sbb = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	    setBorder(eb);
	    Font font = new Font("TimesRoman", Font.BOLD, 48); 

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout());
		
		JPanel p2 = new JPanel();
		p2.setBorder(sbb);
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,4));
		
		String[] opStrings = {"+", "-", "/", "*"};
		operator = new JComboBox(opStrings);
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
		
		p3.add(Box.createRigidArea(new Dimension(10, 0)));
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
		
		equalB.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			int first, second;
			String op;
			
			if (!input1.getText().isEmpty() && !input2.getText().isEmpty())
			{
				first = Integer.parseInt(input1.getText());
				second = Integer.parseInt(input2.getText());
				op = (String) operator.getSelectedItem();
				
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
			
		}
	}

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
