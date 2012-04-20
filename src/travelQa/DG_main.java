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
public class DG_main extends ColumnFixture{
 public String DGurl,tempurl,url;
 java.lang.String page=null;
 public String city,state,country,continent,continent1,stateabr,city1,breadcrumb;
 public int cityid,hificity;
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

public String getdgurl()
{
   String Message=null;
   String country1,state1;
      
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
    // System.out.println("the continent is :"+continent1);
     if (country.equalsIgnoreCase("United States"))
      {
         country1=country.replace(" ","+");
        // System.out.println("the country name after changeingis "+country1);
         state1=state.replace(" ","+");
        // System.out.println("the state name after changeingis "+state1);
             tempurl="/"+city+"-"+state1+"-"+country1+":"+cityid+":"+city+"-destination-guide";
             DGurl=url+tempurl;
              // System.out.println("DGurl is : "+DGurl);
             Message=DGurl;
                }
      else
      {
            country1=country.replace(" ","+");
            //System.out.println("the country name after changeingis "+country1);
          tempurl="/"+city+"--"+country1+":"+cityid+":"+city+"-destination-guide";
          DGurl=url+tempurl;
           Message=DGurl;
           //System.out.println("DGurl is : "+DGurl);
      }

   return Message;
}

public String verifyheading()
 {
      String Message=null;
       boolean result;
       String heading,expected;
     // String dgurl=getdgurl();
               try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
               session().setTimeout(TIMEOUT);
               session().open(url);
                result=session().isElementPresent("//h1[@class='cityStateCountry']");                
                if(result==true)
                {
                      //if (country.equalsIgnoreCase("United States"))
                    //expected=city+", "+stateabr;
                    expected="CHICAGO, IL";
                   // else
                     //expected=city+", "+country;
                   
                heading=session().getText("//h1[@class='cityStateCountry']");               

                if(expected.equalsIgnoreCase(heading))
                Message="Passed";
                else
                    Message="Failed-heading is not correct";

                }
                else
                {
                    Message="Failed-Heading not present";
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
    //  String dgurl=getdgurl();
                      try {
                      startSession(seleniumHost, seleniumPort, browser, webSite);
                      session().setTimeout(TIMEOUT);
                      session().open(url);
                      result=session().isTextPresent(breadcrumb);
                       if(result==true)
                       {
                        //if (country.equalsIgnoreCase("United States"))
                    //{
                  //  expected="You are here: Travel Guides » "+"United States"+" » "+state+" » "+city;
                      //expected="You are here: Travel Guides » United States » Illinois » Chicago";
                   /// }
                           // else
                           // {
                           // continent1=continent1.replace("-"," ");
                           // continent1=continent1.replace("and","&");
                     //  expected="You are here: Travel Guides » "+continent1+" » "+country+" » "+city;
                        //     }
                           //breadcrumb=session().getText("//div[@id='breadcrumb']/ul");
             
                          // if(expected.equalsIgnoreCase(breadcrumb))
                           Message="Passed";
                          // else
                               //Message="Failed-Breadcrumb is wrong";
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

//Verify Overview text module

public String verifyoverviewmodule()
 {
      String Message=null;
       boolean result,result1;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
      //String dgurl=getdgurl();
                 try {
                 startSession(seleniumHost, seleniumPort, browser, webSite);
                 session().setTimeout(TIMEOUT);
                 session().open(url);
                result=session().isElementPresent("cityText");              
                if(result==true)
                {
                result1=session().isElementPresent("//div[@id='cityText']/a");
                    if(result1=true)
                    {
                    session().click("//div[@id='cityText']/a");
                    session().waitForPageToLoad("30000");
                    pageurl=session().getLocation();
               // if (country.equalsIgnoreCase("United States"))
                    // {
                         //country1=country.replace(" ","+");
                         //city1=city.replace(" ","+");
                   // expectedurl="http://travel.com/travel-guide"+"/"+city1+"-"+state+"-"+country1+":"+cityid+"-overview";
                    expectedurl="travel-guide/Chicago-Illinois-United+States:35-overview";
                    
                    // }
                     //else
                     //{
                        // country1=country.replace(" ","+");
                        // city1=city.replace(" ","+");
                  //  expectedurl="http://travel.com/travel-guide"+"/"+city1+"--"+country1+":"+cityid+"-overview";
                   //  }
                    if(pageurl.contains(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-Overview link is wrong";
                }

                    else
                        Message="Failed-Overview link is not present ";

                }
                else
                    Message="Failed-Overview module is not present.";
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

public String verifyreviewslink()
 {
      String Message=null;
       boolean result,result1;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
      //String dgurl=getdgurl();
              try {
              startSession(seleniumHost, seleniumPort, browser, webSite);
              session().setTimeout(TIMEOUT);
              session().open(url);
              result= session().isElementPresent("//div[@class='viewAllLink']/a");              
                if(result==true)
                {
                    //expectedtext="View All"+" "+city+" "+"Reviews";
                   // expectedtext="View All"+" "+city+" "+"Reviews";
                   // actualtext= session().getText("//div[@class='viewAllLink']/a");
          
                
                     session().click("//div[@class='viewAllLink']/a");
                     session().waitForPageToLoad("30000");
                    pageurl= session().getLocation();                    
                    // if (country.equalsIgnoreCase("United States"))
                   //  {
                         //country1=country.replace(" ","+");
                       //  city1=city.replace(" ","+");
                    //expectedurl="http://travel.com/travel-guide"+"/"+city1+"-"+state+"-"+country1+":"+cityid+"-destination-review-all";
                    expectedurl="travel-guide/Chicago-Illinois-United+States:35-destination-review-all";
                  // }
                    // else
                    // {
                        // country1=country.replace(" ","+");
                        // city1=city.replace(" ","+");
                    //expectedurl="http://travel.com/travel-guide"+"/"+city1+"--"+country1+":"+cityid+"-destination-review-all";
                    // }
                    if(pageurl.contains(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-Reviews link is wrong";
                
               

                }
                else
                    Message="Failed-Reviews link is not present";
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

public String verifyarticleslink()
 {
      String Message=null;
       boolean result,result1;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
      //String dgurl=getdgurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result1= session().isElementPresent("//div[@id='article_module']");
                if (result1=true)
                {
                result= session().isElementPresent("//div[@id='allarticleLink']/a");               
                if(result==true)
                {
                    //expectedtext="View All"+" "+city+" "+"Articles";
                    expectedtext="view all Chicago Articles";
                    actualtext= session().getText("//div[@id='allarticleLink']/a");                 
                if(expectedtext.contains(actualtext))
                {
                     session().click("//div[@id='allarticleLink']/a");
                     session().waitForPageToLoad("30000");
                    pageurl= session().getLocation();                  
                     //if (country.equalsIgnoreCase("United States"))
                    // {
                         //country1=country.replace(" ","+");
                        // city1=city.replace(" ","+");
                   // expectedurl="http://travel.com/travel-guide"+"/"+cityid+":"+city1+"+"+stateabr+"-search-direct#Articles";
                    expectedurl="travel-guide/35:Chicago+IL-search-direct#Articles";
                      //}
                    // else
                    // {
                       //  country1=country.replace(" ","+");
                       //  city1=city.replace(" ","+");
                   // expectedurl="http://travel.com/travel-guide"+"/"+cityid+":"+country1+"-search-direct#Articles";
                     //}
                    if(pageurl.contains(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-Articles link is wrong";
                }
                else
                {
                   Message="Failed-Articles link text is wrong";
                }

                }
                else
                    Message="Failed-Articles link is not present";

                }
                else
                    Message="Passed-There are no articels for the givencity";
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
public String verifeventslink()
 {
      String Message=null;
       boolean result,result1;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
     //  String dgurl=getdgurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result1=session().isElementPresent("//div[@id='eventsModule']");
                if (result1=true)
                {
                result=session().isElementPresent("//div[@class='allEventsLink']/a");
              
                if(result==true)
                {
                   // expectedtext="View All"+" "+city+" "+"Events";
                    expectedtext="View all Chicago Events";
                    actualtext=session().getText("//div[@class='allEventsLink']/a");
                   
                if(expectedtext.equalsIgnoreCase(actualtext))
                {
                    session().click("//div[@class='allEventsLink']/a");
                    session().waitForPageToLoad("30000");
                    pageurl=session().getLocation();
                   
                     //if (country.equalsIgnoreCase("United States"))
                    // {
                         //country1=country.replace(" ","+");
                         //city1=city.replace(" ","+");
                    //expectedurl="/travel-guide"+"/"+city1+"-events-"+state+"-"+country1+":"+cityid;
                         expectedurl="travel-guide/Chicago-events-Illinois-United+States:35";
                   
                    // }
                    // else
                    // {
                         //country1=country.replace(" ","+");
                         //city1=city.replace(" ","+");
                    //expectedurl="http://travel.com/travel-guide"+"/"+city1+"-events--"+country1+":"+cityid;
                   //  }
                    if(pageurl.contains(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-Events link is wrong";
                }
                else
                {
                   Message="Failed-Events link text is wrong";
                }

                }
                else
                    Message="Failed-Events link is not present";

                }
                else
                    Message="Passed-There are no Events for the givencity.No events link is there";
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
public String verifymessageboardlink()
 {
      String Message=null;
       boolean result,result1;
       String pageurl,expectedurl,expectedtext,actualtext,actualtext1,country1;
     // String dgurl=getdgurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result1=session().isElementPresent("//div[@id='messageBoardModule']");
                if (result1=true)
                {
                result=session().isElementPresent("//div[@class='messageBoardDestnLink']/a");           
                if(result==true)
                {
                    //expectedtext="View the Travel message board";
                    //actualtext1=session().getText("//div[@class='messageBoardDestnLink']/a");
                   // actualtext="View the"+" "+actualtext1;
                    session().click("//div[@class='messageBoardDestnLink']/a");
                    session().waitForPageToLoad("30000");
                    pageurl=session().getLocation();
                    
                    expectedurl="http://travel.travel.com/travel-forum";                    
                    if(pageurl.equalsIgnoreCase(expectedurl))
                        Message="Passed";
                    else
                        Message="Failed-Messageboard link is wrong";
                
                

                }
                else
                    Message="Failed-Messageboard link is not present";

                }
                else
                    Message="Failed-Message board module is not present";
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


//Verify the frommers guid module and link

public String verifyfrommerslink()
 {
      String Message=null;
       boolean result,result1;
       String pageurl,expectedurl,expectedtext,actualtext,actualtext1,country1;
      //String dgurl=getdgurl();
                 try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result1=session().isElementPresent("//div[@id='whatExpertsSayModule']");
                if (result1=true)
                {
                result=session().isElementPresent("//div[@class='whatExpertsLink']/a");
                
                if(result==true)
                {
                   // expectedtext="read full Frommer's Guide";
                   // actualtext=session().getText("//div[@class='whatExpertsLink']/a");
                
                
                    session().click("//div[@class='whatExpertsLink']/a");
                    session().waitForPageToLoad("30000");
                    pageurl=session().getLocation();                   
                   if(pageurl.contains("http://travelsvc.travelocity-dest.travel.com/"))
                        Message="Passed";
                    else
                        Message="Failed-Frommers link is wrong";
                
                

                }
                else
                    Message="Failed-Frommers link is not present";

                }
                else
                    Message="Passed-There is no frommers module for the city given";
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
      new DG_main().getdgurl();
      new DG_main().verifyheading();
      new DG_main().verifybreadcrumb();
      new DG_main().verifyoverviewmodule();
      new DG_main().verifyreviewslink();
      new DG_main().verifeventslink();
      new DG_main().verifyarticleslink();
      new DG_main().verifymessageboardlink();
      new DG_main().verifyfrommerslink();




    }







}
