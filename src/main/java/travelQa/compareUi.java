package travelQa;

import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.closeSeleniumSession;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.session;
import static com.thoughtworks.selenium.grid.tools.ThreadSafeSeleniumSessionStorage.startSeleniumSession;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

//import ic.*;
import fit.ColumnFixture;

public class compareUi extends ColumnFixture {

	public static final String TIMEOUT = "120000";
	public String url, browser, pagename, browserfolder;
	
	protected void startSession(String seleniumHost, int seleniumPort,
			String browser, String webSite) throws Exception {
		startSeleniumSession(seleniumHost, seleniumPort, browser, webSite);
		session().setTimeout(TIMEOUT);
	}

	protected void closeSession() throws Exception {
		closeSeleniumSession();
	}

	public String compareui() {
		
		try {
			
			String seleniumHost = "localhost";
			int seleniumPort = 4444;
			String webSite = url;
			startSession(seleniumHost, seleniumPort, browser, webSite);
			session().setTimeout(TIMEOUT);
			session().open(url);
			session().waitForPageToLoad("50000");
			session().windowMaximize();
			session().windowFocus();			
		
			if (browser.equals("*chrome")) {
				browserfolder = "Firefox";
			}
			if (browser.equals("*iehta")) {
				browserfolder = "IE";
			}
			if (browser.equals("*safari")) {
				browserfolder = "Safari";
			}
			
			String baseline = "C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\" + pagename + "\\baseline\\baseline.png";
			String testimage = "C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\"+pagename+"\\"+browserfolder+"\\testimage.png";
			String resultimage = "C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\"+pagename+"\\"+browserfolder+"\\resultimage.png";
		
			
			new File("C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\"
					+ pagename + "\\" + browserfolder).delete();
			new File("C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\"
					+ pagename + "\\" + browserfolder).mkdirs();	
			
			session().captureEntirePageScreenshot(
					"C:\\workspace\\AutomationTestsReport\\WebContent\\CompareUi\\"
							+ pagename + "\\" + browserfolder
							+ "\\testimage.png", "background=#FFFFFF");

			session().stop();
			closeSession();
			
			
//			ImageProcessor img = new ImageProcessor(
//					"C:\\Program Files\\ImageMagick-6.6.2-Q16", 2);
//			img.convertImage(baseline, testimage, resultimage);
//
		System.out.println("image comparison complete");
		return "Complete";
		} catch (Exception e) {
			e.printStackTrace();
			session().stop();
			try {
				closeSession();
			} catch (Exception en) {
				en.printStackTrace();
			}
		}
		return "compareui failed";
	}

	public static void main(String argvs[]){
		new compareUi().compareui();
	}
	
}
