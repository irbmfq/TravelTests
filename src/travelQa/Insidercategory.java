/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;


/**
 *
 * @author soujanyaqa
 */
public class Insidercategory extends ColumnFixture {
    public String url,s;
    public boolean result, result1;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://theinsider.tripvine.com";


    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String check_AuthorTitle() {
       try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().click("pt19291238");
	session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains(urlPoiDetails.AuthorDetail);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";
        }
    }

    public String check_FeatBlog() {
       try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().selectFrame("myFrame");
	session().click("link=Laurie Borman");
	session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains(urlPoiDetails.AuthorLink);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";
        }
    }

    public String check_TagCloud() {
       try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().click("//div[@id='jscloud']/span[3]/a");
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains(urlPoiDetails.Category);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";
        }
    }

    public String check_MoreTravel() {
       try{
    startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().click("link=Chicago Travel Guide");
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains(urlPoiDetails.CityGuide);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";

        }
    }

/*public String check_Ncid() {
       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        //session().waitForPageToLoad("30000");
        session().getHtmlSource();
      //  session().getHtmlSource();
         //session().waitForPageToLoad("30000");
       // result=session().isElementPresent("travelCOMMtravshardest0015");
        //System.out.println(result);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";
        }
    }*/

public String check_RssFeed() {
       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().click("//img[@alt='RSS']");
        session().waitForPageToLoad("30000");
        String s = session().getLocation();
        result = s.contains(urlPoiDetails.rss);
        System.out.println(result);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().click("//div[@id='pageContent']/div/div[1]/p/a");
        session().waitForPageToLoad("30000");
        session().click("//img[@alt='RSS']");
        session().waitForPageToLoad("30000");
        String s1 = session().getLocation();
        result1 = s1.contains(urlPoiDetails.rss);
        System.out.println(result1);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result==true && result1==true){
            // if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";
        }
    }

public String check_Ncid() {
       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open("http://theinsider.tripvine.com/category/chicago-arts-culture/");
        session().waitForPageToLoad("30000");
       String s = session().getHtmlSource();
      //  session().getHtmlSource();
         session().waitForPageToLoad("30000");
       result = s.contains("travelCOMMtravshardest0015");
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            System.out.println("Test Passed");
            return "Test Passed";
             } else {
           System.out.println("Test Failed");
            return "Test Failed";
        }
    }

    public static void main(String argv[]) {

        //new Insidercity().check_CityPage();
       new Insidercategory().check_RssFeed();
       new Insidercategory().check_AuthorTitle();
        //new Insidercity().check_AddThis();
      new Insidercategory().check_FeatBlog();
      new Insidercategory().check_TagCloud();
      new Insidercategory().check_MoreTravel();
       //new Insidercity().check_Ncid();
    }
}
