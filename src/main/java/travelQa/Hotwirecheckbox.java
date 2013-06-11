package travelQa;

import java.net.URLDecoder;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;


public class Hotwirecheckbox extends ColumnFixture {

    
    public String url,  strline,  omniurl,  pageNameValue,  msg,  v11Value,  v4Value,  c23Value;
    public String adurl;
    DefaultSelenium selenium = new DefaultSelenium ("localhost",4444, "*chrome" , "http://travel.com/");
    

    public String flight_main()   {
        selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("leavingFromFL", "NYC");
        selenium.type("goingToFL", "IAD");
        selenium.click("leavingDate");
        selenium.click("link=27");
        selenium.click("adults");
        selenium.click("returningDate");
        selenium.click("link=28");
        selenium.click("kayak");
        selenium.click("travelTicker");
        selenium.click("flightsBtn");
        selenium.waitForPageToLoad("60000");
      //  Thread.sleep(3000);
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                       // System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");

                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");
                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                               // System.out.println(msg);
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                            } else {
                                msg = msg + "verification failed";
                            }
                        }

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
public String flight_lob() throws InterruptedException {
        
       selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("leavingFromFL", "NYC");
        selenium.type("goingToFL", "IAD");
        //selenium.click("leavingDate");
        //selenium.click("link=29");
        //selenium.click("adults");
        //selenium.click("returningDate");
        //selenium.click("link=30");
        selenium.click("kayak");
        selenium.click("travelTicker");
        selenium.click("flightsLobBtn");
        selenium.waitForPageToLoad("60000");
        //Thread.sleep(1000);
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                    //   System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");

                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");
                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";

                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";

                                //System.out.println(msg);
                            }
                        }

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
   public String hotel_main() throws InterruptedException {
         selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("trvCity", "Las vegas");
        //selenium.clickAt("country", "United States");
        //selenium.clickAt("state", "LA");
       // selenium.clickAt("trvHotelIn", "link=30");
        //selenium.clickAt("trvHotelOut", "link=30");
       selenium.click("//form[@id='mainFrmTrv']/div[2]/div/span[2]/input[2]");
		selenium.click("//form[@id='mainFrmTrv']/div[2]/div/span[2]/input[3]");
        selenium.click("hotelsBtn");
      selenium.waitForPageToLoad("60000");
       
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                       //System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                               //System.out.println(msg);
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                               // System.out.println(msg);
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String hotel_lob() throws InterruptedException {
         selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("trvCity", "Las vegas");
        //selenium.clickAt("country", "United States");
        //selenium.clickAt("state", "LA");
       // selenium.clickAt("trvHotelIn", "link=30");
        //selenium.clickAt("trvHotelOut", "link=30");
        selenium.click("kayak");
        selenium.click("travelTicker");
        selenium.click("hotelsLobBtn");
      selenium.waitForPageToLoad("60000");
      
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                       // System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                               //System.out.println(msg);
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                                //System.out.println(msg);
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
    public String car_main() throws InterruptedException {
       selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("pickupCity", "paris");
        //selenium.type("dropoffCity", "london");
        selenium.click("CAdepart");
        selenium.click("link=27");
        selenium.click("CAreturn");
        selenium.click("link=28");
        selenium.click("//form[@id='formCATrv']/div[2]/div/span[2]/input[2]");
		selenium.click("carRentals");
		selenium.click("//form[@id='formCATrv']/div[2]/div/span[2]/input[4]");
		selenium.click("carsBtn");
        selenium.waitForPageToLoad("60000");
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                        System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                               System.out.println(msg);
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String car_lob() throws InterruptedException {
         selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("pickupCity", "paris");
        //selenium.type("dropoffCity", "london");
        selenium.click("CAdepart");
        selenium.click("link=27");
        selenium.click("CAreturn");
        selenium.click("link=28");
        selenium.click("kayak");
		selenium.click("carRentals");
		selenium.click("travelTicker");
		selenium.click("carsLobBtn");
        selenium.waitForPageToLoad("60000");
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                        //System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                               // System.out.println(msg);
                            }
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }
public String cruise_main() throws InterruptedException {
         selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.select("destination", "label=Asia");
        selenium.select("cruiseLength", "label=3-6 Nights");
        selenium.select("fromMonthYear", "label=January-2011");
        selenium.select("fromDay", "label=4");
        selenium.select("cruiseVendor", "label=Celebrity Cruises");
        selenium.click("//form[@id='formCR']/div[2]/div/span[2]/input");
		selenium.click("cruisesBtn");
        selenium.waitForPageToLoad("60000");
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                      //  System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                                if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                    msg = msg + "c23 verified";
                                  // System.out.println(msg);
                                }
                            }
                        }

                    }
                        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String cruise_lob() throws InterruptedException {
        selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.select("destination", "label=Asia");
        selenium.select("cruiseLength", "label=3-6 Nights");
        selenium.select("fromMonthYear", "label=January-2011");
        selenium.select("fromDay", "label=4");
        selenium.select("cruiseVendor", "label=Celebrity Cruises");
        selenium.click("kayak");
		selenium.click("cruisesLobBtn");
        selenium.waitForPageToLoad("60000");
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                        //System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                                if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                    msg = msg + "c23 verified";
                                   // System.out.println(msg);
                                }
                            }
                        }

                    }
                        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String vacation_main() {
         selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("valeavingFrom", "new york");
        selenium.type("vagoingTo", "london");
        selenium.clickAt("valeavingDate", "link=27");
        selenium.select("vadateLeavingTime", "label=12:00am");
        selenium.click("vaadult1");
        selenium.click("vasenior1");
        selenium.clickAt("vareturningDate", "link=28");
        selenium.select("vadateReturningTime", "label=12:00pm");
        selenium.click("//form[@id='VacationSearchForm']/div[2]/div/span[2]/input[2]");
        selenium.click("//form[@id='VacationSearchForm']/div[2]/div/span[2]/input[3]");

        selenium.click("vacationsBtn");
        
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                            }

                        }

                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
