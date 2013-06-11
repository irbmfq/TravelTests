package travelQa;

import java.io.File;
import java.util.Collection;
import com.thoughtworks.selenium.DefaultSelenium;
//import de.michaeltamm.*;
import fit.ColumnFixture;
import fit.Counts;
//import fitnesse.trinidad.FitNesseRepository;
//import fitnesse.trinidad.FitTestEngine;
//import fitnesse.trinidad.TestRunner;

public class layoutBugs extends ColumnFixture {

	public String imagepath = "C:\\wamp\\www\\output\\layoutbugs\\";
	public static String fitnesse_repository = "C:\\root\\fitnesse";
	public static String fitnesse_dump = "C:\\wamp\\www\\output\\layoutbugsdump\\";

	DefaultSelenium selenium;
	public String url, pagename, status;
	public static String testright, testwrong, testexceptions, testname,summary;
	public static Counts cs;
	public static int right, wrong, exceptions, totalright, totalwrong,totalexceptions;

	public String checkbugs() {
		 //FirefoxDriver driver = new FirefoxDriver();


		try {
			 selenium = new DefaultSelenium("localhost", 4444, "*chrome", url);
			 selenium.start();
	         selenium.open(url);

			String filesavepath = imagepath + pagename;
			System.out.println(filesavepath);
		    String testPageUrl = url;
            //driver.get(testPageUrl);
		    selenium.open(url);

//		    FightingLayoutBugs flb = new FightingLayoutBugs();
//			flb.disable(DetectNeedsHorizontalScrolling.class);
//			flb.disable(DetectInvalidImageUrls.class);
//			new File(filesavepath).delete();
//			new File(filesavepath).mkdir();
//			flb.setScreenshotDir(new File(filesavepath));
//			//final Collection<LayoutBug> layoutBugs = flb
//			//		.findLayoutBugsIn(driver);
//			final Collection<LayoutBug> layoutBugs = flb
//					.findLayoutBugsIn(selenium);
//
//			System.out.println("Found " + layoutBugs.size() + " layout bug(s)");
//			for (LayoutBug bug : layoutBugs) {
//				System.out.println(bug);
//				status = "Complete";
//			}
		} catch (Exception e) {
			e.printStackTrace();
			status = "Failed";
		} finally {
				//driver.quit();
				selenium.close();
				selenium.stop();
				status = "Complete";
		}
		return status;

	}

	public static void main(String argvs[]) {

		try {

//			TestRunner tdd = new TestRunner(new FitNesseRepository(
//					fitnesse_repository), new FitTestEngine(),
//					fitnesse_dump);
//
//			cs = tdd.runTest("FrontPage.TravelTestsQa.LayoutBugs");
			right = cs.right;
			wrong = cs.wrong;
			exceptions = cs.exceptions;
			totalright = right + totalright;
			totalwrong = wrong + totalwrong;
			totalexceptions = exceptions + totalexceptions;

			System.out.println(" Test Passed " + totalright);
			System.out.println(" Test Failed  : " + totalwrong);
			System.out.println(" Test Exceptions  : " + totalexceptions);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
