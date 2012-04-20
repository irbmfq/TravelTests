package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Honeymoon extends ColumnFixture {

    public String url,rurl,rurl1,city,label;
    public boolean result,result1,result2,result3,result4;
    public static final String TIMEOUT = "12000";
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

    public String breadcrumb() {
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().waitForPageToLoad("30000");
        result=session().isElementPresent("//div[@id='breadcrumb']");
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
         if(result=true)
           return "bread crumb is correct";
         else
            return "bread crumb is not present";
     }

    public String twitter() {
       try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().waitForPageToLoad("30000");
        result1=session().isElementPresent("twitterModule");
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
         if(result1=true)
                    return "twitter module is present";
         else
            return "twitter module is not present";

    }

      public String cruiselink() {
          try{
     startSession(seleniumHost, seleniumPort, browser, webSite);
      session().setTimeout(TIMEOUT);
      session().open(url);
      session().waitForPageToLoad("30000");
      session().type("destInterest",city);
      session().select("category",label);
      session().click("//button[@type='submit' and @onclick='omnitureFnc();']");
      session().waitForPageToLoad("50000");
      rurl = session().getLocation();
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
        if (rurl.contains("/travel-deals/paris-Flight--deals"))
        {
            return "cruise link is present";
        } else {
            return "cruise link is not present";
        }

      }

public String travelzoodeals() {
          try{
     startSession(seleniumHost, seleniumPort, browser, webSite);
      session().setTimeout(TIMEOUT);
      session().open(url);
      session().waitForPageToLoad("30000");
      result3=session().isElementPresent("/html/body/div[2]/div[3]/div[9]/h2/em/b");
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
        if(result3=true)
                    return "travelzoo link is present";
         else
            return "travelzoo link is not present";
        }

   }
















  
  
  
   
    
    



    

       




