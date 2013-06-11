/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package travelQa;
import fit.ColumnFixture;
import com.thoughtworks.selenium.*;

public class GetOmniValuesTest extends ColumnFixture {
	DefaultSelenium selenium;
	public String Result;
	public String PageType;
	public String PageName;
	public String PageURL;
        
	public int OCount = 0;
	public int BCount = 0;
	public String[] paramOmni ;
	public String[] paramBcon;
	String OmniCall = null;
	String BconCall = null;
        
    /*public static String ip="10.146.174.85";
    public static String port="4444";
    public static String browser="*chrome";
    public static String baseurl="http://shopping-qa.web.travel.com/";*/
    public String hostname;
    public int port;
    public String browser;
    public String baseURL;    
    public static String s_account;

	public GetOmniValuesTest(){
		try {
			this.selenium=SetupTeardown.selenium; //new DefaultSelenium(ip,Integer.parseInt(port),browser,baseurl);
                        //selenium.setSpeed("1000");
			selenium.start("captureNetworkTraffic=true");
		} catch (Exception E) {
			System.out.println("Error in function: GetOmniValuesTest" + E);
		}
	}

	public int CallCount() {
		paramOmni = null;
		paramBcon = null;                
		selenium.open(PageURL);
		selenium.waitForPageToLoad("90000");
                System.out.println("URL: " + PageURL);
		String plain = selenium.captureNetworkTraffic("plain"); // image, gif
		String[] plainSplit = plain.split("\n");     
		OCount = 0;
		BCount = 0;
               for (int i = 0; i < plainSplit.length; i++){
			if (plainSplit[i].contains("200 GET http://o.sa.travel.com/b/ss/"+s_account)){
				OCount++;
				OmniCall = plainSplit[i];
				System.out.println("Omniture Call : " + plainSplit[i]);
			}

			if (plainSplit[i].contains("http://b.travel.com/vanity")) {
				BCount++;
				BconCall = plainSplit[i]; //.replaceAll("=&","= &");
				System.out.println("Beacon Call : " + plainSplit[i]);
			}
		}
                
          //      if (plainSplit[i].contains("200 GET http://o.sa.travel.com/b/ss/devtravelinstore,devtravelsvc")
		System.out.println("Number of Omniture Calls: " + OCount);
		if (OCount == 1)
		{
			paramOmni= OmniCall.replace(PageURL,"PageURL").replace("%20", " ").replace("%21", "!").replace("%27", "'").replace("%22", "\"").replace("%2B", "+").replace("%23", "#").replace("%3A",":").replace("%7C","|").replace("%26","&").replace("%24","$").replace("%2C",",").replace("%2F","/").replace("%3E",">").replace("%28","(").replace("%29",")").replace(" & ", " # ").replace("%3F","?").replace("%3D","=").split("&");
		}
		if (BCount == 1)
		{
			paramBcon= BconCall.replace("%20", " ").replace("%27", "'").replace("%22", "\"").replace("%2B", "+").replace("%23", "#").replace("%3A",":").replace("%7C","|").replace("%26","&").replace("%24","$").replace("%2C",",").replace("%2F","/").replace("%3E",">").replace("%28","(").replace("%29",")").replace(" & ", " # ").replace("%3F","?").replace("%3D","=").split("&");
		}
		return OCount;
	}
        
        public int BconCallCount() {
            int temp = CallCount();
            return BCount;
        }

	//For Adding verification for a new omniture parameter the below template can be used (substitute <paramName> with the actual parameter
	/*public String <paramName>(){
	Result = "#";

	try{
	for (int j = 0; j < paramOmni.length; j++)
		if(paramOmni[j].startsWith("<paramName>="))
			Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
	}catch(Exception e){
		System.out.println("<paramName> - Exception: " + e.toString());
	}

	if (Result.equals("#"))
		return "[null]";
	else
		return Result;
	}*/

