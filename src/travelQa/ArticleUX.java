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
public class ArticleUX extends ColumnFixture {

    public String url,  articleurl,  articleheading,  rurl,  pagenationlinks,  populartraveldeals,  searchtraveldeals;
    public String hot5deals,  breadcrumb,  articletext,    travelguides,  Destinationdeals;
    public String   mostrecentarticlesgalleries,   UStravelguide,  morearticles,twitter, populartraveldealsideas;
    public String bestdeals,Searchtraveldeals,byauthorname,feed;
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
     public ArticleUX() {

       
    }

   public String check_breadcrumb() {
         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
        result = session().isTextPresent(breadcrumb);
        //result = session().getText("breadcrumb").equalsIgnoreCase(breadcrumb);
        //System.out.println(result);
        //System.out.println(session().getText("breadcrumb"));

        //session().waitForPageToLoad("50000");
         session().stop();
         closeSession();
        } catch (Exception e) {
          e.printStackTrace();
          session().stop();
        }
         if (result) {
            System.out.println("Test Passed"+result);
            return "Test Passed";
        } else {
            System.out.println("Test Failed"+result);
            return "Test Failed";
        }

    }

    public String check_articleheading() {


         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(articleheading);
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

    public String check_articletext() {

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(articletext);
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


    public String check_morearticles() {

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(morearticles);
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
    public String check_mostrecentarticlesgalleries() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
  session().waitForPageToLoad("50000");
        result = session().isTextPresent(mostrecentarticlesgalleries);
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

    public String check_twitter() {

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);

         session().waitForPageToLoad("50000");

        session().click("link=Follow Us");
        session().waitForPageToLoad("50000");

        String[] wintitle = session().getAllWindowTitles();
       // System.out.println("COUNT  :- " + wintitle.length);
        //System.out.println("WindowTitles :-" + wintitle[0]);
        //System.out.println("WindowTitles :-" + wintitle[1]);
        String s = session().getLocation();
        String Exptext = "travel Travel (traveltravel) on Twitter";
        result = Exptext.equals(wintitle[1]);
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

      public String check_populartraveldealsideas() {

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(populartraveldealsideas);
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

       public String check_byauthorname() {

      try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(byauthorname);
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
         public String check_feed() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().waitForPageToLoad("50000");
         result = session().isTextPresent(feed);
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
