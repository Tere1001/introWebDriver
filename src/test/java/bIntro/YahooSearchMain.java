package bIntro;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchMain {
	
	

	public static void main(String[] args) {
		//INICIALIZACION DE SYSTEM.SETPROPERTY()
	    WebDriver driver;
		driver = new ChromeDriver();  //arranca el navegador, obvio Chrome
		driver.manage().timeouts().implicitlyWait(30,  TimeUnit.SECONDS); //configura las esperas implicitas hasta 30 segundos
		driver.get("http://www.yahoo.com"); //navega a la url que le indiquemos
		WebElement searchBox = driver.findElement(By.id("header-search-input")); // busca elemento caja de bsqueda
		WebElement searchButton = driver.findElement(By.id("header-desktop-search-button")); // busca elemento de icono de busqueda
		
		searchBox.clear(); // limpia caja de texto
		searchBox.sendKeys("Selenium"); // inserta texto en el campo
		searchButton.click();
		
		WebElement seleniumLink = driver.findElement(By.xpath("//h3[.='Selenium' and ./following-sibling::div[contains(.,'selenium.dev')] ] /a"));// encontro un elemento con xpath que contenga la palabara selenium
		seleniumLink.click();
		

		System.out.println("Number of windows: " + driver.getWindowHandles().size()); // se obtiene el numero de ventanas abiertas
		
		for(String windowId: driver.getWindowHandles()) { // obtiene la lista de ventanas
			driver.switchTo().window(windowId); // pasa de una ventana a otra
		}
		
		WebElement downloadLink = driver.findElement(By.linkText("Downloads")); // busca el elemento de descargas
		downloadLink.click(); // da clic en el enlace
		
		driver.quit(); // cierra todo

	}

}
