/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import travelQa.urlPoiDetails;
//import com.thoughtworks.selenium.*;
//import fit.ColumnFixture;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author soujanyaqa
 */
public class dealsMain extends ColumnFixture {

    public String url,  deals_type,  check_deal,  deals_region,  page_num,  price_sort,  region,  state_country,  city,  popularDeals;
    public boolean result,  result1;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4444;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
    //DefaultSelenium selenium;

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }


    /*public dealsMain() {
    selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://travel.com");
    selenium.start();
    }*/
    public String check_dealtype() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad(urlPoiDetails.PageLoad);
            session().click("//a[@id='Car']");
            //session().waitForPageToLoad(urlPoiDetails.PageLoad);
            String firstPath = "//div[2]/h3[@id='dealsTitleClickId";
            String secondPath = "']/a";
            for (int i = 1; i <= 10; i++) {
                result = session().isElementPresent(firstPath + i + secondPath);
                result1 = session().isTextPresent("car");
                System.out.println(result1);
            }
                session().stop();
                closeSession();
            } catch (Exception e) {
            e.printStackTrace();
            session().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }
        if (result == true && result1 == true) {
            return urlPoiDetails.testPassed;
        } else {
            return urlPoiDetails.testFailed;
        }

    }

    public String check_dealprovider() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad(urlPoiDetails.PageLoad);
            session().click("//a[@id='shermans']");
           // session().waitForPageToLoad(urlPoiDetails.PageLoad);
            String firstPath = "//div[2]/h3[@id='dealsTitleClickId";
            String secondPath = "']/a";
            for (int i = 1; i <= 10; i++) {
                result = session().isElementPresent(firstPath + i + secondPath);
                result1 = session().isTextPresent("Published by ShermansTravel.com");
                System.out.println(result1);
            }
            session().stop();
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            session().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }
        if (result == true && result1 == true) {
           //if (result == true){
            return urlPoiDetails.testPassed;
        } else {
            return urlPoiDetails.testFailed;
        }

    }

    public String check_popularregion() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().waitForPageToLoad(urlPoiDetails.PageLoad);
            session().click("//a[@id='canada']");
            session().waitForPageToLoad(urlPoiDetails.PageLoad);
            String firstPath = "//div[2]/h3[@id='dealsTitleClickId";
            String secondPath = "']/a";
            for (int i = 1; i <= 10; i++) {
                result = session().isElementPresent(firstPath + i + secondPath);
            }
            session().stop();
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            session().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }
        if (result) {
            return urlPoiDetails.testPassed;
        } else {
            return urlPoiDetails.testFailed;
        }


    }

    public String checkPagination() {

        int link = 0;
        String total;
        System.out.println("aaaaa");
        String firstPath = "//div[2]/h3[@id='dealsTitleClickId";
        System.out.println("bbbb");
        String secondPath = "']/a";
        System.out.println("ccccc");
        boolean flag = true;
        System.out.println("dddddd");
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            System.out.println("eeeee");
            session().waitForPageToLoad(urlPoiDetails.PageLoad);
            System.out.println("fffff");
            session().click("allCatg");
            System.out.println("ggggg");
            total = session().getText("//div[@id='countPaginationSpan']/span");
            System.out.println("hhhh" + total);
            //total = total.substring(total.indexOf("of") + 3);
            //System.out.println("total" +total);
            int listingDetail = Integer.parseInt(total.trim());
            System.out.println("listingDetail" + listingDetail);
            int pagination = 1;
            pagination = listingDetail;
            int noOfPages = pagination / 10;
            int noOflistingLastPage = 0;
            if (noOfPages * 10 < pagination) {
                noOflistingLastPage = pagination - noOfPages * 10;
                noOfPages++;

            }//end If
            if (listingDetail > 0) {
                for (int page = 0; page < noOfPages; page++) {
                    link = page + 2;
                    System.out.println("page" + page);
                    System.out.println("link" + link);
                    System.out.println("noOfPages" + noOfPages);
                    System.out.println("Page No : " + (link - 1));
                    //for (int i =1; i <= 10; i++){
                    //      result = selenium.isElementPresent(firstPath+i+secondPath);
                    // }
                    if (link <= 4) {
                        session().click("link=" + link);

                    }
                }

            }
            session().stop();
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            session().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }

        if (flag) {
            return urlPoiDetails.testPassed;
        } else {
            return urlPoiDetails.testFailed;
        }

    }

    public static void main(String argv[]) {

        //new dealsMain().check_dealtype();
        new dealsMain().check_dealprovider();
        //new dealsMain().checkPagination();
    }
}
