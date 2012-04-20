package travelQa;

import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import fit.ColumnFixture;

public class travelMainCruise extends ColumnFixture {

	public String url,destination,cruiseLength,fromMonthYear,fromDay,cruiseVendor1,pageTitle="";
	
	public static final String TIMEOUT = "120000";
    
	  protected void startSession() throws Exception {
	     String seleniumHost="localhost";
		 String webSite="http://travel.travel.com";
		 int seleniumPort=4444;			 
		 String  browser = System.getProperty("browser");
		  
		  startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
	        session().setTimeout(TIMEOUT);
	    }
    
    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }
     
    public String verifyTravelMainCruiseBm(){
    	try{
        	startSession();
            session().setTimeout(TIMEOUT);    	
            session().open(url);        
            session().select("destination",destination);
            session().select("cruiseLength",cruiseLength);
            session().select("fromMonthYear",fromMonthYear);
            session().select("fromDay",fromDay);
            session().select("cruiseVendor",cruiseVendor1);
            session().click("cruisesBtn");	      
            session().waitForPageToLoad("50000");        
            pageTitle = session().getTitle();    
            session().stop();
            closeSession();
        	}catch(Exception e){
        		e.printStackTrace();
        		session().stop();
        		try{
                closeSession();
        		}catch(Exception en){
        			en.printStackTrace();	
        		}
        	}         
                    

        
        	return ("verifyTravelMainCruiseBm Passed");
    }
}
   