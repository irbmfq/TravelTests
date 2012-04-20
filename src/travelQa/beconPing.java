package travelQa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.StringTokenizer;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class beconPing extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,  strline,  bconurl,  dl_task,  city,  cityid,  country,  region,  state,  msg,  nm,  tr_cityoverview_cityid,  tr_cityoverview_cityidvalue,  tr_cityoverview_cityname,  tr_cityoverview_citynamevalue,  tr_cityoverview_regionname,  tr_cityoverview_regionnamevalue,  tr_cityoverview_countryname,  tr_cityoverview_statenamevalue,  tr_cityoverview_countrynamevalue,  tr_statehubs_countrynamevalue,  tr_statehubs_statenamevalue;
    public String tr_activitylisting_cityidvalue,  tr_activitylisting_citynamevalue,  tr_activitylisting_countrynamevalue,  tr_activitylisting_regionnamevalue,  tr_activitylisting_statenamevalue,  tr_restaurantlisting_cityidvalue,  tr_restaurantlisting_citynamevalue,  tr_restaurantlisting_countrynamevalue,  tr_restaurantlisting_regionnamevalue,  tr_restaurantlisting_statenamevalue;
    public String tr_barlisting_cityidvalue,  tr_barlisting_citynamevalue,  tr_barlisting_countrynamevalue,  tr_barlisting_regionnamevalue,  tr_barlisting_statenamevalue,  tr_visitingthecitylisting_cityidvalue,  tr_visitingthecitylisting_citynamevalue,  tr_visitingthecitylisting_countrynamevalue,  tr_visitingthecitylisting_regionnamevalue,  tr_visitingthecitylisting_statenamevalue,  tr_eventslisting_statenamevalue,  tr_eventslisting_cityidvalue,  tr_eventslisting_citynamevalue,  tr_eventslisting_regionnamevalue,  tr_eventslisting_countrynamevalue,  tr_editgallery_categoryvalue,  tr_editgallery_namevalue;
    public String tr_hotellisting_cityidvalue,  tr_hotellisting_citynamevalue,  tr_hotellisting_countrynamevalue,  tr_hotellisting_statenamevalue,  tr_hotellisting_regionnamevalue;

    public beconPing() {
        selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    }

    public String checkTmainLob() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        } else {
                            msg = msg + "dl_task verified";
                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        } else {
                            msg = msg + "nm verified";

                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkgalleries() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";
                        } else {
                            msg = msg + "dl_task verified";
                        }
                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        } else {
                            msg = msg + "nm verified";
                        }
                        if (keys[0].equals("tr_editgallery_category") && keys[1].equals(tr_editgallery_categoryvalue)) {
                            tr_editgallery_categoryvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "category verified";
                        } else {
                            msg = msg + "category verified";
                        }
                        if (keys[0].equals("tr_editgallery_name") && keys[1].equals(tr_editgallery_namevalue)) {
                            tr_editgallery_namevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "name verified";
                        } else {
                            msg = msg + "name verified";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("category")&& msg.contains("category")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkDgUS() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        } else {
                            msg = msg + "dl_task verified";
                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        } else {
                            msg = msg + "nm verified";
                        }

                        if (keys[0].equals("city") && keys[1].equals(city)) {
                            city = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        } else {
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("cityid") && keys[1].equals(cityid)) {
                            cityid = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        } else {
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("country") && keys[1].equals(country)) {
                            country = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        } else {
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("region") && keys[1].equals(region)) {
                            region = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                        } else {
                            msg = msg + "region verified";
                        }
                        if (keys[0].equals("State") && keys[1].equals(state)) {
                            region = "null";
                            System.out.println(keys[1]);
                            msg = msg + "state verified";
                        } else {
                            msg = msg + "state verified";
                        }


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("state")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkDgInter() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("180000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        } else {
                            msg = msg + "dl_task verified";
                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        } else {
                            msg = msg + "nm verified";
                        }

                        if (keys[0].equals("city") && keys[1].equals(city)) {
                            city = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        } else {
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("cityid") && keys[1].equals(cityid)) {
                            cityid = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        } else {
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("country") && keys[1].equals(country)) {
                            country = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        } else {
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("region") && keys[1].equals(region)) {
                            region = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                        } else {
                            msg = msg + "region verified";
                        }


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkOverviewInter() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        } else {
                            msg = msg + "dl_task verified";
                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        } else {
                            msg = msg + "nm verified";
                        }

                        if (keys[0].equals("tr_cityoverview_cityid") && keys[1].equals(tr_cityoverview_cityidvalue)) {
                            tr_cityoverview_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        } else {
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_cityoverview_cityname") && keys[1].equals(tr_cityoverview_citynamevalue)) {
                            tr_cityoverview_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        } else {
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_cityoverview_regionname") && keys[1].equals(tr_cityoverview_regionnamevalue)) {
                            tr_cityoverview_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        } else {
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_cityoverview_countryname") && keys[1].equals(tr_cityoverview_countrynamevalue)) {
                            tr_cityoverview_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                        } else {
                            msg = msg + "region verified";
                        }


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkOverviewUS() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }


                        if (keys[0].equals("tr_cityoverview_cityid") && keys[1].equals(tr_cityoverview_cityidvalue)) {
                            tr_cityoverview_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_cityoverview_cityname") && keys[1].equals(tr_cityoverview_citynamevalue)) {
                            tr_cityoverview_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_cityoverview_regionname") && keys[1].equals(tr_cityoverview_regionnamevalue)) {
                            tr_cityoverview_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                            System.out.println("pass");
                        }
                        if (keys[0].equals("tr_cityoverview_countryname") && keys[1].equals(tr_cityoverview_countrynamevalue)) {
                            tr_cityoverview_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                        }
                        if (keys[0].equals("tr_cityoverview_statename") && keys[1].equals(tr_cityoverview_statenamevalue)) {
                            tr_cityoverview_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "State verified";
                        }


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("State")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkStateHub() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }


                        if (keys[0].equals("tr_statehubs_countryname") && keys[1].equals(tr_statehubs_countrynamevalue)) {
                            tr_statehubs_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_statehubs_statename") && keys[1].equals(tr_statehubs_statenamevalue)) {
                            tr_statehubs_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "state verified";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("country") && msg.contains("state")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkThingstodo() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }


                        if (keys[0].equals("tr_activitylisting_cityid") && keys[1].equals(tr_activitylisting_cityidvalue)) {
                            tr_cityoverview_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_activitylisting_cityname") && keys[1].equals(tr_activitylisting_citynamevalue)) {
                            tr_cityoverview_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_activitylisting_regionname") && keys[1].equals(tr_activitylisting_regionnamevalue)) {
                            tr_cityoverview_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                            System.out.println("pass");
                        }
                        if (keys[0].equals("tr_activitylisting_countryname") && keys[1].equals(tr_activitylisting_countrynamevalue)) {
                            tr_cityoverview_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_activitylisting_statename") && keys[1].equals(tr_activitylisting_statenamevalue)) {
                            tr_cityoverview_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "State verified";
                        }


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("State")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkRestaurantlisting() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }


                        if (keys[0].equals("tr_restaurantlisting_cityid") && keys[1].equals(tr_restaurantlisting_cityidvalue)) {
                            tr_cityoverview_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_restaurantlisting_cityname") && keys[1].equals(tr_restaurantlisting_citynamevalue)) {
                            tr_cityoverview_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_restaurantlisting_regionname") && keys[1].equals(tr_restaurantlisting_regionnamevalue)) {
                            tr_cityoverview_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                            System.out.println("pass");
                        }
                        if (keys[0].equals("tr_restaurantlisting_countryname") && keys[1].equals(tr_restaurantlisting_countrynamevalue)) {
                            tr_cityoverview_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_restaurantlisting_statename") && keys[1].equals(tr_restaurantlisting_statenamevalue)) {
                            tr_cityoverview_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "State verified";
                        }


                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("State")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkNightlifelisting() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";

                        }

                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }


                        if (keys[0].equals("tr_barlisting_cityid") && keys[1].equals(tr_barlisting_cityidvalue)) {
                            tr_barlisting_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_barlisting_cityname") && keys[1].equals(tr_barlisting_citynamevalue)) {
                            tr_barlisting_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_barlisting_regionname") && keys[1].equals(tr_barlisting_regionnamevalue)) {
                            tr_barlisting_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                            System.out.println("pass");
                        }
                        if (keys[0].equals("tr_barlisting_countryname") && keys[1].equals(tr_barlisting_countrynamevalue)) {
                            tr_barlisting_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkAttractionslisting() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";
                        }
                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }
                        if (keys[0].equals("tr_visitingthecitylisting_cityid") && keys[1].equals(tr_visitingthecitylisting_cityidvalue)) {
                            tr_visitingthecitylisting_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_visitingthecitylisting_cityname") && keys[1].equals(tr_visitingthecitylisting_citynamevalue)) {
                            tr_visitingthecitylisting_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_visitingthecitylisting_regionname") && keys[1].equals(tr_visitingthecitylisting_regionnamevalue)) {
                            tr_visitingthecitylisting_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                            System.out.println("pass");
                        }
                        if (keys[0].equals("tr_visitingthecitylisting_countryname") && keys[1].equals(tr_visitingthecitylisting_countrynamevalue)) {
                            tr_visitingthecitylisting_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_visitingthecitylisting_statename") && keys[1].equals(tr_visitingthecitylisting_statenamevalue)) {
                            tr_visitingthecitylisting_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "State verified";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("State")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkEventslisting() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";
                        }
                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }
                        if (keys[0].equals("tr_eventslisting_cityid") && keys[1].equals(tr_eventslisting_cityidvalue)) {
                            tr_eventslisting_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_eventslisting_cityname") && keys[1].equals(tr_eventslisting_citynamevalue)) {
                            tr_eventslisting_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_eventslisting_regionname") && keys[1].equals(tr_eventslisting_regionnamevalue)) {
                            tr_eventslisting_regionnamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "region verified";
                            System.out.println("pass");
                        }
                        if (keys[0].equals("tr_eventslisting_countryname") && keys[1].equals(tr_eventslisting_countrynamevalue)) {
                            tr_eventslisting_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_eventslisting_statename") && keys[1].equals(tr_eventslisting_statenamevalue)) {
                            tr_eventslisting_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "State verified";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("region") && msg.contains("State")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String checkHotellisting() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        selenium.waitForPageToLoad("50000");
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://b.travel.com/ping")) {

                    bconurl = strline.substring(8);
                    bconurl = URLDecoder.decode(bconurl);
                    bconurl = bconurl.substring(bconurl.indexOf("?") + 1);
                    System.out.println(bconurl);
                    StringTokenizer st = new StringTokenizer(bconurl, "&");
                    while (st.hasMoreTokens()) {
                        String paramvalue = st.nextToken();
                        System.out.println(paramvalue);
                        String keys[] = paramvalue.split("=");

                        if (keys[0].equals("dl_task") && keys[1].equals(dl_task)) {
                            dl_task = "null";
                            System.out.println(keys[1]);
                            msg = msg + "dl_task verified";
                        }
                        if (keys[0].equals("nm") && keys[1].equals(nm)) {
                            nm = "null";
                            System.out.println(keys[1]);
                            msg = msg + "nm verified";
                        }
                        if (keys[0].equals("tr_hotellisting_cityid") && keys[1].equals(tr_hotellisting_cityidvalue)) {
                            tr_hotellisting_cityidvalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "cityid verified";
                        }
                        if (keys[0].equals("tr_hotellisting_cityname") && keys[1].equals(tr_hotellisting_citynamevalue)) {
                            tr_hotellisting_citynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "city verified";
                        }
                        if (keys[0].equals("tr_hotellisting_countryname") && keys[1].equals(tr_hotellisting_countrynamevalue)) {
                            tr_hotellisting_countrynamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "country verified";
                        }
                        if (keys[0].equals("tr_hotellisting_statename") && keys[1].equals(tr_hotellisting_statenamevalue)) {
                            tr_hotellisting_statenamevalue = "null";
                            System.out.println(keys[1]);
                            msg = msg + "State verified";
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (msg.contains("dl_task") && msg.contains("nm") && msg.contains("city") && msg.contains("cityid") && msg.contains("country") && msg.contains("State")) {

            System.out.println(msg);
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
}
