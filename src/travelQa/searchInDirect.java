package travelQa;

/**
 *
 * @author Shanti
 */
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class searchInDirect extends ColumnFixture {

    public String url,  travelguide_heading,  overview_text,  poi,  rurl,  hotel,  attractions,  article,  s = "";
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
            session().click(travelguide_heading);
            session().waitForPageToLoad("30000");
            s = session().getLocation();                   
            result = s.contains("/travel-guide/Europe/France/Paris");
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

    public String check_overview_text() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            result = session().isTextPresent(overview_text);
            session().close();
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
            session().click(poi);
            session().waitForPageToLoad("30000");
            rurl = session().getLocation();
            session().close();
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
        if (rurl.contains("/travel-guide/Paris-restaurants--France:8")) {
            return "Test Passed";
        } else {
            return "Test Failed";
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
        if (rurl.contains("/travel-guide/Paris--France-Four+Seasons+Hotel+George+V+Paris:8:280216-hotel-detail")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_article() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(article);
            session().waitForPageToLoad("30000");
            rurl = session().getLocation();
            session().close();
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
        if (rurl.contains("articles/paris-france-shops")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
}


