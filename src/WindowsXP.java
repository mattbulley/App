import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WindowsXP implements ActionListener{
	JMenuItem item1, item2, item3, item4;
	Calculations calc;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	public WindowsXP() {
		JFrame win = new JFrame("Windows-XP");
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Maths");
		JMenu menu2 = new JMenu("Test");
		item1 = new JMenuItem("Addition");
		item2 = new JMenuItem("Subtraction");
		item3 = new JMenuItem("Division");
		item4 = new JMenuItem("Multiplication");
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		menuBar.add(menu1);
		menuBar.add(menu2);
		win.setJMenuBar(menuBar);
		win.setSize(400,400);
		win.setLocation(dim.width/2-win.getSize().width/2, dim.height/2-win.getSize().height/2);
		win.setVisible(true);
		calc = new Calculations();
		
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
	}
}
