import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Convert implements ActionListener{
	JTextField T1,T2;
	JFrame F;
	JButton btn = new JButton("Convert");
	JButton exit = new JButton("Exit");
	JLabel L1,L2,Empty;
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	
	
	public Convert() {
		F = new JFrame();
		T1 = new JTextField(10);
		T2 = new JTextField(10);

		L1 = new JLabel("Input");
		L2 = new JLabel("Output");

		Empty = new JLabel("");
		
		F.setLayout(new GridLayout(5, 2));
		
		btn.addActionListener(this);
		exit.addActionListener(this);
		F.add(L1); F.add(T1);
		F.add(Empty); F.add(btn);
		F.add(L2); F.add(T2);

		F.add(exit);
		F.setSize(400,400);
	}
	
	public void ShowWindow(String title) {
		
		F.setTitle(title);
		F.setLocation((dim.width/2-F.getSize().width/2) - 30, (dim.height/2-F.getSize().height/2) - 30);
		T1.setText(""); T2.setText("");
		F.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent E) {
		
		JButton I = (JButton) E.getSource();
		if(I == exit) {
			F.setVisible(false);
			
			return;
		}
		String T = F.getTitle();
		
		if(T == "binary2Decimal")
		{
			char[] c = T1.getText().toCharArray();
			char[] c2 = new char[c.length];
			int out = 0;
			for(int i = c.length-1, j = 0; i >= 0; i--, j++) {
				c2[j] = c[i];
				out += binaryToDecimal((c2[j] - '0'), j);
			}
			
			T2.setText(Integer.toString(out));
			
		} else if (T == "decimal2Binary")
		{
			int number = Integer.parseInt(T1.getText());
			char[] array = new char[1];
			
			if(number >= 16384) array = new char[15];
			else if(number >= 8192) array = new char[14];
			else if(number >= 4096) array = new char[13];
			else if(number >= 2048) array = new char[12];
			else if(number >= 1024) array = new char[11];
			else if(number >= 512) array = new char[10];
			else if(number >= 256) array = new char[9];
			else if(number >= 128) array = new char[8];
			else if(number >= 64) array = new char[7];
			else if(number >= 32) array = new char[6];
			else if(number >= 16) array = new char[5];
			else if(number >= 8) array = new char[4];
			else if(number >= 4) array = new char[3];
			else if(number >= 2) array = new char[2];
			else if(number >= 1) array = new char[1];

			int counter = array.length-1;

			do {
				if(number%2 == 0)
					array[counter] = 0;
				else
					array[counter] = 1;
				
				number /= 2;
				counter--;
			} while (number > 0);
			
			String output = "";
			
			for(char digit : array)
				output += (char)(digit + '0');
	
			T2.setText(output);
		}
	}
	
	public int binaryToDecimal(int in, int index) {
		int out = 0;
		
		if(in == 1)
			out = (int) Math.pow(2, index);
		
		return out;
	}
}
