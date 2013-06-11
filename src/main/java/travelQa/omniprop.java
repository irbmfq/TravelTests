/*
 * magicNumbers.java
 *
 * Created on July 10, 2008, 4:50 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package travelQa;
import com.thoughtworks.selenium.*;
/**
 *
 * @author samaitra
 */
public class omniprop {

    /** Creates a new instance of magicNumbers */
    public void omnipropTest() {
        DefaultSelenium sel = new DefaultSelenium("localhost",4441,"*chrome","http://travel.com");
        
        sel.start();
        try{
        sel.open("/travel-guide/Williston-North+Dakota-United+States:368716-hotels");
        }
        catch(Exception e){
        sel.waitForPageToLoad("60000");
        }
        
       // System.out.println(sel.getText("//script[@src='http://o.travelcdn.com/omniunih.js']"));
        String s = sel.getBodyText();
        s=s.substring(s.indexOf("s_265.prop2"));
        s = s.substring(0 , s.indexOf(";"));
        if(s.contains("DG Hotels Listing"))
        {
        System.out.print("omniprop Test Passed");
        }
        else
        {
        System.out.print("Failed");
        }     
            
        //System.out.println(s);
        
        
        
        
        sel.stop();
        
        
    }
    
    public static void main(String argv[]){
    new omniprop().omnipropTest();
    }
    
}
