package travelQa;

import java.sql.*;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import java.io.*;
import java.util.*;
import com.jcraft.jsch.*;
import net.htmlparser.jericho.*;
import java.net.*;

import fit.ColumnFixture;

public class takescreenshot extends ColumnFixture {

	//public static final String TIMEOUT = "120000";
    public int seleniumPort=4444;
	public String browserfolder,filepattern;
	public String browser,Firefox3_WindowsXP,Firefox35_WindowsXP,IE8_WindowsXP,IE7_WindowsXP,IE6_WindowsXP,Safari;
	public String url,seleniumHost;
	public String pagename;
    public String Message,sql;
    public boolean resultFF3,resultFF5,resultIE8,resultIE7,resultIE6,resultsafari;

     UUID batchId = UUID.randomUUID();
	protected void startSession(String seleniumHost, int seleniumPort,
			String browser, String webSite) throws Exception {
		startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
		//session().setTimeout(TIMEOUT);
	}

	protected void closeSession() throws Exception {
		closeSeleniumSession();
	}

	public String completed() {
try {
      Class.forName("com.mysql.jdbc.Driver");
      
      String connUrl ="jdbc:mysql://dpdev-lm05.office.travel.com:3306/automation";
      Connection c = DriverManager.getConnection(connUrl,"automation_rw", "autorw46%1");
      
      //String connUrl ="jdbc:mysql://localhost:3306/automation";
      //Connection c = DriverManager.getConnection(connUrl,"root", "");
      
      
      System.out.println("database connected");
     java.util.Date dt = new java.util.Date();
   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
     "yyyy-MM-dd HH:mm:ss");
   String currentTime = sdf.format(dt);
    if (Firefox3_WindowsXP.equals("yes,baseline"))
    {
        filepattern=pagename+"_Firefox3_0_"+batchId+".png";
        resultFF3=firefox3();
      sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','Firefox3.0_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','yes','"+url+"')";
    PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
                    System.out.println("the result for firefox 3.0 for pagename: "+pagename+" is: "+resultFF3);
    }
     else if (Firefox3_WindowsXP.equals("yes"))
     {
      filepattern=pagename+"_Firefox3_0_"+batchId+".png";
        resultFF3=firefox3();
      sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','Firefox3.0_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','no','"+url+"')";
    PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
                    System.out.println("the result for firefox 3.0 for pagename: "+pagename+" is: "+resultFF3);
     }
     else
        resultFF3=true;
if (Firefox35_WindowsXP.equals("yes,baseline"))
    {
         filepattern=pagename+"_Firefox3_5_"+batchId+".png";
        resultFF5=firefox5();
         sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','Firefox3.5_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','yes','"+url+"')";
PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
                    System.out.println("the result for firefox 3.5 for pagename: "+pagename+" is: "+resultFF5);
}
else if (Firefox35_WindowsXP.equals("yes"))
{
    filepattern=pagename+"_Firefox3_5_"+batchId+".png";
        resultFF5=firefox5();
         sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','Firefox3.5_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','no','"+url+"')";
PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
                    System.out.println("the result for firefox 3.5 for pagename: "+pagename+" is: "+resultFF5);
}

     else
        resultFF5=true;
if (IE8_WindowsXP.equals("yes,baseline"))
    {
        filepattern=pagename+"_IE8_"+batchId+".png";
        resultIE8=IE8();
         sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','IE8_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','yes','"+url+"')";
PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
System.out.println("the result for IE8 for pagename: "+pagename+" is: "+resultIE8);
}

else if (IE8_WindowsXP.equals("yes"))
{
  filepattern=pagename+"_IE8_"+batchId+".png";
        resultIE8=IE8();
         sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','IE8_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','no','"+url+"')";
PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
System.out.println("the result for IE8 for pagename: "+pagename+" is: "+resultIE8);  
}

else
          resultIE8=true;

    if (IE7_WindowsXP.equals("yes,baseline"))
        {
        filepattern=pagename+"_IE7_"+batchId+".png";
        resultIE7=IE7();
        sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','IE7_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','yes','"+url+"')";
    PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
                  System.out.println("the result for IE7 for pagename: "+pagename+" is: "+resultIE7);
    }

    else if (IE7_WindowsXP.equals("yes"))
    {
         filepattern=pagename+"_IE7_"+batchId+".png";
        resultIE7=IE7();
        sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','IE7_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','no','"+url+"')";
    PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
                  System.out.println("the result for IE7 for pagename: "+pagename+" is: "+resultIE7);
    }

    else
        resultIE7=true;

        if (IE6_WindowsXP.equals("yes,baseline"))
        {
         filepattern=pagename+"_IE6_"+batchId+".png";
         resultIE6=IE6();
        sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','IE6_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','yes','"+url+"')";
   PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
      System.out.println("the result for IE6 for pagename:"+pagename+" is: "+resultIE6);
        }
    
        else if (IE6_WindowsXP.equals("yes"))
        {
           filepattern=pagename+"_IE6_"+batchId+".png";
         resultIE6=IE6();
        sql="insert into screenshot(pageName,envName,fileName,batchId,createdTime,baseline,url) values ('"+pagename+"','IE6_WindowsXP','"+filepattern+"','"+batchId+"','"+currentTime+"','no','"+url+"')";
   PreparedStatement ps = c.prepareStatement(sql);
					ps.execute(sql);
					ps.close();
      System.out.println("the result for IE6 for pagename:"+pagename+" is: "+resultIE6); 
        }
        else
        resultIE6=true;

     }
     catch( Exception e ) {
      e.printStackTrace();
    }

