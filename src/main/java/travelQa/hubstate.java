package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;

public class hubstate extends ColumnFixture {

    public String url,result2,test1,test2,test3,result4,result5,test4,test5,result6,test8;
    public boolean result,result1,result3;
    public static final String TIMEOUT = "120000";
    public String webSite ="http://travel.com";
    public String browser = "*chrome";
    public int seleniumPort = 4444;
    public String seleniumHost ="localhost";
   
    
    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
      }
 
    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }
    
    public String Verifyheadings() {
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().waitForPageToLoad("60000");
        result = session().isTextPresent("California Vacations, Hotels and Travel");
        result1 = session().isTextPresent("California Travel Deals");
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
    	 if(result=true)
           return "test is passed";
         else
            return "test is failed";
    }
    

	public String Verifydestination() {
		try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click(test1);
        session().waitForPageToLoad("50000");
        result2= session().getLocation();
        session().stop();
        closeSession();
         }catch (Exception e) {
 			e.printStackTrace();
 			session().stop();
 			try {
 				closeSession();
 			} catch (Exception en) {
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
           
           if(result2.contains("/travel-guide/united-states/District-of-Columbia")){
        	  return "destinations are present";
           }
           
        	   else {
        		   return "destinations are not present";
        	 	}
	}
	
//        public String Verifyhotels(){
//        	
//        	try {
//        		startSession(seleniumHost, seleniumPort, browser, webSite);
//        		session().setTimeout(TIMEOUT);
//        	    session().open(url);
//        	    session().waitForPageToLoad("60000");
//        	    session().click(test2);
//        	    session().waitForPageToLoad("60000");
//        	    result4= session().getLocation();
//        	    session().click(test4);
//        	    session().waitForPageToLoad("60000");
//        	    session().click(test3);
//        	    session().waitForPageToLoad("80000");
//        	    result5 = session().getLocation();
//        	  	session().stop();
//        	    closeSession();
//        	    }catch (Exception e) {
//         			e.printStackTrace();
//         			session().stop();
//         			try {
//         				closeSession();
//         			} catch (Exception en) {
//         				en.printStackTrace();
//
//                    }
//    		try {
//                closeSession();
//
//            } catch (Exception e5) {
//            	e5.printStackTrace();
//               System.out.println(e.getMessage());
//            }
//            System.out.println("Time out error captured");
//        	    }
//        	    if(result4.contains("/travel-guide/Los+Angeles-hotels-California-United+States:44")&& result5.contains("/travel-guide/united-states/California/hotels"))
//        	    	
//        	    {
//        	    	return "hotels are present";
//        	    }
//        	    	else
//        	    	return "hotels are not present";
//        	    }
      public String populardest(){
    	  try {
    		  startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
    		  session().setTimeout(TIMEOUT);
    		  session().open(url);    		
    		  session().waitForPageToLoad("50000");
    		  session().click(test8);    		  
    		  result6= session().getLocation();
    		  closeSession();
  	               }catch (Exception e) {
   			e.printStackTrace();
   			session().stop();
   			try {
   				closeSession();
   			} catch (Exception en) {
   				en.printStackTrace();
   			}
  	    }
    		  if(result6.contains("/travel-guide/United-States/California/Lake-Tahoe")){
    			  return "popular destinations are present";
    		  }
    		  else
    			  return "popular destinations are not present";
    	  }
    	  
      }





