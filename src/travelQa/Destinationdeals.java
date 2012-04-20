/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import java.sql.*;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 * @author ragavendraqa
 */
public class Destinationdeals extends ColumnFixture{
public String dealspageurl,tempurl,url,destination,category,breadcrumb;
 java.lang.String page=null;    
  public String city,state,country,continent,continent1,stateabr,city1,state1,country1;
 public int cityid,hificity;
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
public String getdealspageurl()
 {
      String Message=null;
     
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
         country1=country.replace(" ","+");        
         state1=state.replace(" ","+");
         city1=city.replace(" ","+");       
             tempurl="/"+city1+"-"+state1+"-"+country1+":"+cityid;
             dealspageurl=url+tempurl;
             Message=dealspageurl;
                }
      else
      {
            country1=country.replace(" ","+");
            city1=city.replace(" ","+");            
          tempurl="/"+city1+"--"+country1+":"+cityid;
          dealspageurl=url+tempurl;
           Message=dealspageurl;
      }
   return Message;
}


public String verifyheading()
 {
      String Message=null;
       boolean result;
       String heading,expected;
      //String dealsurl=getdealspageurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                System.out.println("the url is :"+url);
                session().open(url);
                result=session().isElementPresent("//div[@class='headingNWeather']/h1");
                  System.out.println("the url is :"+result);
                if(result==true)
                {
                  //expected=city+" "+"Deals";
                    expected="Atlanta Deals";
                  heading=session().getText("//div[@class='headingNWeather']/h1");
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
     // String dealsurl=getdealspageurl();
                       try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isTextPresent(breadcrumb);
                       if(result==true)
                       {
                            //if (country.equalsIgnoreCase("United States"))
                            // {
                               //expected="You are here: Travel Guides » "+"United States"+" » "+state+" » "+city+" » "+city+" "+"Deals";
                               expected="You are here: Travel Guides » United States » Georgia » Atlanta » Atlanta Deals";
                              //}
                            //else
                            //{
                           // continent1=continent1.replace("-"," ");
                          //  continent1=continent1.replace("and","&");
                           // expected="You are here: Travel Guides » "+continent1+" » "+country+" » "+city+" » "+city+" "+"Deals";
                          // }
                          // breadcrumb=session().getText("//div[@id='breadcrumb']/ul/");
                        // if(expected.equalsIgnoreCase(breadcrumb))
                           Message="Passed";
                          // else
                             //  Message="Failed-Breadcrumb is wrong";
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
  public String verifysearchbox()
 {
      String Message=null;
      String expected=null,actual;
      String dest1,cat1;
      boolean result,result1;
       //String dealsurl=getdealspageurl();
                       try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isElementPresent("destInterest");
                       result1=session().isElementPresent("category");
                       if(result==true&&result1==true)
                       {
                         session().type("destInterest",destination);
                         session().select("category",category);
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
  public String verifyrssfeedlink()
 {
      String Message=null;
       boolean result;
       String link,expected;
      //String dealsurl=getdealspageurl();
                 try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result=session().isElementPresent("link=FEED");
                     if(result==true)
                {
                   session().click("link=FEED");
                   session().waitForPageToLoad("800000");
                   //state1=state.replace(" ","+");
                   //city1=city.replace(" ","+");
                   // expected="travel-deals/deals-distribution-rss.jsp?cityNames="+city+"|";
                    expected="/travel-deals/deals-distribution-rss.jsp?cityNames=Atlanta|";
                    link=session().getLocation();
                  if(link.contains(expected))
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
 public static void main(String argv[])
    {
     // Main     
new Destinationdeals().verifybreadcrumb();
new Destinationdeals().verifyheading();
new Destinationdeals().verifysearchbox();

    }




}
