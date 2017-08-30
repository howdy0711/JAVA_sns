package death;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

class Init implements Runnable {

	Socket socket;
	DataInputStream dis;
	FileOutputStream fos;
	BufferedOutputStream bos;
	String id;

	public Init(String id,DataInputStream dis){
		this.id = id;
		System.out.println(id);
		this.dis = dis;
	}
	
	public Init(DataInputStream dis){
		this.dis = dis;
	}
	
	public void img() {
		try {
			
			System.out.println("초기화");
			String Path = "C:\\test\\rtimeline\\";
			
			// 파일명을 전송 받고 파일명 수정.
			String fName = dis.readUTF();
			if(!fName.equals("error"))
			{
					
					System.out.printf("File Name : %s Receving....\n", fName);
		
					// 파일을 생성하고 파일에 대한 출력 스트림 생성
					
					
					File f = new File(Path);
					f.mkdirs();
					f = new File(Path,fName);
					fos = new FileOutputStream(f);
					bos = new BufferedOutputStream(fos);
		
					// 바이트 데이터를 전송받으면서 기록
					int len;
					int size = 4096;
					byte[] data = new byte[size];
					
					long sum = dis.readLong();
					long sum2=0;
					while (true) {
						if(sum2 != sum)
						{
							len = dis.read(data);
							sum2 +=len;
							bos.write(data, 0, len);
							
							bos.flush();
						}
						else break;
					}
					bos.close();
					fos.close();
					
					System.out.println("File Receive Success!!");
					System.out.println("File Size : " + f.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void img2() {
		try {
			
			System.out.println("이미지 초기화");
			String Path = "C:\\test\\timeline\\";
			
			// 파일명을 전송 받고 파일명 수정.
			String fName = dis.readUTF();
			System.out.println(fName);
			if(!fName.equals("error"))
			{
					
					System.out.printf("File Name : %s Receving....\n", fName);
		
					// 파일을 생성하고 파일에 대한 출력 스트림 생성
					
					
					File f = new File(Path);
					f.mkdirs();
					f = new File(Path,fName);
					fos = new FileOutputStream(f);
					bos = new BufferedOutputStream(fos);
		
					// 바이트 데이터를 전송받으면서 기록
					int len;
					int size = 4096;
					byte[] data = new byte[size];
					
					long sum = dis.readLong();
					long sum2=0;
					while (true) {
						if(sum2 != sum)
						{
							len = dis.read(data);
							sum2 +=len;
							bos.write(data, 0, len);
							
							bos.flush();
						}
						else break;
					}
					bos.close();
					fos.close();
					
					System.out.println("File Receive Success!!");
					System.out.println("File Size : " + f.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void chat() {
		try {
			
			System.out.println("초기화");
			String Path = "C:\\test\\"+id+"\\";
			
			// 파일명을 전송 받고 파일명 수정.
			String fName = dis.readUTF();
			if(!fName.equals("error"))
			{
					fName = "chatting.txt";
					System.out.printf("File Name : %s Receving....\n", fName);
		
					// 파일을 생성하고 파일에 대한 출력 스트림 생성
					
					
					File f = new File(Path);
					f.mkdirs();
					f = new File(Path,fName);
					fos = new FileOutputStream(f);
					bos = new BufferedOutputStream(fos);
		
					// 바이트 데이터를 전송받으면서 기록
					int len;
					int size = 4096;
					byte[] data = new byte[size];
					
					long sum = dis.readLong();
					long sum2=0;
					while (true) {
						if(sum2 != sum)
						{
							len = dis.read(data);
							sum2 +=len;
							bos.write(data, 0, len);
							
							bos.flush();
						}
						else break;
					}
					bos.close();
					fos.close();
					
					System.out.println("File Receive Success!!");
					System.out.println("File Size : " + f.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			
			System.out.println("초기화");
			String Path = "C:\\test\\"+id+"\\";
			
			// 파일명을 전송 받고 파일명 수정.
			String fName = dis.readUTF();
			if(!fName.equals("error"))
			{
					fName = "profile.png";
					System.out.printf("File Name : %s Receving....\n", fName);
		
					// 파일을 생성하고 파일에 대한 출력 스트림 생성
					
					
					File f = new File(Path);
					f.mkdirs();
					f = new File(Path,fName);
					fos = new FileOutputStream(f);
					bos = new BufferedOutputStream(fos);
		
					// 바이트 데이터를 전송받으면서 기록
					int len;
					int size = 4096;
					byte[] data = new byte[size];
					
					long sum = dis.readLong();
					long sum2=0;
					while (true) {
						if(sum2 != sum)
						{
							len = dis.read(data);
							sum2 +=len;
							bos.write(data, 0, len);
							
							bos.flush();
						}
						else break;
					}
					bos.close();
					fos.close();
					
					System.out.println("File Receive Success!!");
					System.out.println("File Size : " + f.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void pic() {
		try {
			
			System.out.println("초기화");
			String Path = "C:\\test\\"+id+"\\img\\";
			
			// 파일명을 전송 받고 파일명 수정.
			String fName = dis.readUTF();
			if(!fName.equals("error"))
			{
					System.out.printf("File Name : %s Receving....\n", fName);
		
					// 파일을 생성하고 파일에 대한 출력 스트림 생성
					
					
					File f = new File(Path);
					f.mkdirs();
					f = new File(Path,fName);
					fos = new FileOutputStream(f);
					bos = new BufferedOutputStream(fos);
		
					// 바이트 데이터를 전송받으면서 기록
					int len;
					int size = 4096;
					byte[] data = new byte[size];
					
					long sum = dis.readLong();
					long sum2=0;
					while (true) {
						if(sum2 != sum)
						{
							len = dis.read(data);
							sum2 +=len;
							bos.write(data, 0, len);
							
							bos.flush();
						}
						else break;
					}
					bos.close();
					fos.close();
					
					System.out.println("File Receive Success!!");
					System.out.println("File Size : " + f.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

