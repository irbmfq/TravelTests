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

public class Ideasandinterests extends ColumnFixture {

    public String url,ideasurl,heading,toptravelstories,addthis,topics;
    public String newsletter,UStravelguide,facebook,twitter,tagcloud;
    public String hottraveldeals,toptravelstories1,storyarticlelink;
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

    public String check_toptravelstories(){

  try {
           startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
session().waitForPageToLoad("50000");
         result = session().isTextPresent(toptravelstories);

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

    public String check_toptravelstories1(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
session().waitForPageToLoad("50000");
        result= session().isTextPresent(toptravelstories1);

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

    public String check_storyarticlelink(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
//session().waitForPageToLoad("50000");
       session().click("//div[@id='archiveModule']/div[8]/div/div[3]/div[1]/a");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("/travel-ideas/articles/categoryarticle");

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
       session().click("//ul[@id='leftList']/li[5]/a");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("/travel-ideas/beach");
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

      public String check_newsletter(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
session().waitForPageToLoad("50000");
         result= session().isTextPresent(newsletter);
         
         System.out.println(result);
         System.out.println(session().getText("newsletter"));

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
      session().click("//ul[@id='leftList']/li[5]/a");
       session().waitForPageToLoad("50000");
       String s = session().getLocation();
       result = s.contains("travel-ideas/beach");

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

      public String check_facebook(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
session().waitForPageToLoad("50000");
        result= session().isTextPresent(facebook);

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

      public String check_twitter(){
    try{
        startSession(seleniumHost,seleniumPort,browser,webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
session().waitForPageToLoad("50000");
        result= session().isTextPresent(twitter);
        session().waitForPageToLoad("50000");
        System.out.println(result);
        System.out.println(session().getText(twitter));

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


