package death;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

class DataBase {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://119.201.62.63:3306/";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "eastgod";

	private String id="0",pw="0",id_u,pw_u,email,phone,sex,name;
	private String b_day;
	String [] idlist;
	DataOutputStream dos;
	DataInputStream dis;
	public DataBase(String id,DataOutputStream dos,DataInputStream dis) //친구목록 DB 
	{
		this.dos = dos;
		this.dis = dis;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			//------ connection 

			String sql;
			sql = "use eastgod";
			stmt.executeQuery(sql);
			
			sql = "SELECT id from test where id != '"+id+"'";
			ResultSet rs = stmt.executeQuery(sql); //질의문 실행
			   rs.last();     
		       int rowcount = rs.getRow();
		       String[] idlist = new String[rowcount];
		       for(int i =0; i<rowcount; i++)
		       {
		    	idlist[i] = new String();   
		       }
		       rs.beforeFirst();
		       int i = 0;
			while(rs.next())
			{
				idlist[i] = rs.getString("id");
				
				i++;
			}
			setIDlist(idlist);
			

			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se1){
			
			//se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
		
	}
	
	public DataBase(String id_u,String pw_u){ //데이터베이스 조회 생성자.
		this.id_u = id_u;
		this.pw_u = pw_u;
		
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			//------ connection 

			String sql;
			sql = "use eastgod";
			stmt.executeQuery(sql);
			sql = "SELECT * from test where id = '"+id_u+"' AND pw = '"+pw_u+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql); //질의문 실행

			while(rs.next())
			{
				id = rs.getString("id");
				System.out.println(id);
				pw = rs.getString("pw");
			}

			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se1){
			
			//se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
	}
	
	public DataBase(String id ,String pw, String email_, String phone, String sex, String name_,String b_day){ //회원가입  생성자.
		
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			//------ connection 
			
			String sql;
			sql = "use eastgod";
			System.out.println(sql);
			stmt.execute(sql);
			sql = "insert into test value('"+id+"','"+pw+"','"+email_+"','"+phone+"','"+sex+"','"+name_+"','"+b_day+"','"+0+"')";
			//sql = "insert into register values("+"\""+id+"\"" + ","+ "\""+pw+"\"" +","+"\""+email+"\""+ ","+"\""+phone+"\""+ ","+"\""+sex+"\""+ ","+"\""+name+"\""+ ","+"\""+b_day+"\""+")";
			stmt.execute(sql); //질의문 실행
			System.out.println(sql);
			

			stmt.close();
			conn.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
	}
	
	public boolean Check(){
		if(id.equals(id_u) && pw.equals(pw_u)) return true;
		else return false;
		
	}
	
	public void Connect (String id)
	{
		String ing = null;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			//------ connection 
			
			
			String sql;
			sql = "use eastgod";
			stmt.executeQuery(sql);
			sql = "update test set ing=1 where id='"+id+"';";
			System.out.println(sql);
			stmt.executeUpdate(sql); //질의문 실행
			
			
			
			stmt.close();
			conn.close();
			
		
		
		}catch(SQLException se1){
			
			//se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
				
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
	
		
	}
	
	
	
	
	
	static public boolean DisConnect(String id)
	{
		String ing = null;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			//------ connection 
			
			
			String sql;
			sql = "use eastgod";
			stmt.executeQuery(sql);
			sql = "update test set ing=0 where id='"+id+"';";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql); //질의문 실행
			
			
			rs.close();
			stmt.close();
			conn.close();
			
			if(ing.equals("1")) return true; // 접속중이면 참을 반환
		
		}catch(SQLException se1){
			
			//se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
				
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
		return false;
		
	}
	
	public boolean ConCheck(String id)
	{
		String ing = null;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("\n- MySQL Connection");
			stmt = conn.createStatement();
			//------ connection 
			
			
			String sql;
			sql = "use eastgod";
			stmt.executeQuery(sql);
			sql = "SELECT ing from test where id = '"+id_u+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql); //질의문 실행
			
			
			while(rs.next())
			{
				ing = rs.getString("ing");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			if(ing.equals("1")) return true; // 접속중이면 참을 반환
		
		}catch(SQLException se1){
			
			//se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
				
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("\n\n- MySQL Connection Close");
		return false;
	}
	
	
	static public void ConCheck() //실시간 친구 접속 현황 체크
	{
		int ing,i=0;
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			
			stmt = conn.createStatement();
			//------ connection 
			
			
			String sql;
			sql = "use eastgod";
			stmt.executeQuery(sql);
			sql = "select ing from test where id !='"+Madang.id+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql); //질의문 실행
			
			
			
			while(rs.next())
			{
				ing = rs.getInt("ing");
				Madang.f_check[i++].on_off(ing);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			
		
		}catch(SQLException se1){
			
			//se1.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				if(stmt!=null)
					stmt.close();
				
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		
	}
	
	public void setIDlist(String id[]) throws IOException
	{
		this.idlist = id;
		for(int i = 0; i<id.length; i++)
		{
			Main.Flag(id[i], dos);
			new Init(id[i], dis).run();
		}
	}
	public String[] getIDlist()
	{
		return idlist;
	}
	
	
}
