
package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;


public class travelLobCruise extends ColumnFixture {
    public String url,destination,cruiseLength,fromMonthYear,fromDay,cruiseVendor1,deptPort;
   
    public boolean VerifyCruiseLob(){
    boolean flag=true;
        DefaultSelenium selenium = new DefaultSelenium("localhost" , 4441, "*chrome", "http://travel.com");
          selenium.start();
                selenium.open("/cruises");
                 selenium.waitForPageToLoad("50000");
		selenium.select("destination", destination);
		selenium.select("cruiseLength", cruiseLength);
		selenium.select("fromMonthYear", fromMonthYear);
		selenium.select("fromDay", fromDay);
		selenium.select("cruiseVendor1", cruiseVendor1);
		selenium.select("deptPort",deptPort );
		selenium.click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4,eVar5';s_265.linkTrackEvents='event1';s_265.eVar4='cruiselob|travelocity';s_265.eVar5=s_265.pageName;s_265.tl(this,'o','Travel Search');\"]");
                selenium.waitForPageToLoad("50000");
                String pagetitle=selenium.getTitle();
                if(pagetitle.equalsIgnoreCase("Hawaii Cruises and Cruise Deals at travel Travel")){
                    System.out.println("VerifyCruiseLob is passed \n"+pagetitle);
                          flag=true;             
                }else{
                     System.out.println("VerifyCruiseLob is failed \n"+pagetitle);
                            flag=false;
                }
                  selenium.stop();  
                 return flag;  
    }
      
      public boolean verifyBacktoBasicurl(){
          boolean flag=true;
          DefaultSelenium selenium = new DefaultSelenium("localhost", 4441, "*chrome", "http://travel.com");
          selenium.start();
          selenium.open("/cruises");
           selenium.waitForPageToLoad("50000");
            selenium.click("link=Back to basic search");
                selenium.waitForPageToLoad("50000");
             String urlfinal = selenium.getLocation();
               if(urlfinal.equalsIgnoreCase("http://travel.com/cruise")){
           System.out.println("verifyBacktoBasicurl passed " );
		flag=true;
		}else{
		System.out.println("verifyBacktoBasicurl failed : ");
		flag=false;
		}
		selenium.stop();
		return flag; 
        }
      
      
        
  public static void main(String args[])  {
      new travelLobCruise().VerifyCruiseLob();
  }
    
    

}
