package death;

import java.awt.Image;
import java.io.*;
import java.net.*;

class TLService implements Runnable{
	String serverIP = "119.201.62.63";
	String sendID,toID;
	
	static Socket socket;
	static DataInputStream dis;
	static DataOutputStream dos;
	
	static Madang madang;
	
	static public void setMadang(Madang madang)
	{
		TLService.madang = madang;
	}
	public TLService(String sendID) //서버 접속용 생성자
	{
		this.sendID = sendID;
		try {
			socket = new Socket(serverIP,7777);
			 if(socket != null)
	            {
	            	System.out.println("TimeLine Server에 연결 되었습니다.");
	            	dis = new DataInputStream(socket.getInputStream());
	            	dos = new DataOutputStream(socket.getOutputStream());
	            	dos.writeUTF(sendID);
	            	dos.flush();
	            	
	            	
	            }
		} catch (UnknownHostException e) {
			System.out.println("TL서버가  연결되어있지않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		int flag = 0;
		String path;
		String s1,s2,s3;
		try {
			
			while(true)
			{
				while(flag == 0)
				{	
					flag  = dis.readInt();
				}
				
				if(flag == 1)
				{
					
					s1 = dis.readUTF();
					s2 = dis.readUTF();
					s3 = dis.readUTF();
					path = dis.readUTF();
					new Init(dis).img();
					
					madang.setTimeline(s1, s2, s3, path);
					flag = 0;
				}
				
				else if(flag == 2)
				{
					
					s1 = dis.readUTF();
					s2 = dis.readUTF();
					s3 = dis.readUTF();

					madang.setTimeline(s1, s2, s3);
					flag = 0;
				}
				else if(flag == 3)
				{
					s1 = dis.readUTF();
					s2 = dis.readUTF();
					s3 = dis.readUTF();
					path = dis.readUTF();
					new Init(dis).img2();
					
					madang.setTimeline1(s1, s2, s3, path);
					flag = 0;
				}
				
				
				
			}
		} catch (IOException e) {
			System.out.println("logout");
		}
	
	}
} 




class TLwrite
{
	String Path;
	String s1,s2,s3;
	
	public TLwrite(String Path,String s1, String s2,String s3)
	{
		
		this.Path = Path;
		this.s1 = s1;  
		this.s2 = s2;
		this.s2 = s3;
		
		try {
			TLService.dos.writeInt(1);
			TLService.dos.flush();
			TLService.dos.writeUTF(s1); // ID
			TLService.dos.flush();
			TLService.dos.writeUTF(s2); // 날짜
			TLService.dos.flush();
			TLService.dos.writeUTF(s3); // 본문내용
			TLService.dos.flush();
			
			new FileSender(TLService.dos,Path).img();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public TLwrite(String s1, String s2,String s3)
	{
		
		
		this.s1 = s1;  
		this.s2 = s2;
		this.s2 = s3;
		
		try {
			TLService.dos.writeInt(2);
			TLService.dos.flush();
			TLService.dos.writeUTF(s1); // ID
			TLService.dos.flush();
			TLService.dos.writeUTF(s2); // 날짜
			TLService.dos.flush();
			TLService.dos.writeUTF(s3); // 본문내용
			TLService.dos.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}