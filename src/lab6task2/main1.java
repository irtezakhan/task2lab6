package lab6task2;

import java.sql.*;
import java.util.Scanner;

public class main1 {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/lab6";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);

	      Statement st = conn.createStatement();
	      st.executeQuery("select * from records");
	      ResultSet rs = st.getResultSet();

	      while(rs.next()) {
	                  System.out.println(rs.getString("Reg_no"));
	                  System.out.println(rs.getString("name"));
	                  System.out.println(rs.getString("class"));
	                  System.out.println(rs.getString("section"));
	                  System.out.println(rs.getString("contact"));
	                  System.out.println(rs.getString("address"));
	}
	      System.out.println("Select 1 to Add data and 2 to Delete record");
	      Scanner reader = new Scanner(System.in);  
	       int n = reader.nextInt(); 
	       if(n==1){
	    	  
	    	   System.out.println("Enter Reg_no");
	    	   String r = reader.next();
	    	   System.out.println("Enter Name:");
	    	   String na = reader.next();
	    	   System.out.println("Enter class");
	    	   String c = reader.next();
	    	   System.out.println("Enter section");
	    	   String s = reader.next();
	    	   System.out.println("Enter contact");
	    	   String ct = reader.next();
	    	   System.out.println("Enter Address");
	    	   String a = reader.next();
	    	   Statement statement = conn.createStatement();

	    	
	    	statement.executeUpdate("INSERT INTO records (Reg_no, name,class,section,contact,address) VALUES ('" + r + "','" + na + "','" + c + "','" + s + "' ,'" + ct + "' ,'" + a + "')"); 
	    	   
	       }
	      if(n==2){
	    System.out.println("Enter Reg_no to delete");
	   	String reg = reader.next(); 
	   	stmt = conn.createStatement();
	    String sql = "DELETE FROM records " +
	                 "WHERE Reg_no =" + reg;
	    stmt.executeUpdate(sql);
	    	  
	    	  
	    	  
	      }
	      
	      
	      
	   
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	  
	}//end main
	}//end JDBCExample



