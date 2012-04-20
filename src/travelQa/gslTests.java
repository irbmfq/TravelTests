/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import com.thoughtworks.selenium.*;

import fit.ColumnFixture;

/**
 *
 * @author pavankarnam
 */
public class gslTests extends ColumnFixture {

    DefaultSelenium selenium;
 public String url,strline,msg,gslurl,sclientValue,spchValue;
 public String schValue,sschValue,shintsValue,snumValue;

 public gslTests() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
       }
 public String checkGsl(){

     selenium.start("captureNetworkTraffic=true");
          selenium.open(url);
          String plain = selenium.captureNetworkTraffic("plain");
          selenium.close();
          selenium.stop();

          BufferedReader reader = new BufferedReader(new StringReader(plain));

           try{
          while((strline = reader.readLine())!= null){

        	  if(strline.contains("200 GET http://switcher.dmn.travel.com/")){

                 gslurl = strline.substring(8);
                 gslurl = URLDecoder.decode(gslurl);
                  gslurl = gslurl.substring(gslurl.indexOf("?") + 1);
        		  StringTokenizer st = new StringTokenizer(gslurl,"&");
        		  while (st.hasMoreTokens()){
        			  String paramvalue = st.nextToken();
        			  String keys[] = paramvalue.split("=");

        			  if (keys[0].equals("sch") && keys[1].equals(schValue)){
                          schValue="null";
                          System.out.println(keys[1]);
        				  msg = msg + "sch verified";
        			  }
        			  else if (keys[0].equals("sclient") && keys[1].equals(sclientValue)){
                          sclientValue="null";
                          System.out.println(keys[1]);
        				 msg = msg + "sclient verified";
        			  } else
                      {
                          msg = msg + "sclient verified";
                      }
                          if (keys[0].equals("shints") && keys[1].equals(shintsValue)){
                              shintsValue="null";
                          System.out.println(keys[1]);
        				  msg = msg + "shints verified";
        			  } else
                      {
                          msg = msg + "shints verified";
                      }

                       if (keys[0].equals("snum") && keys[1].equals(snumValue)){
                           snumValue="null";
                           System.out.println(keys[1]);
        				  msg = msg + "snum verified";
        			  }

                      else if (keys[0].equals("spch") && keys[1].equals(spchValue)){
                          spchValue="null";
                          System.out.println(keys[1]);
        				  msg = msg + "spch verified";
        			  } else
                      {
                          msg = msg + "spch verified";
                      }
        			    if (keys[0].equals("ssch") && keys[1].equals(sschValue)){
                            sschValue="null";
                            System.out.println(keys[1]);
        				  msg = msg + "ssch verified";
        			  }


        		  }


        	  }
          }
          }catch (IOException e) {
			e.printStackTrace();
		}
          if(msg.contains("sch") && msg.contains("sclient") && msg.contains("shints")&& msg.contains("snum")
                  && msg.contains("spch")&& msg.contains("ssch"))
          {
        	  return "Test Passed";
          }else {
        	  return "Test Failed";
          }
    }









 }


