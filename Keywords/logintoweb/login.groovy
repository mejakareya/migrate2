package logintoweb

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.support.Color;

import internal.GlobalVariable

public class login {


	@Keyword
	def uiVerification(){
		WebUI.verifyElementText(findTestObject('Object Repository/loginObject/Page_Login/header_Log In'), 'Log In')
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'), 'placeholder', 'Email', 0)
		WebUI.verifyElementAttributeValue(findTestObject('Object Repository/loginObject/Page_Login/input_Password_password'), 'placeholder', 'Password', 0)
		WebUI.verifyElementText(findTestObject('Object Repository/loginObject/Page_Login/button_Log In'), 'Log In')
	}

	@Keyword
	def loginWithoutEmailPassword(){
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/button_Log In'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/loginObject/Page_Login/error'), 'Sorry, your email or password could not be found. Please try again.')
		String expectedColor="#b72706";
		String alertColor= WebUI.getCSSValue(findTestObject('Object Repository/loginObject/Page_Login/error'), 'color')
		System.out.println(alertColor);
		String hexcolor=Color.fromString(alertColor).asHex();
		System.out.println(hexcolor);
		WebUI.verifyMatch(hexcolor, expectedColor,true)
	}

	@Keyword
	def loginWithoutPassword() {
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'))
		WebUI.setText(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'), 'a@a.com')
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/button_Log In'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/loginObject/Page_Login/error'), 'Sorry, your email or password could not be found. Please try again.')
		String expectedColor="#b72706";
		String alertColor= WebUI.getCSSValue(findTestObject('Object Repository/loginObject/Page_Login/error'), 'color')
		System.out.println(alertColor);
		String hexcolor=Color.fromString(alertColor).asHex();
		System.out.println(hexcolor);
		WebUI.verifyMatch(hexcolor, expectedColor,true)
	}

	@Keyword
	def loginWithWrongEmailWrongPassword(email, password) {
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'))
		WebUI.clearText(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'))
		WebUI.setText(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'), email)
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/input_Password_password'))
		WebUI.setText(findTestObject('Object Repository/loginObject/Page_Login/input_Password_password'), password)
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/button_Log In'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/loginObject/Page_Login/error'), 'Sorry, your email or password could not be found. Please try again.')
		String expectedColor="#b72706";
		String alertColor= WebUI.getCSSValue(findTestObject('Object Repository/loginObject/Page_Login/error'), 'color')
		System.out.println(alertColor);
		String hexcolor=Color.fromString(alertColor).asHex();
		System.out.println(hexcolor);
		WebUI.verifyMatch(hexcolor, expectedColor,true)
	}

	@Keyword
	def loginWithCorrectEmailCorrectPassword(email, password) {
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'))
		WebUI.clearText(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'))
		WebUI.setText(findTestObject('Object Repository/loginObject/Page_Login/input_Email_email'), email)
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/input_Password_password'))
		WebUI.setText(findTestObject('Object Repository/loginObject/Page_Login/input_Password_password'), password)
		WebUI.click(findTestObject('Object Repository/loginObject/Page_Login/button_Log In'))
		WebUI.delay(05)
		WebUI.verifyElementPresent(findTestObject('Object Repository/loginObject/Page_Login/book_div'), 0)
	}
}
