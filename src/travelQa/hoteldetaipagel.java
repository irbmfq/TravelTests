package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class hoteldetaipagel extends ColumnFixture {
    public String url,breadcrumbname;
    public String verifybreadcrumb(){
        DefaultSelenium selenium=new DefaultSelenium("10.146.178.29",4442,"*chrome","http://travel.com");
        selenium.start();
        selenium.open(url);
        selenium.click("link="+breadcrumbname);
        selenium.waitForPageToLoad("50000");
        String breadcrumburl=selenium.getLocation();
        return breadcrumburl;
       
        
    }
    
     public String verifyrecirculation(){
         
        DefaultSelenium selenium=new DefaultSelenium("10.146.178.29",4442,"*chrome","http://travel.com");
        selenium.start();
        selenium.open(url);
        selenium.click("//span[@id='gototxt']/a");
        selenium.waitForPageToLoad("60000");
        String guideurl=selenium.getLocation();
        return guideurl;
                
     }
}
