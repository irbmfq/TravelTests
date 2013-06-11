package travelQa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*; 

public class ReportSummary {

	public void generateSummary(){
		File file = new File("C:\\root\\fitnesse\\output\\summary.txt");
		int last;
		String totalright, totalwrong, totalexcep, summ;
		
		try{		
		BufferedReader bufRdr = new BufferedReader(new FileReader(file));
		String fileline = null;
		List<String> reportlist = new ArrayList<String>();
		
		while ((fileline = bufRdr.readLine()) != null) {
					
			reportlist.add(fileline);
			
		}	
		bufRdr.close();
		
		last = reportlist.size();
		summ = reportlist.get(last-1);
		//System.out.print(summ);		
		String summarray[] = summ.split(",");
		totalright = summarray[0];
		totalwrong = summarray[1];
		totalexcep = summarray[2];

		String	str1 = "<tr><td width='300'> "
			+ "<b>Summary</b>"
			+ "</td><td width='150' bgcolor='#80FF80'> <b>Total Passed:</b> "
			+ totalright
			+ "</td><td width='150' bgcolor='#FF7788'> <b>Total Failed:</b> "
			+ totalwrong
			+ "</td><td width='150' bgcolor='#FFFF85'> <b>Total Exceptions:</b> "
			+ totalexcep
			+ "</td><td width='50' style='font-size:0px'><form name='form1' method='post' action='http://travel-qa.office.travel.com:5000/FrontPage.TravelTestsQa"
			+ "?suite' style='margin:0px;padding:0px;float:lef;'><input type='submit' name='Test' value='Suite'></form></td></tr>";

	try {
		BufferedWriter out = new BufferedWriter(new FileWriter(
				"C:\\root\\fitnesse\\output\\index.html", true));
		out.flush();
		out.write(str1);
		out.close();
	} catch (IOException e) {
	}

		
		}
		catch (IOException e) {
		}
	}
	
	
	public void postMail( String recipients[ ], String subject, String message , String from) throws MessagingException
	{
	    boolean debug = false;

	     //Set the host smtp address
	     Properties props = new Properties();
	     props.put("mail.smtp.host", "postman.mx.travel.com");

	    // create some properties and get the default Session
	    Session session = Session.getDefaultInstance(props, null);
	    session.setDebug(debug);

	    // create a message
	    Message msg = new MimeMessage(session);

	    // set the from and to address
	    InternetAddress addressFrom = new InternetAddress(from);
	    msg.setFrom(addressFrom);

	    InternetAddress[] addressTo = new InternetAddress[recipients.length]; 
	    for (int i = 0; i < recipients.length; i++)
	    {
	        addressTo[i] = new InternetAddress(recipients[i]);
	    }
	    msg.setRecipients(Message.RecipientType.TO, addressTo);
	   

	    // Optional : You can also set your custom headers in the Email if you Want
	    msg.addHeader("MyHeaderName", "myHeaderValue");

	    // Setting the Subject and Content Type
	    msg.setSubject(subject);
	    msg.setContent(message, "text/html");
	    Transport.send(msg);
	}
	
	
	public static void main(String[] args) throws IOException {
	
		ReportSummary rs = new ReportSummary();
		rs.generateSummary();		
		StringBuffer messageList = new StringBuffer();		
		String recipients [] = {"saikat.maitra@corp.travel.com"};		
		
		
		int last;
		String totalright, totalwrong, totalexcep, summ;		
		File file1 = new File("C:\\root\\fitnesse\\output\\summary.txt");
		
		try{		
		BufferedReader bufRdr1 = new BufferedReader(new FileReader(file1));
		String fileline = null;
		List<String> reportlist = new ArrayList<String>();
		
		while ((fileline = bufRdr1.readLine()) != null) {
					
			reportlist.add(fileline);
			
		}
		bufRdr1.close();
		
		last = reportlist.size();
		summ = reportlist.get(last-1);
		//System.out.print(summ);		
		String summarray[] = summ.split(",");
		totalright = summarray[0];
		totalwrong = summarray[1];
		totalexcep = summarray[2];
		
		
		
		String subject = "Travel QA Automation Report - Summary : Test Passed : " + totalright + " Test Failed : "+ totalwrong +" Test Exceptions : "+totalexcep;
		String from = "TRAVEL-BDC-QA@LISTSERV.SUP.travel.COM";
		String message = null;
		
		File file = new File("C:\\root\\fitnesse\\output\\index.html");
		try {
			BufferedReader bufRdr = new BufferedReader(new FileReader(file));
			String csvline = null;
			while ((csvline = bufRdr.readLine()) != null) {	
					messageList.append(csvline);
					messageList.append("\n");
				}		
			
			message = messageList.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
			//System.out.println(message);
		
			
			try{
			rs.postMail(recipients, subject, message, from);
			}catch(Exception em){
			em.printStackTrace();
			}
	}catch (Exception eg){
	eg.printStackTrace();	
	}
	}
	
	
}
