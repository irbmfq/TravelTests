package travelQa;

/**
 *
 * @author Shanti
 */

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class searchCountryDirect extends ColumnFixture {

    public String url,  heading,  travelguide_heading,  overview_text,  poi,  rurl,  hotel,  article, s="";
    public boolean result;
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

    public String check_heading() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            result = session().isTextPresent(heading);
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
            return "check_heading Passed";
        } else {
            return "check_heading Failed";
        }
    }

    public String check_dg_heading() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(travelguide_heading);
            session().waitForPageToLoad("90000");
            s = session().getLocation();      
            result = s.contains("/travel-guide/Europe/Germany/Berlin");
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
            return "test Passed";
        } else {
            return "test Failed";
        }
    }

    public String check_overview_text() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            result = session().isTextPresent(overview_text);
            //session().waitForPageToLoad("90000");
            //s = session().getLocation();
            session().close();
            session().stop();
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
            return "check_overview_text Passed";
        } else {
            return "check_overview_text Failed";
        }

    }

    public String check_poi() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(poi);
            session().waitForPageToLoad("30000");
            rurl = session().getLocation();
            session().close();
            session().stop();
        } catch (Exception e) {
            e.printStackTrace();
            session().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }
        if (rurl.contains("Berlin-restaurants--Germany:9")) {
            return "check_poi Passed";
        } else {
            return "check_poi Failed";
        }

    }

    public String check_hotel() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(hotel);
            session().waitForPageToLoad("30000");
            rurl = session().getLocation();
            session().close();
            session().stop();
        } catch (Exception e) {
            e.printStackTrace();
            session().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }
        if (rurl.contains("Berlin-hotels--Germany:9")) {
            return "check_hotel Passed";
        } else {
            return "check_hotel Failed";
        }
    }
}

    


    
