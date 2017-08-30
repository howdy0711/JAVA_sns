package servertest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class FileSave {
	
	String message;
	String id;
	String send;
	static int timecount = 0;
	String s1,s2,s3,path=null;
	public FileSave(){}
	public FileSave(String message,String id,String send) //chatting
	{
		this.message = message;
		this.id = id;
		this.send = send;
		
	        String fileName = "C:\\temp\\"+id+"\\chatting.txt" ;
	        System.out.println(fileName);
	        try{
   
	            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	            
	            fw.write(send);
	            fw.newLine();
	            fw.write(message);
	            fw.newLine();
	            fw.flush();
 
	            fw.close(); 
    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}
	
	
	public FileSave(String id, String date ,String s3,int i) //
	{

	        String fileName = "C:\\temp\\timeline\\"+timecount+".txt" ;
	        System.out.println(fileName);
	        try{
   
	            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	            
	            fw.write(id);
	            fw.newLine();
	            fw.write(date);
	            fw.newLine();
	            fw.write(s3);
	            fw.newLine();
	            fw.flush();
 
	            fw.close(); 
	            timecount ++;
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}
	
	public FileSave(String id, String date ,String s3,String path_img) //
	{

	        String fileName = "C:\\temp\\timeline\\"+timecount+".txt" ;
	        System.out.println(fileName);
	        try{
   
	            BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, true));
	            
	            fw.write(id);
	            fw.newLine();
	            fw.write(date);
	            fw.newLine();
	            fw.write(s3);
	            fw.newLine();
	            fw.write(path_img);
	            fw.newLine();
	            fw.flush();
 
	            fw.close(); 
	            timecount ++;
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	}
	
	public int FileOpen(String filename)
	{
		
		try{
			   
            BufferedReader fw = new BufferedReader(new FileReader("C:\\temp\\timeline\\"+filename+".txt"));
            
            this.s1=fw.readLine();
            this.s2=fw.readLine();
            this.s3=fw.readLine();
            this.path=fw.readLine();
            System.out.println("path =="+path);
            fw.close(); 
            
	        }catch(Exception e){
	            e.printStackTrace();
	        }
		if(this.path == null) return 2;
        else return 1;
		
	}
	public String gets1()
	{
		return this.s1;
	}
	public String gets2()
	{
		return this.s2;
	}
	public String gets3()
	{
		return this.s3;
	}
	public String getsPath()
	{
		return this.path;
	}
	
}
