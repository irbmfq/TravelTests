package travelQa;

import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;


import java.io.File;
import java.util.UUID;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.HttpCommandProcessor;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.ie.*;

public class screenShot {
	UUID batchId = UUID.randomUUID();
	public static final String TIMEOUT = "12000000";	
	
	public void IE8(){
		 
	        try {
	        	String filepattern="samaitra"+"_IE8_"+batchId;
	        	//String filename = "C:\\wamp\\www\\output\\baseline\\"+ filepattern + ".png";
	        	String filename = "C:\\"+ filepattern + ".png";
	        	
	        	//DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "*iexploreproxy", "http://travel.travel.com");
	        		
	        	DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, "*iehta", "http://travel.com");
	        	selenium.start();	
	        		//selenium.setTimeout(TIMEOUT);
					selenium.open("http://travel.com");
					selenium.waitForPageToLoad("50000");
					selenium.windowMaximize();
					selenium.windowFocus();
	                System.out.println("the filename is :"+filename);	                                
	                selenium.getEval("this.takeNewScreenshot(\""+filename+"\",\"background=#FFFFFF\")");
					//selenium.captureEntirePageScreenshot(filename,"background=#FFFFFF");	                
	                selenium.stop();
        		} catch (Exception e) {
				e.printStackTrace();
			}	
	    }
	
public static void main(String[] argvs){
	new screenShot().IE8();
}	
}
