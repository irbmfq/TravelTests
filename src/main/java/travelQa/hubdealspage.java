package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;


public class hubdealspage extends ColumnFixture{
    public String url,alphabet,cityname;    
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
    
    public String verifyAlphabar()
    {
       String alpha=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("link=" +alphabet);
		session().waitForPageToLoad("50000");
        alpha=session().getLocation();
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
        return alpha;
    }
    public String verifydealsurl()
    {
        String citydealsurl=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("link="+cityname);
        session().waitForPageToLoad("50000");
        citydealsurl=session().getLocation();
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
         return citydealsurl;        
    }
    public String verifynextlink()
    {
        String nexturl=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("link=next >>");
	    session().waitForPageToLoad("50000");
        nexturl=session().getLocation();
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
        return nexturl;
    }
    
    public String verifyprevlink()
    {
        String prevurl=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().click("link=previous");
	    session().waitForPageToLoad("50000");
        prevurl=session().getLocation();
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
        return prevurl;
    }
    public String verifytopdestinations()
    {
        String desturl=null;
        try {
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        session().waitForPageToLoad("30000");
        session().click("//div[@id='hotelList']/ul[2]/li[9]/a");
        session().waitForPageToLoad("90000");
	    desturl=session().getLocation();
      result = desturl.contains("/travel-deals/garbatella--italy:80292677");
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
        if (result) {
            return "Test Passed";
           } else {
            return "Test Failed";
        }
                
    }

    public static void main(String argv[])
    {
   
        new hubdealspage().verifytopdestinations();
      }
}

