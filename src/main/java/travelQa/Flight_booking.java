/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import com.thoughtworks.selenium.*;
import fit.ColumnFixture;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

/**
 *
 * @author ragavendraqa
 */
public class Flight_booking extends ColumnFixture
{
    public String url;
    public int number;
    public String flight_type,dateoption,departdate,returndate;
    public boolean result,result1,result_triptype,result_nearport;
//DefaultSelenium selenium = new DefaultSelenium ("localhost",4441, "*chrome" , "http://travel.com/");
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

    public String Checkonewayoption()  {
        String Message = null;
        try{
          startSession(seleniumHost, seleniumPort, browser, webSite);
          session().setTimeout(TIMEOUT);
          session().open(url);
          session().select("flightType",flight_type);
          result_triptype=session().isChecked("tripType");
          result_nearport=session().isChecked("nearbyAirports");
          session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();	
    		}
    	}
                       if (result_triptype==true||result_nearport==true)
                           result=true;
                       else
                           result=false;
                       
                        if (result==false) {  
                           
                            Message="Passed";
                        }
                        else{
                            Message="Failed";
                        }
                       
                       return(Message);

    }
    public String Checkmulticityoption(){
        String Message = null;
        boolean result_from,result_to,result_date,result_time;
		try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
          session().setTimeout(TIMEOUT);
          session().open(url);
			session().select("flightType",flight_type);
             result_triptype=session().isChecked("tripType");
             result_nearport=session().isChecked("nearbyAirports");
                       if (result_triptype==true||result_nearport==true)
                           result=true;
                       else
                           result=false;
                       //Taking the values in the loop	
                       int i=1;
                      do {                                                   
                      result_from=session().isElementPresent("leavingFrom"+i);
                      //System.out.println("the 1stfrom:  "+result_from);
                      result_to=session().isElementPresent("goingTo"+i);
                      //System.out.println("the 1stgo:  "+result_to);
                      result_date=session().isElementPresent("leavingDate"+i);
                     //System.out.println("the 1stDate:  "+result_date);
                      result_time=session().isElementPresent("leavingTime"+i);
                    //  System.out.println("the 1st Time:  "+result_time);
                      i=i+1;
                      if (result_from==false||result_to==false||result_date==false||result_time==false)
                      {
                         //System.out.println("Test is Failed");
                          break;                     
                      }       
                      else
                          result1=true;
                      
                       } while(i<=4);
                       session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
          if (result==false && result1==true)
          {
              Message="Passed";
          }
         else{
              Message="Failed";
              }
          return(Message);
    }
    public String CheckRoundtrip_dateoption()
    {
        String Message = null;        
        java.lang.String dayoption;
        boolean result_class,result_dayoption;	
        try{
          startSession(seleniumHost, seleniumPort, browser, webSite);
          session().setTimeout(TIMEOUT);
          session().open(url);
          session().select("flightType",flight_type);
          session().select("dateTypeSelectOption",dateoption);
          result_triptype=session().isChecked("tripType");
          result_nearport=session().isChecked("nearbyAirports");
         result_class=session().isEditable("classOfService");
         dayoption=session().getText("departDateFlexibility");
                        if (!dayoption.equalsIgnoreCase("+/- 1 day+/- 2 days+/- 3 daysExact day"))
                          result_dayoption=false;                        
                          else
                          result_dayoption=true;
                        if (result_triptype==true||result_nearport==true||result_class==true||result_dayoption==false)
                           result=true;
                       else
                           result=false;
         session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
      if (result==false)
      {
      Message="Passed";                           
      }
      else {
        Message="Failed";                           
          }
        return(Message);       
        
    }
    public String CheckRoundtrip_daterangeoption()
      {
          String Message = null;        
      
        boolean result_class,result_nonstop,result_mostchanges,result_date;

                   try{
                    startSession(seleniumHost, seleniumPort, browser, webSite);
                    session().setTimeout(TIMEOUT);
                    session().open(url);
                    session().select("flightType",flight_type);
                    session().select("dateTypeSelectOption",dateoption);
                       result_triptype=session().isChecked("tripType");
                       result_nearport=session().isChecked("nearbyAirports");
                       result_nonstop=session().isChecked("maxConnections");
                       result_mostchanges=session().isChecked("mostChngPenalties");
                       result_class=session().isEditable("classOfService");
                       result_date=session().isVisible("departDateFlexibility");
                                              
                        if (result_triptype==true||result_nearport==true||result_class==true||result_nonstop==true||result_mostchanges==true||result_date==true)
                           result=true;
                       else
                           result=false;
                       session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
             if (result==false)
             {
              Message="Passed";
             }
             else {
              Message="Failed";                            
                   }                      
              return(Message);
        }
    public String Checkonewy_daterangeoption()
    {
        String Message = null;      
        boolean result_class,result_nonstop,result_mostchanges,result_date;
        
                    try{
                    startSession(seleniumHost, seleniumPort, browser, webSite);
                    session().setTimeout(TIMEOUT);
                    session().open(url);
                    session().select("flightType",flight_type);
                    session().select("dateTypeSelectOption",dateoption);
                       result_triptype=session().isChecked("tripType");
                       result_nearport=session().isChecked("nearbyAirports");
                       result_nonstop=session().isChecked("maxConnections");
                       result_mostchanges=session().isChecked("mostChngPenalties");
                       result_class=session().isEditable("classOfService");
                       result_date=session().isVisible("departDateFlexibility");
                                              
                        if (result_triptype==true||result_nearport==true||result_class==true||result_nonstop==true||result_mostchanges==true||result_date==true)
                           result=true;
                       else
                           result=false;
                       session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
        if (result==false)
        {
         Message="Passed";                            
         }
        else {
       Message="Failed";                            
            }                       
        return(Message);
     }
    public String Checkflightplushoteloption()
    {
        String Message = null;       
        boolean result_class,result_nonstop,result_mostchanges,result_airline;

                      try{
                      startSession(seleniumHost, seleniumPort, browser, webSite);
                      session().setTimeout(TIMEOUT);
                      session().open(url);
                       session().click("tripType");
                       result_nearport=session().isChecked("nearbyAirports");
                       result_nonstop=session().isChecked("maxConnections");
                       result_mostchanges=session().isChecked("mostChngPenalties");
                       result_class=session().isEditable("classOfService");
                       result_airline=session().isEditable("airlineSearchPref");
                                              
                        if (result_nearport==true||result_class==true||result_nonstop==true||result_mostchanges==true||result_airline==true)
                           result=true;
                       else
                           result=false;
                        session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
       if (result==false)
       {
       Message="Passed";                            
        }
        else {
         Message="Failed";
             }
        return(Message);
    
    }
public String getDepartDate()
   {
         Calendar cal=Calendar.getInstance();
               cal.add(Calendar.DATE, +21);
               DateFormat dateFormat =  new SimpleDateFormat("MM/dd/yyyy"); 
        return dateFormat.format(cal.getTime());
    } 
    public String Validatedefaultdate()
            {
        String Message = null; 
        String pagedepart=null;
        String pagereturn=null;
        String sysdepart=null;
        String sysreturn=null;
                       try{
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       pagedepart=session().getValue("leavingDateExact");
                       pagereturn=session().getValue("returningDateExact");
                       Calendar cal=Calendar.getInstance();
                        cal.add(Calendar.DATE, +21);
                        DateFormat dateFormat =  new SimpleDateFormat("MM/dd/yyyy");
                        sysdepart=dateFormat.format(cal.getTime());
                        Calendar cal1=Calendar.getInstance();
                        cal1.add(Calendar.DATE, +28);                     
                        sysreturn=dateFormat.format(cal1.getTime());
                         session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();	
    		}
    	}
     if(!pagedepart.equalsIgnoreCase(sysdepart)||!pagereturn.equalsIgnoreCase(sysreturn))
                  Message="Failed";                       
         else                                     
                  Message="Passed";
             return(Message);    
    }
    public String Checknearairportoption()
    {
        String Message = null;       
        boolean result_class,result_flightplushotel;

                       try{
                       startSession(seleniumHost, seleniumPort, browser, webSite);
                       session().setTimeout(TIMEOUT);
                       session().open(url);
                       session().click("nearbyAirports");
                       result_flightplushotel=session().isChecked("tripType");
                       result_class=session().isEditable("classOfService");
                                              
                        if (result_flightplushotel==true||result_class==true)
                           result=true;
                       else
                           result=false;
                       session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
      if (result==false)
        {
       Message="Passed";
        }
       else {
         Message="Failed";
          }
           return(Message);
    }

 public String Backtobasicsearchlink()
    {
        String Message=null;
        String url1=null;
        String final_url=null;
        java.lang.String page=null; 

                    try{
                    startSession(seleniumHost, seleniumPort, browser, webSite);
                    session().setTimeout(TIMEOUT);
                    session().open(url);
                    url1=url.substring(0,(url.length()-1));                   
                    session().click("link=Back to basic search");
                    session().waitForPageToLoad("100000");
                    page=session().getLocation();
                    session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();	
    		}
    	}

                 if(page.contains("/flight"))
                     Message="Passed";
                 else                 
                 Message="Failed";
                 
        return Message;
    }
    public String Validatechildrenoption()
    {
        String Message=null;       
        String n=null;       

          try{
          startSession(seleniumHost, seleniumPort, browser, webSite);
          session().setTimeout(TIMEOUT);
          session().open(url);
         if (number==1)
         {
             n="1";
           session().select("children",n);
           result=session().isElementPresent("minorsAge0");
           if (result==true)
               Message="Passed";
           else
               Message="Failed";           
         }
         if (number==2)
         {
             n="2";
           session().select("children",n);
           result=session().isElementPresent("minorsAge1");
           if (result==true)
               Message="Passed";
           else
               Message="Failed";            
         }
         if (number==3)
         {
             n="3";
           session().select("children",n);
           result=session().isElementPresent("minorsAge2");
           if (result==true)
               Message="Passed";
           else
               Message="Failed";           
         }
         if (number==4)
         {
             n="4";
           session().select("children",n);
           result=session().isElementPresent("minorsAge3");
           if (result==true)
               Message="Passed";
           else
               Message="Failed";           
         }
          if (number==5)
         {
             n="5";
           session().select("children",n);
           result=session().isElementPresent("minorsAge4");
           if (result==true)
               Message="Passed";
           else
               Message="Failed";            
         }
          session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
                   
                      
         return Message;
    }
    public String verifyFromToMissingAlert()
    {
        String Message=null;
        String alert1=null;
         
         try{
         startSession(seleniumHost, seleniumPort, browser, webSite);
          session().setTimeout(TIMEOUT);
          session().open(url);
         session().click("//button[@type='submit' and @onclick=\"var s_265=s_gi(s_account);s_265.linkTrackVars='eVar4';s_265.eVar4='Flights | Travelocity - '+pageTitle;s_265.tl(this,'o','Flights | Travelocity - '+pageTitle); doSubmit();\"]");
         alert1=session().getAlert();
         session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
         if(alert1.equalsIgnoreCase("Please enter a departure city or airport code of 3 to 40 characters.\nPlease enter an arrival city or airport code of 3 to 40 characters."))
        {
        Message="Passed";        
         }
        else{
          Message="Failed";
            }
       return Message;
   }
    public String verifyDatevalidationAlert()
    {
        String Message=null;
        String alert1=null;
        
        try{
        startSession(seleniumHost, seleniumPort, browser, webSite);
        session().setTimeout(TIMEOUT);
        session().open(url);
         session().type("leavingFromFL", "LAX");
         session().type("goingToFL", "WAS");
         session().select("dateLeavingTime", "Morning");
         session().select("dateReturningTime", "Evening");
          session().click("leavingDateExact");
         result= session().isElementPresent(departdate);
         if (result==true)
          session().click(departdate);
         else
            {
             session().click("//img[@alt='Next Month']");
             session().click("link=2");
             }
         session().click("returningDateExact");
        result= session().isElementPresent(returndate);
         if (result==true)
           session().click(returndate);
         else
            {
             session().click("//img[@alt='Next Month']");
             session().click("link=1");
             }          
          session().click("flightsLobBtn");
         alert1= session().getAlert();
         session().stop();
        closeSession();
    	}catch(Exception e){
    		e.printStackTrace();
    		session().stop();
    		try{
            closeSession();
    		}catch(Exception en){
    			en.printStackTrace();
    		}
    	}
         
         if(alert1.equalsIgnoreCase("Return date cannot be earlier than departure date."))
          {
        Message="Passed";        
          }
        else {
            Message="Failed";
             }
        return Message;
  }
    
    
     public static void main(String argv[]) 
    {
        // Main functions
        new Flight_booking().Checkonewayoption();
        new Flight_booking().Checkmulticityoption();
        new Flight_booking().CheckRoundtrip_dateoption();
        new Flight_booking().CheckRoundtrip_daterangeoption();
       new Flight_booking().Checkonewy_daterangeoption();
       new Flight_booking().Checkflightplushoteloption();
        new Flight_booking().Validatedefaultdate();
       new Flight_booking().Checknearairportoption();
       new Flight_booking().Backtobasicsearchlink();
       new Flight_booking().Validatechildrenoption();
       new Flight_booking().verifyFromToMissingAlert();
       new Flight_booking().verifyDatevalidationAlert();
       
        
      
        
        
    }

}
