package travelQa;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;
import java.io.*;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import fit.ColumnFixture;

public class createBaseline extends ColumnFixture {
	
	public static final String TIMEOUT = "120000";
	public String browserfolder;
	public String browser;
	public String url;
	public String pagename;
	
	protected void startSession(String seleniumHost, int seleniumPort,
			String browser, String webSite) throws Exception {
		startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
		session().setTimeout(TIMEOUT);
	}

	protected void closeSession() throws Exception {
		closeSeleniumSession();
	}
	
	public String baseline() {
	 
	 String seleniumHost = "localhost";
	 int seleniumPort = 4444;
	 String webSite = url;
		
		String returnMessage = null;
		String filesavepath = "C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\" + pagename + "\\baseline";
		String filename = "\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\" + pagename + "\\baseline\\baseline.png";
		try {			
			if (browser.equals("*safari"))
			{

				new File(filesavepath).delete();
				new File(filesavepath).mkdirs();	
		   
		   //generate screenshot
				
				JSch jsch = new JSch(); 
				jsch.setKnownHosts("C:\\Documents and Settings\\samaitra\\.ssh\\known_hosts");
				
				Session session = jsch.getSession("saikatmaitra", "192.168.0.101",22);			
				session.setPassword("abcd1234");
				session.connect();				  
				String command="python webkit2png/webkit2png.py " + url;
				Channel channel=session.openChannel("exec");
			    ((ChannelExec)channel).setCommand(command);
				channel.setInputStream(null);
				((ChannelExec)channel).setErrStream(System.err);
				InputStream in=channel.getInputStream();

				  channel.connect();

					byte[] tmp=new byte[1024];
					while(true){
					while(in.available()>0){
					int i=in.read(tmp, 0, 1024);
					if(i<0)break;
					System.out.print(new String(tmp, 0, i));
					}
					if(channel.isClosed()){
					System.out.println("exit-status: "+channel.getExitStatus());
					break;
					}
					try{Thread.sleep(1000);}catch(Exception ee){}
					}
					channel.disconnect();
					session.disconnect();			
					
			//copy files from remote mac host
					 String command2="scp saikatmaitra@192.168.0.101:shoppingtravelcom-full.png "+filename;					
					 Runtime run = Runtime.getRuntime() ;
					 Process pr = run.exec(command2) ;
					 
					}
		
			else{
				
				startSession(seleniumHost, seleniumPort, browser, webSite);
				session().setTimeout(TIMEOUT);
				session().open(url);
				session().waitForPageToLoad("50000");
				session().windowMaximize();
				session().windowFocus();			
				new File(filesavepath).delete();
				new File(filesavepath).mkdirs();	
				session().captureEntirePageScreenshot(filename,
								"background=#FFFFFF");
				
				session().stop();
				closeSession();
				
				
			}
			return "Complete";
			
			
			

		} catch (Exception e) {
			e.printStackTrace();				
			try {			
				closeSession();
			} catch (Exception en) {
			
				en.printStackTrace();
			}
		return "Failed to create baseline";
		}

	}

	
}
