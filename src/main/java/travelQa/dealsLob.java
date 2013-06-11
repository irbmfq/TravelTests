/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelQa;

import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samaitra
 */
public class dealsLob extends ColumnFixture{

    public String url,deals_type,check_deal,deals_region,page_num,price_sort,region,state_country,city,popularDeals;
    public boolean result;
    DefaultSelenium selenium;

    public dealsLob() {
        selenium = new DefaultSelenium("localhost", 4441, "*chrome", "http://travel.com");
        selenium.start();
    }

    public String dealsType() {
        try {
            selenium.open(url);
        } catch (Exception e) {
            try {
                selenium.waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Page timed out";
                return Tmesage;
            }
        }

        selenium.click(deals_type);
        new Wait() {

            public boolean until() {
                return selenium.isTextPresent(check_deal);
            }
        }.wait("element"+check_deal+"not found");
        selenium.close();
        selenium.stop();
        return "Test Passed";

    }

    public String dealsRegion() {
        try {
            selenium.open(url);
        } catch (Exception e) {
            try {
                selenium.waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Page timed out";
                return Tmesage;
            }
        }

        selenium.click(deals_region);
        new Wait() {

            public boolean until() {
                return selenium.isTextPresent(check_deal);
            }
        }.wait("element"+check_deal+"not found");
        selenium.close();
        selenium.stop();
        return "Test Passed";

    }
    public String pagination() {
        try {
            selenium.open(url);
        } catch (Exception e) {
            try {
                selenium.waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Page timed out";
                return Tmesage;
            }
        }

        selenium.click(page_num);
        new Wait() {

            public boolean until() {
                return selenium.isTextPresent(check_deal);
            }
        }.wait("element"+check_deal+"not found");
        selenium.close();
        selenium.stop();
        return "Test Passed";

    }

        public String sortPrice() {
        try {
            selenium.open(url);
        } catch (Exception e) {
            try {
                selenium.waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Page timed out";
                return Tmesage;
            }
        }

        selenium.click(price_sort);
        new Wait() {

            public boolean until() {
                return selenium.isTextPresent(check_deal);
            }
        }.wait("element"+check_deal+"not found");
        selenium.close();
        selenium.stop();
        return "Test Passed";

    }

       public String findDeals() throws InterruptedException {
        try {
            selenium.open(url);
        } catch (Exception e) {
            try {
                selenium.waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Page timed out";
                return Tmesage;
            }
        }

        selenium.select("countries",region);
        new Wait() {

            public boolean until() {
                return selenium.isVisible(state_country);
            }
        }.wait("element"+state_country+"not found");
        selenium.select("states",state_country);
        selenium.select("cities",city);
        selenium.click("gobtn");
        selenium.waitForPageToLoad("30000");
        String s=selenium.getLocation();

        selenium.close();
        selenium.stop();
        if (s.contains("travel-deals/Miami-Florida-United+States:38"))
        return "Test Passed";
        else
        return "Test Failed";
    }

        public String checkpopularDeals() {
        try {
            selenium.open(url);
        } catch (Exception e) {
            try {
                selenium.waitForPageToLoad("50000");
            } catch (Exception e2) {
                String Tmesage = "Page timed out";
                return Tmesage;
            }
        }

        selenium.click(popularDeals);
        selenium.waitForPageToLoad("30000");
        String s = selenium.getLocation();
        selenium.close();
        selenium.stop();
        result = s.contains("travel-deals/Nassau--Bahamas:338");
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

}
