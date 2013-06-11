package travelQa;

/**
 *
 * @author Shanti
 */
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Hotelmain_cms extends ColumnFixture {

    public String url,  traveltoolsheading,  dealsheading,Headline,  popularflightsHeading,  titletraveltools,  dealstitle,  title;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4441;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

    protected void startSession(String selenuimHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String check_HotelmainTraveltools() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            titletraveltools = session().getText("//div[@id='toolsModule']/h3");
            session().waitForPageToLoad("5000");
            session().type("titletraveltools", titletraveltools);
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
            return "check_HotelmainTraveltools Passed";
        } else {
            return "check_HotelmainTraveltools Failed";
        }
    }

    public String check_DealsHeading() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            dealstitle = session().getText("//div[@id='mainContent']/h2");
            session().waitForPageToLoad("5000");
            session().type("dealstitle", dealstitle);
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

    public String check_Headline() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);

            title = session().getText("//div[@id='seoInnerLeft']/div/div/h3");
            session().waitForPageToLoad("5000");
            session().type("title", title);
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


        if (title.equals(Headline)) {
            return "check_Headline Passed";
        } else {
            return "check_Headline Failed";

        }

    }
}


