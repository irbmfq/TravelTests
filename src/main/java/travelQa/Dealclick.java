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
 *
 * @author pavankarnam
 */
public class Dealclick extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,  strline,  omniurl,  pageNameValue,  v5Value,  msg,abc;
    public int DealpageNO;

    public Dealclick() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    }

    public String checkOmni() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("30000");
       
        switch (DealpageNO) {
            case 1:  abc = selenium.getText("//html/body/div[2]/div[2]/div/div[3]/div/div/div[2]/div/div/span"); break;
            case 2:  abc = selenium.getText("//html/body/div[2]/div[4]/div[3]/div[2]/div[3]/div[2]/div/div[2]/div"); break;
            case 3:  abc = selenium.getText("//html/body/div[2]/div[3]/div/div[3]/div/div[2]/p/span"); break;
            case 4:  abc = selenium.getText("//html/body/div[3]/div[3]/div/div[2]/div/div[2]/p/span"); break;
            case 5:  abc = selenium.getText("//html/body/div[3]/div[3]/div/div[4]/div/div[2]/p/span"); break;
            case 6:  abc = selenium.getText("//html/body/div/div[2]/div[2]/div[2]/div/div/div[2]/div/ul/li/div/div[2]/div[2]/span"); break;
            case 7:  abc = selenium.getText("//html/body/div/div[5]/div[2]/div/div/div/div[2]/p/span"); break;
            case 8:  abc = selenium.getText("//html/body/div[2]/div[4]/div[7]/div/div/div[2]/p/span"); break;
            case 9:  abc = selenium.getText("//html/body/div/div[5]/div[6]/div/div/div/div[2]/p/span"); break;
            case 10:  abc = selenium.getText("//html/body/div[2]/div[4]/div[7]/div/div/div[2]/p/span"); break;
            case 11:  abc = selenium.getText("//html/body/div/div[5]/div[6]/div/div/div/div[2]/p/span"); break;
            case 12:  abc = selenium.getText("//html/body/div/div[5]/div[2]/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/div/span"); break;
            case 13:  abc = selenium.getText("//html/body/div/div[6]/div[5]/div/div/div/div[2]/p/span"); break;
            case 14:  abc = selenium.getText("//html/body/div[2]/div[4]/div[4]/ul/li/div[2]/p"); break;
            case 15:  abc = selenium.getText("//html/body/div/div[5]/div[4]/ul/li/div[2]/p"); break;
            case 16:  abc = selenium.getText("//html/body/div[2]/div[4]/div[2]/div[3]/ul/li/div[2]/p"); break;
            case 17:  abc = selenium.getText("//html/body/div/div[2]/div/div[3]/div[3]/ul/li/div[2]/p"); break;
            case 18:  abc = selenium.getText("//html/body/div/div[4]/div[2]/div[4]/ul/li/div[2]/p"); break;
            case 19:  abc = selenium.getText("//html/body/div/div[2]/div/div[3]/div[3]/ul/li/div[2]/p"); break;
            case 20:  abc = selenium.getText("//html/body/div[3]/div[4]/div[2]/div[2]/div[2]/a/div[2]/p[2]"); break;
            case 21:  abc = selenium.getText("//html/body/div[3]/div[4]/div[2]/div[2]/div/a/div[2]/p[2]"); break;
            case 22:  abc = selenium.getText("//html/body/div[3]/div[4]/div[2]/div[2]/div[2]/a/div[2]/p[2]"); break;
            case 23:  abc = selenium.getText("//html/body/div[3]/div[3]/div[3]/div[2]/div[2]/div[3]/a/div[2]/p/span"); break;
            case 24:  abc = selenium.getText("//html/body/div/div[4]/div[2]/div[3]/ul/li/div[2]/p"); break;
            
        }
        
       
System.out.println(abc);
        if (abc.contains("Travel.com")) {
            abc = abc.substring(abc.indexOf("by")+1, abc.indexOf("Travel.com"));
        }
        if (abc.contains(" *")) {
            abc = abc.substring(abc.indexOf("by")+3, abc.indexOf(" *"));
        }
            abc = abc.substring(abc.indexOf("by")+3);
        
        System.out.println(abc);
        v5Value = v5Value.replace("provider", abc);
       System.out.println(v5Value);
        v5Value = v5Value.replace("   ", " | ");
       // System.out.println(v5Value);
try {
    selenium.click("dealsTitleClickId1");
   }catch (Exception e) {
       try {
    selenium.click("//*[@id='dealsPriceClickId3']");
   }catch (Exception e1) {
          try {
    selenium.click("//html/body/div[3]/div[4]/div[2]/div[2]/div[2]/a/div/p");
   }catch (Exception e2) {
         try {
    selenium.click("//html/body/div[3]/div[4]/div[2]/div[2]/div[2]/a/div/p");
   }catch (Exception e3) {
    try{
        selenium.click("//html/body/div[2]/div[4]/div[2]/div[2]/div[2]/a/div/p ");
       }catch (Exception e4) {
           selenium.click("//html/body/div[3]/div[3]/div[3]/div[2]/div[2]/div[3]/a/div/span ");
       }
       }}}}

        selenium.waitForPageToLoad("60000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {

                    omniurl = strline.substring(8);
                    omniurl = URLDecoder.decode(omniurl);
                    omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                    StringTokenizer st = new StringTokenizer(omniurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                            System.out.println(keys[1]);
                            msg = msg + "pageName verified";
                        }
                        
                        if (keys[0].equals("v5") && keys[1].equalsIgnoreCase(v5Value)) {
                            System.out.println(keys[1]);
                            msg = msg + "v5 verified";
                        }





                    }


                }
            }
        
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v5")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    

}
}

