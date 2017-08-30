package death;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Message extends JFrame{
	
	
	Color color = new Color(120,205,209);
	Color color1 = new Color(255,255,255);
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Font font1 = new Font("¸¼Àº °íµñ",Font.BOLD,12);
	public Message(String name){
	
	setSize(200,100);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	panel.setLayout(null);
	label.setBounds(55, 20, 100, 30);
	label.setText(name);
	label.setFont(font1);
	label.setForeground(color);

	panel.add(label);
	panel.setBackground(Color.white);
	add(panel);
	setResizable(false);
	setVisible(true);
	}
	
}