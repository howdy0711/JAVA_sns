package servertest;

import java.io.*;
import java.net.*;




class Chatd implements Runnable{
	ServerSocket chatsock = null;
	Socket socket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;
	public Chatd()
	{
		try {
			chatsock = new ServerSocket(5555);
			Admin.StaTus("채팅서버가 시작되었습니다.");
			
			
		} catch (IOException e) {
			System.out.println("채팅 서버 실패");
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		while(true)
		{
			try {
				while(true)
				{
					socket = chatsock.accept();
					Admin.StaTus("ChatServer : "+socket.getRemoteSocketAddress()+"Connection");
					new Thread(new ChatServer(socket)).start();
				}
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	
	class ChatServer implements Runnable {
		DataInputStream dis;
		DataOutputStream dos;
		Socket socket;
		String ID;
		
		public ChatServer(Socket socket)
		{
			
			
			try {
				this.socket = socket;
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				ID = dis.readUTF();
				Admin.chatlist.put(socket,ID);
				Admin.dataout.put(ID,dos);
				Admin.datain.put(ID,dis);
				System.out.println(Admin.dataout);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void run() {
			//String Status;
			String id =null;
			String message = null;
			
					try 
					{
						while(true)
						{	
								while(message == null && id ==null)
								{
									id = dis.readUTF();	
									message = dis.readUTF();
									
								}
								if(Admin.dataout.get(id) != null)
								{
									System.out.println("id : "+id);
									System.out.println("메세지 : "+message);
									new MessageSend(id,message,socket);
									id = null;
									message = null;
								}
								else 
								{
									System.out.println("File SAVE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
									new FileSave(message,id,Admin.chatlist.get(socket));
									id = null;
									message = null;
								}
									
						}
					} catch (IOException e) {
						
						System.out.println("Logout");
						new DataBase(Admin.chatlist.get(socket));
						Admin.chatlist.remove(socket);
						Admin.dataout.remove(ID);
						Admin.datain.remove(ID);
						e.printStackTrace();
					}
				
		}
		
		class MessageSend
		{
			DataOutputStream dos;
			String Message;
			String id;
			Socket socket;
			public MessageSend(String id,String Message,Socket socket) throws IOException
			{
				this.socket = socket;
				this.id = id;
				this.dos = Admin.dataout.get(id);
				dos.writeUTF(Admin.chatlist.get(socket)); // 발신자 아이디 보냄
				dos.flush();
				dos.writeUTF(Message);
				dos.flush();
			}
		}
	}
	
}
