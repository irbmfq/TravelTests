/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 * @author Ragavendraqa
 */
public class Internationaldeals extends ColumnFixture {
    public String url,tempurl,destination,category,title,travelzootext,breadcrumb;
 java.lang.String page=null;
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

 public String verifybreadcrumb()
 {
      String Message=null;     
      boolean result;
                      try {
                      startSession(seleniumHost, seleniumPort, browser, webSite);
                      session().setTimeout(TIMEOUT);
                      session().open(url);
                       result=session().isTextPresent(breadcrumb);
                          if(result==true)                                              
                             Message="Passed";                       
                       else
                           Message="Failed-breadcrumb is not present";
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
                 
         return Message;
 }
 public String verifysearchbox()
 {
      String Message = null;
        String expected = null, actual;
        String dest1, cat1;
        boolean result, result1;
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        } catch (Exception e) {
            session().waitForPageToLoad("300000");
        }
        result = session().isElementPresent("destInterest");
        result1 = session().isElementPresent("category");
        if (result == true && result1 == true) {
            session().type("destInterest", destination);
            session().select("category", category);
            session().click("//button[@type='submit' and @onclick='omnitureFnc();']");
            session().waitForPageToLoad("300000");
             cat1=category.replace("label=","");
            expected=destination+" "+cat1;
         actual=session().getText("//div[@id='mainContent']/h1");
            if (actual.equalsIgnoreCase(expected)) {
                Message = "Passed";
            } else {
                Message = "Failed-Search functionality is not working";
            }
        } else {
            Message = "Failed-Search box is not present";
        }
        session().close();
        session().stop();
        return Message;
 }
 public String verifytwittermodule()
 {
      String Message=null;
      boolean result;
                       try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isElementPresent("twitterModule");                       
                          if(result==true)
                       {
                           Message="Passed";
                       }
                       else
                           Message="Failed-twitter module is not present";
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
                     
         return Message;
 }
 public String verifytoppickmodule()
 {
      String Message=null;
      String toptext=null;
      String expected=null;
      boolean result;
                      try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isElementPresent("link=Top Pick! Summer European Air Deals");
                          if(result==true)
                       {
                          expected=title;
                          toptext=session().getText("link=Top Pick! Summer European Air Deals");
                          if(toptext.contains(expected))
                            Message="Passed";
                          else
                               Message="Failed-Toppicktext is not matching";
                       }
                       else
                           Message="Failed-toppick module is not present";
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
                      
         return Message;
 }
public String verifytravelzoomodule()
 {
      String Message=null;
      String actual=null;
      boolean result;
                       try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isElementPresent("//div[@id='travelZooLeft']/h2/em/b");
                          if(result==true)
                       {
                         actual=session().getText("//div[@id='travelZooLeft']/h2/em/b");
                         if (actual.equalsIgnoreCase(travelzootext))
                           Message="Passed";
                         else
                             Message="Failed-travelzoo module heading is wrong";
                       }
                       else
                           Message="Failed-travelzoo module is not present";
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
         return Message;
 }
public static void main(String argv[])
    {
        // Main
      new Internationaldeals().verifybreadcrumb();
      new Internationaldeals().verifysearchbox();
      new Internationaldeals().verifytoppickmodule();
      new Internationaldeals().verifytravelzoomodule();
      new Internationaldeals().verifytwittermodule();
    }

}
