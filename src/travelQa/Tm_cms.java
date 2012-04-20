package travelQa;

/**
 *
 * @author Shanti
 */
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Tm_cms extends ColumnFixture {

    public String url,  Hot_deals;
    public boolean result;
    public String vaadult1,  vasenior1,  vachild1,  vaminorAge1Room1,  var1,  var2;
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

    public String Check_RtRail() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            result = session().isElementPresent("//div[@id='toolsModule']/h3");
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
        System.out.println(result);
        if (result) {
            return "Passed";
        } else {
            return "Failed";
        }

    }

    public String Check_HFDeals() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("70000");
            result = session().isElementPresent("//div[@id='mainDealsResults']/h2");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String Check_ETG() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("90000");
            var1 = session().getText("//div[@id='mostPop2']//a[@class='guideTitle']");
            session().click("nextBtn");
            result = session().isElementPresent("//div[@id='mostPop4']/a[2]");
            var2 = session().getText("//div[@id='mostPop4']//a[@class='guideTitle']");
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
        if (var1.equalsIgnoreCase(var2)) {

            return "Test Failed";
        } else {
            return "Test Passed";
        }

    }
    public String Check_FEditors() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("90000");
            session().click("exploreGuidesBy");
            session().select("exploreGuidesBy", "label=From Our Editors");
            var1 = session().getText("//div[@id='mostPop2']//a[@class='guideTitle']");
            session().click("nextBtn");
            result = session().isElementPresent("//div[@id='mostPop4']/a[2]");
            var2 = session().getText("//div[@id='mostPop4']//a[@class='guideTitle']");
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
        if (var1.equalsIgnoreCase(var2)) {

            return "Test Failed";
        } else {
            return "Test Passed";
        }

    }
}

