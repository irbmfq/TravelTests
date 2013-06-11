package travelQa;

import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 *
 * @author pavankarnam
 */
public class Poi_Listing extends ColumnFixture {

    public String url,  travelguide_heading,  poi,  rurl,  Restaurants1,  Nightlife1,  Attractions,  thingstodo1,  Events,  Attractions1,  Events1,  ThingstoDo;
    public boolean result;
    public String restaurantspoi,  Restaurants2,  Restaurants3,  Nightlifepoi,  Nightlifemap,  Travelguide,  Nightlife2,  Restaurants4,  thingstodo2;
    public String nightlifefacet1,  nightlifefacet2,  thingstodo3,  thingstodo4,  thingstodo5,  thingstodo6,  thingstodo7,  thingstodo8;
    public String events2,  events3,  events4,  events5,  events6,  events7,  events8,  events9,  events10;
    public String attractions2,  attractions3,  attractions4,  attractions5,  attractions6,  attractions7,  attractions8,  attractions9,  attractions10;
    public String restaurants5,  restaurants6,  restaurants7,  restaurants8,  s = "";
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4442;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";

    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    //public Poi_Listing() {
        //selenium = new DefaultSelenium("localhost", 4442, "*chrome", "http://travel.com");
        // selenium.start();
   // }

    public String check_heading() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(travelguide_heading);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            result = s.contains("/travel-guide/United-States/District-of-Columbia/Washington-DC");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_restaurantspoi() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(restaurantspoi);
            session().waitForPageToLoad("30000");
            String s = session().getLocation();

            result = s.contains("travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }

    }

