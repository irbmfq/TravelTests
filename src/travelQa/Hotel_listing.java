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

public class Hotel_listing extends ColumnFixture {
public String city,state_name,country_name;
 public String base,hotelurl,url_final,tempurl,url1,name;
    java.lang.String page=null; 
    public int rating;
   public String cityid,state,country;  
    
 DefaultSelenium selenium = new DefaultSelenium ("localhost",4444, "*chrome" , "http://travel.com/");   
    
    public String getcountry()   { 
   String tc = null;
   String returnMessage = null;
 
    Connection c = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url ="jdbc:mysql://realmap-lm03.websys.travel.com:3606/travel_travel";
      c = DriverManager.getConnection(url,"travelread", "travelq8");
      }catch( Exception e ) {
      e.printStackTrace();
    }  
      try{
      String query = "select country_name as tc from destination where city_name=\""+city+"\"";;
      PreparedStatement pStmt = c.prepareStatement(query);
      ResultSet rs = pStmt.executeQuery();
      if (rs.next()) {
        tc = rs.getString("tc");
        returnMessage = tc;
        
      } else {
        returnMessage = 
          "Error: did not find any data!";
      }
      rs.close();
      pStmt.close();
    } catch (SQLException e) {
      returnMessage = "Error: " + e;
    } 
    finally {
      if (c != null) {
        try {
          c.close();
        } catch (SQLException e1) {
        }
      }

   } 

