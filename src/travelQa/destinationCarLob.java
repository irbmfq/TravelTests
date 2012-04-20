package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class destinationCarLob extends ColumnFixture {
    public String url,  pickupCity1,  CAdepart1,  CAreturn1,  cadateLeavingTime1,  cadateReturningTime1,  pickupCity2,  pickupCity3;
    public String pickupCity4,  CAdepart4,  CAreturn4,  cadateLeavingTime4,  cadateReturningTime4;
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

   public String verifyCarBmBasic() 
   {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("pickupCity", pickupCity1);
        session().click("CAdepart");
        session().click(CAdepart1);
        session().click("CAreturn");
        session().click(CAreturn1);
        session().select("cadateLeavingTime", cadateLeavingTime1);
        session().select("cadateReturningTime", cadateReturningTime1);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Car | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Car '+document.getElementById('pickupCity').value;s_265.tl(this,'o','Car | Travelocity - '+pageTitle);\"]");
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

        return ("verifyCarBmBasic Passed");
    }

    public String verifyCarCapsPickupCity()
    {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("pickupCity", pickupCity2);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Car | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Car '+document.getElementById('pickupCity').value;s_265.tl(this,'o','Car | Travelocity - '+pageTitle);\"]");
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
        return ("verifyCarCapsPickupCity Passed");

    }

    public String verifyCarMissingPickupCity()
     {
       String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("pickupCity", "");
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Car | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Car '+document.getElementById('pickupCity').value;s_265.tl(this,'o','Car | Travelocity - '+pageTitle);\"]");
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
        if (s.equals("Please let us know where you want to pick-up your car.")) {
            return ("verifyCarMissingPickupCity Passed");
        } else {
           return ("verifyCarMissingPickupCity Failed");
        }

    }

    public String verifyCarPickupCityCookies()
    {
        String pickupCityValue=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("pickupCity", pickupCity3);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Car | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Car '+document.getElementById('pickupCity').value;s_265.tl(this,'o','Car | Travelocity - '+pageTitle);\"]");
        try {
            session().waitForPageToLoad("50000");
        } catch (Exception e3) {
            String Tmessage2 = "Search result page timed out";
            return Tmessage2;
        }
        session().goBack();
        try {
            session().waitForPageToLoad("50000");
        } catch (Exception e3) {
            String Tmessage2 = "TravelMain Car page timed out";
            return Tmessage2;
        }
        pickupCityValue = session().getValue("pickupCity");
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
        if (pickupCityValue.equals(pickupCity3)) {
           return ("verifyCarPickupCityCookies Passed");
        }
        else {
             return ("verifyCarPickupCityCookies Failed");
             }
  }

    public String verifyCarPickupGreaterDepart() 
    {
        String s=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("pickupCity", pickupCity4);
        session().click("CAdepart");
        session().click(CAdepart4);
        session().click("CAreturn");
        session().click(CAreturn4);
        session().select("cadateLeavingTime", cadateLeavingTime4);
        session().select("cadateReturningTime", cadateReturningTime4);
        session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar11';s_265.eVar4='Car | Travelocity - '+pageTitle;s_265.eVar11='sTerms:f | Car '+document.getElementById('pickupCity').value;s_265.tl(this,'o','Car | Travelocity - '+pageTitle);\"]");
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
        if (s.equals("Drop-off date can not be earlier than Pick-up date.")) {
           return ("verifyCarPickupGreaterDepart Passed");
        } else {
          return ("verifyCarPickupGreaterDepart Failed");
        }

    }
    public static void main(String argv[])
   {
       //System.out.println("test is passed");
   }
}
