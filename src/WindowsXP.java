import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WindowsXP implements ActionListener{
	JMenuItem item1, item2, item3, item4, decimal2Binary, binary2Decimal;
	Calculations calc;
	Convert convert;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public WindowsXP() {
		JFrame win = new JFrame("Windows-XP");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Maths");
		JMenu menu2 = new JMenu("Convert");
		item1 = new JMenuItem("Addition");
		item2 = new JMenuItem("Subtraction");
		item3 = new JMenuItem("Division");
		item4 = new JMenuItem("Multiplication");
		decimal2Binary = new JMenuItem("decimal2Binary");
		binary2Decimal = new JMenuItem("binary2Decimal");
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		decimal2Binary.addActionListener(this);
		binary2Decimal.addActionListener(this);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		menu2.add(decimal2Binary);
		menu2.add(binary2Decimal);
		menuBar.add(menu1);
		menuBar.add(menu2);
		win.setJMenuBar(menuBar);
		win.setSize(400,400);
		win.setLocation(dim.width/2-win.getSize().width/2, dim.height/2-win.getSize().height/2);
		win.setVisible(true);
		calc = new Calculations();
		convert = new Convert();
		
	}
	
	public void actionPerformed(ActionEvent E) {
		JMenuItem I = (JMenuItem) E.getSource();
		if(I == item1) {
			calc.ShowWindow("Addition");
		}
		if(I == item2) {
			calc.ShowWindow("Subtraction");
		}
		if(I == item3) {
			calc.ShowWindow("Division");
		}
		if(I == item4) {
			calc.ShowWindow("Multiplication");
		}
		if(I == decimal2Binary) {
			convert.ShowWindow("decimal2Binary");
		}
		if(I == binary2Decimal) {
			convert.ShowWindow("binary2Decimal");
		}
	}
}
