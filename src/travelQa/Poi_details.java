/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelQa;
//import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import travelQa.urlPoiDetails;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 * @author Soujanya
 */
public class Poi_details extends ColumnFixture {

    public String url,  travelguide_heading,  res_overview,  poi,  rurl,  Restaurants1,  res_leftdg,  res_lfdestOver,  res_lfrestaurant,  res_lfthingstodo,  res_lt_tg1,  res_lt_tg2,  res_lt_rt1,  res_lt_rt2,  things1,  things_overview,  things_leftdg,  things_lfdestOver,  things_lfrestaurant,  things_lfthingstodo,  things_lt_tg1,  things_lt_tg2,  things_lt_th1,  things_lt_th2,  night1,  night_overview,  night_leftdg,  night_lfdestOver,  night_lfrestaurant,  night_lfthingstodo,  night_lt_tg1,  night_lt_tg2,  night_lt_nt1,  night_lt_nt2,  attraction1,  attraction_overview,  attract_leftdg,  attract_lfdestOver,  attract_lfrestaurant,  attract_lfthingstodo,  attract_lt_tg1,  attract_lt_tg2,  attract_lt_at1,  attract_lt_at2,  event1,  event_overview,  event_leftdg,  event_lfdestOver,  event_lfrestaurant,  event_lfthingstodo,  event_lt_tg1,  event_lt_tg2,  event_lt_ev1,  event_lt_ev2;
    public boolean result;
    public String restaurantspoi,  res_cat1,  res_cat2,  res_hotel1,  res_hotel2,  thingspoi,  things_cat1,  things_cat2,  things_hotel1,  things_hotel2,  nightpoi,  night_cat1,  night_cat2,  night_hotel1,  night_hotel2,  attractpoi,  attraction_cat1,  attraction_cat2,  attraction_hotel1,  attraction_hotel2,  eventpoi,  event_cat1,  event_cat2,  event_hotel1,  event_hotel2;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4441;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
    //DefaultSelenium selenium;
    urlPoiDetails URLPoiDetails = new urlPoiDetails();

