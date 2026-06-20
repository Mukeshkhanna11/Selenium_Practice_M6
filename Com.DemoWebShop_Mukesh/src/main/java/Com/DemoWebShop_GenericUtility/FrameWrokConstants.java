package Com.DemoWebShop_GenericUtility;

public interface FrameWrokConstants {
	
	JavaUtility jUtil= new JavaUtility();
	String propertyFilePath="./src/test/resources/testData/commonData.properties";
	String excelPath = "./src/test/resources/testData/addressData.xlsx";
	String screenshotPath ="./screenshots/"+jUtil.dateAndTime()+".png";
	String extentReportPath="./reports/"+jUtil.dateAndTime()+".html";

}
