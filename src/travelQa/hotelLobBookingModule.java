package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class hotelLobBookingModule extends ColumnFixture {

    public String url,  trvHotelOut,  adult2,  htchild2,  numRooms,  trvCity,  htchild1,  adult1,  minorAge1Room1;
    public String trvHotelIn,  page_url,  alert1,  Alert1,  Alert2,  Alert3,  pageTitle,  urlfinal;
    public boolean result;
    public String minorAge1Room2;
    public String departdate,  returndate;
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

    public String searchbutton() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().type("trvCity", "paris");
            session().select("state", "label=AZ");
            session().click("trvHotelIn");
            session().click("trvHotelOut");
            session().select("numRooms", "label=1");
            session().select("adult1", "label=3");
            session().select("htchild1", "label=2");
            session().select("minorAge1Room1", "label=4");
            session().select("minorAge2Room1", "label=6");
            session().click("hotelsLobBtn");
            session().waitForPageToLoad("120000");
            page_url = session().getLocation();
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

        if (page_url.contains("hotel")) {
            Message = "Passed";
        } else {
            Message = "Failed";
        }
        return Message;


    }

    public String verifyReturnEarlierDepartAlert() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("80000");
            session().type("trvCity", "paris");
            session().click("trvHotelIn");
            result = session().isElementPresent(departdate);
            if (result == true) {
                session().click(departdate);
            } else {
                session().click("//img[@alt='Next Month']");
                session().click("link=2");
            }
            session().click("trvHotelOut");
            result = session().isElementPresent(returndate);
            if (result == true) {
                session().click(returndate);
            } else {
                session().click("//img[@alt='Next Month']");
                session().click("link=1");
            }
            session().click("hotelsLobBtn");
            alert1 = session().getAlert();
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

        if (alert1.equalsIgnoreCase("Check-out date can not be earlier than check-in date.")) {
            System.out.print("verifyReturnEarlierDepartAlert Passed");
            Message = "Passed";
        } else {
            System.out.print("verifyReturnEarlierDepartAlert Failed");
            Message = "Failed";
        }

        return Message;
    }

    public String verifyCityMissingAlert() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("80000");
            session().click("hotelsLobBtn");
            Alert1 = session().getAlert();
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
        if (!Alert1.equalsIgnoreCase("Please enter a city.")) {
            System.out.print("verifyCityMissingAlert failed : " + Alert1);
            Message = "Faied";
        } else {
            System.out.print("verifyCityMissingAlert passed : " + Alert1);
            Message = "Passed";
        }
        return Message;

    }

    public String verifyChildAgeMissingAlert() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("80000");
            session().type("trvCity", trvCity);
            session().select("htchild1", htchild1);
            session().click("hotelsLobBtn");
            Alert2 = session().getAlert();
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
        if (!Alert2.equalsIgnoreCase("Please specify ages of all children.")) {
            System.out.print("verifyChildAgeMissingAlert: failed" + Alert2);
            Message = "Failed";
        } else {
            System.out.print("verifyChildAgeMissingAlert : Passed" + Alert2);
            Message = "Passed";
        }

        return Message;
    }

    public String verifyMaxSixTraveler() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("80000");
            session().type("trvCity", trvCity);
            session().select("adult1", adult1);
            session().select("htchild1", htchild1);
            session().select("minorAge1Room1", minorAge1Room1);
            session().click("hotelsLobBtn");
            Alert3 = session().getAlert();
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
        if (Alert3.equalsIgnoreCase("There can be a maximum of 6 travelers in Room 1.")) {
            System.out.print("verifyMaxSixTraveler passed\n" + Alert3);
            Message = "Passed";
        } else {
            System.out.print("verifyMaxSixTraveler failed" + Alert3);
            Message = "Failed";
        }

        return Message;
    }

    public String verifydatapassing() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("80000");
            session().type("trvCity", trvCity);
            session().click("trvHotelIn");
            session().click(trvHotelIn);
            session().click("trvHotelOut");
            session().click(trvHotelOut);
            session().select("numRooms", numRooms);
            session().select("htchild1", htchild1);
            session().select("minorAge1Room1", minorAge1Room1);
            session().select("adult2", adult2);
            session().select("htchild2", htchild2);
            session().select("minorAge1Room2", minorAge1Room2);
            session().click("//div[@id='hotelRow6']//span[2]//button[@id='hotelsLobBtn']");
            //session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar5';s_265.linkTrackEvents='event1';s_265.eVar4='hotellob|travelocity';s_265.eVar5=s_265.pageName;s_265.tl(this,'o','Travel Search');\"]");
            session().waitForPageToLoad("30000");
            pageTitle = session().getTitle();
            //pageTitle = session().getTitle();
            System.out.println(pageTitle);
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
        if (pageTitle.trim().equalsIgnoreCase("We are searching...".trim())) {
            System.out.println("verifydatapassing passed ");
            Message = "Passed";
        } else {
            System.out.println("verifydatapassing failed : " + pageTitle);
            Message = "Failed";
        }

        return Message;

    }

    public String verifyBacktoBasicurl() {
        String Message = null;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("80000");
            session().click("link=Back to basic search");
            session().waitForPageToLoad("120000");
            urlfinal = session().getLocation();
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
        if (urlfinal.equalsIgnoreCase("http://travel.com/hotel")) {
            System.out.println(" verifyBacktoBasicurl passed ");
            Message = "Passed";
        } else {
            System.out.println("verifyBacktoBasicurl failed : ");
            Message = "Failed";
        }

        return Message;
    }
}








