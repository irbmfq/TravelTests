/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package travelQa;
import fit.ColumnFixture;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
public class seoMetaData2 extends ColumnFixture {

    public String url;
    public String Title;
    public String MetaKeyword;
    public String MetaDescription;
    public String comments = "";
    boolean status = true;
    public static final String TIMEOUT = "120000";
    public String seleniumHost = "localhost";
    public int seleniumPort = 4441;
    public String browser = "*chrome";
    public String webSite = "http://travel.com";
    protected void startSession(String seleniumHost, int seleniumPort, String browser, String webSite) throws Exception {
        startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
    }

    protected void closeSession() throws Exception {
        closeSeleniumSession();
    }

    public String Verify() {
    	try {
            startSession(seleniumHost, seleniumPort, browser, webSite);
            session().open(url);
            session().waitForPageToLoad("60000");
            Title = session().getTitle();
            try {
                MetaKeyword = session().getAttribute("//meta[@name='keywords']/@content");

            } catch (Exception e) {
                try {
                    MetaKeyword = session().getAttribute("//meta[@name='KEYWORDS']/@content");


                } catch (Exception e1) {
                    try {
                        MetaKeyword = session().getAttribute("//meta[@name='Keywords']/@content");
                    } catch (Exception e2) {
                        status = false;
                        comments = comments + "* Meta Keywords not present\n";
                    }
                }
            }
            try {
                MetaDescription = session().getAttribute("//meta[@name='description']@content");

            } catch (Exception e) {
                try {
                    MetaDescription = session().getAttribute("//meta[@name='DESCRIPTION']@content");
                } catch (Exception e1) {

                    try {
                        MetaDescription = session().getAttribute("//meta[@name='Description']@content");
                        System.out.println(MetaDescription);
                    } catch (Exception e2) {
                        status = false;
                        comments = comments + "* Meta Description not present\n";
                    }
                }
            }
            System.out.println(MetaKeyword);
            System.out.println(MetaDescription);
            session().stop();
            closeSession();
            if (Title!="" && MetaKeyword!="" && MetaDescription!=""){
            	status = true;
            }

    	}catch(Exception e){
        		e.printStackTrace();
        		session().stop();
        		status = false;
        		try{
                closeSession();
        		}catch(Exception en){
        			en.printStackTrace();
        		}
        	}
    	if(status){
    		return "Passed";
    	}
    	else{
    		return "Failed";
    	}

}
}




