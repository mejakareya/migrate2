package bookingroom

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

public class booking {


	@Keyword
	def bookingUIVerification() {
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/div_Book'), 'Book')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/div_New Booking'), 'New Booking')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/span_Clear'), 'Clear')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/div_Time'), 'Time')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Date'), 'Date:')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Start Time'), 'Start Time:')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Duration'), 'Duration:')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Recurrence'), 'Recurrence:')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/div_Host  Attendees'), 'Host & Attendees')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Host'), 'Host:')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Attendees'), 'Attendees:')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/attendense_availability'), 'Check Attendees Availability')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/div_Details'), 'Details')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/span_Next'), 'Next')
	}

	@Keyword
	def bookingWithoutTitle() {
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/span_Next'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/title_Error'), 'Title is required')
		String expectedColor="#f44336";
		String alertColor= WebUI.getCSSValue(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/title_Error'), 'color')
		System.out.println(alertColor);
		String hexcolor=Color.fromString(alertColor).asHex();
		System.out.println(hexcolor);
		WebUI.verifyMatch(hexcolor, expectedColor,true)
		
		String alertColor2= WebUI.getCSSValue(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/label_Title'), 'color')
		System.out.println(alertColor2);
		String hexcolor2=Color.fromString(alertColor2).asHex();
		System.out.println(hexcolor2);
		WebUI.verifyMatch(hexcolor2, expectedColor,true)
		
		
	}
	
	@Keyword
	def bookingAllDay() {
		int randomInt = new Random().nextInt(9 - 1 + 1) + 1;
		System.out.println(randomInt);
		
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/calender_Dropdown'))
		WebUI.delay(02)
		
		for (int a = 0; a < randomInt; a++) {
			WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/calender_Next'))
			WebUI.delay(1)
		}
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/date_Select'))
		WebUI.delay(02)
		
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/allDay_CheckBox'))
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/input__title'))
		WebUI.setText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/input__title'), 'Test Title')
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/noRoom_Required_CheckBox'))
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/span_Next'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/confirm_Title'), 'Test Title')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/confirm_Duration'), 'All Day')
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/button_Save'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/confirm'), 0)
		WebUI.delay(02)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/button_Cancel'))
		
	
	}
	
	@Keyword
	def bookingOneTime() {
		
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/span_Clear'))
		
		int randomInt = new Random().nextInt(9 - 1 + 1) + 1;
		System.out.println(randomInt);
		
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/calender_Dropdown'))
		WebUI.delay(02)
		
		for (int a = 0; a < randomInt; a++) {
			WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/calender_Next'))
			WebUI.delay(1)
		}
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/date_Select'))
		WebUI.delay(02)
		
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/time_Dropdown'))
		WebUI.delay(01)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/time_Select'))
		WebUI.delay(01)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/duration_Dropdown'))
		WebUI.delay(01)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/duration_Select'))
		WebUI.delay(01)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/input__title'))
		WebUI.setText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/input__title'), 'Test Title')
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/span_Next'))
		WebUI.delay(03)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/button_Book'))
		WebUI.delay(02)
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/confirm_Title'), 'Test Title')
		WebUI.verifyElementText(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/confirm_Duration'), '45 minutes')
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/button_Save'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/confirm'), 0)
		WebUI.delay(02)
		WebUI.click(findTestObject('Object Repository/Booking/Page_mySmartOffice PWCMe/button_Cancel'))
		
		
	}
	
}
