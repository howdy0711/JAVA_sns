package servertest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.xml.ws.FaultAction;

class ConNect implements Runnable {
	protected Socket socket;
	ServerSocket serverSocket;
	// DataInputStream dis = null;
	String flag;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	

	// ----------------------- Constructor
	public ConNect(ServerSocket serverSocket,Socket socket) throws IOException
	{
		this.socket = socket;
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
	}

	// ------------------------------------
	
	public void run() {
		//String Status;
		String id =null;
		String Status = null;
		
		
		
				try 
				{
					
					while(true)
					{	
							while(Status == null)
							{
								Status = dis.readUTF();
							}

							
							if(Status.equals("profile")) {
								//dis.close();
								System.out.println("���Ͼ��ε�");
								new FileReceiver(dis,id).run();
								
								Status = null;
							}
							else if(Status.equals("setid"))
							{
								System.out.println("setid excute");
								id = dis.readUTF();
								System.out.println(id);
								Admin.clientlist.put(socket, id);
								Status = null;
							}
							
							else if(Status.equals("chat"))
							{
								new Init(id+"\\",dos).chat();
								Status = null;
							}
							
							else
							{
								
								System.out.println("�ʱ�ȭ");
								new Init(Status+"\\",dos).run();
								Status = null;
							}
							
					}
				} catch (IOException e) {
					new DataBase(id);
					Admin.clientlist.remove(socket);
					Admin.StaTus("[-]IP "+socket.getRemoteSocketAddress()+" Disconneted");
					Admin.shutdown(socket,id);
					//new DataBase(id);
					System.out.println("socket close");
				}
			
	}
}




class Admin extends JFrame implements ActionListener {
		
	protected JTextField textField;
	protected static JTextArea textArea;
	protected static JScrollPane js;
	static int total_client=0;
	static private String Status;
	static  Map<Socket,String> clientlist = new HashMap<Socket,String>();
	static  Map<Socket,String> chatlist = new HashMap<Socket,String>();
	static  Map<String,DataInputStream> datain = new HashMap<String,DataInputStream>();
	static  Map<String,DataOutputStream> dataout = new HashMap<String,DataOutputStream>();
	
	public Admin() 
	{
		
try {
			
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
		    // LookAndFeel ���� ����
		    ex.printStackTrace();
		}
		setTitle("�츮���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textField = new JTextField();
		textField.addActionListener(this);

		textArea = new JTextArea(20, 70);
		js = new JScrollPane(textArea);
		textArea.setEditable(false);
		add(js, BorderLayout.CENTER);
		add(textField, BorderLayout.PAGE_END);
		//add(textArea, BorderLayout.CENTER);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		String s = textField.getText();
		if(s.equals("help"))
		{
			textArea.append("============== COMMAND LIST =============="+"\n");
			textArea.append("total : �� ������ ���� �����ݴϴ�.\n");
			textArea.append("list : ������ ID �� IP�� �����ݴϴ�.\n");
			textArea.append("clear : ȭ���� ����ϴ�.\n");
			textArea.append("save log : �α׸� �����մϴ�.\n");
			textArea.append("=========================================="+"\n");
			js.getVerticalScrollBar().setValue(js.getVerticalScrollBar().getMaximum());
			
			
		}
		
		else if(s.equals("total"))
		{
			textArea.append("�� ������ : "+getTotal_client()+"\n");
			js.getVerticalScrollBar().setValue(js.getVerticalScrollBar().getMaximum());
		}
		else if(s.equals("list"))
		{
			
			textArea.append(clientlist+"\n");
			js.getVerticalScrollBar().setValue(js.getVerticalScrollBar().getMaximum());
		}
		else if(s.equals("clear"))
		{
			textArea.setText("");
		}
		else if(s.equals("save log"))
		{
			textArea.setText("�߰�����");
			js.getVerticalScrollBar().setValue(js.getVerticalScrollBar().getMaximum());
		}
		else
		{
			textArea.append("[ - ] ' "+s+" ' Command Not Found\n");
			js.getVerticalScrollBar().setValue(js.getVerticalScrollBar().getMaximum());
		}
		
		textField.setText("");
		
		//textArea.append("SENT: " + s + "\n");
		//textField.selectAll();
		//textArea.setCaretPosition(textArea.getDocument().getLength());
		
	}
	

	/*public static void AddClient(Socket socket,String id,DataInputStream dis,DataOutputStream dos)
	{
		clientlist.put(id, socket);
		datain.put(socket, dis);
		dataout.put(socket, dos);
	}*/
	
	public int getTotal_client() 
	{
		return total_client;
	}

	public void user() 
	{
		total_client++;
	}
	
	static public void shutdown(Socket socket,String id)
	{
		total_client--;
		clientlist.remove(id);
		datain.remove(socket);
		dataout.remove(socket);
	
	}
	
	
	static public void StaTus(String status)
	{
		Status = status;
		textArea.append(Time()+" : "+Status+"\n");
	}
	
	public static String Time()
	{
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String time = (new SimpleDateFormat("HH:mm:ss").format(date));
        return time;
	}
}
	




public class Server {

