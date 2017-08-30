package death;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

class ChatService implements Runnable{
	String serverIP = "119.201.62.63";
	String sendID,toID;
	String sendmessage,tomessage;
	static Socket chatsock;
	static DataInputStream dis;
	static DataOutputStream dos;
	
	public ChatService(String toID,String sendmessage) //메세지 전송용 생성자
	{
		
		try {
			this.sendmessage = sendmessage;
			dos.writeUTF(toID);
			dos.flush();
			dos.writeUTF(sendmessage);
			dos.flush();
		} catch (IOException e) {
			System.out.println("메세지 전송이 이루어지지 않았습니다.");
			e.printStackTrace();
		}
		
	}
	public ChatService(String sendID) //서버 접속용 생성자
	{
		this.sendID = sendID;
		try {
			chatsock = new Socket(serverIP,5555);
			 if(chatsock != null)
	            {
	            	System.out.println("채팅서버에 연결되었습니다.");
	            	dis = new DataInputStream(chatsock.getInputStream());
	            	dos = new DataOutputStream(chatsock.getOutputStream());
	            	dos.writeUTF(sendID);
	            	dos.flush();
	            }
		} catch (UnknownHostException e) {
			System.out.println("채팅서버가 연결되어있지않습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void run() {
		String id = null;
		try {
			while(true)
			{
				while(tomessage == null || id == null)
				{	
					id  = dis.readUTF();
					tomessage = dis.readUTF();
				}
				
				for(int i =0; i<Madang.chat.length; i++)
				{
					System.out.println("id:"+id);
					System.out.println("chat :"+Madang.chat[i].getID());
					if(id.equals(Madang.chat[i].getID()))
					{
						Madang.chat[i].ONOFF(true);
						Madang.chat[i].area.append(Madang.chat[i].getID()+" : "+tomessage+"\n");
						
					}
				}
					id = null;
					tomessage = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
} 



class LoadChat
{
	BufferedReader inputStream = null;
    String id;
    boolean flag = true;
	public LoadChat(String id) throws IOException
	{
		this.id = id;
			File file = new File("C:\\test\\"+id+"\\"+"chatting.txt");
	            try {
					inputStream = new BufferedReader(new FileReader(file));
				
						String temp = null;
			            String l;
			            while ((l = inputStream.readLine()) != null) 
			            {
			               if(flag)
			               {
			            	   temp = l;
			            	   flag = false;
			               }
			               else
			               {
			            	   Madang.chatlist.get(temp).area.append(l+"\n");
			            	   flag = true;
			            	   temp = null;
			               }	
			            }
			            
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					
		            if (inputStream != null) {
		                inputStream.close();
		                file.delete();  
		            }
		
		  }
	}

}

	
