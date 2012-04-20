/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import fit.ColumnFixture;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 * @author ragavendraqa
 */
public class CarLob_booking extends ColumnFixture{
	 public String url,pickupCity1,CAdepart1,CAreturn1,cadateLeavingTime1,cadateReturningTime1,pickupCity2,pickupCity3;
	    public String pickupCity4,CAdepart4,CAreturn4,cadateLeavingTime4,cadateReturningTime4,pageTitle="",s="";
	    public String pickupCityValue="";
	    public static final String TIMEOUT = "120000";
	    public String seleniumHost = "localhost";
	    public int seleniumPort = 4441;
	    public String browser = "*chrome";
	    public String webSite = "http://travel.com";
	      
    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }


    public String verifyTravelMainCarBmBasic() {
    	try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);    	
        session().open(url);
        session().type("pickupCity", pickupCity1);
        session().click("CAdepart");
        session().click(CAdepart1);
        session().click("CAreturn");
        session().click(CAreturn1);
        session().select("cadateLeavingTime",cadateLeavingTime1);
        session().select("cadateReturningTime",cadateReturningTime1);
        session().click("carsBtn");
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
        if (pageTitle.equals("Car Search Results") || pageTitle.equals("Car Request Page")) {
            return ("verifyTravelMainCarBmBasic Passed");
        } else {
            return ("verifyTravelMainCarBmBasic Failed");
        }

    }
   
            
    public String verifyTravelMainCarCapsPickupCity() {
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);
            session().type("pickupCity", pickupCity2);
            session().click("carsBtn");
        	session().waitForPageToLoad("50000");    		
        	pageTitle = session().getTitle();
        	session().stop();
        	closeSession();
			}catch(Exception e){
				e.printStackTrace();
				session().stop();
	    		try{
	            closeSession();
	    		}catch(Exception ex){
	    			ex.printStackTrace();	
	    		}
			}
        
			if (pageTitle.equals("Car Search Results")  || pageTitle.equals("Car Request Page")) {
            return ("verifyTravelMainCarCapsPickupCity Passed");
			} else {
            return ("verifyTravelMainCarCapsPickupCity Failed");
			}

    }
    
    public String verifyTravelMainCarMissingPickupCity() {
    	try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);    	
        session().open(url);
        session().type("pickupCity", "");
        session().click("carsBtn");;
        s = session().getAlert();
        session().stop();
        closeSession();
		}catch(Exception e){
			e.printStackTrace();
			session().stop();
    		try{
            closeSession();
    		}catch(Exception ey){
    			ey.printStackTrace();	
    		}
		}    
		
        if (s.equals("Please let us know where you want to pick-up your car.")) {
            return ("verifyTravelMainCarMissingPickupCity Passed");
        } else {
            return ("verifyTravelMainCarMissingPickupCity Failed");
        }

    } 
    
       
    public String verifyTravelMainCarPickupCityCookies() {
    	try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);    	
        session().open(url);
        session().type("pickupCity", pickupCity3);
        session().click("carsBtn");;
        session().waitForPageToLoad("50000");            
        session().goBack();
        session().waitForPageToLoad("50000");            
        pickupCityValue = session().getValue("pickupCity");
        session().stop();
        closeSession();
		}catch(Exception e){
			e.printStackTrace();
			session().stop();
    		try{
            closeSession();
    		}catch(Exception ez){
    			ez.printStackTrace();	
    		}
		}   
		
        if (pickupCityValue.equals(pickupCity3)) {
            return ("verifyTravelMainCarPickupCityCookies Passed");
        } else {
            return ("verifyTravelMainCarPickupCityCookies Failed");
        }
    }

    
   public String verifyTravelMainCarPickupGreaterDepart() {
	   try{
	    startSession(seleniumHost, seleniumPort, browser, webSite);
	    session().setTimeout(TIMEOUT);    	
	    session().open(url);
        session().type("pickupCity", pickupCity4);
        session().click("CAdepart");
        session().click(CAdepart4);
        session().click("CAreturn");
        session().click(CAreturn4);
        session().select("cadateLeavingTime",cadateLeavingTime4);
        session().select("cadateReturningTime",cadateReturningTime4);
        session().click("carsBtn");
        s = session().getAlert();        
        session().stop();
        closeSession();
		}catch(Exception e){
			e.printStackTrace();
			session().stop();
    		try{
            closeSession();
    		}catch(Exception ea){
    			ea.printStackTrace();	
    		}
		}   		
        
        if (s.equals("Drop-off date can not be earlier than Pick-up date.")) {           
            return ("verifyTravelMainCarPickupGreaterDepart Passed");
        } else {            
            return ("verifyTravelMainCarPickupGreaterDepart Failed");
        }

    }


}
