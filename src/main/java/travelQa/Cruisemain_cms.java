package travelQa;

/**
 *
 * @author Shanti
 */
import com.thoughtworks.selenium.Wait;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Cruisemain_cms extends ColumnFixture {

    public String url,  traveltoolsheading,  dealsheading,  Headline,  titletraveltools, popularcruiseHeading,  dealstitle,  title;
   public boolean result=false;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4441;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String check_PopularCruiseHeading() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("90000");
            
            result = session().isTextPresent(popularcruiseHeading);
            
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
            return "check_PopularCruiseHeading Passed";
        } else {
            return "check_PopularCruiseHeading Failed";

        }

    }

   public String check_CruisemainTraveltools() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("50000");
            titletraveltools = session().getText("//div[@id='toolsModule']/h3");
            //session().type("titletraveltools", titletraveltools);

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
        if (titletraveltools.equals(traveltoolsheading)) {
            return "check_CruisemainTraveltools Passed";
        } else {
            return "check_CruisemainTraveltools Failed";

        }

    }

   public String check_DealsHeading() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            dealstitle = session().getText("//div[@id='mainContent']/h2");
            session().waitForPageToLoad("50000");
            session().type("dealstitle", dealsheading);
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
        if (dealstitle.equals(dealsheading)) {
            return "check_DealsHeading Passed";
        } else {
            return "check_DealsHeading Failed";

        }

    }


}

