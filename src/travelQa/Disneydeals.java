package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Disneydeals extends ColumnFixture {

    public String url,locationurl,dealcity,deallabel,topdeals;
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

    public String twitter_module() {
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

public String travelzoodeals() {
          try{
     startSession(seleniumHost, seleniumPort, browser, webSite);
      session().setTimeout(TIMEOUT);
      session().open(url);
      session().waitForPageToLoad("30000");
      result3=session().isElementPresent(topdeals);
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
































