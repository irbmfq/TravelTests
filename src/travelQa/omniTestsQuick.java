package travelQa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class omniTestsQuick	 extends ColumnFixture {

DefaultSelenium selenium;
public String url,strline,omniurl,pageNameValue,c1Value,c2Value,msg,omnivar;

	public omniTestsQuick() {		
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://travel.com");
       }
 
    public String checkOmni(String omnivar){
    	  selenium.start("captureNetworkTraffic=true");	
          selenium.open(url);
          String plain = selenium.captureNetworkTraffic("plain"); 
          selenium.close();
          selenium.stop();
          
          BufferedReader reader = new BufferedReader(new StringReader(plain));
          
          try{
          while((strline = reader.readLine())!= null){
        	
        	  if(strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")){
        		 
        		  omniurl = strline.substring(8);        		  
        		  //System.out.print(omniurl);
        		  //omniurl = URLDecoder.decode(omniurl);           		  
        		  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  omniurl = omniurl.trim();
        		  System.out.print(omnivar);
        		  
        	  }              	  
          }           
          }catch (IOException e) {
			e.printStackTrace();			  	
		}    
          return omnivar;
          
    }
   
}
