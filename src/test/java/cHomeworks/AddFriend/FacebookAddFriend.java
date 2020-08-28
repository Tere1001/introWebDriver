package cHomeworks.AddFriend;

import bIntro.ParentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FacebookAddFriend extends ParentTest {
	private static WebElement driver;


	public static void main(String[] args) {
		setUp();
		testFriendSearch("Monica Galindo");
		tearDown();

	}

	private static void testFriendSearch(String friendName) {
		loginToFacebook("username", "password");
		searchFriend(friendName);
		addFriend(friendName);
		
	}

	private static void addFriend(String friendName) {
		inputText(By.id(""), friendName);
		clickElement(By.id(""));
		
	}

	private static void searchFriend(String friendName) {

		inputText(By.name("q"), friendName);
		clickElement(By.xpath("//*[@data-testid='facebar_search_button']"));
		verifyLinkExists(friendName);
		
	}

	private static void loginToFacebook(String email, String password) {

		//campoUsuario css "#email"
		WebElement campoUsuario = driver.findElement(By.cssSelector("#email"));
		campoUsuario.sendKeys(email);
		//campoContrasena css "#pass"
		WebElement campoContrasena = driver.findElement(By.cssSelector("#pass"));
		campoContrasena.sendKeys(password);
		//botonIniciarSesion  css "[value='Iniciar sesión']"
		WebElement botonIniciarSesion = driver.findElement(By.cssSelector("[data-testid='royal_login_button']"));
		botonIniciarSesion.click();
	}

}
