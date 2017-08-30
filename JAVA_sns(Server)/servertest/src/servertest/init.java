package servertest;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class Init extends Thread implements Runnable{


    DataOutputStream dos=null;
    FileInputStream fis;
    BufferedInputStream bis;
    String fName;
    String path;
    File f=null;
    
    public Init(String path,DataOutputStream dos) {
        this.dos = dos;
        this.path = path;
    }
    
public void img() {
    	
    	fName = path+".png";
    	System.out.println("이미지 초기화 " + fName);
   	 	f = new File("C:\\temp\\timeline\\img\\",fName);

   	 	if(f.exists())
   	 	{
	        try {
	        	
		    	    dos.writeUTF(fName);
		    	    dos.flush();
		    	    	 
		
		            System.out.printf("filename : %s Sending...",fName);
			            
		            fis = new FileInputStream(f);
		            bis = new BufferedInputStream(fis);
   
		            int len=0;
		            int size = 4096;
		            byte[] data = new byte[size];
		            
		            System.out.println(f.length());
		            
		            dos.writeLong(f.length());
		            long sum = 0;
		            
		            while (true) {
		            	if(sum != f.length())
		            	{
			            	len = bis.read(data);
			            	sum += len;
			                dos.write(data, 0, len);
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
	        	
	        	System.out.println("파일이 없어유 ㅠㅠ");
	            e.printStackTrace();
	        }
	   	 	}
	   	 	else
	   	 	{
			   	 	 try {
						dos.writeUTF("error");
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 
	   	 	}
    }

public void pic(String name) {
	
	fName = name;
	System.out.println("이미지 초기화 " + fName);
	 	f = new File("C:\\temp\\"+path+"\\img\\",fName);

	 	if(f.exists())
	 	{
        try {
        	
	    	    dos.writeUTF(fName);
	    	    dos.flush();
	    	    	 
	
	            System.out.printf("filename : %s Sending...",fName);
		            
	            fis = new FileInputStream(f);
	            bis = new BufferedInputStream(fis);

	            int len=0;
	            int size = 4096;
	            byte[] data = new byte[size];
	            
	            System.out.println(f.length());
	            
	            dos.writeLong(f.length());
	            long sum = 0;
	            
	            while (true) {
	            	if(sum != f.length())
	            	{
		            	len = bis.read(data);
		            	sum += len;
		                dos.write(data, 0, len);
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
        	
        	System.out.println("파일이 없어유 ㅠㅠ");
            e.printStackTrace();
        }
   	 	}
   	 	else
   	 	{
		   	 	 try {
					dos.writeUTF("error");
					dos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 
   	 	}
}
 

 public void chat() {
    	
    	fName = "chatting.txt";
   	 	f = new File("C:\\temp\\"+path,fName);

   	 	if(f.exists())
   	 	{
	        try {
	        	
		    	    dos.writeUTF(fName);
		    	    dos.flush();
		    	    	 
		
		            System.out.printf("filename : %s Sending...",fName);
		 

			            
		            fis = new FileInputStream(f);
		            bis = new BufferedInputStream(fis);
   
		            int len=0;
		            int size = 4096;
		            byte[] data = new byte[size];
		            
		            System.out.println(f.length());
		            
		            dos.writeLong(f.length());
		            long sum = 0;
		            
		            while (true) {
		            	if(sum != f.length())
		            	{
			            	len = bis.read(data);
			            	sum += len;
			                dos.write(data, 0, len);
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
		            
		            f.delete();
	        } catch (IOException e) {
	        	
	        	System.out.println("파일이 없어유 ㅠㅠ");
	            e.printStackTrace();
	        }
	   	 	}
	   	 	else
	   	 	{
			   	 	 try {
						dos.writeUTF("error");
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 
	   	 	}
    }
 
 
    public void run() {
    	
    	fName = "profile.png";
   	 	f = new File("C:\\temp\\"+path,fName);

   	 	if(f.exists())
   	 	{
	        try {
	        	
		    	    dos.writeUTF(fName);
		    	    dos.flush();
		    	    	 
		
		            System.out.printf("filename : %s Sending...",fName);
		 

			            
		            fis = new FileInputStream(f);
		            bis = new BufferedInputStream(fis);
   
		            int len=0;
		            int size = 4096;
		            byte[] data = new byte[size];
		            
		            System.out.println(f.length());
		            
		            dos.writeLong(f.length());
		            long sum = 0;
		            
		            while (true) {
		            	if(sum != f.length())
		            	{
			            	len = bis.read(data);
			            	sum += len;
			                dos.write(data, 0, len);
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
	        	
	        	System.out.println("파일이 없어유 ㅠㅠ");
	            e.printStackTrace();
	        }
	   	 	}
	   	 	else
	   	 	{
			   	 	 try {
						dos.writeUTF("error");
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			 
	   	 	}
    }
    
  
}
