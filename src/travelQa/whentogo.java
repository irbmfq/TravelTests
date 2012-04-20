package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

public class whentogo extends ColumnFixture {

    public String url,city,state,country,city1,state1,country1,continent,continent1,stateabr;
    public String tempurl,whentogourl,destination,category,dealstext,breadcrumb;
    public int cityid;
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
    public String getwhentogourl(){
        String Message;       
       if(continent.equalsIgnoreCase("EUR"))
              continent1="Europe";
       if(continent.equalsIgnoreCase("US"))
              continent1="United States";
          if(continent.equalsIgnoreCase("CEN_SOU_AM"))
              continent1="Central-and-South-America";
          if(continent.equalsIgnoreCase("MIDEA"))
              continent1="Middle-East";
          if(continent.equalsIgnoreCase("OCEANIA"))
              continent1="Australia-and-South-Pacific";
          if(continent.equalsIgnoreCase("ASIA"))
              continent1="Asia";
          if(continent.equalsIgnoreCase("AF"))
              continent1="Africa";
          if(continent.equalsIgnoreCase("MEX_CARIB"))
              continent1="Mexico-and-Caribbean";     
     if (country.equalsIgnoreCase("United States"))
      {
         country1=country.replace(" ","+");
         city1=city.replace(" ","+");      
         state1=state.replace(" ","+");        
             tempurl="/"+city1+"-"+"when-to-go-"+state1+"-"+country1+":"+cityid;
             whentogourl=url+tempurl;           
             Message=whentogourl;
                }
      else
      {
            country1=country.replace(" ","+");
            city1=city.replace(" ","+");            
          tempurl="/"+city1+"when-to-go"+"--"+country1+":"+cityid;
          whentogourl=url+tempurl;
           Message=whentogourl;         
      }       
        return Message;
    }

    public String verifyheading() {
    	String Message=null;
        boolean result;
       // String whentogourl=getwhentogourl();
        String heading=null,actualheading=null;
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result=session().isElementPresent("//div[@id='mainContent']/h1");        
        if(result==true)
        {
        //if (country.equalsIgnoreCase("United States"))
        
        //heading=city+", "+stateabr+": When to Go and Weather";
          heading="Los Angeles, CA: When to Go and Weather";
        //else
        
        //heading=city+", "+country+": When to Go and Weather";
        
        actualheading=session().getText("//div[@id='mainContent']/h1");          
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
        if (actualheading.equals(heading))
        {
           Message="Passed";
        } else {
            Message="Failed";
        }
       return Message;
    }
    public String verifydealsmodule() {
    	String Message=null;
        boolean result;
       // String whentogourl=getwhentogourl();
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result=session().isTextPresent(dealstext);
        if(result==true)
         Message="Passed";
        else
            Message="Failed-Deals module is not there";
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
public String verifybreadcrumb() {
    	String Message=null;
        boolean result;
      //  String whentogourl=getwhentogourl();
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result=session().isTextPresent(breadcrumb);
        if(result==true)
         Message="Passed";
        else
            Message="Failed-Deals module is not there";
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
   public String verifyweathermodule() {
    	String Message=null;
        boolean result;
       // String whentogourl=getwhentogourl();
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result=session().isElementPresent("//div[@id='graphModuleDiv']/h2");       
        if(result==true)
         Message="Passed";
        else
            Message="Failed-Deals module is not there";
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
    public String verifysevendayforecastmodule() {
    	String Message=null;
        boolean result;
      //  String whentogourl=getwhentogourl();
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result=session().isElementPresent("//div[@id='sevenDayForecastDiv']/h2");
        if(result==true)
         Message="Passed";
        else
            Message="Failed-Deals module is not there";
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
public String verifysearhbox() {
    	String Message=null;
        boolean result,result1;
        String expected=null,actual;
        String dest1,cat1;
       // String whentogourl=getwhentogourl();
        try{
    	startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
        result=session().isElementPresent("dest_interest");        
       result1=session().isElementPresent("categorydropdown");      
                       if(result==true&&result1==true)
                       {
                         session().type("dest_interest",destination);
                         session().select("categorydropdown",category);
                         session().click("//button[@type='submit' and @onclick='omnitureFnc();']");
                         session().waitForPageToLoad("300000");
                         actual=session().getLocation();
                         dest1=destination.replace(" ","+");
                         cat1=category.replace("label=","");
                         cat1=cat1.replace(" ","--");
                         cat1=cat1.replace("Deals","deals");
                         expected="/travel-deals/"+dest1+"-"+cat1;
                       if(actual.contains(expected))
                           Message="Passed";
                           else
                               Message="Failed-Search functionality is not working";
                       }
                       else
                           Message="Failed-Search box is not present";
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
}
