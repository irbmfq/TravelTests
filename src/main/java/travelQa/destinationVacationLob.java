package travelQa;

import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class destinationVacationLob extends ColumnFixture {

    public String url,  valeavingFrom,  vagoingTo,  valeavingDate,  vadateLeavingTime,  vareturningDate,  vadateReturningTime;
    public String vaadult1,  vasenior1,  vachild1;
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
   

    public String verifyVacationBm()
    {
        String pageTitle=null;
        try {
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
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Vacation | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Vacation '+document.getElementById('valeavingFrom').value+' '+document.getElementById('vagoingTo').value;s_265.tl(this,'o','Vacation | Travelocity - '+pageTitle);\"]");
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
        if (pageTitle.equals("Select Hotel")) {
            
            return ("verifyVacationBm Passed");
        } else {
          
            return ("verifyVacationBm Failed");
        }
    }

    public String verifyJsMaxSixTraveler()
    {
        String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("valeavingFrom", valeavingFrom);
        session().type("vagoingTo", vagoingTo);
        session().select("vaadult1", vaadult1);
        session().select("vasenior1", vasenior1);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Vacation | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Vacation '+document.getElementById('valeavingFrom').value+' '+document.getElementById('vagoingTo').value;s_265.tl(this,'o','Vacation | Travelocity - '+pageTitle);\"]");
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
        if (s.equals("There is a maximum of 6 travelers per reservation.")) {
            return ("verifyJsMaxSixTraveler Passed");
        } else {
            return ("verifyJsMaxSixTraveler Failed");
        }
    }

    public String verifyAtleastOneTraveler()
    {
        String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("valeavingFrom", valeavingFrom);
        session().type("vagoingTo", vagoingTo);
        session().select("vaadult1", vaadult1);
        session().select("vasenior1", vasenior1);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Vacation | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Vacation '+document.getElementById('valeavingFrom').value+' '+document.getElementById('vagoingTo').value;s_265.tl(this,'o','Vacation | Travelocity - '+pageTitle);\"]");
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
        if (s.equals("Please select at least 1 traveler.")) {
            return ("verifyAtleastOneTraveler Passed");
        } else {
            return ("verifyAtleastOneTraveler Failed");
        }
    }

    public String verifyTravelTime()
    {
        String pageTitle=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("valeavingFrom", valeavingFrom);
        session().type("vagoingTo", vagoingTo);
        session().select("vadateLeavingTime", vadateLeavingTime);
        session().select("vadateReturningTime", vadateReturningTime);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Vacation | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Vacation '+document.getElementById('valeavingFrom').value+' '+document.getElementById('vagoingTo').value;s_265.tl(this,'o','Vacation | Travelocity - '+pageTitle);\"]");
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
        if (pageTitle.equals("We are searching...")) {
            return ("verifyTravelTime Passed");
        } else {
            return ("verifyTravelTime Failed");
        }
    }

    public String verifyReturnEarlierDepartAlert()
    {
        String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("valeavingFrom", valeavingFrom);
        session().type("vagoingTo", vagoingTo);
        session().select("vadateLeavingTime", vadateLeavingTime);
        session().select("vadateReturningTime", vadateReturningTime);
        session().click("valeavingDate");
        session().click(valeavingDate);
        session().click("vareturningDate");
        session().click(vareturningDate);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Vacation | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Vacation '+document.getElementById('valeavingFrom').value+' '+document.getElementById('vagoingTo').value;s_265.tl(this,'o','Vacation | Travelocity - '+pageTitle);\"]");
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
        if (s.equals("Return date cannot be earlier than departure date.")) {
            return ("verifyReturnEarlierDepartAlert Passed");
        } else {
            return ("verifyReturnEarlierDepartAlert Failed");
        }

    }

 public static void main(String argv[])
   {
       //System.out.println("test is passed");
   }

}