    return (returnMessage == null) 
          ? "Something wrong with the Test code"
          : returnMessage;

  }
  public String getstatename()   { 
   String tc = null;
   String returnMessage = null;
 
    Connection c = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url ="jdbc:mysql://realmap-lm03.websys.travel.com:3606/travel_travel";
      c = DriverManager.getConnection(url,"travelread", "travelq8");
      }catch( Exception e ) {
      e.printStackTrace();
    }  
      try{
      String query = "select state_name as tc from destination where city_name=\""+city+"\"";;
      PreparedStatement pStmt = c.prepareStatement(query);
      ResultSet rs = pStmt.executeQuery();
      if (rs.next()) {
        tc = rs
              .getString("tc");
        returnMessage = tc;
        
      } else {
        returnMessage = 
          "Error: did not find any data!";
      }
      rs.close();
      pStmt.close();
    } catch (SQLException e) {
      returnMessage = "Error: " + e;
    } 
    finally {
      if (c != null) {
        try {
          c.close();
        } catch (SQLException e1) {
        }
      }

   } 

    return (returnMessage == null) 
          ? "Something wrong with the Test code"
          : returnMessage;

  }
  
 public String getcityid()   { 
   String tc = null;
   String returnMessage = null;
 
    Connection c = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String url ="jdbc:mysql://realmap-lm03.websys.travel.com:3606/travel_travel";
      c = DriverManager.getConnection(url,"travelread", "travelq8");
      }catch( Exception e ) {
      e.printStackTrace();
    }  
      try{
      String query = "select city_id as tc from destination where city_name=\""+city+"\"";;
      PreparedStatement pStmt = c.prepareStatement(query);
      ResultSet rs = pStmt.executeQuery();
      if (rs.next()) {
        tc = rs
              .getString("tc");
        returnMessage = tc;
        
      } else {
        returnMessage = 
          "Error: did not find any data!";
      }
      rs.close();
      pStmt.close();
    } catch (SQLException e) {
      returnMessage = "Error: " + e;
    } 
    finally {
      if (c != null) {
        try {
          c.close();
        } catch (SQLException e1) {
        }
      }

   } 

    return (returnMessage == null) 
          ? "Something wrong with the Test code"
          : returnMessage;

  }
    
 public String geturl(){
     hotelurl=null;
     cityid=getcityid();
     System.out.println("the cityid : "+cityid);
     System.out.println("the cityname:  "+city);   
     country=getcountry();
     System.out.println("the country name is  : "+country);
     System.out.println("the cityname is : "+city);
     if (country.equalsIgnoreCase("United States"))
      {
          System.out.println("the country is US");
          state=getstatename();         
          tempurl=city+"-hotels-"+state+"-"+"United+States"+":"+cityid;
          base="http://travel.com/travel-guide/";
          hotelurl=base+tempurl;
          System.out.println("the url is : "+hotelurl);
                }
      else
      {
           System.out.println("the country is not US");
          tempurl=city+"-hotels-"+"-"+country+":"+cityid;
          System.out.println("the temp url is : "+tempurl);
          base="http://travel.com/travel-guide/";
          hotelurl=base+tempurl;
          System.out.println("the url is : "+hotelurl);
      }
      
     
     return hotelurl;
     
 }      
   
   public String Checkurl_rating() 
    {
      String Message = null;
      boolean result;
      hotelurl=geturl();
                        
                    selenium.start();
			try {
			selenium.open(hotelurl);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("30000");				
			}   
                        
                       if (rating==1)
                       {
                        result=selenium.isElementPresent("//div[@id='ratingFlt']/div[2]/ul/li[5]/a/span[1]");
                        if (result==true)
                        {
                        selenium.click("//div[@id='ratingFlt']/div[2]/ul/li[5]/a/span[1]");
                        selenium.waitForPageToLoad("30000");
                        page=selenium.getLocation();  
                        }
                        else
                        {
                         System.out.println("There are no hotels for the rating :"+rating);
                         Message="No hotels for the given rating";
                        }                  
                       }
                        if (rating==2)
                       {
                        result=selenium.isElementPresent("//div[@id='ratingFlt']/div[2]/ul/li[4]/a/span[1]");
                        if (result==true)
                        {
                        selenium.click("//div[@id='ratingFlt']/div[2]/ul/li[4]/a/span[1]");
                        selenium.waitForPageToLoad("30000");
                        page=selenium.getLocation();  
                        }
                        else
                        {
                         System.out.println("There are no hotels for the rating :"+rating);
                         Message="No hotels for the given rating";
                        }                  
                       }
                        if (rating==3)
                       {
                        result=selenium.isElementPresent("//div[@id='ratingFlt']/div[2]/ul/li[3]/a/span[1]");
                        if (result==true)
                        {
                        selenium.click("//div[@id='ratingFlt']/div[2]/ul/li[3]/a/span[1]");
                        selenium.waitForPageToLoad("30000");
                        page=selenium.getLocation();  
                        }
                        else
                        {
                         System.out.println("There are no hotels for the rating :"+rating);
                         Message="No hotels for the given rating";
                        }                  
                       }
                        if (rating==4)
                       {
                        result=selenium.isElementPresent("//div[@id='ratingFlt']/div[2]/ul/li[2]/a/span[1]");
                        if (result==true)
                        {
                        selenium.click("//div[@id='ratingFlt']/div[2]/ul/li[2]/a/span[1]");
                        selenium.waitForPageToLoad("30000");
                        page=selenium.getLocation();  
                        }
                        else
                        {
                         System.out.println("There are no hotels for the rating :"+rating);
                         Message="No hotels for the given rating";
                        }                  
                       }
                        if (rating==5)
                       {
                        result=selenium.isElementPresent("//div[@id='ratingFlt']/div[2]/ul/li[1]/a/span[1]");
                        if (result==true)
                        {
                        selenium.click("//div[@id='ratingFlt']/div[2]/ul/li[1]/a/span[1]");
                        selenium.waitForPageToLoad("30000");
                        page=selenium.getLocation();  
                        }
                        else
                        {
                         System.out.println("There are no hotels for the rating :"+rating);
                         Message="No hotels for the given rating";
                        }                  
                       }
                        
                        url1="-rating-"+rating+"-sort-price-page-1";
                        System.out.println("url structure is : "+url1);                     
                        url_final=hotelurl+url1;
                        System.out.println("the finalurl is : "+url_final);
                       if(page.equalsIgnoreCase(url_final))
                       {
                           Message="Passed";
                           System.out.println("The test is passed");
                       }
                       else
                        Message="Failed";                       
                        selenium.close();
                        selenium.stop();
                       return(Message);   
                       
    }
   
   public String Chekurl_name()
   {
                      hotelurl=geturl();
			selenium.start();
			try {
			selenium.open(hotelurl);
			}
			catch(Exception e)
                        {
			selenium.waitForPageToLoad("30000");				
			}   
       String Message=null;
       boolean result;
     result=selenium.isElementPresent("link="+name);
     System.out.println("is link is present:  "+result);
     if (result==true)
     {
      selenium.click("link="+name);      
      selenium.waitForPageToLoad("40000");
      page=selenium.getLocation();  
     
     
     url1="-name-"+name+"-sort-price-page-1";
                        System.out.println("url structure is : "+url1);                     
                        url_final=hotelurl+url1;
                        System.out.println("the finalurl is : "+url_final);
                       if(page.equalsIgnoreCase(url_final))
                       {
                           Message="Passed";
                           System.out.println("The test is passed");
                       }
                       else
                        Message="Failed"; 
     }               
                       else
     {
         System.out.println("There are no hotels for requested name");
         Message="There are no hotels for requested name";
         selenium.stop();
     }
     selenium.close();
     selenium.stop();
     return(Message);  
       
   }
public static void main(String[] args)
{
    //Methods
    new Hotel_listing().getcityid();
    new Hotel_listing().getcountry();   
    new Hotel_listing().Checkurl_rating();    
    new Hotel_listing().Chekurl_name();
   
}
}