	public static void main(String[] args) throws IOException {
	
		ServerSocket serverSocket = null;
	      Socket socket = null;
	      
	      Admin admin = new Admin();
		        try {
		        	
		            // ������ ���� ���� �� ���
		            serverSocket = new ServerSocket(8888);
		            Admin.StaTus("MAIN ���� ���۵Ǿ����ϴ�.");
		            new Thread(new Chatd()).start();
		            new Thread(new TLServer()).start();
		          
		            // ����Ǹ� ��ſ� ���� ����
		            
		            
		            while(true)
		            {
			            socket = serverSocket.accept();
			            admin.user();
			            Admin.StaTus("IP "+socket.getRemoteSocketAddress()+" Connection.");
			            ConNect connect = new ConNect(serverSocket,socket);

			            new Thread(connect).start();
		        	}
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		        	
		        	Admin.total_client--;
					socket.close();
					
				}
		        
	        
	   }
	
	
}

		
		
		
class FileReceiver extends Thread {
	String id;
    DataInputStream dis;
    FileOutputStream fos;
    BufferedOutputStream bos;
    static int imgcount = 0;
    public FileReceiver(DataInputStream dis,String id) {
    	this.dis = dis;
        this.id = id;
    }
    public FileReceiver(DataInputStream dis) {
    	this.dis = dis;
     
    }
 
    @Override
    public void run() {
        try {
        	System.out.println(id);
        	String Path="C:\\temp\\"+id+"\\";

          // ���ϸ��� ���� �ް� ���ϸ� ����.
           String fName = dis.readUTF();
        
           System.out.printf("File Name : %s Receving....\n",fName);
           	fName = "profile.png";
            // ������ �����ϰ� ���Ͽ� ���� ��� ��Ʈ�� ����
            File f = new File(Path);
            f.mkdirs();
            f = new File(Path+fName);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
 
            // ����Ʈ �����͸� ���۹����鼭 ���
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            
            long sum = dis.readLong();
			long sum2=0;
			System.out.println("re:"+sum);
			
			while (true) {
				if(sum2 != sum)
				{
					len = dis.read(data);
					sum2 +=len;
					bos.write(data, 0, len);
					System.out.println(len);
					bos.flush();
				}
				else break;
			}
			System.out.println("��");
            
            bos.flush();
            bos.close();
            fos.close();
            System.out.println("File Receive Success!!");
            System.out.println("File Size : " + f.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void img() {
        try {
        	
        	String Path="C:\\temp\\timeline\\img\\";

          // ���ϸ��� ���� �ް� ���ϸ� ����.
            String fName = dis.readUTF();
        
            System.out.printf("File Name : %s Receving....\n",fName);
           	fName = (++imgcount)+".png";
            // ������ �����ϰ� ���Ͽ� ���� ��� ��Ʈ�� ����
            File f = new File(Path);
            f.mkdirs();
            f = new File(Path+fName);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
 
            // ����Ʈ �����͸� ���۹����鼭 ���
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            
            long sum = dis.readLong();
			long sum2=0;
			System.out.println("re:"+sum);
			
			while (true) {
				if(sum2 != sum)
				{
					len = dis.read(data);
					sum2 +=len;
					bos.write(data, 0, len);
					System.out.println(len);
					bos.flush();
				}
				else break;
			}
	
            
            bos.flush();
            bos.close();
            fos.close();
            System.out.println("File Receive Success!!");
            System.out.println("File Size : " + f.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void pic() {
        try {
        	System.out.println(id);
        	String Path="C:\\temp\\"+id+"\\img\\";

          // ���ϸ��� ���� �ް� ���ϸ� ����.
           String fName = dis.readUTF();
        
           System.out.printf("File Name : %s Receving....\n",fName);
           	
            // ������ �����ϰ� ���Ͽ� ���� ��� ��Ʈ�� ����
            File f = new File(Path);
            f.mkdirs();
            f = new File(Path+fName);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);
 
            // ����Ʈ �����͸� ���۹����鼭 ���
            int len;
            int size = 4096;
            byte[] data = new byte[size];
            
            long sum = dis.readLong();
			long sum2=0;
			System.out.println("re:"+sum);
			
			while (true) {
				if(sum2 != sum)
				{
					len = dis.read(data);
					sum2 +=len;
					bos.write(data, 0, len);
					System.out.println(len);
					bos.flush();
				}
				else break;
			}
		
            
            bos.flush();
            bos.close();
            fos.close();
            System.out.println("File Receive Success!!");
            System.out.println("File Size : " + f.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
   
}
