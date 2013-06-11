/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
//import com.thoughtworks.selenium.*;
//import fit.ColumnFixture;
import travelQa.urlPoiDetails;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 * @author soujanyaqa
 */
public class Deals_Canned_links extends ColumnFixture{
    public String url,Fl_cat,Fl_cat1,what_deal;
    public boolean result;
    public String resultString;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4442;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
   // DefaultSelenium selenium;
    
    /*public Deals_Canned_links() {
       selenium = new DefaultSelenium("localhost", 4442, "*chrome", "http://travel.com");
        selenium.start();
   }*/

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

  
  public String check_subcat(){
      try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

      session().click(Fl_cat);
      session().waitForPageToLoad(urlPoiDetails.PageLoad);
      String s = session().getLocation();
      result = s.contains(urlPoiDetails.Fldeals);
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
      if (result){
      return urlPoiDetails.testPassed;
      }
      else{
          return urlPoiDetails.testFailed;
      }

  }
      
  public String check_subcat1(){
    try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
    session().click(Fl_cat1);
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
    String s = session().getLocation();
    result = s.contains(urlPoiDetails.Fl_deals1);
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
    if (result){
        return urlPoiDetails.testPassed;
    }
    else{
        return urlPoiDetails.testFailed;
    }
      }
  
  public String check_Whatshot(){
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
    session().click(what_deal);
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
    String s = session().getLocation();
    result = s.contains(urlPoiDetails.hot_deal1);
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
    if (result){
        return urlPoiDetails.testPassed;
    }
    else{
        return urlPoiDetails.testFailed;
    }
      }
  
  public String check_breadcrumb(){
    try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
    result = session().isElementPresent("//ul[@id='breadCrumbUl']/li[2]/a");
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
    if (result){
        return urlPoiDetails.testPassed;
    }
    else{
        return urlPoiDetails.testFailed;
    }
      }

  public String check_numdeals(){
       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
      session().waitForPageToLoad(urlPoiDetails.PageLoad);
      System.out.println("hello");
      String firstPath = "//a[@id='completeDealDivClickId";
      String secondPath = "']//p[@class='desc']";
       for (int i =1; i <= 10; i++){
         //System.out.println(selenium.getText(firstPath+i+secondPath));
          //System.out.println(selenium.getText("/html/body/div[2]/div[4]/div[2]/div[2]/div["+i+"]/a/div[2]/p"));
          result = session().isElementPresent(firstPath+i+secondPath);
          //System.out.println(result);
       }
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
          if (result){
              return urlPoiDetails.testPassed;
          }
          else{
              return urlPoiDetails.testFailed;
          }
  }
    public String check_searchmodule(){
    try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
    session().type("dest_interest", "london");
    session().click("dealsCannedSearchBTN");
    session().waitForPageToLoad(urlPoiDetails.PageLoad);
    String s = session().getLocation();
    result = s.contains("travel--deals");
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
    if (result){
        return urlPoiDetails.testPassed;
    }
    else{
        return urlPoiDetails.testFailed;
    }
      }
          
         
      
public static void main(String argv[]) {
    //String S=new String();
   // S=this.check_numdeals();
        new Deals_Canned_links().check_numdeals();
}
      }

     
  
    
     

