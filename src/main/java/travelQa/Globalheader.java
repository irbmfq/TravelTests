package travelQa;

/**
 *
 * @author shanthid2003
 */

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Globalheader extends ColumnFixture {

    public String url,rurl ;
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

    public String Check_travellink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            System.out.println(1);
           // System.println(1);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_hat']//ul[@id='GH_hat_links']//li[1]//a[@id='GH_hat_A_first']");
            //System.out.println(result);
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
    public String Check_Maillink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            //System.out.println(1);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_hat']//ul[@id='GH_hat_links']//li[2]/a");
           // System.out.println(result);
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
       }
        public String Check_Tripvinelink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_hat']//ul[@id='GH_hat_links']//li[3]//ul[@id='GH_hat_more']//li[2]//a");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }      
        
         public String Check_Morelink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_hat']//ul[@id='GH_hat_links']//li[3]//ul[@id='GH_hat_more']//li[4]//a[@id='GH_hat_more_link']");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

   public String Check_Signinlink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_hat']//ul[@id='GH_hat_tools']//li//a");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

   public String Check_Mainlink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
           session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_']//ul[@id='GH_nav']//li[@id='GH_nav_act']//a");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

   public String Check_BookTravellink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_']//ul[@id='GH_nav']//li[2]//a//span");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
    public String Check_Dealslink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_']//ul[@id='GH_nav']//li[3]//a//span");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
    public String Check_Ideasinterestslink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_']//ul[@id='GH_nav']//li[4]//a");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

     public String Check_Travelguideslink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_']//ul[@id='GH_nav']//li[5]//a//span");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
     public String Check_Feedbacklink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_']//ul[@id='GH_nav']//li[@id='GH_fb_link']//a");
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
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

     public String Check_Searchbuttonlink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
           session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_search']//form[@id='GH_search_form']//input[@id='GH_search_button']");
            session().type("GH_search_field", "paris");
            session().click("GH_search_button");
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
        if (result = true && rurl.contains("/travel-guide/search-indirect?query=paris")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
/*public static void main(String argv[]) {

        //new dealsMain().check_dealtype();
        new Globalheader().Check_travellink();
        //new dealsMain().checkPagination();
    }*/

}
