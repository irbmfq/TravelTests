package travelQa;

/**
 *
 * @author shanthid2003
 */

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Globalfooter extends ColumnFixture {

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

    /*public String Check_logolink() {
       try{
           startSession(seleniumHost,seleniumPort,browser,webSite);
           session().setTimeout(TIMEOUT);
           session().open(url);
           System.out.println(1);
           session().waitForPageToLoad("30000");
           //result = session().isElementPresent("//div[@id='GH_footer_brand']//a[@id='GH_footer_brand_link']");
           result = session().isElementPresent("//div[@id='GF_']//ul[@id='GF_other']//li[1]//ul//li[3]//a");

           System.out.println(result);
           session().close();
           session().stop();
       } catch(Exception e){
           e.printStackTrace();
           session().stop();
           try{
               closeSession();
           }catch(Exception en){
               en.printStackTrace();
           }
           }
       if(result = true){
           return "Test Passed";
       }else{
           return "Test Failed";
           }
       }*/
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
     public String Check_Feedbacklink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GH_footer_fb_link']//a");
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
     public String Check_Moreontravellink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GF_']//ul[@id='GF_other']//li[1]//ul//li[6]//a");
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

     public String Check_Downloadtravellink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GF_']//ul[@id='GF_other']//li[1]//ul//li[6]//a");
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
     public String Check_Seolink() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='GF_']//ul[@id='GF_other']//li[1]//ul//li[6]//a");
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
public String Check_Footertext() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad("30000");
            result = session().isElementPresent("//div[@id='footertext'");
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

    public static void main(String argv[]) {

        //new dealsMain().check_dealtype();
        //new Globalfooter().Check_logolink();
        // new Globalfooter().Check_Moreontravellink();
        //new dealsMain().checkPagination();
    }
}

