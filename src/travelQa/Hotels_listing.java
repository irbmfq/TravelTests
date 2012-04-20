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
public class Hotels_listing extends ColumnFixture{
    public String url,travelguide_heading,poi, rurl, hotel1,hotel2,hotel3,hotel4,hotel5,popularcities;
    public String hotel6,hotel7,hotel8,hotel9,s="";
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
    public boolean result;

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
     }

   public Hotels_listing() {
     
   }
     public String check_heading() {

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("link=Los Angeles Travel Guide");
        session().waitForPageToLoad("50000");
        String s = session().getLocation();
       result = s.contains("/travel-guide/United-States/California/Los-Angeles");
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
      public String check_poi() {

     try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//div[@id='srpOverviewModule']/div/div[2]/div[3]/a[1]");
            session().waitForPageToLoad("50000");
            String s= session().getLocation();
        
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44");
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
      

    public String check_hotel1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       session().click("link=Hilton Los Angeles Airport");
        session().waitForPageToLoad("50000");
        String s = session().getLocation();
        result = s.contains("/travel-guide/Los+Angeles-California-United+States-Hilton+Los+Angeles+Airport:44:026689-hotel-detail");
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
    

        public String check_hotel2() {

           try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("link=Mayfair Hotel");
        session().waitForPageToLoad("50000");
        String s = session().getLocation();
        result = s.contains("/travel-guide/Los+Angeles-California-United+States-Mayfair+Hotel:44:027251-hotel-detail");
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
        
        public String check_hotel3() {

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(hotel3);
        session().waitForPageToLoad("50000");
       String s = session().getLocation();
        
        result = s.contains("/travel-guide/Los+Angeles-California-United+States-Holiday+Inn+Los+Angeles:44:023558-hotel-detail");
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
       public String check_hotel4() {

         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(hotel4);
        session().waitForPageToLoad("50000");
        String s = session().getLocation();
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44-name-K-sort-name-asc-1");
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
          public String check_hotel5() {

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(hotel5);
        session().waitForPageToLoad("50000");
       String s = session().getLocation();
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44-acc-Romantic-sort-rating-desc-1");
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
         public String check_popularcities() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(popularcities);
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
        result = s.contains("/travel-guide/United-States/Nevada/Las-Vegas");
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
          public String check_hotel6() {

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("link=Price");;
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
        
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44-sort-price-asc-1");
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
         public String check_hotel7() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("link=Expert Rating");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
      
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44-sort-rating-desc-1");
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

        public String check_hotel8() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("link=Name");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
     
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44-sort-name-asc-1");
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
    public String check_hotel9() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("amenities");
        session().click("//div[@id='amenitiesList']/div[2]/div/ul/li[4]/a/span");
        session().waitForPageToLoad("50000");
         String s = session().getLocation();
       
        result = s.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44-amty-High+speed+internet-sort-price-asc-1");
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

        

    
       
       
       
