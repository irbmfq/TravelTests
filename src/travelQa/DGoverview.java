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
 * @author ragavendraqa
 */
public class DGoverview extends ColumnFixture{
    public String overviewurl,tempurl,url,breadcrumb;
 java.lang.String page=null;
 public String city,state,country,continent,continent1,stateabr,cityid,city1;
 public int hificity;
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
public String getoverviewurl()
{
   String Message=null;
   String country1,state1;
     // System.out.println("the city name is "+city);
      //System.out.println("the state name is "+state);
      //System.out.println("the country name is "+country);

      //System.out.println("the city id is "+cityid);
      //System.out.println("the continent is "+continent);
      //System.out.println("hificity value : "+hificity);
      if(continent.equalsIgnoreCase("EUR"))
              continent1="Europe";
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
         city1=city.replace(" ","+");
         country1=country.replace(" ","+");
        // System.out.println("the country name after changeingis "+country1);
         state1=state.replace(" ","+");
        // System.out.println("the state name after changeingis "+state1);
             tempurl="/"+city1+"-"+state1+"-"+country1+":"+cityid+"-overview";
             overviewurl=url+tempurl;
             Message=overviewurl;
                }
      else
      {
          city1=city.replace(" ","+");
          country1=country.replace(" ","+");
           // System.out.println("the country name after changeingis "+country1);
          tempurl="/"+city1+"--"+country1+":"+cityid+"-overview";
          overviewurl=url+tempurl;
           Message=overviewurl;
      }

   return Message;
}

public String verifyheading()
 {
      String Message=null;
       boolean result;
       String heading,expected;
      //String overviewrl=getoverviewurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result=session().isElementPresent("//div[@id='cityInfo']/h1");
                if(result==true)
                {
                      //if (country.equalsIgnoreCase("United States"))
                   // {
                    //expected=city+", "+stateabr;
                    expected="Atlanta, GA";
                      // }
                  //  else
                    //{
                    // expected=city+", "+country;
                    // }
                heading=session().getText("//div[@id='cityInfo']/h1");
                if(expected.equalsIgnoreCase(heading))
                Message="Passed";
                else
                    Message="Failed";
                }
                else
                {
                    Message="Failed-Heading is not present";

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
         return Message;
 }

public String verifybreadcrumb()
 {
      String Message=null;
      //String breadcrumb=null;
      String expected=null;
      boolean result;
     // String overviewurl=getoverviewurl();
                        try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isTextPresent(breadcrumb);
                       if(result==true)
                       {
                           // if (country.equalsIgnoreCase("United States"))
                           // {
                    //expected="You are here: Travel Guides » "+"United States"+" » "+state+" » "+city+" » "+city+" "+"Overview";
                     //expected="You are here: Travel Guides » United States » Georgia » Atlanta » Atlanta Overview";
                             //}
                            //else
                           // {
                           // continent1=continent1.replace("-"," ");
                           // continent1=continent1.replace("and","&");
                           // expected="You are here: Travel Guides » "+continent1+" » "+country+" » "+city+" » "+city+" "+"Overview";
                            // }
                           //breadcrumb=session().getText("//div[@id='breadcrumb']/ul");
                          
                           //if(expected.equalsIgnoreCase(breadcrumb))
                           Message="Passed";
                          // else
                              // Message="Failed-Breadcrumb is wrong";
                       }
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

public String verifydealslink()
 {
      String Message=null;
       boolean result;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
      //String overviewrl=getoverviewurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result=session().isElementPresent("//li[@class='lastDealsLI']/a");               
                if(result==true)
                {
                             
                    session().click("//li[@class='lastDealsLI']/a");
                    session().waitForPageToLoad("30000");
                    pageurl=session().getLocation();
                     //if (country.equalsIgnoreCase("United States"))
                     //{
                         //country1=country.replace(" ","+");
                    //expectedurl="http://travel.com/travel-deals/"+city+"-"+state+"-"+country1+":"+cityid;
                    expectedurl="/travel-deals/Atlanta-Georgia-United+States:58";
                    // }
                    // else
                     //{
                        // country1=country.replace(" ","+");
                   // expectedurl="http://travel.com/travel-deals/"+city+"--"+country1+":"+cityid;
                    // }
                    if(pageurl.contains(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-Deals link is wrong";
                
                

                }
                else
                    Message="Failed-City deals link is not present";
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
public String verifyhotelslink()
 {
      String Message=null;
       boolean result;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
     // String overviewrl=getoverviewurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result=session().isElementPresent("//div[@class='viewAllTop11HotelsLink']");
                if(result==true)
                {
                   session().click("//div[@class='viewAllTop11HotelsLink']/a");
                    session().waitForPageToLoad("30000");
                    pageurl=session().getLocation();
                    // if (country.equalsIgnoreCase("United States"))
                         // {
                        // country1=country.replace(" ","+");
                         // expectedurl="http://travel.com/travel-guide/"+city+"-hotels-"+state+"-"+country1+":"+cityid;
                          expectedurl="/travel-guide/Atlanta-hotels-Georgia-United+States:58";
                          // }
                    // else
                     //{
                        // country1=country.replace(" ","+");
                    //expectedurl="http://travel.com/travel-guide/"+city+"-hotels--"+country1+":"+cityid;
                     //}
                    if(pageurl.contains(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-top11Hotels link is wrong";         

                }
                else
                    Message="Failed-Top11hotels link is not present";
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
      new DGoverview().verifyheading();
      new DGoverview().verifybreadcrumb();
      new DGoverview().verifydealslink();
      new DGoverview().verifyhotelslink();

    }




}
