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
 * @author Ragavendraqa
 */
public class CKMGarticles extends ColumnFixture {
    public String url,articleurl,tempurl,breadcrumb;
 java.lang.String page=null;
 public String city,state,country,continent,continent1,name,arurl,artype,country1,state1,city1;
 public int hificity,cityid;
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

 public String getarticleurl()
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
      articleurl=arurl.replace("http://travel.travel","http://travel-qa.test.travel");     
             Message=articleurl;
   return Message;
}
 public String verifyheading()
 {
      String Message=null;
       boolean result;
       String heading,expected;
       //articleurl=getarticleurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(articleurl);
                result=session().isElementPresent("articleTitle");
                if(result==true)
                {                     
                  expected=name;
                heading=session().getText("articleTitle");
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
     // articleurl=getarticleurl();
                        try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(articleurl);
                       result=session().isTextPresent(breadcrumb);
                       if(result==true)
                       {
                            //if (country.equalsIgnoreCase("United States"))
                           //  {
                           // expected="You are here: Travel Guides» "+"United States"+"» "+state+"» "+city+"» "+name;
                            expected="You are here: Travel Guides» United States» New York» New York» New York City";
                             //}
                            //else
                            //{
                           // continent1=continent1.replace("-"," ");
                           // continent1=continent1.replace("and","&");
                           // expected="You are here: Travel Guides» "+continent1+"» "+country+"» "+city+"» "+name;
                           //  }
                           //breadcrumb=session().getText("//ul[@id='breadCrumbUl']");
                          // if(expected.equalsIgnoreCase(breadcrumb))
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

public String verifyreviewslink()
 {
      String Message=null;
       boolean result;
       String link,expected,tempurl,reviewtext;
       //articleurl=getarticleurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(articleurl);
                result=session().isElementPresent("//div[@id='reviewLink']");
                reviewtext=session().getText("//div[@id='reviewLink']");
                if(result==true)
                {
                    session().click("link=Read all "+"New York"+" Reviews");
                 session().waitForPageToLoad("300000");
                   link=session().getLocation();
               // if (country.equalsIgnoreCase("United States"))
                   //{
                    //city1=city.replace(" ","+");
                   // state1=state.replace(" ","+");
                   // expected="http://travel.com/travel-guide/"+city1+"-"+state1+"-"+"United+States"+":"+cityid+"-destination-review-all";
                    expected="/travel-guide/New+York-New+York-United+States:33-destination-review-all";
                   // }
                //else
               // {
                 // country1=country.replace(" ","+");
                 // city1=city.replace(" ","+");
               // expected="http://travel.com/travel-guide/"+city1+"--"+country1+":"+cityid+"-destination-review-all";
               // }
                   if(link.contains(expected))
                   Message="Passed";
                    else
                    Message="Failed-Review link is wrong";
                }
                else
                {
                    Message="Failed-Review link is not present";
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
public String verifyhotellistinglink()
 {
      String Message=null;
       boolean result;
       String link,expected,tempurl,hotellinktext;
       //articleurl=getarticleurl();
               try {
               startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(articleurl);
                //result=session().isElementPresent("//div[@id='view']");
                result=session().isElementPresent("link=View All New York hotels");
               // hotellinktext=session().getText("//div[@id='view']");
                if(result==true)
                {
                   session().click("link=View All New York hotels");
                   session().waitForPageToLoad("300000");
                   link=session().getLocation();
               // if (country.equalsIgnoreCase("United States"))
                   //{
                  // city1=city.replace(" ","+");
                  // state1=state.replace(" ","+");
                  // expected="http://travel.com/travel-guide/"+city1+"-hotels-"+state1+"-"+"United+States"+":"+cityid;
                   expected="/travel-guide/New+York-hotels-New+York-United+States:33";
                   // }
               //  else
                //  {
                    // country1=country.replace(" ","+");
                    // city1=city.replace(" ","+");
                    // expected="http://travel.com/travel-guide/"+city1+"-hotels"+"--"+country1+":"+cityid;
                   //     }
                if(link.contains(expected))
                Message="Passed";
                else
                    Message="Failed-Hotellisting link is wrong";
                }
                else
                {
                    Message="Failed-Hotellisting link is not present";
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
 public static void main(String args[])
 {
     new CKMGarticles().verifyheading();
 }






}
