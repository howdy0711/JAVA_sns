package death;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CCNA_DATA extends JFrame {
	JTextArea jt = new JTextArea();
	ArrayList<String> arr= new ArrayList<>();
	JScrollPane jb;
	public CCNA_DATA(String name){
		setSize(500, 730);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		if(name == "one")
			inputdata(arr,1);
		if(name == "two")
			inputdata(arr,2);
		if(name == "three")
			inputdata(arr,3);
		if(name == "four")
			inputdata(arr,4);
		if(name == "five")
			inputdata(arr,5);
		if(name == "size")
			inputdata(arr,6);
		if(name == "seven")
			inputdata(arr,7);
		if(name == "eight")
			inputdata(arr,8);
		if(name == "nine")
			inputdata(arr,9);
		if(name == "ten")
			inputdata(arr,10);
		
		for(int i=0; i<arr.size(); i++){
			jt.append(arr.get(i)+"\n");
		}
		jb = new JScrollPane(jt,jb.VERTICAL_SCROLLBAR_AS_NEEDED,jb.HORIZONTAL_SCROLLBAR_NEVER);
		add(jb);
		setVisible(true);
	}
	
	
	public void inputdata(ArrayList arr, int i){
		String line;
		try {
			BufferedReader input = new BufferedReader(new FileReader("¹®Á¦\\"+i+".txt");
			while ((line = input.readLine()) != null) {
				arr.add(line);
			}
			input.close();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
