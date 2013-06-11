package travelQa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class bscore extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,  strline,  bscoreurl,  c4Value,  c7Value,c8Value,  msg;
    // public int cityid;

    public bscore() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    }

    public String checkbscore() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("204 GET http://b.scorecardresearch.com")) {

                    bscoreurl = strline.substring(8);
                    bscoreurl = URLDecoder.decode(bscoreurl);
                    bscoreurl = bscoreurl.substring(bscoreurl.indexOf("?") + 1);
                    StringTokenizer st = new StringTokenizer(bscoreurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("C4") && keys[1].contains(c4Value)) {
                            c4Value = "null";
                           // System.out.println(keys[1]);
                            msg = msg + "c4 verified";
                        //System.out.println(msg);
                        }

                        if (keys[0].equals("C7") && keys[1].contains(c7Value)) {
                            c7Value = "null";
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
        } catch (IOException e) {
            e.printStackTrace();
        }
         if (msg.contains("c4") && msg.contains("c7")&& msg.contains("c8") ) {
            //System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
}
