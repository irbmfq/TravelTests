/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;

//import com.thoughtworks.selenium.*;
//import fit.ColumnFixture;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import travelQa.urlPoiDetails;
/**
 *
 * @author soujanyaqa
 */
public class Deals_search  extends ColumnFixture{
    public String url,H5picks_deal1,H5picks_deal2,canned_deal1,canned_deal2,dl_type1,dl_type2,dl_region1,dl_region2;
    public boolean result;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4442;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
    //DefaultSelenium selenium;

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }
    /*public Deals_search() {
       selenium = new DefaultSelenium("localhost", 4442, "*chrome", "http://travel.com");
        selenium.start();
   }*/
    
    public String check_Hot5deals1() {
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("//ul[@id='facet_category']/li[4]/a");
        session().waitForPageToLoad(urlPoiDetails.PageLoad);
        String s = session().getLocation();
        result = s.contains("/travel-deals/California-travel-deals/canned");
        session().close();
        session().stop();
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
    
    public String check_Populardeals() {
 try{
     startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("//div[@id='facet_category']/ul/li[1]/a");
        session().waitForPageToLoad(urlPoiDetails.PageLoad);
        String s = session().getLocation();
        result = s.contains("/travel-deals/Orlando-travel-deals/canned");
        session().close();
        session().stop();
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
    
    public String check_dealtype() {
try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("//div[@id='facet_category']/ul/li[5]/a");
        session().waitForPageToLoad("50000");
        String s = session().getLocation();
        result = s.contains("/travel-deals/Cruise/canned");
        session().close();
        session().stop();
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
   
    
    public String check_popregion1() {
try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("//div[@id='facet_region']/ul/li[1]/a");
        session().waitForPageToLoad("50000");
        String s = session().getLocation();
        result = s.contains("/travel-deals/Canada-travel-deals/canned");
        session().close();
        session().stop();
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
    
    public String check_dealsModule() {
try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().type("destination", "paris");
	session().click("//button[@type='submit' and @onclick='omnitureFnc();']");
	session().waitForPageToLoad("50000");
        String s = session().getLocation();
        result = s.contains("/travel-deals/paris-travel--deals");
        session().close();
        session().stop();
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
    
    
}
