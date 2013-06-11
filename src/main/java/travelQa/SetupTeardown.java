/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;

/**
 *
 * @author praveens14
 */

import com.thoughtworks.selenium.*;
import fit.ColumnFixture;

public class SetupTeardown extends  ColumnFixture{
	public String hostname;
	public int port;
	public String browser;
	public String baseURL;
	public static DefaultSelenium selenium;
	//Process pcsFiddler;

	public boolean SetUp(){
		try{
			selenium = new DefaultSelenium(hostname ,port , browser , baseURL);	
			return true; 
		}catch(Exception E){
			return false;
		}
	}
	public boolean teardown(){
		try{
			selenium.stop();			
			return true;
		}catch(Exception E){
			return false;
		}
	}
}