
public class QANewTest {
 
private WebDriver driver;
@BeforeMethod
public void setUp() throws Exception {
// System.setProperty("webdriver.gecko.driver", "C:\\TEMP\\clem2\\geckodriver.exe");
// driver = new FirefoxDriver();
   // System.setProperty("webdriver.chrome.driver", "C:\\TEMP\\clem2\\chromedriver.exe");
//  driver = new ChromeDriver();
 
System.setProperty("webdriver.ie.driver", "C:\\TEMP\\clem2\\IEDriverServer.exe");
driver = new InternetExplorerDriver();
 
 
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 driver.manage().window().maximize();
driver.get("http://www.valtech.com/");
}

@AfterMethod
public void tearDown() throws Exception {
driver.quit();
}
 
@Test()
public void goValtechPage() throws InterruptedException {
Thread.sleep(2000);
String bodyText = driver.findElement(By.xpath("//h2[contains(text(),'Latest news')]")).getText();
System.out.println(bodyText);
Thread.sleep(2000);
Assert.assertTrue(bodyText.toLowerCase().contains("latest news"));
 
// Assert that H1 tag in each page is displaying(SAME for work and services)
Thread.sleep(2000);
 driver.findElement(By.xpath("//a[@href='/about/']")).click();
String h1Text = driver.findElement(By.xpath("//h1[contains(text(),'About')]")).getText();
Thread.sleep(2000);
Assert.assertTrue(h1Text.contains("About"));
Thread.sleep(2000);
 
driver.findElement(By.xpath("//div[@id='navigationMenuWrapper']/descendant::a[position()=2]")).click();
String h1WorkText = driver.findElement(By.xpath("//h1[contains(text(),'Work')]")).getText();
Thread.sleep(1000);
Assert.assertTrue(h1WorkText.contains("Work"));
Thread.sleep(2000);
 
driver.findElement(By.xpath("//div[@id='navigationMenuWrapper']/descendant::a[position()=3]")).click();
String h1servicesText = driver.findElement(By.xpath("//h1[contains(text(),'Services')]")).getText();
Thread.sleep(1000);
Assert.assertTrue(h1servicesText.contains("Services"));
Thread.sleep(2000);
 
 
// Navigate to contact page and output how many VALTECH offices in total
 
driver.findElement(By.xpath("//i[@class='icons glyph' and @data-icon='earth-contact']")).click();
Thread.sleep(2000);
List<WebElement> results = driver.findElements(By.cssSelector(".contactcountry>h3"));
  System.out.println("VALTECH offices in total is "+ results.size());


}

}