    public String check_Restaurants1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Restaurants1);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            session().close();
            session().stop();
            result = s.contains("/travel-guide/2941+Restaurant-Washington+DC-restaurants-District+of+Columbia-United+States:37:319465");

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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Restaurants2() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("category");
            session().click("//div[@id='categoryList']/div[2]/div/ul/li[4]/a/span");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            session().close();
            session().stop();
            result = s.contains("/travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37-cat-Asian/Pacific-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Restaurants3() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Restaurants3);
           session().waitForPageToLoad("30000");
            String s = session().getLocation();
            result = s.contains("/travel-guide/Baltimore-restaurants-Maryland-United+States:357");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Restaurants4() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("neighborhood");
            session().click("//div[@id='neighborhoodList']/div[2]/div/ul/li[2]/a/span");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37-cat-Asian/Pacific-nh-Dupont+Circle-sort-name-asc-page-1");

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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_restaurants5() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=Name");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37-sort-name-desc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_restaurants6() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=remove");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_restaurants7() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("//div[@id='listingContent']/div[1]/div[2]/div[2]/div[2]/div[2]/div/a");
            session().waitForPageToLoad("30000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37-cat-Middle+Eastern+and+African-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_restaurants8() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=reset");
            session().waitForPageToLoad("30000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-restaurants-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Nightlifepoi() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Nightlifepoi);
            session().waitForPageToLoad("30000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-nightlife-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Nightlife1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Nightlife1);
            session().waitForPageToLoad("30000");
            String s = session().getLocation();


            result = s.contains("/travel-guide/American+Century+Theater-Washington+DC-nightlife-District+of+Columbia-United+States:37:129010");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Nightlifemap() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Nightlifemap);
            session().waitForPageToLoad("30000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Big+Bear+Cafe-Washington+DC-nightlife-District+of+Columbia-United+States:37:381822-maps");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nightlifefacet1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=Baltimore Nightlife");
            session().waitForPageToLoad("30000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Baltimore-nightlife-Maryland-United+States:357");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_nightlifefacet2() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(nightlifefacet2);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-District+of+Columbia-United+States-Grand+Hyatt+Washington:37:536083-hotel-detail");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Travelguide() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Travelguide);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/United-States/Maryland/Ocean-City");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Nightlife2() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Nightlife2);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-nightlife-District+of+Columbia-United+States:37-name-P-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Attractions() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
           session().click("link=Adams-Morgan");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("travel-guide/Adams-Morgan-Washington+DC-attractions-District+of+Columbia-United+States:37:55372");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Attractions1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Attractions1);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Richmond-attractions-Virginia-United+States:325");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_ThingstoDo() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(ThingstoDo);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Carlyle+House-Washington+DC-things-to-do-District+of+Columbia-United+States:37:282939483");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Events() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Events);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-events-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_Events1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(Events1);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/American+University+Eagles+Basketball-Washington+DC-events-District+of+Columbia-United+States:37:321277964");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo1() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=Creating the United States");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            session().close();
            session().stop();
            result = s.contains("/travel-guide/Creating+the+United+States-Washington+DC-things-to-do-District+of+Columbia-United+States:37:10629:8882");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo2() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("category");
            session().click("//div[@id='categoryList']/div[2]/div/ul/li[1]/a/span");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-things-to-do-District+of+Columbia-United+States:37-cat-Others-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo3() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("link=Bob Hope and American Variety");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Bob+Hope+and+American+Variety-Washington+DC-things-to-do-District+of+Columbia-United+States:37:14623176:8882");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo4() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("poiName");
            session().click("link=M");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-things-to-do-District+of+Columbia-United+States:37-name-M-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo5() {
        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("neighborhood");
            session().click("//div[@id='neighborhoodList']/div[2]/div/ul/li[2]/a/span");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-things-to-do-District+of+Columbia-United+States:37-nh-National+Mall-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo6() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(thingstodo6);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("travel-deals/Philadelphia-Pennsylvania-United+States:51");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo7() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(thingstodo7);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-hotels-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_thingstodo8() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(thingstodo8);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            
            result = s.contains("/travel-guide/Washington+DC-things-to-do-District+of+Columbia-United+States:37-name-D-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events2() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("category");
            session().click("//div[@id='categoryList']/div[2]/div/ul/li[4]/a/span");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-events-District+of+Columbia-United+States:37-cat-Venues-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events3() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
           	session().click("neighborhood");
	 	   session().click("//div[@id='neighborhoodList']/div[2]/div/ul/li[2]");
           session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("travel-guide/Washington+DC-events-District+of+Columbia-United+States:37-nh-Adams-Morgan-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events4() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(events4);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Bugs+Bunny+On+Broadway-Washington+DC-events-District+of+Columbia-United+States:37:321326252");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events5() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(events5);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-things-to-do-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events6() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(events6);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-events-District+of+Columbia-United+States:37-name-V-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events7() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(events7);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-events-District+of+Columbia-United+States:37-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events8() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(events8);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/WWE+-+World+Wrestling+Entertainment-Washington+DC-events-District+of+Columbia-United+States:37:321321206");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events9() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(events9);
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-District+of+Columbia-United+States-The+Hay+Adams+Hotel:37:049735-hotel-detail");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_events10() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("eventsName");
            session().click("link=M");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();

            result = s.contains("/travel-guide/Washington+DC-events-District+of+Columbia-United+States:37-nh-All+other+neighborhoods-name-M-sort-name-asc-page-1");
         
            session()

            .stop();
            closeSession();


            } catch (Exception e) {
                e.printStackTrace();


         session
             ().stop();
            try {
                closeSession();
            } catch (Exception en) {
                en.printStackTrace();
            }
        }

        if (result) {
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

    public String check_attractions2() {

        try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click("neighborhood");
            session().click("//div[@id='neighborhoodList']/div[2]/div/ul/li[3]/a/span");
            session().waitForPageToLoad("50000");
            String s = session().getLocation();
            session().close();
            session().stop();
            result =s.contains("/travel-guide/Washington+DC-attractions-District+of+Columbia-United+States:37-nh-National+Mall-sort-name-asc-page-1");

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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

public String check_attractions3() {

       try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
       	session().click("poiName");
		session().click("link=T");
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
   
       result =s.contains("/travel-guide/Washington+DC-attractions-District+of+Columbia-United+States:37-name-T-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

public String check_attractions4() {

         try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(attractions4);
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
        session().close();
        session().stop();
       result =s.contains("/travel-guide/Washington+DC-attractions-District+of+Columbia-United+States:37-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }



public String check_attractions5() {

        try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(attractions5);
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
    
       result =s.contains("/travel-guide/Philadelphia-attractions-Pennsylvania-United+States:51");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }

public String check_attractions6(){

        try { startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click("neighborhood");
        session().click("//div[@id='neighborhoodList']/div[2]/div/ul/li[4]/a/span");
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
     
       result =s.contains("/travel-guide/Washington+DC-attractions-District+of+Columbia-United+States:37-cat-Children-nh-Arlington-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }


public String check_attractions7() {

         try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
            session().click(attractions7);
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
 
       result =s.contains("/travel-guide/Washington+DC-attractions-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }


public String check_attractions8() {

         try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(attractions8);
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
        session().close();
        session().stop();
       result =s.contains("/travel-guide/Washington+DC-things-to-do-District+of+Columbia-United+States:37");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }


public String check_attractions9() {

       try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
        session().click(attractions9);
        session().waitForPageToLoad("50000");
        String s=session().getLocation();
        session().close();
        session().stop();
       result =s.contains("travel-guide/United-States/Maryland/Baltimore");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }


public String check_attractions10() {

         try {startSession(seleniumHost, seleniumPort, browser, webSite);
            session().setTimeout(TIMEOUT);
            session().open(url);
      session().click("poiName");
		session().click("link=M");
        session().waitForPageToLoad("50000");
          String s=session().getLocation();
      
       result =s.contains("travel-guide/Washington+DC-attractions-District+of+Columbia-United+States:37-name-M-sort-name-asc-page-1");
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
            return "Test Passed";
        } else {
            return "Test Failed";
        }
    }


}