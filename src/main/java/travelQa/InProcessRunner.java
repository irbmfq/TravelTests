package travelQa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fit.Counts;
//import fitnesse.trinidad.*;
import java.io.*;

public class InProcessRunner {
	public static String testright, testwrong, testexceptions, testname,summary;
	public static Counts cs;
	public static int right, wrong, exceptions, totalright, totalwrong,
			totalexceptions;
	public static String str1, strhead , strsummary;
	static UUID batchId = UUID.randomUUID();
	
	public static void startProcessing(final List<String> tests)
			throws InterruptedException {
		
		Thread t = new Thread() {

			@Override
			public void run() {
            try{
				for (String next : tests) {			
					      

					String dbhost = "jdbc:mysql://localhost/automation?user=root";
					Class.forName("com.mysql.jdbc.Driver").newInstance();			
					Connection conn = DriverManager.getConnection(dbhost);	
					
					Statement stmt = conn.createStatement();
					stmt.executeQuery("select * from environment");	    
					
					ResultSet rs = stmt.getResultSet();
					     
					      while(rs.next()){
						  
					      System.setProperty("browser", rs.getString("browserCode"));				
						   
						  
						  
						  boolean status = new File("C:\\wamp\\www\\output\\"+ batchId +"\\"+ rs.getString("browserName") +"").mkdirs();	
						  System.out.println(status);
//						   TestRunner tdd = new TestRunner(new FitNesseRepository(
//								"C:\\root\\fitnesse"), new FitTestEngine(),
//								"C:\\wamp\\www\\output\\"+ batchId+"\\"+rs.getString("browserName")+"");
//
//						cs = tdd.runTest(next);
//						right = cs.right;
						wrong = cs.wrong;
						exceptions = cs.exceptions;
						totalright = right + totalright;
						totalwrong = wrong + totalwrong;
						totalexceptions = exceptions + totalexceptions;
					

				testname = tests.toString();
				testname = testname.replace("[", "");
				testname = testname.replace("]", "");
				summary = cs.toString();

				
				java.util.Date dt = new java.util.Date();
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String currentTime = sdf.format(dt);
				 
				String sql = "insert into report(testName,passed,failed,exception,createdTime,batchId,browser) values ('"+ testname +"','"+ right +"','"+ wrong +"','"+ exceptions +"','"+ currentTime  + "','"+ batchId +"','"+ rs.getString("browserName") +"')";
				System.out.println(sql);
				PreparedStatement ps = conn.prepareStatement(sql);
				System.out.println(sql);					
				
				ps.execute(sql);
				ps.close ();				
				
				
				System.out.println(" Test Passed " + totalright);
				System.out.println(" Test Failed  : " + totalwrong);
				System.out.println(" Test Exceptions  : " + totalexceptions);
				}
				
				}
		
            }catch(Exception e){
			e.printStackTrace();	
		}
	}	
	
        };
        t.start();
        
}
	
			
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\root\\fitnesse\\TestList1.txt");
		

		try {
			BufferedReader bufRdr = new BufferedReader(new FileReader(file));
			String csvline = null;
			
			int c = 0;
			List<String> testList = new ArrayList<String>();
			
			while ((csvline = bufRdr.readLine()) != null) {
				if (c == 1) {
					startProcessing(testList);
					testList = new ArrayList<String>();
					c = 0;
				}
				testList.add(csvline);
				c++;
			}
			startProcessing(testList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
}

