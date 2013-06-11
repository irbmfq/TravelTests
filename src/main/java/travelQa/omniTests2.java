package travelQa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class omniTests2 extends ColumnFixture {

DefaultSelenium selenium;
public String url,strline,omniurl,pageNameValue,c1Value,c2Value,msg;

	public omniTests2() {
        selenium = new DefaultSelenium("localhost", 4442, "*chrome", "http://travel.com");
       }

    public String checkOmni(){
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
        		  omniurl = URLDecoder.decode(omniurl);
        		  omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(omniurl,"&");
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");

        			  if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)){
        				  msg = msg + "pageName verified";
        			  }
        			  else if (keys[0].equals("c1") && keys[1].equals(c1Value)){
        				 msg = msg + "c1 verified";
        			  }
        			  else if (keys[0].equals("c2") && keys[1].equals(c2Value)){
        				  msg = msg + "c2 verified";
        			  }

     

        		  }


        	  }
          }
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("pageName") && msg.contains("c1") && msg.contains("c2"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }
    }

}
