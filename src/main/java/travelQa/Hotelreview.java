package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Hotelreview extends ColumnFixture {

    public String reviewurl,tempurl,url;
    public String title,desc,user,password,expected,message;
    public boolean result,result1,submitreview;
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

    public String breadcrumb() {
    	try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result = session().isElementPresent("//div[@id='breadcrumb']");
         session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }


    }


    public String check_heading() {

        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result = session().isElementPresent("//div[@id='pageHeadlineCont']/h1");
        session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
        }
        if (result = true) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

        }


    public String writeareview()
    {
       try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);    	
        session().open(url);
       session().click("//div[@id='writereviewtop']/div[@id='writehotelreview']/a");
        session().waitForPageToLoad("600000");
        session().type("lgnId1", user);
        session().type("pwdId1", password);
        session().click("ssbmttravel");
        session().waitForPageToLoad("300000");
        //System.out.println("write a review page is reached");
        session().click("oar_star_4");
        session().type("reviewTitleFld", title);
        session().type("reviewDescFld", desc);
        session().click("submitBtn");
        session().waitForPageToLoad("300000");
        //System.out.println("thank you page is reached");
        session().click("cancelBtn");
        session().waitForPageToLoad("300000");
        //System.out.println("Back to review listing page is reached");
         result1 = session().isElementPresent("/html/body/div/div[3]/div[3]/div/div[3]/div/div/div/div/div[3]/a");
         System.out.println("result1="+ result1);

         if (result1=true){
        submitreview=session().isTextPresent("1.Testing the hotel review page by automation");
                      }
        session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
        }
         if (submitreview)

           return "Test Passed";
         
         else
             return "Test Failed review is not submitting";
             
           }

   
}



