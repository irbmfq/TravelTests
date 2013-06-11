package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class hubregion extends ColumnFixture {

    public String url,  countryname,topcity,popularguide,breadcrumb,countryurl,s,expected;
    
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

    public String Verifybreadcrumb() {
        String Message=null;
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().waitForPageToLoad("60000");
        breadcrumb = session().getText("//div[@id='breadcrumb']/ul");
        expected="You are here: Travel Guides » Europe";
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
        if (breadcrumb.equalsIgnoreCase(expected)){
            //System.out.println("Verifybreadcrumb passed" + backurl);
            Message = "Passed";
        } else {
            //System.out.println("Verifybreadcrumb failed" + backurl);
            Message="Failed";
        }

        //session().stop();
        return Message;

    }

    public String verifyCountryurl() {
        String Message=null;

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);

        session().click("link=" + countryname);
        session().waitForPageToLoad("60000");
         countryurl = session().getLocation();
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
       if (countryurl.contains(countryname))
           Message="Passed";
       else
           Message="Failed";
        return Message;
    }

    public String topCities() {
          try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(topcity);
        session().waitForPageToLoad("60000");
        s =session().getLocation();
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
        if (s.contains("/travel-guide/Asia/Indonesia/Bali")) {

            return ("topCities Passed");
        } else {
            return ("topCities Failed");
        }


    }

      public String popularGuides() {
          try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(popularguide);
        session().waitForPageToLoad("60000");
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
        if (s.contains("/travel-guide/Asia/Thailand/Bangkok")) {
            return ("popularGuides Passed");
        } else {
            return ("popularGuides Failed");
        }


    }

}

