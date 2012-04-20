package travelQa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class GoogleSuggest {
	    public static void main(String[] args) throws Exception {
	        // The Firefox driver supports javascript 
	        WebDriver driver = new FirefoxDriver();
	        
	        // Go to the Google Suggest home page
	        driver.get("http://www.google.com/webhp?complete=1&hl=en");
	        
	        // Enter the query string "Cheese"
	        WebElement query = driver.findElement(By.name("q"));
	        query.sendKeys("Selenium");

	        // Sleep until the div we want is visible or 5 seconds is over
	        long end = System.currentTimeMillis() + 5000;
	        while (System.currentTimeMillis() < end) {
	            // Browsers which render content (such as Firefox and IE) return "RenderedWebElements"
	            RenderedWebElement resultsDiv = (RenderedWebElement) driver.findElement(By.className("gac_m"));

	            // If results have been returned, the results are displayed in a drop down.
	            if (resultsDiv.isDisplayed()) {
	              break;
	            }
	        }

	        // And now list the suggestions
	        List<WebElement> allSuggestions = driver.findElements(By.xpath("//td[@class='gac_c']"));
	        
	        for (WebElement suggestion : allSuggestions) {
	            System.out.println(suggestion.getText());
	        }
	     }
	}

