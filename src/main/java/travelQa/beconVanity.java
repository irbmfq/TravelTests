package travelQa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class beconVanity extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,  strline,  bconurl,  dl_task,  city,  cityid,  country,  region,  state,  msg;
    // public int cityid;

    public beconVanity() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    }

    public String checkBcon() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        String plain = selenium.captureNetworkTraffic("plain"); //plain
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/vanity/")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    //System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        //System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");
                        //System.out.println(keys[0]+" ==="+keys[1] );
                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        } else {
                            msg = msg + "dl_task verified";
                        }

                        if (keys[0].equals("city") && keys[1].equals(city)) {
                            city = "null";
                           // System.out.println(keys[1]);
                            msg = msg + "city verified";
                        } else {
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("cityid") && keys[1].equals(cityid)) {
                              cityid = "null";
                            // System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        } else {
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("country") && keys[1].equals(country)) {
                            country = "null";
                            //System.out.println(keys[1]);
                            msg = msg + "country verified";
                        } else {
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("region") && keys[1].equals(region)) {
                            region = "null";
                            //System.out.println(keys[1]);
                            msg = msg + "region verified";
                        } else {
                            msg = msg + "region verified";
                        }
                        if (keys[0].equals("state") && keys[1].equals(state)) {
                            state = "null";
                            //System.out.println(keys[1]);
                            msg = msg + "state verified";
                        }else {
                            msg = msg + "state verified";
                        }

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("state")) {

           // System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
}
