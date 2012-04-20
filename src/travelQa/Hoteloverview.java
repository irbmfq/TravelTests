
package travelQa;

import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class Hoteloverview extends ColumnFixture {

    public String check_heading,check_overview ,check_photos,url, overview_text, hotel_name,maps ;
    public boolean result,result1,result3,result4;
    DefaultSelenium selenium;

    public Hoteloverview() {

        selenium = new DefaultSelenium("localhost", 4442, "*chrome", "http://travel.com");
        
    }

    public String check_overview() {
                 selenium.start();
        selenium.open("http://travel.com/travel-guide/Berkeley-California-United+States-Claremont+Resort++Spa:595:019100-hotel-detail");
       selenium.waitForPageToLoad("30000");
        
        result=selenium.isElementPresent("link=Overview");
       
        selenium.close();
        selenium.stop();
       
         if(result=true)
           return "Test Passed";
         else 
            return "Test Failed";
        
    }
    
    public String check_heading() {
        selenium.start();

        selenium.open("http://travel.com/travel-guide/Berkeley-California-United+States-Claremont+Resort++Spa:595:019100-hotel-detail");
        
        result=selenium.isElementPresent("/div[@id='mainContent']/div[1]/h1");
        selenium.close();
        selenium.stop();
        if(result=true)     
                    return "Test Passed";
         else 
            return "Test Failed";
         
    }

    public String check_photos() {
        selenium.start();

        selenium.open("http://travel.com/travel-guide/Berkeley-California-United+States-Claremont+Resort++Spa:595:019100-hotel-detail");
        selenium.click("link=Photos");
        selenium.waitForPageToLoad("30000");
        String s = selenium.getLocation();
        selenium.close();
        selenium.stop();
        result3 = s.contains("/travel-guide/Berkeley-California-United+States-Claremont+Resort++Spa:595:019100-hotel-photos");
        if (result3) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
        public static void main(String argv[])
        {
         new Hoteloverview().check_overview();
         new Hoteloverview().check_heading();
         new Hoteloverview().check_photos();
    }
}
    



