package com.ReusableMethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


	public abstract class Baseclass {

		protected static WebDriver driver;

		// Browser Launch
		protected static void launchingBrowser(String browserName) {
			try {
				if (browserName.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (browserName.equalsIgnoreCase("edge")) {
					driver = new EdgeDriver();
				} else if (browserName.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				}
			} catch (Exception e) {
				Assert.fail("Error : During the Launching Browser");
			}
			driver.manage().window().maximize();
		}

		// WebElement get Text
		protected static void getText(WebElement element) {
			try {
				String text = element.getText();
				System.out.println(text);
			} catch (Exception e) {
				Assert.fail("ERROR OCCURED DURING GETTEXT WEB-ELEMENT");
			}
		}

//		Get Attribute
		protected static void getAttribute(WebElement element, String getAttribute) {
			try {
				String attribute = element.getAttribute(getAttribute);
				System.out.println(attribute);
			} catch (Exception e) {
				Assert.fail("ERROR OCCURED DURING GETATTRIBUTE");
			}
		}

//		Alert
		protected static void alerttype(String type) {
			try {
				Alert alert = driver.switchTo().alert();
				if (type.equalsIgnoreCase("accept")) {
					alert.accept();
				} else if (type.equalsIgnoreCase("dismiss")) {
					alert.dismiss();
				}
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURED DURING ALERT METHOD");
			}
		}

//			WindowHandles
		protected static void windowhandles(int number) {
			try {
				List<String> allwindows = new ArrayList(driver.getWindowHandles());
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURED WHILE WINDOW HANDLES");
			}
		}

	//Launching URL
		protected static void launchingUrl(String url) {
			try {
				driver.get(url);
			} catch (Exception e) {
				Assert.fail("Error : During the URL Launch");
			}
		}
		protected static void waitUntilVisible(WebElement element, int seconds) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
				wait.until(ExpectedConditions.visibilityOf(element));
			} catch (TimeoutException e) {
				Assert.fail("Element not visible after " + seconds + " seconds: " + e.getMessage());
			}
		}

//		Send Keys
		protected static void inputPassing(WebElement element, String value) {
			try {
				element.sendKeys(value);
			} catch (Exception e) {
				Assert.fail("Error : During the Input Value");
			}
		}

//		Browser Terminate
		protected static void terminateBrowser() {
			try {
				driver.quit();
			} catch (Exception e) {
				Assert.fail("Error : During the Terminate Browser");
			}
		}

//		Exit Browser
		protected static void ExitBrowser() {
			try {
				driver.close();
			} catch (Exception e) {
				Assert.fail("Error : During the Exit Browser");
			}
		}

//		Element Click
		protected static void elementclick(WebElement element) {
			try {
				element.click();
			} catch (Exception e) {
				Assert.fail("Error : During the Element Click");
			}
		}

	//Navigation
		protected static void Navigateto(String URL) {
			try {
				if (URL.equalsIgnoreCase("navigateforward")) {
					driver.navigate().forward();
				} else if (URL.equalsIgnoreCase("navigateback")) {
					driver.navigate().back();
				} else if (URL.equalsIgnoreCase("navigaterefresh")) {
					driver.navigate().refresh();
				}
			} catch (Exception e) {
				Assert.fail("Error : During the Navigateto");
			}
		}

	//Implicit & Explicit Wait 
		protected static void implicitwait(String type, int value) {
			try {
				if (type.equalsIgnoreCase("Seconds")) {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
				} else if (type.equalsIgnoreCase("Minutes")) {
					driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(value));
				}
			} catch (Exception e) {
				Assert.fail("Error : During the Time given");
			}
		}

	//SelectDropDown
		protected static void SelectDropDown(WebElement element, String type, String value) {
			try {
				Select select = new Select(element);
				if (type.equalsIgnoreCase("value")) {
					select.selectByValue(value);
				} else if (type.equalsIgnoreCase("text")) {
					select.selectByVisibleText(value);
				} else if (type.equalsIgnoreCase("Index")) {
					select.selectByIndex(Integer.parseInt(value));
				}
			} catch (NumberFormatException e) {
				Assert.fail("Error : During the Time DropDown");
			}
		}

		// js executore like scrollup, scrolldown, scrollbyelement, click and sendkeys
		protected static void javaScriptExecution(WebElement element, String option, String value, String x_axis,
				String y_axis, Object Yaxis) {
			try {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				int Xaxis = Integer.parseInt(x_axis);
				int Xaxis1 = Integer.parseInt(y_axis);
				if (option.equalsIgnoreCase("scrollintoview")) {
					js.executeScript("arguments[0].scrollIntoView()", element);
				} else if (option.equalsIgnoreCase("click")) {
					js.executeScript("arguments[0].click()", element);
				} else if (option.equalsIgnoreCase("sendkeys")) {
					js.executeScript("arguments[0].value=arguments[1];", element, value);
				} else if (option.equalsIgnoreCase("scrollup")) {
					js.executeScript("window.scrollBy(arguments[0],arguments[1];", Xaxis1, Yaxis);
				} else if (option.equalsIgnoreCase("scrolldown")) {
					js.executeScript("window.scrollBy(arguments[0],arguments[1];", Xaxis1, Yaxis);
				}
			} catch (NumberFormatException e) {
				Assert.fail("Error : During the java script execution");
			}
		}

