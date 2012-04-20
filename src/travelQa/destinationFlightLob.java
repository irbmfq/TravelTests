package travelQa;

import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;


public class destinationFlightLob extends ColumnFixture {
    public String url,leavingFromFL,goingToFL,leavingDate,returningDate,adults,seniors,children,leavingFromFL2,goingToFL2;
    public String leavingFromFL3,goingToFL3,leavingFromFL4,goingToFL4,adults4,seniors4,leavingFromFL5,goingToFL5,adults5,seniors5;
    public String leavingFromFL6,goingToFL6,dateLeavingTime6,dateReturningTime6,leavingFromFL7,goingToFL7,dateLeavingTime7,dateReturningTime7,leavingDate7,returningDate7;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4442;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String verifyFlightTab()
    {
        String returnMessage = null;
        String pageTitle=null;
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("leavingFromFL",leavingFromFL);
        session().type("goingToFL", goingToFL);
        session().click("leavingDate");
        session().click(leavingDate);
        session().click("returningDate");
        session().click(returningDate);
        session().select("adults", adults);
        session().select("seniors", seniors);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Flights | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Flights '+document.getElementById('leavingFromFL').value+' '+document.getElementById('goingToFL').value;s_265.tl(this,'o','Flights | Travelocity - '+pageTitle);\"]");
        session().waitForPageToLoad("30000");
        pageTitle = session().getTitle();
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
        if (pageTitle.equals("We are performing your requested search")) {            
            returnMessage = "verifyFlightTab Passed";
        } else {            
            returnMessage = "verifyFlightTab Failed";
        }        
        return(returnMessage);               
    }

    public String verifyAtleastOneTraveler()
    {
        String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("leavingFromFL", leavingFromFL4);
        session().type("goingToFL",goingToFL4 );
        session().select("adults", adults4);
        session().select("seniors", seniors4);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Flights | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Flights '+document.getElementById('leavingFromFL').value+' '+document.getElementById('goingToFL').value;s_265.tl(this,'o','Flights | Travelocity - '+pageTitle);\"]");
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
        if(s.equals("Please select at least 1 traveler."))
          {
          return("verifyAtleastOneTraveler Passed");
           }
        else {
               return("verifyAtleastOneTraveler Failed");
              }
       }

    public String verifyJsMaxSixTraveler()
    {
      String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("leavingFromFL", leavingFromFL5);
        session().type("goingToFL", goingToFL5);
        session().select("adults", adults5);
        session().select("seniors", seniors5);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Flights | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Flights '+document.getElementById('leavingFromFL').value+' '+document.getElementById('goingToFL').value;s_265.tl(this,'o','Flights | Travelocity - '+pageTitle);\"]");
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
        if(s.equals("There is a maximum of 6 travelers per reservation."))
          {
          return("verifyJsMaxSixTraveler Passed");
           }
        else{
            return("verifyJsMaxSixTraveler Failed");
            }
       }      
       
       public String verifyTravelTime()
       {
        String pageTitle=null;
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("leavingFromFL", leavingFromFL6);
        session().type("goingToFL", goingToFL6);
        session().select("dateLeavingTime", dateLeavingTime6);
        session().select("dateReturningTime", dateReturningTime6);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Flights | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Flights '+document.getElementById('leavingFromFL').value+' '+document.getElementById('goingToFL').value;s_265.tl(this,'o','Flights | Travelocity - '+pageTitle);\"]");
        session().waitForPageToLoad("30000");
        pageTitle = session().getTitle();
        session().waitForPageToLoad("30000");
        pageTitle = session().getTitle();
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
        if (pageTitle.equals("Outbound")) {
           return("verifyTravelTime Passed");
        } else {
           return("verifyTravelTime Failed");
        }       
       }        
       
            
       
       public String verifyReturnEarlierDepartAlert()
       {
        String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("leavingFromFL", leavingFromFL7);
        session().type("goingToFL", goingToFL7);
        session().select("dateLeavingTime", dateLeavingTime7);
        session().select("dateReturningTime", dateReturningTime7);
        session().click("leavingDate");
        session().click(leavingDate7);
        session().click("returningDate");
        session().click(returningDate7);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Flights | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Flights '+document.getElementById('leavingFromFL').value+' '+document.getElementById('goingToFL').value;s_265.tl(this,'o','Flights | Travelocity - '+pageTitle);\"]");
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

        public static void main(String argv[])
   {
       //System.out.println("test is passed");
   }
      
}
