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
//import dbtravel.*;

/**
 *
 * @author ragavendraqa
 */
public class Hub_country extends ColumnFixture {
public String city,state_name,country_name,breadcrumb;
 public String hubcountryurl,tempurl,url;
 java.lang.String page=null;    
 public String cityid,state,country,continent;
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
    
 
 
 
 public String gethubcountryurl()
 {
      String Message=null;
     
     if (country.equalsIgnoreCase("United States")||country.equalsIgnoreCase("Canada"))
      {
                Message="Please Enter country other than US or Canada";
                }
      else
      {
            if(continent.equalsIgnoreCase("EUR"))
              continent="Europe";
          if(continent.equalsIgnoreCase("CEN_SOU_AM"))
              continent="central-and-south-america";
          if(continent.equalsIgnoreCase("MIDEA"))
              continent="middle-east";
          if(continent.equalsIgnoreCase("OCEANIA"))
              continent="australia-and-south-pacific";
          if(continent.equalsIgnoreCase("ASIA"))
              continent="asia";
          if(continent.equalsIgnoreCase("AF"))
              continent="africa";
          if(continent.equalsIgnoreCase("MEX_CARIB"))
              continent="mexico-and-caribbean";          
          // System.out.println("the actual url is : "+url);
          tempurl="/"+continent+"/"+country;
         // System.out.println("the tempurl is : "+tempurl);
           hubcountryurl=url+tempurl;
          // System.out.println("the url is : "+hubcountryurl);
           Message=hubcountryurl;          
      }
                
         return Message;
 }
  public String verifybreadcrumb()
 {
      String Message=null; 
      //String breadcrumb=null;
      //String expected=null;      
     // String hubcountryurl=gethubcountryurl();
                       try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isTextPresent(breadcrumb);
                       //continent=continent.replace("-"," ");
                      // continent=continent.replace("and","&");
                       //expected="You are here: Travel Guides » "+continent+" » "+country;
                       //expected="You are here: Travel Guides » Europe » France";
                      // breadcrumb=session().getText("//div[@id='breadcrumb']/ul/");
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
                      if(result==true)
                      {
                           Message="Passed";                       
                      }
                      else
                      {
                          Message="Failed";
                      }
                      
         return Message;
 }
  public String verifyintrotext()
 {
      String Message=null;
     // String hubcountryurl=gethubcountryurl();
      boolean result;
      String introtext_actual=null;
      String introtext_expected=null;
                        try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
               result=session().isElementPresent("//div[@class='cityTextNoImg']");
               if (result==true)
               {
                //introtext_expected="Whether you're a first-time visitor to "+country+" or a seasoned traveler, find out more before you go on your "+country+" vacation. Our "+country+" travel guides cover famous places and "+country+" destinations off the beaten path you won't soon forget.";
               introtext_expected="Whether you're a first-time visitor to Mexico or a seasoned traveler, find out more before you go on your Mexico vacation. Our Mexico travel guides cover famous places and Mexico destinations off the beaten path you won't soon forget.";
               introtext_actual=session().getText("//div[@class='cityTextNoImg']");                 
                 if(introtext_expected.equals(introtext_actual))
                 {
                       Message="Passed";                 
                 }
                 else
                 {
                       Message="Failed-Introtext is wrong";                
                 }
               }

               else
               {
                   Message="Failed-Intro text is not present";
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

  public String verifyheading()
 {
      String Message=null;         
     // String hubcountryurl=gethubcountryurl();
      String heading_actual=null;
      boolean result;
      String heading_expected=null;
               try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
               session().setTimeout(TIMEOUT);
               session().open(url);
               //heading_expected=country+" Vacations, Hotels and Travel";
               heading_expected="Mexico Vacations, Hotels and Travel";
               result=session().isElementPresent("//div[@id='pageContainer']/div[2]/div[1]/h1");
               if(result==true)
                 {
               heading_actual=session().getText("//div[@id='pageContainer']/div[2]/div[1]/h1");
                                
                 if(heading_expected.equals(heading_actual))
                   {
                       Message="Passed";
                   }
                 else 
                   {
                       Message="Failed-Heading is wrong";
                 }
             }
                 else
                     Message="Failed-Page Heading is not present";
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
   public String verifyseeallhotelslink()
 {
      String Message=null;
      //String hubcountryurl=gethubcountryurl();
      String page=null;
      String temp;
      boolean result;
      String expected=null;
                try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
               session().setTimeout(TIMEOUT);
               session().open(url);
               result=session().isElementPresent("//div[@id='topHotels']/p/a");
             
               if(result==true)
                 {
               session().click("//div[@id='topHotels']/p/a");
               session().waitForPageToLoad("80000");
               page=session().getLocation();
               //expected=url+"/"+continent+"/"+country+"/hotels";
               expected="/travel-guide/mexico-and-caribbean/Mexico/hotels";
               if(page.contains(expected))
                 {
                       Message="Passed";
                 }
                 else
                       {
                       Message="Failed-Hotels link is wrong";
                       }
              }
                 else
                     Message="Failed-Hotels link is not present";
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
      //String hubcountryurl=gethubcountryurl();
      String page=null;
      String temp;
      boolean result;
      String expected=null;
               try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
               session().setTimeout(TIMEOUT);
               session().open(url);
               result=session().isElementPresent("//div[@id='topDeals']/p/a");
               if(result==true)
                 {
               session().click("//div[@id='topDeals']/p/a");
               session().waitForPageToLoad("80000");
               page=session().getLocation();
               //expected=url+"/"+continent+"/"+country+"/deals";
               expected="/travel-guide/mexico-and-caribbean/Mexico/deals";


                 if(page.contains(expected))
                 {
                       Message="Passed";                
                 }
                 else
                 {
                       Message="Failed-Deals link is wrong";
                  }
              }
                 else
                     Message="Failed-Deals link is not present";
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

 public String verifydealsmodule()
 {
      String Message=null;
      //String hubcountryurl=gethubcountryurl();
      String heading=null;
      String temp;
      boolean result;
      String expected=null;
               try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
               session().setTimeout(TIMEOUT);
               session().open(url);
               result=session().isElementPresent("//div[@id='dg_dealsResults']");
                      if(result==true)
                        {
               //expected=country+" Travel Deals";
                          expected="Mexico Travel Deals";
               heading=session().getText("//div[@id='dg_dealsResults']/h2");

                 if(heading.equalsIgnoreCase(expected))
                 {
                     Message="Passed";               
                 }
                 else
                   {
                   Message="Failed-Deals module heading is wrong";            
                   }
              }
                 else
                     Message="Failed-Deals module is not present";
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
     new Hub_country().gethubcountryurl(); 
     new Hub_country().verifybreadcrumb();
     new Hub_country().verifyintrotext();
     new Hub_country().verifyheading();   
    }      
}