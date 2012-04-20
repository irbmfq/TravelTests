package travelQa;

import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class Omnibooking extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,strline,omniurl,pageNameValue,msg,v11Value,v4Value;
    public String  adurl;

    public Omnibooking() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    }

    public String flight_main() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("60000");
        selenium.type("leavingFromFL","paris");
        selenium.type("goingToFL","new york");
        selenium.click("leavingDate");
        selenium.click("link=27");
        selenium.click("adults");
        selenium.click("returningDate");
        selenium.click("link=28");
        selenium.click("flightsBtn");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt=0;
     try{
          while((strline = reader.readLine())!= null){

        	  if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")){
        cnt=cnt+1;
        if (cnt==2){
        		  omniurl = strline.substring(8);
        		  omniurl = URLDecoder.decode(omniurl);
                   System.out.println("omniurl after decoding"+omniurl);
                  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(omniurl,"&");
                  
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");
                        if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)){
        				  msg = msg + "pageName verified";
                          System.out.println(msg);
        			  }
        			  if (keys[0].equals("v11") && keys[1].equals(v11Value)){
        				 msg = msg + "v11 verified";
        			  }
        			  if (keys[0].equals("v4") && keys[1].equals(v4Value)){
        				  msg = msg + "v4 verified";
        			  }else{
                          msg = msg + "verification failed";
                      }
                  }

        	  }
              }

          }
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("pageName") && msg.contains("v11") && msg.contains("v4"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }

    }

    
public String hotel_main() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("60000");
        selenium.type("trvCity","las vegas");
        selenium.clickAt("country","United States");
        selenium.clickAt("state","LA");
        selenium.clickAt("trvHotelIn", "link=27");
        selenium.clickAt("trvHotelOut","link=28");
        selenium.click("hotelsBtn");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        
        BufferedReader reader = new BufferedReader(new StringReader(plain));
 int cnt=0;
     try{
          while((strline = reader.readLine())!= null){

        	  if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")){
  cnt = cnt+1;
  if(cnt==2){
        		  omniurl = strline.substring(8);
        		  omniurl = URLDecoder.decode(omniurl);
        		  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(omniurl,"&");
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");

        			  if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)){
        				  msg = msg + "pageName verified";
                          System.out.println(msg);
        			  }
        			  if (keys[0].equals("v11") && keys[1].equals(v11Value)){
        				 msg = msg + "v11 verified";
        			  }
        			  if (keys[0].equals("v4") && keys[1].equals(v4Value)){
        				  msg = msg + "v4 verified";
        			  }else{
                          msg = msg + "verification failed";
                      }
                  }

        	  }}
          }
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("pageName") && msg.contains("v11") && msg.contains("v4"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }
}

  public String car_main() {
      selenium.start("captureNetworkTraffic=true");
      selenium.open(url);
      selenium.waitForPageToLoad("60000");
      selenium.type("pickupCity","paris");
      selenium.type("dropoffCity","london");
      selenium.click("CAdepart");
      selenium.click("link=27");
      selenium.click("CAreturn");
      selenium.click("link=28");
      selenium.click("carsBtn");
      String plain=selenium.captureNetworkTraffic("plain");
      selenium.close();
      selenium.stop();
      
      BufferedReader reader = new BufferedReader(new StringReader(plain));
 int cnt=0;
     try{
          while((strline = reader.readLine())!= null){

        	  if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")){
cnt=cnt+1;
if(cnt==2){
        		  omniurl = strline.substring(8);
        		  omniurl = URLDecoder.decode(omniurl);
        		  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(omniurl,"&");
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");

        			  if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)){
        				  msg = msg + "pageName verified";
        			  }
        			   if (keys[0].equals("v11") && keys[1].equals(v11Value)){
        				 msg = msg + "v11 verified";
        			  }
        			   if (keys[0].equals("v4") && keys[1].equals(v4Value)){
        				  msg = msg + "v4 verified";
        			  }else{
                          msg = msg + "verification failed";
                      }
                  }

        	  }
          }}
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("pageName") && msg.contains("v11") && msg.contains("v4"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }
        
  }
 public String cruise_main(){
     selenium.start("captureNetworkTraffic=true");
     selenium.open(url);
      selenium.waitForPageToLoad("60000");
     selenium.select("destination","label=Asia");
     selenium.select("cruiseLength","label=3-6 Nights");
     selenium.select("fromMonthYear","label=January-2011");
     selenium.select("fromDay","label=4");
     selenium.select("cruiseVendor","label=Celebrity Cruises");
     selenium.click("cruisesBtn");     
     String plain=selenium.captureNetworkTraffic("plain");
     selenium.close();
     selenium.stop(); 
       
  BufferedReader reader = new BufferedReader(new StringReader(plain));
int cnt=0;
     try{
          while((strline = reader.readLine())!= null){

        	  if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")){
cnt=cnt+1;
if(cnt==2){
        		  omniurl = strline.substring(8);
        		  omniurl = URLDecoder.decode(omniurl);
        		  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(omniurl,"&");
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");

        			  if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)){
        				  msg = msg + "pageName verified";
        			  }
        			   if (keys[0].equals("v11") && keys[1].equals(v11Value)){
        				 msg = msg + "v11 verified";
        			  }
        			   if (keys[0].equals("v4") && keys[1].equals(v4Value)){
        				  msg = msg + "v4 verified";
        			  }
                  }

        	  }
          }}
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("pageName") && msg.contains("v11") && msg.contains("v4"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }
 }
 public String vacation_main(){
     selenium.start("captureNetworkTraffic=true");
     selenium.open(url);
      selenium.waitForPageToLoad("60000");
     selenium.type("valeavingFrom","new york");
     selenium.type("vagoingTo","london");
     selenium.clickAt("valeavingDate","link=27");
     selenium.select("vadateLeavingTime","label=12:00am");
     selenium.click("vaadult1");
     selenium.click("vasenior1");
     selenium.clickAt("vareturningDate","link=28");
     selenium.select("vadateReturningTime","label=12:00pm");
     selenium.click("vacationsBtn");
     String plain=selenium.captureNetworkTraffic("plain");
     selenium.close();
     selenium.stop();
     BufferedReader reader = new BufferedReader(new StringReader(plain));
int cnt=0;
     try{
          while((strline = reader.readLine())!= null){

        	  if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")){
cnt=cnt+1;
if(cnt==2){
        		  omniurl = strline.substring(8);
        		  omniurl = URLDecoder.decode(omniurl);
        		  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(omniurl,"&");
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");

        			  if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)){
        				  msg = msg + "pageName verified";
        			  }
        			   if (keys[0].equals("v11") && keys[1].equals(v11Value)){
        				 msg = msg + "v11 verified";
        			  }
        			   if (keys[0].equals("v4") && keys[1].equals(v4Value)){
        				  msg = msg + "v4 verified";
        			  }
                  }

        	  }}
          }
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("pageName") && msg.contains("v11") && msg.contains("v4"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }

 }
}
    





