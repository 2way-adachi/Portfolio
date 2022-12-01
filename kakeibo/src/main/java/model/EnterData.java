package model;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterData {
	Duration waittime = Duration.ofSeconds(10);

	public void jsWait(ChromeDriver d) {
		d.manage().timeouts().implicitlyWait(waittime);
	}

	public void nextInput(WebElement element, ChromeDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"confirmation-button\"]"));
		element.click();
	}

	public void inputData(WebElement element, ChromeDriver driver, Category cate, String date, String comment) throws InterruptedException {

		// 日付入力欄
		jsWait(driver);
		element = driver.findElement(By.xpath("//*[@id=\"updated-at\"]"));
		element.click();
		element.clear();
		element.click();
		element.sendKeys(date);
		element.click();

		//	支出金額
		jsWait(driver);
		element = driver.findElement(By.xpath("//*[@id=\"appendedPrependedInput\"]"));
		element.click();
		element.sendKeys(cate.getData());

		//	（大項目）未分類を選択
		jsWait(driver);
		element = driver.findElement(By.xpath("//*[@id=\"js-large-category-selected\"]"));
		element.click();
		Thread.sleep(500);

		//	税率に応じてラージカテゴリーを選択
		jsWait(driver);
		switch (cate.getLargeCategory()) {
		case "食費":
			element = driver.findElement(By.xpath("//*[@id=\"11\"]"));
			break;
		case "日用品":
			element = driver.findElement(By.xpath("//*[@id=\"10\"]"));
			break;
		}
		element.click();

		//	（中項目）未分類を選択
		jsWait(driver);
		element = driver.findElement(By.xpath("//*[@id=\"js-middle-category-selected\"]"));
		element.click();
		Thread.sleep(500);

		//	税率に応じてミドルカテゴリーを選択

		element = driver.findElement(By.xpath(selectMiddleCategory(cate.getDisplayName())));
		element.click();

		//	コメントフィールドを選択
		jsWait(driver);
		element = driver.findElement(By.xpath("//*[@id=\"js-content-field\"]"));
		element.click();
		element.sendKeys(comment);

		//	保存するを選択
		jsWait(driver);
		element = driver.findElement(By.xpath("//*[@id=\"submit-button\"]"));
		element.click();
	}

	public String selectMiddleCategory(String displayName) {
		String result = "";
		switch (displayName) {
		case "弁当"-> result = "//*[@id=\"14623499\"]";
		case "冷凍食品"-> result =  "//*[@id=\"14623500\"]";
		case "健康系食品"-> result = "//*[@id=\"14623520\"]";
		case "飲み物類"-> result = "//*[@id=\"14623519\"]";
		case "お菓子類"-> result = "//*[@id=\"14623517\"]";
		case "加工食品"-> result = "//*[@id=\"14623516\"]";
		case "乳／大豆製品・卵"-> result = "//*[@id=\"14623515\"]";
		case "インスタント食品"-> result = "//*[@id=\"14623513\"]";
		case "パン類"-> result = "//*[@id=\"14623512\"]";
		case "肉・魚"-> result = "//*[@id=\"14623508\"]";
		case "野菜・果物"-> result = "//*[@id=\"14623507\"]";
		case "ミルク/離乳食"-> result = "//*[@id=\"14623505\"]";
		case "調味料・粉類"-> result = "//*[@id=\"14601908\"]";
		
		case "洗濯用品"-> result = "//*[@id=\"14623524\"]";
		case "掃除用品"-> result = "//*[@id=\"14623526\"]";
		case "ヘアケア用品"-> result = "//*[@id=\"14623527\"]";
		case "ボディケア用品"-> result = "//*[@id=\"14623528\"]";
		case "トイレ・紙用品"-> result = "//*[@id=\"14623529\"]";
		case "子育て用品"-> result = "//*[@id=\"46\"]";
		case "ペット用品"-> result = "//*[@id=\"40\"]";
		default ->System.out.println("default");
		}
		return result;
	}
}
