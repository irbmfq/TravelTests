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

public class Topicpages extends ColumnFixture {
    public String url,breadcrumb,heading,toptravelstories,addthis,topics,rssfeed;
    public String newsletter,UStravelguide,facebook,twitter,tagcloud,toptravelstory_nextpage;
     public String hottraveldeals,toptravelstories1,toptravelstorylink,next,previous;
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

    public String check_url() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//div[@id='tagCloud']/a[4]");
           session().waitForPageToLoad("50000");
           String s = session().getLocation();

        result = s.contains("/travel-ideas/arts-culture");
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
public String check_heading(){

       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
session().waitForPageToLoad("50000");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
public String check_breadcrumb() {
         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
        result = session().isTextPresent(breadcrumb);
        //result = session().getText("breadcrumb").equalsIgnoreCase(breadcrumb);
        //System.out.println(result);
       // System.out.println(session().getText("breadcrumb"));

        //session().waitForPageToLoad("50000");
         session().stop();
         closeSession();
        } catch (Exception e) {
          e.printStackTrace();
          session().stop();
        }
         if (result) {
            System.out.println("Test Passed"+result);
            return "Test Passed";
        } else {
            System.out.println("Test Failed"+result);
            return "Test Failed";
        }

    }

 public String check_toptravelstorylink(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
//session().waitForPageToLoad("50000");
       session().click("link=Thomas Alva Edison");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("/travel-ideas/galleries/thomos");

        session().stop();
        closeSession();
    }catch (Exception e){
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
 public String check_topics(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
//session().waitForPageToLoad("50000");
       session().click("//ul[@id='rightList']/li[3]/a");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("/travel-ideas/holidays");
        session().waitForPageToLoad("50000");
        session().stop();
        closeSession();
    }catch (Exception e){
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
     public String check_tagcloud(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
//session().waitForPageToLoad("50000");
      session().click("link=Golf");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("travel-ideas/golf");

        session().stop();
        closeSession();
    }catch (Exception e){
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
      public String check_UStravelguide() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().waitForPageToLoad("50000");
         result = session().isTextPresent(UStravelguide);
        session().waitForPageToLoad("50000");
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
public String check_toptravelstory_nextpage(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
//session().waitForPageToLoad("50000");
        session().click("link=NEXT");
        session().waitForPageToLoad("50000");
       session().click("link=Bali");;
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("/travel-ideas/articles/bali");

        session().stop();
        closeSession();
    }catch (Exception e){
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
 public String check_rssfeed(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
//session().waitForPageToLoad("50000");
      session().click("link=FEED");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("travel-ideas/rss");

        session().stop();
        closeSession();
    }catch (Exception e){
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
   public String check_newsletter(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
session().waitForPageToLoad("50000");
         result= session().isTextPresent(newsletter);
session().waitForPageToLoad("50000");
         //System.out.println(result);
        // System.out.println(session().getText("newsletter"));

        session().stop();
        closeSession();
    }catch (Exception e){
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