public String vacation_lob() throws InterruptedException {
         selenium.start("captureNetworkTraffic=true");
        try {
        selenium.open(url);
        }
        catch(Exception e)
        {
        selenium.waitForPageToLoad("60000");
        }
        selenium.type("valeavingFrom", "new york");
        selenium.type("vagoingTo", "london");
        selenium.clickAt("valeavingDate", "link=27");
        selenium.select("vadateLeavingTime", "label=12:00am");
        selenium.click("vaadult1");
        selenium.click("vasenior1");
        selenium.clickAt("vareturningDate", "link=28");
        selenium.select("vadateReturningTime", "label=12:00pm");
        selenium.click("kayak");
		selenium.click("travelTicker");
		selenium.click("vacationsLobBtn");
        selenium.waitForPageToLoad("60000");
       // Thread.sleep(1000);
       String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();
        BufferedReader reader = new BufferedReader(new StringReader(plain));
        int cnt = 0;
        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://o.sa.travel.com/b/ss/devtraveltravel,devtravelsvc")) {
                    cnt = cnt + 1;
                    if (cnt == 2) {
                        omniurl = strline.substring(8);
                        omniurl = URLDecoder.decode(omniurl);
                       // System.out.println("omniurl after decoding" + omniurl);
                        omniurl = omniurl.substring(omniurl.indexOf("?") + 1);
                        StringTokenizer st = new StringTokenizer(omniurl, "&");
                        while (st.hasMoreTokens()) {
                            String paramvalue = st.nextToken();
                            String keys[] = paramvalue.split("=");

                            if (keys[0].equals("pageName") && keys[1].equals(pageNameValue)) {
                                msg = msg + "pageName verified";
                            }
                            if (keys[0].equals("v11") && keys[1].equals(v11Value)) {
                                msg = msg + "v11 verified";
                            }
                            if (keys[0].equals("v4") && keys[1].equals(v4Value)) {
                                msg = msg + "v4 verified";
                            }
                            if (keys[0].equals("c23") && keys[1].equals(c23Value)) {
                                msg = msg + "c23 verified";
                              //  System.out.println(msg);
                            }

                        }

                    }
                }
            }

    } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("pageName") && msg.contains("v11") && msg.contains("v4") && msg.contains("c23")) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

}
}






