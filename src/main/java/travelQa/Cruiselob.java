package travelQa;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class Cruiselob extends ColumnFixture {

    public String url,destination,cruiseLength,fromMonthYear,fromDay,cruiseVendor1,deptPort,pagetitle,urlfinal;
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



    public String Verifysearch(){
     String Message=null;

      try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
		session().waitForPageToLoad("50000");
		session().select("destination", destination);
		session().select("cruiseLength", cruiseLength);
		session().select("fromMonthYear", fromMonthYear);
		session().select("fromDay", fromDay);
		session().select("cruiseVendor1", cruiseVendor1);
		session().select("deptPort",deptPort );
		session().click("cruisesLobBtn");
        session().waitForPageToLoad("50000");
        pagetitle=session().getTitle();
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
         if(pagetitle.contains(destination))
                {
                    System.out.println("VerifyCruiseLob is passed \n"+pagetitle);
                          Message="Passed";
                }else
                {
                     System.out.println("VerifyCruiseLob is failed \n"+pagetitle);
                            Message="Failed";
                }

                 return Message;
    }



   public String verifyBacktoBasicurl(){
     String Message=null;

      try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
		session().waitForPageToLoad("50000");
        session().click("link=Back to basic search");
        session().waitForPageToLoad("50000");
        urlfinal = session().getLocation();
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
        if(urlfinal.equalsIgnoreCase("http://travel.com/cruise"))
               {
           System.out.println("verifyBacktoBasicurl passed " );
		    Message="Passed";
		        }
               else
               {
		      System.out.println("verifyBacktoBasicurl failed : ");
		       Message="Failed";
		         }
		       return Message;
        }
}


