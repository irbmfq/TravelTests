package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;


public class Tripscene extends ColumnFixture {

    public String url,text,result2,result3,text1,text2,result6,result7,result4,result5;
    public boolean result,result1,result8,result9;
    public static final String TIMEOUT = "12000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        //session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String promo_module() {
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().waitForPageToLoad("60000");
        result= session().isElementPresent("//div[@id='pageContainer']/div[3]/div/div");
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
    		try {
                closeSession();
            
            } catch (Exception e4) {
            	e4.printStackTrace();
               System.out.println(e.getMessage());
            }
            System.out.println("Time out error captured");
    	}
         if(result=true)
           return "promo module is present";
         else
            return "promo module is not present";
    }


  public String upload_videos(){
	  try{
		  startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
		  session().setTimeout(TIMEOUT);
		  try{
			  session().open(url);
			  session().waitForPageToLoad("70000");
			   }catch(Exception e1){
				   e1.printStackTrace();
				   System.out.println("this is first exception");
				try{
					  session().waitForPageToLoad("50000");
				}catch(Exception e2){
					e2.printStackTrace();
					System.out.println("this is second exception");
					
					}
				}	
		  result1=session().isElementPresent("//div[@id='pageContent']/div[1]/div[2]");
		  if(result1=true){
			 session().click("//span[@id='container1']/span[2]");
			 System.out.println("//span[@id='container1']/span[2]");
		  }
		   
		  result2 = session().getText("//*[@id='vhdr']");
		   System.out.println(result2);
		  
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
	          if(result2.equals(text))
	        	  return "featured videos is present";
	          else
	        	  return "featured videos is not present";
}
  public String check_rating(){
	       try{
     startSession(seleniumHost, seleniumPort, browser, webSite);
      session().setTimeout(TIMEOUT);
      session().open(url);
      session().waitForPageToLoad("30000");
      result3 = session().getText("ratingUpVal");
	  session().click("thumbsUp");
	  session().open(url);
      session().waitForPageToLoad("80000");
	  result4 = session().getText("ratingUpVal");
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
        if (result3!=result4)
            return "rating tab is working";
          else
             return "rating tab is not present";
     }
  
 }








