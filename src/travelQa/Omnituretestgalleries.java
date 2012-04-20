/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
/**
 *
 * @author Ragavendraqa
 */
public class Omnituretestgalleries extends ColumnFixture {
public String url,strline,omniurl,pagename,c1Value,c2Value,c11value,magicnumber,Message;
public boolean result,result1;
    DefaultSelenium selenium = new DefaultSelenium ("localhost",4442, "*chrome" , "http://travel.com/");
    public String verifynextgallaryomniture()
    {
        int count=0;
        try {
        selenium.start("captureNetworkTraffic=true");
       // System.out.println("------------------------------------------------");
       try {
			selenium.open(url);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("120000");
			}
        result=selenium.isElementPresent("//img[@alt='Next']");
       //System.out.println("next button is present or not-old gallaries :"+result);
       result1=selenium.isElementPresent("//div[@id='navWrapperTop']/div[2]/div[2]/a");     
      // System.out.println("next button is present or not-new galleries :"+result1);
       if(result==true)
       {
          selenium.click("//img[@alt='Next']");
        String plain=selenium.captureNetworkTraffic("plain");     
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try{
            while((strline = reader.readLine())!= null)
            {

                if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc"))
                {
                    count=count+1;
                    omniurl = strline.substring(8);
                    omniurl = URLDecoder.decode(omniurl);                    
                     omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                   //  System.out.println("the omniurl is :"+omniurl);
                     StringTokenizer st = new StringTokenizer(omniurl,"&");
                     while(st.hasMoreTokens())
                     {
                          String paramvalue = st.nextToken();
        			    String keys[] = paramvalue.split("=");
                       if (keys[0].equals("pageName"))
                       {
                           if(keys[1].equals(pagename))
                         {
                      // System.out.println("the actualvalue is-nextold :"+keys[1]);
                               Message="Passed";
                       }
                         
        			  else
                           Message="Failed-Page name is wrong";
                        }
                     }
                }
            }
           if (count>2)
            {
                Message="Failed-More than one call is found for gallary pagingation click";
            }
        }
catch (IOException e) {
			e.printStackTrace();
		}
       }
       else  if(result1==true)
       {
        selenium.click("//div[@id='navWrapperTop']/div[2]/div[2]/a");
        String plain=selenium.captureNetworkTraffic("plain");

        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try{
            while((strline = reader.readLine())!= null)
            {

                if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc"))
                {
                    count=count+1;
                    omniurl = strline.substring(8);
                    omniurl = URLDecoder.decode(omniurl);
                     omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                    // System.out.println("the omniurl is :"+omniurl);
                     StringTokenizer st = new StringTokenizer(omniurl,"&");
                     while(st.hasMoreTokens())
                     {
                          String paramvalue = st.nextToken();
        			    String keys[] = paramvalue.split("=");
                       if (keys[0].equals("pageName"))
                       {
                           if(keys[1].equals(pagename))
                         {
                         Message="Passed";
                        // System.out.println("the actualvalue is-nextnew :"+keys[1]);
                       }

        			  else
                           Message="Failed-Page name is wrong";
                        }
                     }
                }
            }
           if (count>2)
            {
                Message="Failed-More than one call is found for gallary pagingation click";
            }
        }
catch (IOException e) {
			e.printStackTrace();
		}
        }
        
        }
    catch(Exception e1)
    {
     e1.getMessage();
    // System.out.println("Error found -Closing the browser");
     selenium.close();
     selenium.stop();
    }
        return Message;      
    }
public String verifyprevgallaryomniture()
    {
    try {
        int count=0;
        selenium.start("captureNetworkTraffic=true");
       try {
			selenium.open(url);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("120000");
			}
        result=selenium.isElementPresent("//img[@alt='Previous']");
       // System.out.println("previous button is present or not-old gallaries :"+result);
         result1=selenium.isElementPresent("//div[@id='navWrapperTop']/div[2]/div[2]/a");
      // System.out.println("next button is present or not-new galleries :"+result1);
          if (result==true)
          {
          selenium.click("//img[@alt='Previous']");
        String plain=selenium.captureNetworkTraffic("plain");

        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while((strline = reader.readLine())!= null)
            {

                if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc"))
                {
                    count=count+1;                    
                    omniurl = strline.substring(8);
                    omniurl = URLDecoder.decode(omniurl);
                     omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                    // System.out.println("the omniurl is-prevold :"+omniurl);
                     StringTokenizer st = new StringTokenizer(omniurl,"&");
                     while(st.hasMoreTokens())
                     {
                          String paramvalue = st.nextToken();
        			    String keys[] = paramvalue.split("=");
                       if (keys[0].equals("pageName"))
                       {
                          if(keys[1].equals(pagename))
                         {
                           Message="Passed";
                         // System.out.println("the actualvalue is-prevold :"+keys[1]);
                       }
               	   else
                           Message="Failed-Pagename is wrong";
                          }
                     }
                }
            }
            if (count>2)
            {
                Message="Failed-More than one call is found for gallary pagingation click";
            }
        }
catch (IOException e) {
			e.printStackTrace();
		}
        
          }
    else  if(result1==true)
       {
        selenium.click("//div[@id='navWrapperTop']/div[2]/div[2]/a");
        String plain=selenium.captureNetworkTraffic("plain");

        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try{
            while((strline = reader.readLine())!= null)
            {

                if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc"))
                {
                    count=count+1;
                    omniurl = strline.substring(8);
                    omniurl = URLDecoder.decode(omniurl);
                     omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                    // System.out.println("the omniurl is-prevnew :"+omniurl);
                     StringTokenizer st = new StringTokenizer(omniurl,"&");
                     while(st.hasMoreTokens())
                     {
                          String paramvalue = st.nextToken();
        			    String keys[] = paramvalue.split("=");
                       if (keys[0].equals("pageName"))
                       {
                           if(keys[1].equals(pagename))
                         {
                         Message="Passed";
                         //  System.out.println("the actualvalue is-prevnew :"+keys[1]);
                       }

        			  else
                           Message="Failed-Page name is wrong";
                        }
                     }
                }
            }
           if (count>2)
            {
                Message="Failed-More than one call is found for gallary pagingation click";
            }
        }
catch (IOException e) {
			e.printStackTrace();
		}
        }
    }
        catch(Exception e1)
        {
      e1.getMessage();
      selenium.close();
     selenium.stop();
        }
        return Message;
    }


    public static void main(String argv[])
    {
        //System.out.println("omniture galleries");
    }
}
