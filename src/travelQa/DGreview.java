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
public class DGreview extends ColumnFixture{
    public String reviewurl,tempurl,url,breadcrumb;
 java.lang.String page=null;
 public String city,state,country,continent,continent1,stateabr,city1,state1;
 public int cityid,hificity,rating;
 public String user,password,title,desc;
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

public String getreviewurl()
{
   String Message=null;
   String country1,state1;   
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
         tempurl="/"+city1+"-"+state1+"-"+country1+":"+cityid+"-destination-review-all";
         reviewurl=url+tempurl;
             Message=reviewurl;
                }
      else
      {
            country1=country.replace(" ","+");
            city1=city.replace(" ","+");          
            tempurl="/"+city1+"--"+country1+":"+cityid+"-destination-review-all";
            reviewurl=url+tempurl;
           Message=reviewurl;
      }

   return Message;
}
public String verifyheading()
 {
      String Message=null;
       boolean result;
       String heading,expected;
      // String reviewurl=getreviewurl();
                 try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result=session().isElementPresent("//div[@id='mainContent']/h1");
                if(result==true)
                {
                      //if (country.equalsIgnoreCase("United States"))
                      //{
                     // expected=city+", "+state+" "+"REVIEWS AND RATINGS";
                      expected="Atlanta, Georgia Reviews and Ratings";
                      // }
                   // else
                   // {
                    // expected=city+", "+country+" "+"REVIEWS AND RATINGS";
                   // }
                heading=session().getText("//div[@id='mainContent']/h1");
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
      //String reviewurl=getreviewurl();
                       try {
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       result=session().isElementPresent("//div[@id='breadcrumb']/ul/");                      
                       if(result==true)
                       {
                       // if (country.equalsIgnoreCase("United States"))
                        // {
                           //expected="You are here: Travel Guides » "+"United States"+" » "+state+" » "+city+" » "+"Reviews";
                          // expected="You are here: Travel Guides » United States » Georgia » Atlanta » Reviews";
                         //}
                            //else
                            //{
                           // continent1=continent1.replace("-"," ");
                           // continent1=continent1.replace("and","&");
                           // expected="You are here: Travel Guides » "+continent1+" » "+country+" » "+city+" » "+"Reviews";
                           //}
                           //breadcrumb=session().getText("//div[@id='breadcrumb']/ul");
                           expected=session().getText("//div[@id='breadcrumb']/ul/");
                            
                           if(expected.equalsIgnoreCase(breadcrumb))
                           Message="Passed";
                           else
                               Message="Failed-Breadcrumb is wrong";
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
      //String reviewurl=getreviewurl();
                try {
                startSession(seleniumHost, seleniumPort, browser, webSite);
                session().setTimeout(TIMEOUT);
                session().open(url);
                result= session().isElementPresent("//li[@class='lastDealsLI']/a");               
                if(result==true)
                {       
                     session().click("//li[@class='lastDealsLI']/a");
                     session().waitForPageToLoad("30000");
                    pageurl= session().getLocation();
                    // if (country.equalsIgnoreCase("United States"))
                    // {
                         //country1=country.replace(" ","+");
                         // city1=city.replace(" ","+");
                         // state1=state.replace(" ","+");
                    //expectedurl="http://travel.com/travel-deals/"+city1+"-"+state1+"-"+country1+":"+cityid;
                     expectedurl="/travel-deals/Atlanta-Georgia-United+States:58";
                     //}
                     //else
                    // {
                         //country1=country.replace(" ","+");
                         // city1=city.replace(" ","+");
                    //expectedurl="http://travel.com/travel-deals/"+city1+"--"+country1+":"+cityid;
                     //}
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


//Verify Top11 Hotels link

public String verifyhotelslink()
 {
      String Message=null;
       boolean result;
       String pageurl,expectedurl,expectedtext,actualtext,country1;
      //String reviewurl=getreviewurl();
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
                     //if (country.equalsIgnoreCase("United States"))
                    // {
                        // country1=country.replace(" ","+");
                         //state1=state.replace(" ","+");
                         // city1=city.replace(" ","+");
                   // expectedurl="http://travel.com/travel-guide/"+city1+"-hotels-"+state1+"-"+country1+":"+cityid;
                    expectedurl="/travel-guide/Atlanta-hotels-Georgia-United+States:58";
                     //}
                     //else
                     //{
                       //  country1=country.replace(" ","+");
                          //city1=city.replace(" ","+");
                   // expectedurl="http://travel.com/travel-guide/"+city1+"-hotels--"+country1+":"+cityid;
                    // }
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

public String checkwriteareview()
 {
      String Message=null;
       boolean result,result1;
       String cookie,reviewtitle,expected;
     // String reviewurl=getreviewurl();
                  try {
                 startSession(seleniumHost, seleniumPort, browser, webSite);
                 session().setTimeout(TIMEOUT);
                 session().open(url);
                 result=session().isElementPresent("writeAReviewBtn1");
                 if(result==true)
                 {
                    session().click("writeAReviewBtn1");
                    session().waitForPageToLoad("300000");
                    session().click("loginButton1");
                    session().waitForPageToLoad("300000");
                    session().type("lgnId1",user);
                    session().type("pwdId1",password);
                    session().click("ssbmttravel");
                    session().waitForPageToLoad("300000");
                    //session().click("oar_star_4");
                    session().type("reviewTitleFld",title);
                    session().type("reviewDescFld",desc);
                    session().click("submitBtn");
                    session().waitForPageToLoad("300000");
                    session().click("cancelBtn");
                    session().waitForPageToLoad("300000");
                  result1=session().isElementPresent("//div[@id='reviewListingBlock']/div[2]/div[1]/div[1]/div");
                
                  if (result1==true)
                  {
                      reviewtitle=session().getText("//div[@id='reviewListingBlock']/div[2]/div[1]/div[1]/div");
                      expected="1."+title;
                                            if (expected.equalsIgnoreCase(reviewtitle))
                        Message="Passed";
                      else
                          Message="Failed-Write a review is wrong";
                  }
                }
                else
                {
                    Message="Failed-Write a Review Button is not present";
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
       new DGreview().verifyheading();
       new DGreview().verifybreadcrumb();
       new DGreview().verifydealslink();
       new DGreview().checkwriteareview();
    }






}
