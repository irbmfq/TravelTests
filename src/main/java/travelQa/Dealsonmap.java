/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
//import com.thoughtworks.selenium.*;
//import fit.ColumnFixture;
import travelQa.urlPoiDetails;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;


/**
 *
 * @author soujanyaqa
 */
public class Dealsonmap extends ColumnFixture{
    public String url;
    public String sortType;
    public boolean result;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
   // DefaultSelenium selenium;

  protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }
/*public Dealsonmap() {
     selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
        selenium.start();
}*/

public String Check_MapLocation(){
    try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
    session().click("changecity");
    session().type("dealCity", "mexico city");
    session().click("mapsubmit");
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
   String s = session().getLocation();
   result = s.contains(urlPoiDetails.MapLocation);
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
   if (result){
            return urlPoiDetails.testPassed;
        } 
   else {
            return urlPoiDetails.testFailed;
        }
   }

public String Check_Hotellob(){
    try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
    session().click("dealTypeHotel");
    session().click("//button[@type='submit' and @onclick='formDealURL();']");
    //selenium.click("//button[@type='submit' and @onclick='omnitureFnc(); formDealURL();']");
   session().waitForPageToLoad(urlPoiDetails.PageLoad);
    String s = session().getLocation();
    result = s.contains(urlPoiDetails.Hotellob);
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
   if (result){
            return urlPoiDetails.testPassed;
        } 
   else {
            return urlPoiDetails.testFailed;
        }

    
}
public String check_breadcrumb(){
    try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
       session().waitForPageToLoad(urlPoiDetails.PageLoad);
      System.out.println("hello");
       for (int i =1; i <= 4; i++){
        // System.out.println(selenium.getText("//div[@id='breadcrumb']/ul/li["+i+"]/a"));
      result = session().isElementPresent("//div[@id='breadcrumb']/ul/li["+i+"]/a");
      
       }
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
          if (result){
              return urlPoiDetails.testPassed;
          }
          else{
              return urlPoiDetails.testFailed;
          }
  }
    










    public static void main(String argv[])
    {
      new Dealsonmap().Check_MapLocation();
      new Dealsonmap().Check_Hotellob();
      new Dealsonmap().check_breadcrumb();
  }
    
    
}
 


