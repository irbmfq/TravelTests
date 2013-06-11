/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelQa;

import com.thoughtworks.selenium.Wait;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;


/**
 *
 * @author samaitra
 */
public class hubMain extends ColumnFixture {

    public String url,  dest_interest,  srchBox,  regionLink,  exploreGuidesText, popularCitiesLink;
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
  

    public String searchBar() {
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        } catch (Exception e) {
            try {
               session().waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Hub Main page timed out";
                return Tmesage;
            }
        }

        session().type("dest_interest", dest_interest);
        //session().click("//input[@value='Search']");
        session().click("//input[@value='']");

        session().waitForPageToLoad("30000");
        String pageTitle = session().getTitle();
        session().close();
        session().stop();
        if (pageTitle.equals("Delhi Travel Guides, Hotels and Articles - travel Travel")) {
            return ("searchBar Passed");
        } else {
            return ("searchBar Failed");
        }

    }

    public String channelSearch() throws InterruptedException{
       try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
            } catch (Exception e) {
                try {
                    session().waitForPageToLoad("50000");
                } catch (Exception e2) {
                    String Tmesage = "Hub Main page timed out";
                    return Tmesage;
                }
            }
            	session().type("srchBox", srchBox);
                session().focus("srchBox");
                session().keyPressNative("73");
                new Wait(){
                public boolean until() {
                return session().isTextPresent("New Delhi, India") ;
                }
                }.wait("element New Delhi not found");

                session().close();
               session().stop();
                return "channelSearch Passed";
    }

    public String channelSearchHotel() throws InterruptedException{
      try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
            } catch (Exception e) {
                try {
                    session().waitForPageToLoad("50000");
                } catch (Exception e2) {
                    String Tmesage = "Hub Main page timed out";
                    return Tmesage;
                }
            }
            	session().type("srchBox", srchBox);
                session().focus("srchBox");
               session().keyPressNative("73");

                new Wait() {
                public boolean until() {
                return session().isTextPresent("Bellagio Hotel Prague, Prague") ;
                }
                }.wait("element Bellagio Hotel Prague, Prague not found");
                session().close();
                session().stop();
                return "channelSearchHotel Passed";
    }

      public String travelRegions() throws InterruptedException {
         try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        } catch (Exception e) {
            try {
                session().waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Hub Main page timed out";
                return Tmesage;
            }
        }
        session().click(regionLink);
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        session().close();
        session().stop();
        if (s.contains("/travel-guide/asia")) {
            return ("travelRegions Passed");
        } else {
            return ("travelRegions Failed");
        }

    }

    public String exploreGuides() throws InterruptedException {
       try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);

        } catch (Exception e) {
            try {
                session().waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Hub Main page timed out";
                return Tmesage;
            }
        }
        boolean result = session().isTextPresent(exploreGuidesText);
       session().close();
        session().stop();
        if (result) {
            return "exploreGuides Passed";
        } else {
            return "exploreGuides Failed";
        }
    }

     public String popularDestination() throws InterruptedException {
         try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        } catch (Exception e) {
            try {
                 session().waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Hub Main page timed out";
                return Tmesage;
            }
        }
         session().click(popularCitiesLink);
         session().waitForPageToLoad("30000");
        String s =  session().getLocation();
        session().close();
         session().stop();
        if (s.contains("/travel-guide/Las+Vegas-Nevada-United+States:48:Las+Vegas-destination-guide")) {
            return ("popularDestination Passed");
        } else {
            return ("popularDestination Passed");
        }

    }



}