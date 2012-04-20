package travelQa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class Adscall2 extends ColumnFixture {

    DefaultSelenium selenium;
    public String url,  strline,  adurl;

    public Adscall2() {
        selenium = new DefaultSelenium("localhost", 4441, "*chrome", "http://travel.com");
    }

    public String checkads() {
        selenium.start("captureNetworkTraffic=true");
        selenium.open(url);
        String plain = selenium.captureNetworkTraffic("plain");
        selenium.close();
        selenium.stop();

        BufferedReader reader = new BufferedReader(new StringReader(plain));

        try {
            while ((strline = reader.readLine()) != null) {

                if (strline.contains("200 GET http://at.atwola.com/addyn/3.0/5113.1/221794/0/-1/size")) {

                    adurl = strline.substring(0, 3);
                    System.out.println(adurl);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (adurl.equalsIgnoreCase("200")) {

            return "Passed";
        } else {

            return "Test Failed";
        }
    }

    public static void main(String argv[]) {
        new Adscall2().checkads();
    }
}