    /*public Poi_details() {
    selenium = new DefaultSelenium("localhost", 4441, "*chrome", "http://travel.com");
    selenium.start();
    }*/
    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String check_heading() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//div[@id='srpOverviewModule']/div/div[2]/div[1]/a[1]");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            result = s.contains(URLPoiDetails.DestGuide);
            session().close();
            session().stop();
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
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }
    }

    public String check_restaurantspoi() {
         try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(restaurantspoi);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        result = rurl.contains(URLPoiDetails.restlist);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }

    }

    public String check_Restaurants1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(Restaurants1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.restaurant)) {
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }

    }

    public String check_overview_text() {


       try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        result = session().isTextPresent(res_overview);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }
    }

    public String check_categorylink1() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_cat1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.resCat1)) {
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }
    }

    public String check_categorylink2() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_cat2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.resCat2)) {
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }
    }

    public String check_Top11hotels1() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_hotel1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel1)) {
            return URLPoiDetails.testPassed;
        } else {
            return URLPoiDetails.testFailed;
        }
    }

    public String check_Top11hotels2() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_hotel2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleftDG() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_leftdg);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgLink)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleftDestOverview() {


        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_lfdestOver);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgOverview)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleftmore_res() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(res_lfrestaurant);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
        }
        if (rurl.contains(URLPoiDetails.LtMoreRest)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleftmore_things() {
try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(res_lfthingstodo);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
     session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreThingsToDo)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleft_travelguides1() {
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(res_lt_tg1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleft_travelguides2() {
try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(res_lt_tg2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleft_res1() {
try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(res_lt_rt1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
         session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
        }
        if (rurl.contains(URLPoiDetails.LfRest1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_rleft_res2() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(res_lt_rt2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
        }
        if (rurl.contains(URLPoiDetails.LFRest2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_ThingsToDopoi() {
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(thingspoi);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
         session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.ThingsToDolist)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_ThingsToDO1() {

         try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.ThingsToDo)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thoverview_text() {
         try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        result = session().isTextPresent(things_overview);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingscategorylink1() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
             session().click(things_cat1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.ThingsCat1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingscategorylink2() {
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_cat2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.ThingsCat2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thTop11hotels1() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
          session().click(things_hotel1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thTop11hotels2() {

 try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_hotel2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleftDG() {

 try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
               session().click(things_leftdg);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgLink)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleftDestOverview() {


         try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_lfdestOver);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgOverview)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleftmore_res() {
            try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_lfrestaurant);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreRest)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleftmore_things() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_lfthingstodo);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreThingsToDo)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleft_travelguides1() {
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_lt_tg1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
         session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleft_travelguides2() {


 try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
         session().click(things_lt_tg2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
         session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleft_things1() {
             try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
        session().click(things_lt_th1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
        }
        if (rurl.contains(URLPoiDetails.LfThings1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_tleft_things2() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
         session().click(things_lt_th2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfThings2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_NightLifepoi() {
try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(nightpoi);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Nightlist)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_NightLife1() {

        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.NightLife)) {

            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Ntoverview_text() {
try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        result = session().isTextPresent(night_overview);
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Nightcategorylink1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_cat1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.NightCat1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Nightcategorylink2() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_cat2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.NightCat2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_NtTop11hotels1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_hotel1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_NtTop11hotels2() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_hotel2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleftDG() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);
;
        session().click(night_leftdg);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgLink)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleftDestOverview() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lfdestOver);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgOverview)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleftmore_res() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lfrestaurant);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
     session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreRest)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleftmore_things() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lfthingstodo);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreThingsToDo)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleft_travelguides1() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lt_tg1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleft_travelguides2() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lt_tg2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleft_night1() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lt_nt1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfNight1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nleft_night2() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(night_lt_nt2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfNight2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Attpoi() {

        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attractpoi);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.AttList)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_Attractions1() {

        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attraction1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Attractions)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Atoverview_text() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        result = session().isTextPresent(attraction_overview);
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Atcategorylink1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attraction_cat1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.AttCat1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Atcategorylink2() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attraction_cat2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.AttCat2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_AtTop11hotels1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attraction_hotel1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_AtTop11hotels2() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attraction_hotel2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleftDG() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_leftdg);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgLink)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleftDestOverview() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lfdestOver);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgOverview)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleftmore_res() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lfrestaurant);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreRest)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleftmore_things() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lfthingstodo);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreThingsToDo)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleft_travelguides1() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lt_tg1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleft_travelguides2() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lt_tg2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleft_attract1() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lt_at1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfAttract1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_aleft_attract2() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(attract_lt_at2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfAttract2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Eventspoi() {

        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(eventpoi);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.EventList)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_Events1() {

       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Events)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Evoverview_text() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        result = session().isTextPresent(event_overview);
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Evcategorylink1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_cat1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
      session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.EventCat1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Evcategorylink2() {


     try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_cat2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.EventCat2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_EvTop11hotels1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_hotel1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_EvTop11hotels2() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_hotel2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.Top11hotel2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleftDG() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_leftdg);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgLink)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleftDestOverview() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lfdestOver);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LeftDgOverview)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleftmore_res() {

try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lfrestaurant);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreRest)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleftmore_things() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lfthingstodo);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LtMoreThingsToDo)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleft_travelguides1() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lt_tg1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleft_travelguides2() {


       try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lt_tg2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
       session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.TravelGuide2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleft_event1() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lt_ev1);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfEvent1)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_eleft_event2() {


        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    session().open(url);

        session().click(event_lt_ev2);
        session().waitForPageToLoad(URLPoiDetails.PageLoad);
        rurl = session().getLocation();
        session().close();
        session().stop();
        }catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (rurl.contains(URLPoiDetails.LfEvent2)) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }
}

    


