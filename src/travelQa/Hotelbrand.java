package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Hotelbrand extends ColumnFixture {

    public String name,brandcity,text,pickuphotel,url,deals,region,state,city;
    public boolean brandtitle,hotelname,popularbrands,traveldeals,result;
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

  

    public String title() {
    	try{
        	startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
           	session().waitForPageToLoad("50000");
        	brandtitle= session().isTextPresent(text);
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

			if (brandtitle==true) {
            return ("verify title is  Passed");
			} else {
            return ("verify title is Failed");
			}

    }

    public String popularhotel() {
    	try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        hotelname=session().isTextPresent(name);
        popularbrands=session().isTextPresent(brandcity);
        traveldeals=session().isTextPresent(deals);
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

        if (hotelname==true&&popularbrands==true&&traveldeals==true) {
            return ("popular hotel is Passed");
        } else {
            return ("popular hotel is Failed");
        }

    }

    public String findhotel() {
    	try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().select("hb_region",region);
        session().select("hb_stateCountry",state);
        session().select("hb_city",city);
        session().click("hb_goBtn");
        session().waitForPageToLoad("50000");
        pickuphotel=session().getLocation();
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

        if (pickuphotel.contains("/travel-guide")) {
            System.out.print("findhotel is  Passed");
            return ("findhotel module is Passed");
        } else {
            System.out.print("find hotel is  Failed");
            return ("findhotel module is Failed");
        }
    }

}