//		Action Driver Click
		protected static void selectAction(WebElement element, String value) {
			try {
				Actions action = new Actions(driver);
				if (value.equalsIgnoreCase("click")) {
					action.click(element).build().perform();
				} else if (value.equalsIgnoreCase("movetoelement")) {
					action.click(element).build().perform();
				} else if (value.equalsIgnoreCase("click and hold")) {
					action.click().build().perform();
				} else if (value.equalsIgnoreCase("double click")) {
					action.click().build().perform();
				} else if (value.equalsIgnoreCase("release")) {
					action.click().build().perform();
				} else if (value.equalsIgnoreCase("contextclick"))
					;
				{
					action.click().build().perform();
				}
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURED DURING ACTION METHOD");
			}
		}

//		Deselect
		protected static void deselecttype(WebElement element, String Value, String Type) {
			try {
				Select select = new Select(element);
				if (Type.equalsIgnoreCase("value")) {
					select.deselectByValue(Value);
				} else if (Type.equalsIgnoreCase("index")) {
					select.deselectByIndex(0);
				} else if (Type.equalsIgnoreCase("text")) {
					select.deselectByVisibleText(Value);
				}
			} catch (Exception e) {
				Assert.fail("ERROR: OCCURED DURING DE-SELECT OPTIONS");
			}
		}

//			ElementSelection
		protected static void ElementSelection(WebElement element, String type) {
			if (type.equalsIgnoreCase("isdisplayed")) {
				boolean displayed = element.isDisplayed();
			} else if (type.equalsIgnoreCase("isenabled")) {
				boolean enabled = element.isEnabled();
			} else if (type.equalsIgnoreCase("isselected")) {
				boolean selected = element.isSelected();
			}
		}

//				TakeScreenShot		
		protected static void screenShot() throws IOException {
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
				File destinationFile = new File("C:\\Users\\sky\\OneDrive\\Desktop\\sune selenium screenshots\\image3.jpg");
				FileHandler.copy(sourceFile, destinationFile);
			} catch (WebDriverException e) {
				Assert.fail("ERROR OCCURED DURING SCREENSHOT");
			}
		}

//					DropDown Selection
		protected static void dropdownselection(WebElement element, String option) {
			try {
				Select select = new Select(element);
				if (option.equalsIgnoreCase("isMultiple")) {
					boolean multiple = select.isMultiple();
					System.out.println(multiple);
				}
			} catch (Exception e) {
				Assert.fail("ERROR OCCURED DURING DROPDOWN SELECTION");
			}
			}
			protected static Robot robot;

			static {
			    try {
			        robot = new Robot();
			    } catch (AWTException e) {
			        Assert.fail("Robot Initialization Failed");
			    }
			}
			protected static void uploadFileWithRobot(String filePath) {
			    try {
			        StringSelection selection = new StringSelection(filePath);
			        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			        
			        robot.delay(1000);
			        robot.keyPress(KeyEvent.VK_CONTROL);
			        robot.keyPress(KeyEvent.VK_V);
			        robot.keyRelease(KeyEvent.VK_V);
			        robot.keyRelease(KeyEvent.VK_CONTROL);
			        
			        robot.delay(1000);
			        robot.keyPress(KeyEvent.VK_ENTER);
			        robot.keyRelease(KeyEvent.VK_ENTER);
			    } catch (Exception e) {
			        Assert.fail("ERROR DURING FILE UPLOAD USING ROBOT");
			    }
			
			}
			
		}
	



