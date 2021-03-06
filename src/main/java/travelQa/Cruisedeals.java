package travelQa;

/**
 *
 * @author Shanti
 */
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Cruisedeals extends ColumnFixture{
    public String url,tempurl,destination,category,title,travelzootext,breadcrumb;
 java.lang.String page=null;
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

 public String verifybreadcrumb() {
      String Message=null;     
      boolean result;
           try {
           startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
			session().open(url);
			  }
			catch(Exception e)
              {
			session().waitForPageToLoad("300000");
		       }
             result=session().isTextPresent(breadcrumb);
             if(result==true)                       
             Message="Passed";
             else
             Message="Failed-Breadcrumb is wrong";
             session().close();
             session().stop();
         return Message;
 }

 public String verifysearchbox()
 {
      String Message = null;
        String expected = null, actual;
        String dest1, cat1;
        boolean result, result1;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        } catch (Exception e) {
            session().waitForPageToLoad("300000");
        }
        result = session().isElementPresent("destInterest");
        result1 = session().isElementPresent("category");
        if (result == true && result1 == true) {
            session().type("destInterest", destination);
            session().select("category", category);
            session().click("//button[@type='submit' and @onclick='omnitureFnc();']");
            session().waitForPageToLoad("300000");
             cat1=category.replace("label=","");
            expected=destination+" "+cat1;
         actual=session().getText("//div[@id='mainContent']/h1");
            if (actual.equalsIgnoreCase(expected)) {
                Message = "Passed";
            } else {
                Message = "Failed-Search functionality is not working";
            }
        } else {
            Message = "Failed-Search box is not present";
        }
        session().close();
        session().stop();
        return Message;
 }
 public String verifytwittermodule()
 {
      String Message=null;
      boolean result;
                    

           try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
			session().open(url);
			}
			catch(Exception e)
                        {
			session().waitForPageToLoad("300000");

			}
                       result=session().isElementPresent("twitterModule");
                          if(result==true)
                       {

                           Message="Passed";
            
                       }
                       else
                           Message="Failed-twitter module is not present";

                      session().close();
                      session().stop();
         return Message;
 }
 public String verifytoppickmodule()
 {
      String Message=null;
      String toptext=null;
      String expected=null;
      boolean result;
                    

           try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
			session().open(url);
			}
			catch(Exception e)
                        {
			session().waitForPageToLoad("300000");

			}
                       result=session().isElementPresent("link=Popular Cruise Destinations");
                          if(result==true)
                       {
                       expected=title;
                       toptext=session().getText("link=Popular Cruise Destinations");
                       //System.out.println("the top text is :"+toptext);
                        if(toptext.contains(expected))
                           Message="Passed";
                           else
                               Message="Failed-Toppicktext is not matching";
                       }
                       else
                           Message="Failed-toppick module is not present";

                      session().close();
                      session().stop();
         return Message;
 }
public String verifytravelzoomodule()
 {
      String Message=null;
      String actual=null;
      boolean result;
                    

           try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
			session().open(url);
			}
			catch(Exception e)
                        {
			session().waitForPageToLoad("300000");

			}
                       result=session().isElementPresent("//div[@id='travelZooLeft']/h2/em/b");
                          if(result==true)
                       {
                         actual=session().getText("//div[@id='travelZooLeft']/h2/em/b");
                        // System.out.println("actual text is :"+actual);
                         if (actual.equalsIgnoreCase(travelzootext))
                           Message="Passed";
                         else
                             Message="Failed-travelzoo module heading is wrong";


                       }
                       else
                           Message="Failed-travelzoo module is not present";

                      session().close();
                      session().stop();
         return Message;
 }
}
/*public static void main(String argv[])
    {
        // Main
      new Cruisedeals().verifybreadcrumb();
      new Cruisedeals().verifysearchbox();
      new Cruisedeals().verifytoppickmodule();
      new Cruisedeals().verifytravelzoomodule();
      new Cruisedeals().verifytwittermodule();
    }
*/






