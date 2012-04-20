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
public class POIListingLinks extends ColumnFixture {
    public String url,travelguide_heading,hotelspoi,flightspoi,rurl,attractionspoi,thingstodopoi;
    public boolean result;
    public String carrentalspoi,Vacationspoi,dealspoi,restaurantspoi,nightlifepoi,eventspoi;
    public String travelguide_heading1,hotelspoi1,flightspoi1,attractionspoi1,thingstodopoi1,s="";
    public String carrentalspoi1,Vacationspoi1,dealspoi1,restaurantspoi1,nightlifepoi1,eventspoi1;
     public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4442;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

     protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

 
    public POIListingLinks() {

      
    }
    public String check_heading() {
try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
         session().click(travelguide_heading);
         session().waitForPageToLoad("30000");
        String s = session().getLocation();
       
        result = s.contains("/travel-guide/Europe/United-Kingdom/London");
        session().waitForPageToLoad("30000");
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

public String check_hotelspoi() {

       try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(hotelspoi);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
        session().close();
        session().stop();
        result = s.contains("/travel-guide/London-hotels--United+Kingdom:1");
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

    
public String check_flightspoi() {

        try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(flightspoi);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("/travel-guide/London-flights--United+Kingdom:1");
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
public String check_carrentalspoi() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(carrentalspoi);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
        
        result = s.contains("travel-guide/London-car-rentals--United+Kingdom:1");
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
public String check_Vacationspoi() {

        try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(Vacationspoi);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-guide/London-vacations--United+Kingdom:1");
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

public String check_dealspoi() {

        try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(dealspoi);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-deals/London--United+Kingdom:1");
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
public String check_restaurantspoi() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(restaurantspoi);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
       result = s.contains("/travel-guide/London-restaurants--United+Kingdom:1");
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
public String check_nightlifepoi() {
  try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(nightlifepoi);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
      
        result = s.contains("travel-guide/London-nightlife--United+Kingdom:1");
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
public String check_attractionspoi() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(attractionspoi);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-guide/London-attractions--United+Kingdom:1");
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
public String check_thingstodopoi() {

          try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(thingstodopoi);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
     
        result = s.contains("travel-guide/London-things-to-do--United+Kingdom:1");
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
public String check_eventspoi() {

          try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(eventspoi);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-guide/London-events--United+Kingdom:1");
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
 public String check_heading1() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(travelguide_heading1);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
       
        result = s.contains("/travel-guide/Europe/United-Kingdom/London");
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
 public String check_hotelspoi1() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(hotelspoi1);
   session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("/travel-guide/London-hotels--United+Kingdom:1");
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
 public String check_flightspoi1() {

   try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(flightspoi1);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
      
        result = s.contains("/travel-guide/London-flights--United+Kingdom:1");
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
 public String check_carrentalspoi1() {

      try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(carrentalspoi1);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-guide/London-car-rentals--United+Kingdom:1");
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
 public String check_Vacationspoi1() {

          try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(Vacationspoi1);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
      
        result = s.contains("travel-guide/London-vacations--United+Kingdom:1");
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
 public String check_dealspoi1() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(dealspoi1);
        session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-deals/London--United+Kingdom:1");
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
 public String check_restaurantspoi1() {

         try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(restaurantspoi1);
     session().waitForPageToLoad("30000");
      String s = session().getLocation();
      
        result = s.contains("travel-guide/London-restaurants--United+Kingdom:1");
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
public String check_nightlifepoi1() {

     try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(nightlifepoi1);
    session().waitForPageToLoad("30000");
      String s = session().getLocation();
    
        result = s.contains("travel-guide/London-nightlife--United+Kingdom:1");
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
public String check_attractionspoi1() {

          try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(attractionspoi1);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
       
        result = s.contains("travel-guide/London-attractions--United+Kingdom:1");
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
public String check_thingstodopoi1() {

      try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(thingstodopoi1);
       session().waitForPageToLoad("30000");
      String s = session().getLocation();
     
        result = s.contains("travel-guide/London-things-to-do--United+Kingdom:1");
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
public String check_eventspoi1() {

          try {
         startSession(seleniumHost, seleniumPort, browser, webSite);
         session().setTimeout(TIMEOUT);
         session().open(url);
        session().click(eventspoi1);
      session().waitForPageToLoad("30000");
      String s = session().getLocation();
      
        result = s.contains("travel-guide/London-events--United+Kingdom:1");
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

