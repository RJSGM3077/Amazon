import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Trail
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("qa testing for beginners" +Keys.ENTER);
		//driver.findElement(By.linkText("<a class=\"a-link-normal a-text-normal\" href=\"/gp/slredirect/picassoRedirect.html/ref=pa_sp_atf_aps_sr_pg1_1?ie=UTF8&amp;adId=A03355464GB6359Q7LU8&amp;url=%2FUnit-Testing-Principles-Practices-Patterns%2Fdp%2F1617296279%2Fref%3Dsr_1_1_sspa%3Fdchild%3D1%26keywords%3Dqa%2Btesting%2Bfor%2Bbeginners%26qid%3D1625526653%26sr%3D8-1-spons%26psc%3D1&amp;qualifier=1625526653&amp;id=234085936326357&amp;widgetName=sp_atf\"><span class=\"a-size-medium a-color-base a-text-normal\">Unit Testing Principles, Practices, and Patterns: Effective testing styles, patterns, and reliable automation for unit testing, mocking, and integration testing with examples in C#</span> </a> "));
		
	
		WebElement price = driver.findElement(By.xpath("//div[@data-index='1']//a[@class='a-size-base a-link-normal a-text-normal']/span[@data-a-size='l']/span[@class='a-offscreen']"));
		//price.getAttribute("price");
		price.getText();
		System.out.println("price is"+price.getText());
		
		WebElement link = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div[1]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/div[2]/div/div/div[1]/h2/a/span"));
		link.click();
		
		WebElement Cart = driver.findElement(By.id("add-to-cart-button"));
		Cart.click();
		
		WebElement addtocart = driver.findElement(By.id("hlb-ptc-btn-native"));
		addtocart.click();
		
		WebElement Username = driver.findElement(By.id("ap_email"));
		Username.sendKeys("manikandan1999@gmail.com");
		
		WebElement Continue = driver.findElement(By.id("Username"));
		Continue.click();
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Cse_4041");
		
		WebElement Signin = driver.findElement(By.id("signInSubmit"));
		Signin.click();
		
		WebElement Nothanks = driver.findElement(By.className("prime-nothanks-button prime-checkout-continue-link primeEvent checkout-continue-link a-button-text"));
		Nothanks.click();
		
    }
}