	public String PageName(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("pageName="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1].replaceAll("%28","(").replaceAll("%29", ")").replaceAll("%3E", ">").replaceAll("%3F", "?").replaceAll("%3D", "=");
		}catch(Exception e){
			System.out.println("PageName - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}
        
       public String ch(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("ch="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("ch - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c1(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c1="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1].replaceAll("%28","(").replaceAll("%29", ")").replaceAll("%3E", ">").replaceAll("%3F", "?").replaceAll("%3D", "=");
		}catch(Exception e){
			System.out.println("c1 - Exception: " + e.toString());
		}

		//For identifying trailing white spaces
		if(Result.matches("[a-z]*[ ]:[ ]"))
			Result = Result.replace(" : "," :#");

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c2(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c2="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1].replaceAll("%28","(").replaceAll("%29", ")").replaceAll("%3E", ">").replaceAll("%3F", "?").replaceAll("%3D", "=");
		}catch(Exception e){
			System.out.println("c2 - Exception: " + e.toString());
		}

		//For identifying trailing white spaces
		if(Result.matches("[a-z]*[ ]:[ ]"))
			Result = Result.replace(" : "," :#");

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c9(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c9="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c9 - Exception: " + e.toString());
		}
		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c13(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c16="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c13 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c18(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c18="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c18 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c19(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c19="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c19 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	public String c20(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c20="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c20 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//AQB parameter (AQB=[null]) - not required

	//AQE parameter
	public String AQE(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("AQE="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("AQE - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//c parameter
	public String c(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//c10 parameter (c10=external web browser)
	public String c10(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c10="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c10 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//c12 parameter
	public String c12(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c12="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1].replaceAll("%3F","?").replaceAll("%3D","=");
		}catch(Exception e){
			System.out.println("c12 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//c13 parameter (c13=non-authenticated) - changes from browser to browser - not required

	//c15 parameter (c15=unavailable) - changes from browser to browser, unavailable for FF <username hash> for IE - not required

	//c24 parameter (Authentication hash value) - changes every session - not required

	//c3 parameter
	public String c3(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c3="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c3 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//c49 parameter
	public String c49(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("c49="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c49 - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//cc parameter
	public String cc(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("cc="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("cc - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//cl parameter
	public String cl(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("cl="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("c - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//events parameter
	public String events(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("events="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("events - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//g parameter
	public String g(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("g="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1].replaceAll("%3F","?").replaceAll("%3D","=");
		}catch(Exception e){
			System.out.println("g - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//j parameter
	public String j(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("j="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("j - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//k parameter
	public String k(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("k="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("k - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//ndh parameter
	public String ndh(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("ndh="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("ndh - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//ns parameter
	public String ns(){
		Result = "#";

		try{
		for (int j = 0; j < paramOmni.length; j++)
			if(paramOmni[j].startsWith("ns="))
				Result = paramOmni[j].replace(" # ", " & ").split("=")[1];
		}catch(Exception e){
			System.out.println("ns - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//t parameter (Timestamp) - Changes based on the time of execution of test - not required

	//v12 parameter - Authentication parameter, changes from browser to browser, [null] for FF <username hash> for IE - not required

	//v14 parameter (A/B Testing, changes across sessions) - not required

	//v15 parameter - changes from browser to browser, [null] for FF and 24 for IE - not required


	public int BConCallCount(){
		int temp = CallCount();
		System.out.println("Number of Beacon Calls: " + BCount);
		return BCount;
	}

	//For Adding verification for a new beacon parameter the below template can be used (substitute <paramName> with the actual parameter
	/*public String <paramName>(){
	Result = "#";

	try{
	for (int j = 0; j < paramBcon.length; j++)
		if(paramBcon[j].startsWith("<paramName>="))
			Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
	}catch(Exception e){
		System.out.println("<paramName> - Exception: " + e.toString());
	}

	if (Result.equals("#"))
		return "[null]";
	else
		return Result;
	}*/
        
        public String sh_pageName(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("sh_pageName=")){
				//System.out.println("4. " + paramBcon[j]);
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("sh_pageName - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else if (Result.isEmpty())
			return "blank";
		else
			return Result;
	}
        
          public String sh_pageURL(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("sh_pageURL=")){
				//System.out.println("4. " + paramBcon[j]);
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("sh_pageURL - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else if (Result.isEmpty())
			return "blank";
		else
			return Result;
	}

	public String dl_task(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("dl_task=")){
				//System.out.println("4. " + paramBcon[j]);
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("dl_task - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else if (Result.isEmpty())
			return "blank";
		else
			return Result;
	}

	//fv?|

	public String fv(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("fv=")){
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("fv - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//h?|
	public String h(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("h=")){
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("h - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//t?|
	public String t(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("t=")){
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("t - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}

	//v?|
	public String v(){
		Result = "#";

		try{
		for (int j = 0; j < paramBcon.length; j++)
			if(paramBcon[j].startsWith("v=")){
				Result = paramBcon[j].replace(" # ", " & ").split("=")[1];
			}
		}catch(Exception e){
			System.out.println("v - Exception: " + e.toString());
		}

		if (Result.equals("#"))
			return "[null]";
		else
			return Result;
	}


	public static void main (String Args[]){

	}
}

