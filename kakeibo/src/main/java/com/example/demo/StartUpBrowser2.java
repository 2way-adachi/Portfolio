//package com.example.demo;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
////@Component
////コンポーネントAnnotationのコメントアウトでプログラム停止
//
//public class StartUpBrowser2 {
////	フィールド
////	private WebDriver driver;
////	コンストラクタ
////	@SuppressWarnings("deprecation")
//	public StartUpBrowser2() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver","exe/chromedriver.exe");
////		System.setProperty("webdriver.gecko.driver","exe/geckodriver.exe");
////		FirefoxOptions options = new FirefoxOptions();
////		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
////		DesiredCapabilities capabilities = new DesiredCapabilities();
////		capabilities.setCapability("marionette", true);
//		ChromeOptions options = new ChromeOptions();
//		//		アドオンエラー
////		String profileDir = "C:\\Users\\paroo\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\dhrdj074.default";
////		FirefoxProfile fp = new FirefoxProfile(new File(profileDir));
////	    Capabilities.setCapability(FirefoxDriver.PROFILE, fp);
//
//	    //		Chrome用Options
//		options.addArguments("--user-data-dir=C:\\Users\\paroo\\AppData\\Local\\Google\\Chrome\\User Data");
//        options.addArguments("--profile-directory=Profile 1");
//        options.addArguments("--lang=jp");
////        C:\Users\paroo\AppData\Local\Google\Chrome\User Data\Profile 1
//		
////		driver = new FirefoxDriver(options);
//		ChromeDriver driver = new ChromeDriver();
//		String loginURL = "https://moneyforward.com/";
//		String id = "7913ihcad@gmail.com";
//		String pw = "YP6b3pxeEAV$7cr";
//		
////		JS起動待ち
//		Duration wait = Duration.ofSeconds(10);
//		driver.manage().timeouts().implicitlyWait(wait);
//		
////		ログイン方法選択画面に遷移
//		driver.get(loginURL);
////		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(wait);
//		WebElement element = driver.findElement(By.xpath("/html[@class='home_controller index_action']/body[@id='page-home']/div[@id='wrap']/div[@class='with-ad']/div[@id='new-before-login-home']/div[@class='main-contents-container background-main-visual']/div[@class='web-sign-link-container']/p[@class='web-sign-in']/a"));
//		element.click();
//
////		メールアドレスでログインを選択
//		driver.manage().timeouts().implicitlyWait(wait);
//		element = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/div/div/div[2]/div/a[1]"));
//		element.click();
////		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//
////		メールアドレスを入力して次へ
//		driver.manage().timeouts().implicitlyWait(wait);
//		element = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/input"));
//		element.sendKeys(id);
//		element = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/div[4]/input"));
//		element.click();
////		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(wait);
//		
////		WebElement iframe = driver.findElement(By.cssSelector("iframe:nth-of-type(1)")); 
////		try {
////			driver.switchTo().frame(iframe);	
////		} catch (Exception e) {
////			System.out.println("switch失敗");
////		}
////		パスワードを入力して次へ
//		element = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/input[2]"));
////		System.out.println("iframeここから");
////		System.out.println(iframe);	
//		element.clear();
//		element.sendKeys(pw);
//		element = driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/div[3]/input"));
//		element.click();
////		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//		
//		
//
//		
//	}
//}
