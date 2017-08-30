package servertest;
import java.sql.*;

class DataBase {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://119.201.62.63:3306/";
	
	static final String USERNAME = "root";
	static final String PASSWORD = "eastgod";
	public String[] idlist;
	public DataBase(){}
	
	public DataBase(String id)
	{
		DisConnect(id);
	}
	

	public void DisConnect (String id)
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
			stmt.executeUpdate(sql); //질의문 실행
			
			
			//rs.close();
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
	
	public void ConCheck(String id) //실시간 친구 접속 현황 체크
	{
		
		
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
			sql = "select id from test where id !='"+id+"'AND ing = 1";
			System.out.println(sql);
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
				String id1 = rs.getString("id");
				idlist[i++] = id1;
				
			}
			System.out.println(idlist[0]);
			
			
			rs.close();
			stmt.close();
			conn.close();
			
			setIdlist(idlist);
		
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
	
	public void setIdlist(String idlist[])
	{
		this.idlist = idlist;
	}
	
	public String[] getIdlist()
	{
		return this.idlist;
	}

}
