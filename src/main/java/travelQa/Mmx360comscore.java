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
public class Mmx360comscore extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,  strline,  bscoreurl,  c4Value,  c7Value,  c8Value,  cid,  msg;
    public boolean result;
    public int count = 0,  action;

    public Mmx360comscore() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    }

    public String checkBscore() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("12000");

        switch (action) {
            case 0: break;
            case 1:
                selenium.click("//div[@id='nextBtn']/div");
                break;
            case 2:
                selenium.click("next");
               break;
           case 3:
                selenium.click("exploreGuidesBy");
                selenium.select("exploreGuidesBy", "label=From Our Editors");
                selenium.click("//option[@value='From_Our_Editors_Pick']");
                break;
            case 4:
               // selenium.click("srchBox");
                selenium.type("GH_search_field", "New york");
		        selenium.click("GH_search_button");
                break;
            case 5:
                selenium.click("//img[@alt='Next']");
                break;

        }
        /** }
        try{
        selenium.click("//div[@id='nextBtn']/div");
        }catch (Exception e) {
        try {
         *
        selenium.click("next");
        }catch (Exception e1) {
        }*/
        selenium.waitForPageToLoad("60000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {
                //System.out.println(strline);
                if (strline.contains("204 GET http://b.scorecardresearch.com")) {
                    count++;
                    if (count == 2) {
                        bscoreurl = strline.substring(8);
                        bscoreurl = URLDecoder.decode(bscoreurl);
                        bscoreurl = bscoreurl.substring(bscoreurl.indexOf("?") + 1);

                       // System.out.println(bscoreurl);
                        StringTokenizer st = new StringTokenizer(bscoreurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");
                            if (keys[0].equals("C4") && keys[1].contains(c4Value)) {
                                c4Value="null";
                               // System.out.println(keys[1]);
                                msg = msg + "c4 verified";
                                 //System.out.println(msg);
                            }

                            if (keys[0].equals("C7") && keys[1].contains(c7Value)) {
                                c7Value="null";
                               // System.out.println(keys[1]);
                               msg = msg + "c7verified";
                                //System.out.println(msg);

                            }
                            if (keys[0].equals("C8") && keys[1].contains(c8Value)) {
                                c8Value="null";
                               // System.out.println(keys[1]);
                                msg = msg + "c8verified";
                               // System.out.println(msg);

                            }
                        }
                    }
                }

                if (strline.contains("200 GET http://travel.com/mm_track?cId")) {

                    bscoreurl = strline.substring(8);
                    bscoreurl = URLDecoder.decode(bscoreurl);
                    bscoreurl = bscoreurl.substring(bscoreurl.indexOf("?") + 1);
                   // System.out.println(bscoreurl);
                    StringTokenizer st = new StringTokenizer(bscoreurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        String keys[] = paramvalue.split("=");
                        if ((keys[0].equals("cId")) && keys[1] != " ") {
                            System.out.println(keys[1]);
                            msg = msg + "cId verified";
                        }



                    }
                }
                if (action==4){
                    msg = msg + "cId verified";
                }

            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        if (msg.contains("c4") && msg.contains("c7") && msg.contains("cId") && msg.contains("c8")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }


    }
}

