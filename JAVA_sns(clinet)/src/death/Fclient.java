package death;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

import com.mysql.fabric.xmlrpc.base.Data;

import death.Madang.Profile;


class Fclient extends JFrame implements ActionListener {
		private JButton b1,b2 = null;
		
		private JFileChooser fselect = new JFileChooser();
		FileSender fs;
		DataInputStream dis;
		DataOutputStream dos;
		private JPanel panel = null; 
		String id;
		
		Profile profile;
		
	public Fclient(DataInputStream dis , DataOutputStream dos , Profile profile){
		this.profile = profile;
		this.dis = dis;
		this.dos = dos;

		try {
			
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    SwingUtilities.updateComponentTreeUI(this.fselect);
		} catch (Exception ex) {
		    // LookAndFeel 설정 실패
		    ex.printStackTrace();
		}
    	//JFileChooser Theme
		
		/*setSize(300,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("프로필수정");
		
		panel = new JPanel();
		b1 = new JButton("등록하기");
		b1.setEnabled(false);
		
		b2 = new JButton("이미지선택");
		
		b1.addActionListener(this);
		b2.addActionListener(this);*/
		
		
		
		
		if(fselect.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
    	{
    		
    		if(getExtension(fselect.getSelectedFile().getName()))
    		{
    			fs = new FileSender(dos,fselect.getSelectedFile().toString());
    			//fs = new FileSender(socket,fselect.getSelectedFile().toString());
				
				try {
					Profile.img = new ImageIcon(fselect.getSelectedFile().toString());
	    			profile.repaint();
					Main.Flag("profile",dos);
					fs.start();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			
    			
    			//b1.setEnabled(true);
    		}
    		
    		else new Message("지원하지 않는 확장자입니다.");
    		
    	}
		
		//panel.add(b1);
		//panel.add(b2);
		//this.add(panel);
		
		setVisible(false);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		
		/*if (e.getSource() == b1)
		{
		
		
					//fs = new FileSender(socket,fselect.getSelectedFile().toString());
					
					try {
						Profile.img = new ImageIcon(fselect.getSelectedFile().toString());
		    			profile.repaint();
						Main.Flag("profile",dos);
						fs.start();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
		}
	    if(e.getSource() == b2)
	    {
	    	
	    	//JFileChooser Theme
	    	
	    	
	    	if(fselect.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
	    	{
	    		
	    		if(getExtension(fselect.getSelectedFile().getName()))
	    		{
	    			fs = new FileSender(dos,fselect.getSelectedFile().toString());
	    	
	    			
	    			
	    			b1.setEnabled(true);
	    		}
	    		
	    		else new Message("지원하지 않는 확장자입니다.");
	    		
	    	}
	    		
	    }*/
	        
		
	}
	public static boolean getExtension(String fileStr){
		  String EXT = fileStr.substring(fileStr.lastIndexOf(".")+1,fileStr.length());
		  if(EXT.compareToIgnoreCase("png")==0 || EXT.compareToIgnoreCase("jpg")==0 || EXT.compareToIgnoreCase("jpeg")==0 || EXT.compareToIgnoreCase("bmp") == 0)
		  {
			  return true;
		  }
		  else
			  return false;
	}
	
	
}
class Bar extends JFrame implements ActionListener{
	private double fsize=0;
	private double totalsize=0;
	private double downloading=0;
	private Border border;
	private JButton b;
	//private JFrame frame;
	public double getFsize() {
		return fsize;
	}

	public void setFsize(double fsize) {
		this.fsize = fsize;
	}

	public double  getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(double totalsize) {
		this.totalsize = totalsize;
	}

	
	JProgressBar bar = new JProgressBar();
	public Bar(){
		//frame = new JFrame("진행률");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(300, 100);
		setLocationRelativeTo(null);
		border = BorderFactory.createTitledBorder("전송중 입니다.");
		bar.setBorder(border);
		bar.setValue(0);
		bar.setStringPainted(true);
		b = new JButton("완료");
		b.setEnabled(false);
		b.addActionListener(this);
	
		bar.setStringPainted(true);
		
		Container content = getContentPane();
		content.add(bar,BorderLayout.NORTH);
		content.add(b);
		
		setVisible(true);
		
	}
	
	

	public void downloading(double fsize) {
			this.fsize = fsize;
			downloading += this.fsize;
			bar.setValue((int)((downloading*100.0)/totalsize));
			bar.setStringPainted(true);
			
			if(bar.getValue() == 100)
			{
				border = BorderFactory.createTitledBorder("작업이 완료되었습니다.");
				b.setEnabled(true);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b)
		{
			this.dispose();
		}
		
	}
}




/*public class Fclient {

	//public static void main(String[] args) throws IOException{
		
		//String serverIp = "127.0.0.1";
		//Socket socket ;
		MyFrame f = new MyFrame(socket);
 
        try {
            //서버 연결
            f.socket = new Socket(f.serverIp, 6000);
            System.out.println("서버에 연결되었습니다.");
          
            
            //FileSender fs = new FileSender(socket);
            //fs.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
   // }
}*/
 
class FileSender extends Thread implements Runnable{
	
    Socket socket;
    DataOutputStream dos;
    FileInputStream fis;
    BufferedInputStream bis;
    String fName;
    String path;
    //String id;
    public FileSender(DataOutputStream dos,String path) {
    	
    	this.dos = dos;
        this.path = path;
   
           
          
    }
 
    @Override
    public void run() {
    	int i=0,count;
    	String path1="";
        try {
        	StringTokenizer st = new StringTokenizer(path,"\\");
    		System.out.println(st.countTokens());
    		count = st.countTokens();
    		while(st.hasMoreTokens()) {
    			i++;
    			if(i == count){
    				fName = st.nextToken();
    			}
    			else
    			path1 = path1+st.nextToken()+"/";
    			
    		}
    		System.out.println("p:"+path1);
    		System.out.println("f:"+fName);
    		
    		
            dos.writeUTF(fName);
            dos.flush();
            System.out.printf("filename : %s Sending...",fName);
 
            // 파일 내용을 읽으면서 전송
            File f = new File(path1,fName);
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            
            //long filesize = f.length(); // file 사이즈 구하기
            
            Bar b = new Bar();
        
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            b.setTotalsize((double)(f.length()/4096));
            System.out.println(f.length());
            System.out.println(f.length()/4096);
         
            
            dos.writeLong(f.length());
            long sum = 0;
            
            while (true) {
            	if(sum != f.length())
            	{
	            	len = bis.read(data);
	            	sum += len;
	                dos.write(data, 0, len);
	                b.downloading((double)len/4096);
	                System.out.println(len);
	                dos.flush();
            	}
            	else break;
            }
 
 
            dos.flush();
            bis.close();
            fis.close();
            System.out.println("File Send Success!!");
            System.out.println("File Size : %d " + f.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
 
    public void img() {
    	int i=0,count;
    	String path1="";
        try {
        	StringTokenizer st = new StringTokenizer(path,"\\");
    		System.out.println(st.countTokens());
    		count = st.countTokens();
    		while(st.hasMoreTokens()) {
    			i++;
    			if(i == count){
    				fName = st.nextToken();
    			}
    			else
    			path1 = path1+st.nextToken()+"/";
    			
    		}
    		System.out.println("p:"+path1);
    		System.out.println("f:"+fName);
    		
    		
            dos.writeUTF(fName);
            dos.flush();
            System.out.printf("filename : %s Sending...",fName);
 
            // 파일 내용을 읽으면서 전송
            File f = new File(path1,fName);
            fis = new FileInputStream(f);
            bis = new BufferedInputStream(fis);
            
            //long filesize = f.length(); // file 사이즈 구하기
            
            Bar b = new Bar();
        
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            b.setTotalsize((double)(f.length()/4096));
            System.out.println(f.length());
            System.out.println(f.length()/4096);
         
            
            dos.writeLong(f.length());
            long sum = 0;
            
            while (true) {
            	if(sum != f.length())
            	{
	            	len = bis.read(data);
	            	sum += len;
	                dos.write(data, 0, len);
	                b.downloading((double)len/4096);
	                System.out.println(len);
	                dos.flush();
            	}
            	else break;
            }
 
 
            dos.flush();
            bis.close();
            fis.close();
            System.out.println("File Send Success!!");
            System.out.println("File Size : %d " + f.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  
}

	