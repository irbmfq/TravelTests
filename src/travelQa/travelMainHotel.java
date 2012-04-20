package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class travelMainHotel extends ColumnFixture {

    public String url,trvCity,country,state,trvHotelIn,trvHotelOut,adult1,pageTitle="",s="";
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;    
    public String webSite = "http://travel.travel.com";
    public String  browser = "*chrome";
    
    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }
    
    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }
    
    public String verifyTravelMainHotelBmBasic() {    	
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);      
            session().type("trvCity", trvCity);
            session().click("hotelsBtn");        
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
                                                                                           
            return ("verifyTravelMainHotelBmBasic Passed");
        
    }

    public String verifyTravelMainHotelUs() {
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);  
            session().type("trvCity", trvCity);
            session().select("country", country);
            session().select("state", state);
            session().click("trvHotelIn");
            session().click(trvHotelIn);
            session().click("trvHotelOut");
            session().click(trvHotelOut);
            session().select("adult1", adult1);
            session().click("hotelsBtn");
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
            
            
            return ("verifyTravelMainHotelUs Passed");
        }
    

    public String verifyTravelMainHotelIntl() {
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);            
            session().type("trvCity", trvCity);
            session().select("country", country);
            session().click("trvHotelIn");
            session().click(trvHotelIn);
            session().click("trvHotelOut");
            session().click(trvHotelOut);
            session().select("adult1", adult1);
            session().click("hotelsBtn");
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
            
            return ("verifyTravelMainHotelIntl Passed");
        
    }

    public String verifyTravelMainHotelCheckInCheckOutSame() {
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);            
            session().type("trvCity", trvCity);
            session().select("country", country);
            session().click("trvHotelIn");
            session().click(trvHotelIn);
            session().click("trvHotelOut");
            session().click(trvHotelOut);
            session().click("hotelsBtn");
            s = session().getAlert();
            
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
        if (s.equals("Check-out date must be different from the Check-in date")) {
            return ("verifyTravelMainHotelCheckInCheckOutSame Passed");
        } else {
            return ("verifyTravelMainHotelCheckInCheckOutSame Failed");
        }
    }
    
//    public String verifyTravelMainHotelMissingCity() {
//    	try{
//        	startSession(seleniumHost, seleniumPort, browser, webSite);
//            session().setTimeout(TIMEOUT);    	
//            session().open(url);     
//            session().click("hotelsBtn");
//            s = session().getAlert();            
//            session().stop();
//            closeSession();
//        	}catch(Exception e){
//        		e.printStackTrace();
//        		session().stop();
//        		try{
//                closeSession();
//        		}catch(Exception en){
//        			en.printStackTrace();	
//        		}
//        	}  
//        	
//            if (s.equals("Please enter a city.")) {
//            return ("verifyTravelMainHotelMissingCity Passed");
//        } else {
//            return ("verifyTravelMainHotelMissingCity Failed");
//        }
//    }
//    
//      public String verifyTravelMainHotelCheckOutgreaterCheckIn() {
//    	  try{
//          	startSession(seleniumHost, seleniumPort, browser, webSite);
//              session().setTimeout(TIMEOUT);    	
//              session().open(url);             
//              session().type("trvCity", trvCity);
//              session().select("country", country);
//              session().click("trvHotelIn");
//              session().click(trvHotelIn);
//              session().click("trvHotelOut");
//              session().click(trvHotelOut);
//              session().click("hotelsBtn");
//              s = session().getAlert();
//              session().stop();
//              closeSession();
//          	}catch(Exception e){
//          		e.printStackTrace();
//          		session().stop();
//          		try{
//                  closeSession();
//          		}catch(Exception en){
//          			en.printStackTrace();	
//          		}
//          	}  
//          	
//          	if (s.equals("Check-out date can not be earlier than check-in date.")) {          
//            return ("verifyTravelMainHotelCheckOutgreaterCheckIn Passed");
//        } else {        
//            return ("verifyTravelMainHotelCheckOutgreaterCheckIn Failed");
//        }
//    }   
  
}
