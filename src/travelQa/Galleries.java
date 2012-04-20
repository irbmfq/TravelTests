package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 *
 * @author pavankarnam
 */
public class Galleries extends ColumnFixture {

    public String url,  galleryurl,  galleryheading,  rurl,  pagenationlinks,  populartravel_destinations;
    public String hottraveldeals,  breadcrumb,  gallerytext,  gallerytext1,  travelguides,  traveldeals;
    public String gallerylinks,  s = "";
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
    public boolean result;
    //public DefaultSelenium selenium;

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);

    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public Galleries() {

        //selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
        //selenium.start();
    }

    public String check_galleryurl() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("showAllLinksGal");
            session().click("bNgallerylink21");
            
            String s = session().getLocation();
              result = s.contains("/travel-ideas/lodging/galleries/biggest-hotels");
              session().waitForPageToLoad("50000");
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
        // selenium.close();
        // selenium.stop();
      
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_breadcrumb() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("50000");
            result = session().isTextPresent(breadcrumb);
           //System.out.println(result);
          //System.out.println(session().getText("breadcrumb"));
            
            session().stop();
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            session().stop();
        }
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_galleryheading() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("50000");
            result = session().isTextPresent(galleryheading);
            
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


        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_gallerytext() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("50000");
             result = session().isTextPresent(gallerytext);
            
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


        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_gallerytext1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//img[@alt='Next']");
            session().click("//img[@alt='Next']");
            session().waitForPageToLoad("50000");

            result = session().isTextPresent(gallerytext1);
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


        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";

        }
    }

    public String check_populartravel_destinations() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//div[@id='popularLinks']/ul/li[2]/a[1]");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/San+Francisco-hotels-California-United+States:39");
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

        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_hottraveldeals() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            //session().waitForPageToLoad("50000");
            session().click("link=Caribbean Cruise Deals");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

           result = s.contains("/cruises");
           System.out.println(result);
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


      
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_traveldeals() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            //session().waitForPageToLoad("50000");
            session().click("//div[@id='seeAllSlot']/ul[1]/li[2]/a");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            result = s.contains("http://kayak.travel.travel.com/help/baduri.html?url=http%3A%2F%2Fwww.pinpointtravel.com%2Fdeals-flight-tickets");
            System.out.println(result);
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

       
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_travelguides() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=Honeymoon Deals");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            result = s.contains("http://travel.travel.com/travel-deals/honeymoon-travel");
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

        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_gallerylinks() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//img[@alt='Next']");
            session().click("//img[@alt='Next']");
            session().click("link=Vegas Vacation Deals");
            session().waitForPageToLoad("50000");
            session().stop();

            String s = session().getLocation();
            result = s.contentEquals("http://www.pinpointtravel.com/deals-vacation-las_vegas?ncid=travelCOMMptrvcrsstraveln0002");
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
}

