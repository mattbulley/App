import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculations implements ActionListener{
	JTextField T1,T2,T3;
	JFrame F;
	JButton btn = new JButton("Calculate");
	JButton exit = new JButton("Exit");
	JLabel L1,L2,L3,Empty;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public Calculations() {
		F = new JFrame();
		T1 = new JTextField(10);
		T2 = new JTextField(10);
		T3 = new JTextField(10);
		L1 = new JLabel("First No");
		L2 = new JLabel("Second No");
		L3 = new JLabel("Result");
		Empty = new JLabel("");
		
		F.setLayout(new GridLayout(5, 2));
		
		btn.addActionListener(this);
		exit.addActionListener(this);
		F.add(L1); F.add(T1);
		F.add(L2); F.add(T2);
		F.add(Empty); F.add(btn);
		F.add(L3); F.add(T3);
		F.add(exit);
		F.setSize(400,400);
	}
	
	public void ShowWindow(String title) {
		
		F.setTitle(title);
		F.setLocation((dim.width/2-F.getSize().width/2) - 30, (dim.height/2-F.getSize().height/2) - 30);
		T1.setText(""); T2.setText(""); T3.setText("");
		F.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent E) {
		
		JButton I = (JButton) E.getSource();
		if(I == exit) {
			F.setVisible(false);
			
			return;
		}
		
		int A,B,C;
		float D = 0.0f;
		C = 0;
		String T = F.getTitle();
		A = Integer.parseInt(T1.getText());
		B = Integer.parseInt(T2.getText());
		

		if(T.equals("Addition"))
			C = A + B;
		if(T.equals("Subtraction"))
			C = A - B;
		if(T.equals("Division"))
			D = (float)A / (float)B;
		if(T.equals("Multiplication"))
			C = A * B;
		
		if(D != 0.0f)
			T3.setText(Float.toString(D));
		else
			T3.setText(Integer.toString(C));
	}
}
