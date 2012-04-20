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
public class GalleryUX extends ColumnFixture {

    public String url,  galleryurl,  galleryheading,  rurl,  pagenationlinks,  populartraveldeals,  searchtraveldeals;
    public String hot5deals,  breadcrumb,  gallerytext,  gallerytext1,  travelguides,  Destinationdeals;
    public String gallerylinks,  Mostrecentarticlesgalleries,  Related_Galleries,  UStravelguide,  Relatedarticles;
    public String bestdeals,Searchtraveldeals;
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

    public GalleryUX() {

        //selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
        //session().start();
    }

   /** public String check_galleryurl() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=More...");
       
           String s = session().getLocation();
       
        result = s.contains("/travel-ideas/cruises/galleries/delhi-yatra");
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
    }*/
    public String check_breadcrumb() {
         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
        result = session().isTextPresent(breadcrumb);
        //result = session().getText("breadcrumb").equalsIgnoreCase(breadcrumb);
        //System.out.println(result);
       // System.out.println(session().getText("breadcrumb"));

        //session().waitForPageToLoad("50000");
         session().stop();
         closeSession();
        } catch (Exception e) {
          e.printStackTrace();
          session().stop();
        }
         if (result) {
           // System.out.println("Test Passed"+result);
            return "Test Passed";
        } else {
           // System.out.println("Test Failed"+result);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Relatedarticles() {

             try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(Relatedarticles);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Related_Galleries() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
  session().waitForPageToLoad("50000");
        result = session().isTextPresent(Related_Galleries);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Destinationdeals() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        
         session().waitForPageToLoad("50000");
       
        session().click("link=Find Flights to Orlando");
        session().waitForPageToLoad("50000");
       
        String[] wintitle = session().getAllWindowTitles();
       // System.out.println("COUNT  :- " + wintitle.length);
       // System.out.println("WindowTitles :-" + wintitle[0]);
       // System.out.println("WindowTitles :-" + wintitle[1]);
        String s = session().getLocation();
        String Exptext = "Orlando Flights, Cheap Flights to Orlando, FL - travel Travel";

        result = Exptext.equals(wintitle[1]);
         System.out.println(result);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_hot5deals() {

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
        session().click("link=Cruise Travel & Deals");
       session().waitForPageToLoad("50000");
        
        String[] wintitle = session().getAllWindowTitles();
        //System.out.println("COUNT  :- " + wintitle.length);
       // System.out.println("WindowTitles :-" + wintitle[0]);
       // System.out.println("WindowTitles :-" + wintitle[1]);
        String s = session().getLocation();
        String Exptext = "Cruise Travel & Deals";
        result = Exptext.equals(wintitle[1]);
        System.out.println(result);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
      public String check_populartraveldeals() {

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(populartraveldeals);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
      public String check_Mostrecentarticlesgalleries() {

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
        result = session().isTextPresent(Mostrecentarticlesgalleries);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
      public String check_UStravelguide() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
         result = session().isTextPresent(UStravelguide);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

       public String check_bestdeals() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(bestdeals);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
         public String check_Searchtraveldeals() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
         result = session().isTextPresent(Searchtraveldeals);
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
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
}