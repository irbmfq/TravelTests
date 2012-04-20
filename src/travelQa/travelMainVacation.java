package travelQa;

import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import fit.ColumnFixture;
import fit.ColumnFixture;

public class travelMainVacation extends ColumnFixture {

    public String url,valeavingFrom,vagoingTo,valeavingDate,vadateLeavingTime,vareturningDate,vadateReturningTime;
    public String vaadult1,vasenior1,vachild1,pageTitle="",urlfinal="",s="";
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String webSite = "http://travel.travel.com";
    public String  browser = System.getProperty("browser");
       
    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }
    
    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }
    public String verifyTravelMainVacationBm() {
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);        
            session().type("valeavingFrom", valeavingFrom);
            session().type("vagoingTo", vagoingTo);
            session().click("valeavingDate");
            session().click(valeavingDate);
            session().select("vadateLeavingTime", vadateLeavingTime);
            session().click("vareturningDate");
            session().click(vareturningDate);
            session().select("vadateReturningTime", vadateReturningTime);
            session().select("vaadult1", vaadult1);
            session().select("vasenior1", vasenior1);
            session().click("vacationsBtn");
            session().waitForPageToLoad("50000");            
            pageTitle = session().getTitle();
            System.out.println(pageTitle);
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
                        
        if (pageTitle.equals("We are searching...") || pageTitle.equals("Select Hotel")) {            
            return ("verifyTravelMainVacationBm Passed");
        } else {            
            return ("verifyTravelMainVacationBm Failed");
        }
    }

        public String verifyChildrenOption() {
        	try{
            	startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);    	
                session().open(url);        
                session().select("vachild1", vachild1);
                session().waitForPageToLoad("120000");
                urlfinal = session().getLocation();
       
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
        if (urlfinal.contains("/vacations")) {
            return("verifyChildrenOption Passed");
        } else {
            return("verifyChildrenOption failed");
        }
        
    }
    public String verifyJsMaxSixTraveler(){
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);    	
            session().open(url);        
            session().type("valeavingFrom", valeavingFrom);
            session().type("vagoingTo", vagoingTo);
            session().select("vaadult1", vaadult1);
            session().select("vasenior1", vasenior1);   
            session().click("vacationsBtn");
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
        if(s.equals("There is a maximum of 6 travelers per reservation.")){        
        return("verifyJsMaxSixTraveler Passed");
       }
        else{
        return("verifyJsMaxSixTraveler Failed");
        }
       }
    
    
       public String verifyAtleastOneTraveler(){
    	   try{
           	startSession(seleniumHost, seleniumPort, browser, webSite);
               session().setTimeout(TIMEOUT);    	
               session().open(url);        
               session().type("valeavingFrom", valeavingFrom);
               session().type("vagoingTo", vagoingTo);
               session().select("vaadult1", vaadult1);
               session().select("vasenior1", vasenior1);  
               session().click("vacationsBtn");
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
        if(s.equals("Please select at least 1 traveler.")){
        return("verifyAtleastOneTraveler Passed");
       }
        else{         
        return("verifyAtleastOneTraveler Failed");
        } 
       }
       
       public String verifyTravelTime(){
    	   try{
              	startSession(seleniumHost, seleniumPort, browser, webSite);
                  session().setTimeout(TIMEOUT);    	
                  session().open(url); 
                  session().type("valeavingFrom", valeavingFrom);
                  session().type("vagoingTo", vagoingTo);
                  session().select("vadateLeavingTime", vadateLeavingTime);
                  session().select("vadateReturningTime", vadateReturningTime);        
                  session().click("vacationsBtn");
                  session().waitForPageToLoad("50000");
                  pageTitle=session().getTitle();
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
        if (pageTitle.equals("We are searching...") || pageTitle.equals("Select Hotel")) {       
        return("verifyTravelTime Passed");
        } else {       
            return("verifyTravelTime Failed");
        }       
       }          
              
       public String verifyReturnEarlierDepartAlert(){
    	   try{
             	startSession(seleniumHost, seleniumPort, browser, webSite);
                 session().setTimeout(TIMEOUT);    	
                 session().open(url); 
                 session().type("valeavingFrom",valeavingFrom);
                 session().type("vagoingTo", vagoingTo);
                 session().select("vadateLeavingTime", vadateLeavingTime);
                 session().select("vadateReturningTime", vadateReturningTime);  
                 session().click("valeavingDate");
                 session().click(valeavingDate);
                 session().click("vareturningDate");
                 session().click(vareturningDate);  
                 session().click("vacationsBtn");
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
        if(s.equals("Return date cannot be earlier than departure date.")){
        return("verifyReturnEarlierDepartAlert Passed");
       }
        else{
        return("verifyReturnEarlierDepartAlert Failed");
        } 
        
       }
       
    
  
}
