package travelQa;

import net.htmlparser.jericho.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.net.*; //import com.travel.pubt.forc.cfg.PropertyBag;
import net.htmlparser.jericho.Source;
import com.thoughtworks.selenium.DefaultSelenium;
import fit.ColumnFixture;

public class layoutDifferenceSeleniumRc extends ColumnFixture {

	public String url, pagename, pageproperty, browser, status;
	DefaultSelenium selenium;
	UUID batchId = UUID.randomUUID();

	public String checkdiff() {
		try {

			if (browser.equals("IE")) {
				selenium = new DefaultSelenium("travel-qa.office.travel.com", 4444,
						"IE6 on Windows", url);
			 
			} else {
				selenium = new DefaultSelenium("travel-qa.office.travel.com", 4444, "FF30 on Windows",
						url);

			}

			selenium.start();
			selenium.setTimeout("30000000");
			selenium.open(url);
			selenium.waitForPageToLoad("50000");
			selenium.windowMaximize();

			String dbhost = "jdbc:mysql://localhost/automation?user=root";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(dbhost);

			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String currentTime = sdf.format(dt);
			
			long lDateTime = new Date().getTime();
		  
		    
			java.text.SimpleDateFormat sdfd = new java.text.SimpleDateFormat(
			"yyyy-MM-dd");
			String currentDate = sdfd.format(dt);
			
			String screenshot = pagename + lDateTime + browser + ".png";
			
			
			selenium.windowFocus();
			selenium.captureEntirePageScreenshot(
					"C:\\wamp\\www\\output\\layoutdifference\\" + screenshot
							+ "", "background=#FFFFFF");

			String sourceUrlString = url;
			if (args.length == 0)
				System.err.println("Using default argument of \""
						+ sourceUrlString + '"');
			else
				sourceUrlString = args[0];
			if (sourceUrlString.indexOf(':') == -1)
				sourceUrlString = "file:" + sourceUrlString;
			MicrosoftTagTypes.register();
			PHPTagTypes.register();
			PHPTagTypes.PHP_SHORT.deregister(); // remove PHP short tags for

			MasonTagTypes.register();
			Source source = new Source(new URL(sourceUrlString));
			List<Element> elementList = source
					.getAllElements();
			
			Number body_width = selenium.getElementWidth("//html/body");
			Number body_height = selenium.getElementHeight("//html/body");
			Number body_x = selenium.getElementPositionLeft("//html/body");
			Number body_y = selenium.getElementPositionTop("//html/body");
			
			String sql1 = "insert into layout(url,pagename,pageProperty,browser,elementName,elementPositionleft,elementPositionTop,elementwidth,elementHeight,createdTime,batchId,screenShot) values ('"
				+ url
				+ "','"
				+ pagename
				+ "','"
				+ pageproperty
				+ "','"
				+ browser
				+ "','body"				
				+ "',"
				+ body_x
				+ ","
				+ body_y
				+ ","
				+ body_width
				+ ","
				+ body_height
				+ ",'"
				+ currentTime
				+ "','"
				+ batchId
				+ "','"
				+ screenshot + "')";
		PreparedStatement ps1 = conn.prepareStatement(sql1);
		// System.out.println(sql);

		ps1.execute(sql1);
		ps1.close();
			
			
			for (Element element : elementList) {
				if (element.getAttributeValue("id") != null) {
					String idvalue = element.getAttributeValue("id");
					String elementname = element.getName();
					Number x = selenium.getElementPositionLeft(idvalue);
					Number y = selenium.getElementPositionTop(idvalue);
					Number width = selenium.getElementWidth(idvalue);
					Number height = selenium.getElementHeight(idvalue);

					String sql = "insert into layout(url,pagename,pageProperty,browser,elementName,elementPositionleft,elementPositionTop,elementwidth,elementHeight,createdTime,batchId,screenShot) values ('"
							+ url
							+ "','"
							+ pagename
							+ "','"
							+ pageproperty
							+ "','"
							+ browser
							+ "','"+elementname+"."
							+ idvalue
							+ "',"
							+ x
							+ ","
							+ y
							+ ","
							+ width
							+ ","
							+ height
							+ ",'"
							+ currentTime
							+ "','"
							+ batchId
							+ "','"
							+ screenshot + "')";
					PreparedStatement ps = conn.prepareStatement(sql);
					// System.out.println(sql);

					ps.execute(sql);
					ps.close();

				}
			}

			status = "Complete";

		} catch (Exception e) {
			e.printStackTrace();
			status = "Failed";
		} finally {
			selenium.close();
			selenium.stop();

		}
		return status;

	}

}
