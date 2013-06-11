package travelQa;

import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
/**
 *
 * @author samaitra
 */
public class hubHotels extends ColumnFixture {

    public String url,  pageHeading,s,sortlink,cityhotellink,top11Heading,citylink,seeAllDestination;
    public boolean result;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String checkHeading() 
    {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result = session().isTextPresent(pageHeading);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkAlphaSort()
    {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click(sortlink);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains("California/hotels/B");
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

     public String checkCityHotels() 
     {
         try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click(cityhotellink);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains("Adelanto-hotels-California-United+States:9999093");
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
     public String checktop11Heading()
     {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result = session().isTextPresent(top11Heading);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

     public String checktop11Destination()
     {
         try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click(citylink);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains("/travel-guide/United-States/California/Berkeley");
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }


     public String checkSeeAllDestination()
     {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click(seeAllDestination);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains("travel-guide/united-states/California/A");
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
     public String checkSeeAllDestinationCanada() 
     {
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click(seeAllDestination);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains("travel-guide/canada/A");
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
public static void main(String argv[])
   {
       //System.out.println("test is passed");
   }
}