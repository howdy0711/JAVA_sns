package servertest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;





class TLServer implements Runnable{
			
			ServerSocket chatsock = null;
			Socket socket = null;
			static Map<Socket, String> tllist = new HashMap<Socket, String>();
			static Map<String, DataInputStream> datain = new HashMap<String, DataInputStream>();
			static Map<String, DataOutputStream> dataout = new HashMap<String, DataOutputStream>();
			static ArrayList<String> arr = new ArrayList<String>();
			static String [] idlist ;
		
			public TLServer()
			{
				try {
					chatsock = new ServerSocket(7777);
					Admin.StaTus("TimeLine 서버가 시작되었습니다.");
					
					
				} catch (IOException e) {
					System.out.println("TL 서버 실패");
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
							Admin.StaTus("TLServer : "+socket.getRemoteSocketAddress()+"Connection");
							new Thread(new TLService(socket)).start();
						}
					} catch (IOException e) {
						
						e.printStackTrace();
					}
					
				}
			}
			
			class TLService implements Runnable
			{
				DataInputStream dis;
				DataOutputStream dos;
				Socket socket;
				String ID;
				public TLService(Socket socket)
				{
					try {
						this.socket = socket;
						dis = new DataInputStream(socket.getInputStream());
						dos = new DataOutputStream(socket.getOutputStream());
						ID = dis.readUTF();
	
						TLServer.tllist.put(socket,ID);
						TLServer.arr.add(ID);
						TLServer.dataout.put(ID,dos);
						TLServer.datain.put(ID,dis);
						
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				}
				
				public void run()
				{
					String id = null;
					String date = null;
					String s3 =null;
					int flag = 0;
					
					
							try {
								while(true)
								{
									while(flag == 0)
									{
										flag = dis.readInt();
									}
									
									if(flag == 1)
									{ 
										id = dis.readUTF();
										date =dis.readUTF();
										s3 = dis.readUTF();
										new FileReceiver(dis).img();
										new FileSave(id, date, s3, FileReceiver.imgcount+"");
										System.out.println(id);
										
										
										new SendTimeline(id,date,s3,FileReceiver.imgcount+"").run();
									
										flag = 0;
										
									}
									else if (flag == 2)
									{
										id = dis.readUTF();
										date =dis.readUTF();
										s3 = dis.readUTF();
										new FileSave(id, date, s3,1);
										new SendTimeline(id,date,s3,FileReceiver.imgcount+"").text();
										flag = 0;
										
									}
									else if(flag == 3) //초기화
									{
										System.out.println("타임라인 초기화");
										for(int i=0; i<FileSave.timecount; i++)
										{
											FileSave f = new FileSave();
											if(f.FileOpen(i+"")==1)
											{
												System.out.println("씨발련아");
												dos.writeInt(3);
												dos.flush();
												dos.writeUTF(f.gets1()); // ID
												dos.flush();
												dos.writeUTF(f.gets2()); // 날짜
												dos.flush();
												dos.writeUTF(f.gets3()); // 본문내용
												dos.flush();
												dos.writeUTF(f.getsPath());
												dos.flush();
												new Init(f.getsPath(), dos).img();
											}
											else 
											{
												dos.writeInt(2);
												dos.flush();
												dos.writeUTF(f.gets1()); // ID
												dos.flush();
												dos.writeUTF(f.gets2()); // 날짜
												dos.flush();
												dos.writeUTF(f.gets3()); // 본문내용
												dos.flush();
											}								
										}
										flag = 0;
									}
								}
						
								
							} catch (IOException e) {
								for(int i = 0; i<arr.size(); i++)
								{
									if(arr.get(i).equals(ID))
									{
										arr.remove(i);
									}
								}
								tllist.remove(socket);
								datain.remove(ID);
								dataout.remove(ID);
								e.printStackTrace();
							} 
							
					
				}
				
			}
			
		class SendTimeline implements Runnable
		{
			String id,date,s3;
			DataOutputStream dos;
			String path;
		
			public SendTimeline(String id,String date,String s3,String path) throws IOException
			{
				
				this.id = id;
				this.date = date;
				
				this.s3 = s3;
				this.path = path;
				
			}
			
			
			public void run()
			{
				try {
				for(int i=0; i<TLServer.arr.size(); i++)
				{
					if(TLServer.arr.get(i).equals(id)){continue;}
					
					this.dos = TLServer.dataout.get(TLServer.arr.get(i));
					dos.writeInt(1);
					dos.flush();
					dos.writeUTF(id); // ID
					dos.flush();
					dos.writeUTF(date); // 날짜
					dos.flush();
					dos.writeUTF(s3); // 본문내용
					dos.flush();
					dos.writeUTF(path);
					new Init(path, dos).img();
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			public void text()
			{
				try {
				for(int i=0; i<TLServer.arr.size(); i++)
				{
					if(TLServer.arr.get(i).equals(id)){continue;}
					
					this.dos = TLServer.dataout.get(TLServer.arr.get(i));
					dos.writeInt(2);
					dos.flush();
					dos.writeUTF(id); // ID
					dos.flush();
					dos.writeUTF(date); // 날짜
					dos.flush();
					dos.writeUTF(s3); // 본문내용
					dos.flush();
				}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		
		}
	
}
