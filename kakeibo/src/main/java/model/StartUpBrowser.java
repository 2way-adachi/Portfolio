package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@Component
//コンポーネントAnnotationのコメントアウトでプログラム停止

public class StartUpBrowser {
	String loginURL = "https://moneyforward.com/";
	String id = "7913ihcad@gmail.com";
	String pw = "YP6b3pxeEAV$7cr";
	WebElement element;

	public StartUpBrowser(PostData pd) throws InterruptedException {
		if (pd != null) {

			EnterData ed = new EnterData();
			System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");

			//		Chrome用Options
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--user-data-dir=C:\\Users\\paroo\\AppData\\Local\\Google\\Chrome\\User Data");
			options.addArguments("--profile-directory=Profile 1");
			options.addArguments("--lang=jp");

			ChromeDriver driver = new ChromeDriver();
			//		JS起動待ち
			ed.jsWait(driver);

			//		ログイン方法選択画面に遷移
			driver.get(loginURL);
			ed.jsWait(driver);
			element = driver.findElement(By.xpath("//*[@id=\"new-before-login-home\"]/div[1]/div[1]/p[1]/a"));
			element.click();

			//		メールアドレスでログインを選択
			ed.jsWait(driver);
			element = driver
					.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/div/div/div[2]/div/a[1]/p"));
			element.click();

			//		メールアドレスを入力して次へ
			ed.jsWait(driver);
			element = driver
					.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/input"));
			element.sendKeys(id);
			element = driver
					.findElement(
							By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/div[4]/input"));
			element.click();

			//		パスワードを入力して次へ
			ed.jsWait(driver);
			element = driver
					.findElement(By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/input[2]"));
			element.clear();
			element.sendKeys(pw);
			element = driver
					.findElement(
							By.xpath("/html/body/main/div/div/div/div/div[1]/section/form/div[2]/div/div[3]/input"));
			element.click();

			//		データ入力画面まで遷移
			ed.jsWait(driver);
			// 家計タブ選択
			element = driver.findElement(By.xpath("//*[@id=\"header-container\"]/header/div[2]/ul/li[2]/a"));
			element.click();
			ed.jsWait(driver);

			// 手入力
			element = driver.findElement(By.xpath("//*[@id=\"kakeibo\"]/section/div[1]/div[1]/div/button"));
			element.click();
			ed.jsWait(driver);

			//		ループはじまり
			for (int i = 0; i < pd.getActiveDataList().size(); i++) {
				ed.inputData(element, driver, pd.getActiveDataList().get(i), pd.getDate(), pd.getComment());
				ed.jsWait(driver);
				ed.nextInput(element, driver);
			}
			driver.quit();
		}
	}
}
