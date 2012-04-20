/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import java.sql.*;

/**
 *
 * @author ragavendraqa
 */
public class Destination_deals extends ColumnFixture {
public String dealspageurl,tempurl,url;
 java.lang.String page=null;    
 public String city,state,country,continent,hificity;
 public int cityid;
DefaultSelenium selenium = new DefaultSelenium ("localhost",4444, "*chrome" , "http://travel.com/");
 
public String getdealspageurl()
 {
      String Message=null;      
      System.out.println("the city name is "+city);
         //System.out.println("the state name is "+state);
      System.out.println("the country name is "+country);
      System.out.println("the city id is "+cityid);
      
     if (country.equalsIgnoreCase("United States"))
      {
         country=country.replace(" ","+");
         System.out.println("the country name after changeingis "+country);
         state=country.replace(" ","+");
         System.out.println("the state name after changeingis "+country);
             tempurl="/"+city+"-"+state+country+":"+cityid;  
             dealspageurl="http://travel.com/travel-deals"+tempurl;
             Message=dealspageurl; 
                }
      else
      {
            country=country.replace(" ","+"); 
            //System.out.println("the country name after changeingis "+country);
          tempurl="/"+city+"--"+country+":"+cityid;
           dealspageurl="http://travel.com/travel-deals"+tempurl;
           Message=dealspageurl;  
          //System.out.println("the final url "+dealspageurl); 
      }
               
         return Message;
 }

public String checkallelementspresent()
 {
      String Message=null;       
      String dealspageurl=getdealspageurl();   
      boolean br,title,GSL,dealsto,dealsfrom,hot5,nearby,weather,fltab,htab,vtab,bm,recircle,gadget,geo;
      boolean letter,find;
                selenium.start();
     
           try {
			selenium.open(dealspageurl);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("30000");				
			}
                 /* Verifying that the Breadcrumb is present */
                br=selenium.isElementPresent("//ul[@id='breadCrumbUl']/li[1]");
                /* Verifying that the Title is present */
                title=selenium.isElementPresent("//div[@id='td_introText']/h1");
               
                /* Verifying that Dealsmodule are present */
                dealsto=selenium.isElementPresent("link=Deals to "+city);
               if (dealsto==false)
               {
                   dealsfrom=selenium.isElementPresent("link=Deals from "+city);                  
                   if(dealsfrom==false)             
                GSL=selenium.isElementPresent("link=Sponsored Links");                                         
               }
                /* Verifying that find deals module is present */
                find=selenium.isElementPresent("td_search"); 
                /* Verifying that hot5page link is present */
                hot5=selenium.isElementPresent("link=Hot Five Travel Deals");
                /* Verifying that popularcities module is present */
                nearby=selenium.isElementPresent("//div[@id='td_nearbyCities']/h3");
                 /* Verifying that weather module is present */
                weather=selenium.isElementPresent("//div[@id='td_weather']/a[2]/img");
                /* Verifying that Recirculation module is present */
                recircle=selenium.isElementPresent("link=exact:"+city+"?");
                /* Verifying that booking module is present */
                fltab=selenium.isElementPresent("tab1");
                htab=selenium.isElementPresent("tab2");
                vtab=selenium.isElementPresent("tab3");
                if(fltab==true&&htab==true&&vtab==true)
                    bm=true;
                else
                    bm=false;
                 /* Verifying that newsletter module is present */
                letter=selenium.isElementPresent("//img[@alt='Hot Deals']");
                /* Verifying that Google Gadget link is present */
                gadget=selenium.isElementPresent("link=Get our Google Gadgets");
                /* Verifying that Geomodule is present */
                geo=selenium.isElementPresent("//div[@id='geoModuleTitle']/h3");
                
                if(title=true&&br==true&&find==true&&hot5==true&&nearby==true&&weather==true&&bm==true&&letter==true&&gadget==true&&geo==true)
                   Message="Passed";
                else
                    Message="Failed";
                 selenium.close();
                 selenium.stop();
                return Message;
}

public String verifyfinddealsmodule()
 {
      String Message=null;       
      String dealspageurl=getdealspageurl();
      boolean find;  
      String alertregion,alertstate,alertcity,pageurl;
     
                selenium.start();
     
           try {
			selenium.open(dealspageurl);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("30000");				
			}
                  /* Verifying that find deals module is present */
                find=selenium.isElementPresent("td_search"); 
                if(find==true)
                {
                    selenium.click("gobtn");
                    alertregion=selenium.getAlert();
                    System.out.println("region alert: "+alertregion);
                    if(alertregion.equalsIgnoreCase("Please select a Region"))
            {
                        selenium.select("countries", "label=Europe");
                        selenium.click("gobtn");                       
                        alertstate=selenium.getAlert();
                        System.out.println("state alert: "+alertstate);
                if(alertstate.equalsIgnoreCase("Please select a Country/State"))  
                  {
                        selenium.focus("states");
                         //selenium.getSelectOptions("states");
                         
                         selenium.select("states", "label=France");
                         selenium.click("gobtn");
                         alertcity=selenium.getAlert();
                         System.out.println("city alert: "+alertcity);
                    if(alertregion.equalsIgnoreCase("Please select a City"))
                         {
                         selenium.getSelectOptions("cities");
                           selenium.select("cities", "label=Paris");
                           selenium.click("gobtn"); 
                           selenium.waitForPageToLoad("60000");
                           pageurl=selenium.getLocation();
                           if(pageurl.equalsIgnoreCase("http://travel.com/travel-deals/Paris--France:8"))
                           Message="Passed";
                           else
                           Message="Failed";                        
                         }
                    else
                    {
                       Message="Failed";
                       System.out.println("City alert is missed");
                    }
                        
                   }
                 else
                    {
                       Message="Failed";
                       System.out.println("State/country alert is missed");
                    } 
                    
              }
                    else
                    {
                       Message="Failed";
                       System.out.println("region alert is missed");
                    } 
                    
          }
          else
                    {
                       Message="Failed";
                       System.out.println("Find Deals module is not present");
                    }              
                
                   
                
                 selenium.close();
                 selenium.stop();
                return Message;
}


public String verifyhot5link()
 {
      String Message=null;       
      String dealspageurl=getdealspageurl();   
      boolean hot5;
      String pageurl,pageurl_expected;
                selenium.start();
     
           try {
			selenium.open(dealspageurl);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("30000");				
			}
                /* Verifying that hot5page link is present */
                hot5=selenium.isElementPresent("link=Hot Five Travel Deals");
                if(hot5==true)
                {
                    selenium.click("link=Hot Five Travel Deals");
                    selenium.waitForPageToLoad("40000");
                    pageurl=selenium.getLocation();
                    pageurl_expected="http://travel.travel.com/discount-travel";
                    if(pageurl_expected.equalsIgnoreCase(pageurl))
                        Message="Passed";
                    else
                        Message="Failed.hot5 link is not correct";
                } 
                else
                    Message="Failed.Hot5 link is not there";          
                 selenium.close();
                 selenium.stop();
                return Message;
}

public String verifygooglegadgetlink()
 {
      String Message=null;       
      String dealspageurl=getdealspageurl();   
      boolean gadget;
      String pageurl,pageurl_expected;
                selenium.start();
     
           try {
			selenium.open(dealspageurl);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("30000");				
			}
               /* Verifying that Google Gadget link is present */
                gadget=selenium.isElementPresent("link=Get our Google Gadgets");
                if(gadget==true)
                {
                    selenium.click("link=Get our Google Gadgets");
                    selenium.waitForPageToLoad("60000");
                    pageurl=selenium.getLocation();
                    pageurl_expected="http://www.yourminis.com/minis/yourminis/travel/mini:travelTravel";
                    if(pageurl_expected.equalsIgnoreCase(pageurl))
                        Message="Passed";
                    else
                        Message="Failed.Google Gadget link is not correct";
                } 
                else
                    Message="Failed.Google Gadget link is not there";          
                 selenium.close();
                 selenium.stop();
                return Message;
}

public static void main(String argv[]) 
    {
        // Main 
      new Destination_deals().getdealspageurl();
      new Destination_deals().checkallelementspresent();
      new Destination_deals().verifyfinddealsmodule();       
      new Destination_deals().verifyhot5link();
      new Destination_deals().verifygooglegadgetlink();  
        
      
      
        
    }   
    
    
}
