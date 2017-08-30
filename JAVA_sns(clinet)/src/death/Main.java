package death;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.xml.ws.FaultAction;

public class Main {
	public static void main(String[] args) throws IOException {
		String serverIp = "119.201.62.63";
		Socket socket = null;
		DataInputStream dis =null ;
		DataOutputStream dos =null ;
		
        try {
            //���� ����
            socket = new Socket(serverIp, 8888);
          if(socket != null)
            {
            	System.out.println("������ ����Ǿ����ϴ�.");
            	dis = new DataInputStream(socket.getInputStream());
            	dos = new DataOutputStream(socket.getOutputStream());
            	new Login(dis,dos);
            }
            	
        } catch (IOException e) {
        	
        	new Message("���� �������Դϴ�.");
            e.printStackTrace();
        }
	}

	public static void Flag(String s1,DataOutputStream dos) throws IOException
	{
		//System.out.println(s1);
		
		dos.writeUTF(s1);
		dos.flush();
	
	}
	
	public static void Flag(String s1,String id,DataOutputStream dos) throws IOException
	{
		//System.out.println(s1);
		
		dos.writeUTF(s1);
		dos.writeUTF(id);
		dos.flush();
	
	}

}