  if (resultFF3==true && resultFF5==true && resultIE8==true && resultIE7==true && resultIE6==true)
    Message="yes";
  else
      Message="no";
     return Message;

	}

    public boolean firefox3(){

        try {
           String browser = "FF30 on Windows";
	       String seleniumHost = "travel-qa.office.travel.com";
	        String webSite = url;

		    String filename = "C:\\wamp\\www\\output\\baseline\\"+ filepattern;
				startSession(seleniumHost, seleniumPort, browser, webSite);
				//session().setTimeout(TIMEOUT);
				session().open(url);
				session().waitForPageToLoad("50000");
               // session().setExtensionJs(url);
				session().windowMaximize();
				session().windowFocus();
                System.out.println("the filename is :"+filename);
				session().captureEntirePageScreenshot(filename,
								"background=#FFFFFF");
                System.out.println("the image is capturued");
				session().stop();
				closeSession();
                return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				closeSession();
			} catch (Exception en) {

				en.printStackTrace();
			}
		return false;
		}

    }
    public boolean firefox5(){

        try {
        	String browser = "FF35 on Windows";
	       String seleniumHost = "travel-qa.office.travel.com";
	        String webSite = url;
	      //String filesavepath = "C:\\wamp\\www\\output\\baseline\\" + pagename + "\\Firefox3_0\\";
		    String filename = "C:\\wamp\\www\\output\\baseline\\"+ filepattern;
				//new File(filesavepath).delete();
				//new File(filesavepath).mkdirs();
				startSession(seleniumHost, seleniumPort, browser, webSite);
				//session().setTimeout(TIMEOUT);
				session().open(url);
				session().waitForPageToLoad("50000");
				session().windowMaximize();
				session().windowFocus();
                System.out.println("the filename is :"+filename);
				session().captureEntirePageScreenshot(filename,
								"background=#FFFFFF");
				System.out.println("the image is capturued");
				session().stop();
				closeSession();
                return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				closeSession();
			} catch (Exception en) {

				en.printStackTrace();
			}
		return false;
		}

    }
    public boolean IE8(){

        try {
        	String browser = "IE8 on Windows";
	        String seleniumHost = "travel-qa.office.travel.com";
	        String webSite = url;
	      //String filesavepath = "C:\\wamp\\www\\output\\baseline\\" + pagename + "\\Firefox3_0\\";
		    String filename = "C:\\wamp\\www\\output\\baseline\\"+ filepattern;
				//new File(filesavepath).delete();
				//new File(filesavepath).mkdirs();
		    	startSession(seleniumHost, seleniumPort, browser, webSite);
				//session().setTimeout(TIMEOUT);
				session().open(url);
				session().waitForPageToLoad("50000");
				session().windowMaximize();
				session().windowFocus();
                System.out.println("the filename is :"+filename);
				session().captureEntirePageScreenshot(filename,
								"background=#FFFFFF");
				System.out.println("the image is capturued");
				session().stop();
				closeSession();
                return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				closeSession();
			} catch (Exception en) {

				en.printStackTrace();
			}
		return false;
		}

    }
public boolean IE7(){

        try {
        	String browser = "IE7 on Windows";
	       String seleniumHost = "travel-qa.office.travel.com";
	        String webSite = url;
	      //String filesavepath = "C:\\wamp\\www\\output\\baseline\\" + pagename + "\\Firefox3_0\\";
		    String filename = "C:\\wamp\\www\\output\\baseline\\"+ filepattern;
				//new File(filesavepath).delete();
				//new File(filesavepath).mkdirs();
		    	startSession(seleniumHost, seleniumPort, browser, webSite);
				//session().setTimeout(TIMEOUT);
				session().open(url);
				session().waitForPageToLoad("50000");
				session().windowMaximize();
				session().windowFocus();
                System.out.println("the filename is :"+filename);
				session().captureEntirePageScreenshot(filename,
								"background=#FFFFFF");
				System.out.println("the image is capturued");
				session().stop();
				closeSession();
                return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				closeSession();
			} catch (Exception en) {

				en.printStackTrace();
			}
		return false;
		}

    }
public boolean IE6(){

        try {
        	String browser = "IE6 on Windows";
	       String seleniumHost = "travel-qa.office.travel.com";
	        String webSite = url;
	      //String filesavepath = "C:\\wamp\\www\\output\\baseline\\" + pagename + "\\Firefox3_0\\";
		    String filename = "C:\\wamp\\www\\output\\baseline\\"+ filepattern;
				//new File(filesavepath).delete();
				//new File(filesavepath).mkdirs();
				startSession(seleniumHost, seleniumPort, browser, webSite);
			//	session().setTimeout(TIMEOUT);
				session().open(url);
				session().waitForPageToLoad("50000");
				session().windowMaximize();
				session().windowFocus();
                System.out.println("the filename is :"+filename);
				session().captureEntirePageScreenshot(filename,
								"background=#FFFFFF");
				System.out.println("the image is capturued");
				session().stop();
				closeSession();
                return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				closeSession();
			} catch (Exception en) {

				en.printStackTrace();
			}
		return false;
		}

    }
 
}
