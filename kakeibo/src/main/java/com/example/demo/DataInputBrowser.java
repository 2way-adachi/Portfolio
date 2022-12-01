package com.example.demo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DataInputBrowser {
	
	public DataInputBrowser() {
		System.setProperty("webdriver.chrome.driver", "exe/chromedriver.exe");

		//		Chrome用Options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\Users\\paroo\\AppData\\Local\\Google\\Chrome\\User Data");
		options.addArguments("--profile-directory=Profile 1");
		options.addArguments("--lang=jp");
		
		ChromeDriver driver = new ChromeDriver();
	}
}
