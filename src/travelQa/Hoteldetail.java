

package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;


public class Hoteldetail extends ColumnFixture{
   public String url, s, module, listingurl, cityname, dealtype, link1, link2,link, link3,link4,s1,listingurl1;
   public static final String TIMEOUT = "120000";
   public String seleniumHost = "localhost",dest,label,city_name,nexturl;
   public boolean result,result1;
   public int seleniumPort = 4444;
   public String browser = "*chrome";
   public String webSite = "http://travel.com";
   
   protected void startSession(String seleniumHost, int seleniumPort,
			String browser, String webSite) throws Exception {
		startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
		session().setTimeout(TIMEOUT);
	}

	protected void closeSession() throws Exception {
		closeSeleniumSession();
	}

   
   public String breadcrumb() {
	   try {
			startSession(seleniumHost, seleniumPort, browser, webSite);
			session().setTimeout(TIMEOUT);
			session().open(url);
			session().waitForPageToLoad("30000");
			session().click(link);
			session().waitForPageToLoad("90000");
			s = session().getLocation();
			session().stop();
			closeSession();
	   } catch (Exception e) {
			e.printStackTrace();
			session().stop();
			try {
				closeSession();
			} catch (Exception en) {
				en.printStackTrace();
			}
		}
             if (s.contains("http://travel.com/travel-guide/United-States/California/")){
             return ("breadcrumb Passed");
             }
             else{
               return ("breadcrumb Failed");
               }
    }


    public String tabs(){
       	  try {
    			startSession(seleniumHost, seleniumPort, browser, webSite);
    			session().setTimeout(TIMEOUT);
    			session().open(url);
    			session().waitForPageToLoad("30000");
    		    session().click(link1);
    		    session().click(link2);
    		    session().click(link3);
    		    session().click(link4);
                session().waitForPageToLoad("60000");
                s1 = session().getLocation();
    			session().stop();
    			closeSession();
    	   } catch (Exception e) {
    			e.printStackTrace();
    			session().stop();
    			try {
    				closeSession();
    			} catch (Exception en) {
    				en.printStackTrace();
    			}
    	   }
    
               if (s1.contains("http://travel.com/travel-guide/")){
               return ("tabs Passed");
               }
               else{
               return ("tabs Failed");
               }
 
       }
       
	public String verifylisting() {
		String Message = null;
	   	  try {
	    			startSession(seleniumHost, seleniumPort, browser, webSite);
	    			session().setTimeout(TIMEOUT);
	    			session().open(url);
	    			session().waitForPageToLoad("30000");
	    			session().click("//div[@id='top11Module']/div/a");
	    			session().waitForPageToLoad("50000");
	    			listingurl = session().getLocation();
	    			session().stop();
	    			closeSession();
	    	   } catch (Exception e) {
	    			e.printStackTrace();
	    			session().stop();
	    			try {
	    				closeSession();
	    			} catch (Exception en) {
	    				en.printStackTrace();
	    			}
	   		}
	   		if (listingurl.contains("http://travel.com/travel-guide/")) {
	   			Message = "Passed";
	   		} else {
	   			Message = "Failed";
	   		}
	   		return Message;
  }
	public String verifydeals(){
		String Message1 = null;
		 try {
 			startSession(seleniumHost, seleniumPort, browser, webSite);
 			session().setTimeout(TIMEOUT);
 			session().open(url);
 			session().waitForPageToLoad("50000");
 			session().type("dest_interest",dest);
 			session().select("categorydropdown",label);
 			session().click("//button[@type='submit' and @onclick='omnitureFnc();']");
 			session().waitForPageToLoad("60000");
 			listingurl1 = session().getLocation();
 			session().stop();
 			closeSession();
 	   } catch (Exception e) {
 			e.printStackTrace();
 			session().stop();
 			try {
 				closeSession();
 			} catch (Exception en) {
 				en.printStackTrace();
 			}
		}
		if (listingurl1.contains("http://travel.com/travel-deals/paris-Flight--deals")) {
			Message1 = "Passed";
		} else {
			Message1 = "Failed";
		}
		return Message1;
		
	}

	 public String cities(){
		String Message2 = null;
		 try {
 			startSession(seleniumHost, seleniumPort, browser, webSite);
 			session().setTimeout(TIMEOUT);
 			session().open(url);
 			session().waitForPageToLoad("50000");
 			result=session().isTextPresent("Popular Cities near Berkeley");
 			result1=session().isTextPresent("Hotels");
 			 if (result==true && result1==true) {
 			session().click(city_name);	 
 			session().waitForPageToLoad("50000");
 			nexturl=session().getLocation();
 			 }
 			session().stop();
 			closeSession();
 	   } catch (Exception e) {
 			e.printStackTrace();
 			session().stop();
 			try {
 				closeSession();
 			} catch (Exception en) {
 				en.printStackTrace();
 			}
		}
 	  if (nexturl.contains("http://travel.com/travel-guide/United-States/California/San-Francisco")) {
			Message2 = "Passed";
		} else {
			Message2 = "Failed";
		}
		return Message2;
		
	}
}
   
    	


	 
		
