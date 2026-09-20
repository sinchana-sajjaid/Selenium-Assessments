package Day12_OranageHRM;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Day12_OranageHRMBase.BaseClassOrangrHRM;

public class OranageHRMImplemenation extends BaseClassOrangrHRM {

	@Test
	public void testCase1Test() throws InterruptedException, AWTException
	{
		homepage.getMyInfo();
		Thread.sleep(2000);
		String text = myInfopage.getFirstName();
		Thread.sleep(1000);
		homepage.getRecruitment();
		recruitmentpage.clickVacancies();
		Thread.sleep(1000);
		vacanciespage.getAddButton();
		Thread.sleep(1000);
		vacanciespage.getVnametf(vname);
		Thread.sleep(1000);
		vacanciespage.getJobTitle(jobTitle);
		Thread.sleep(1000);
		vacanciespage.getDescriptiontf(description);
		Thread.sleep(1000);
		vacanciespage.getHiringManagertf(text);
		Thread.sleep(1000);
		vacanciespage.getNoOfPsisitiostf(noOfPositions);
		Thread.sleep(1000);
		vacanciespage.getSaveButton();
		Thread.sleep(1000);
		recruitmentpage.clickVacancies();
		Thread.sleep(1000);
		vacanciespage.getJobTitle(jobTitle);
		Thread.sleep(1000);
		vacanciespage.getVacancyDropdown(vname);
		Thread.sleep(1000);
		vacanciespage.getStatusDropdown();
		Thread.sleep(1000);
		vacanciespage.clickSearchButton();
		Thread.sleep(3000);
		vacanciespage.verifyRecordFound(vname);
		System.out.println("TestCase1 executed");
	}
	
	@Test
	public void testCase2Test() throws InterruptedException, AWTException
	{
		homepage.getMyInfo();
		Thread.sleep(1000);
		myInfopage.getFntf(fn);
		Thread.sleep(1000);
		myInfopage.getLntf(ln);
		Thread.sleep(1000);
		myInfopage.getEmpidtf(empid);
		Thread.sleep(1000);
		myInfopage.clickSaveButton();
		Thread.sleep(2000);
		
		
		System.out.println("Testcase2 executed");
	}
	
	@Test
	public void verifyTestcase2Test() throws InterruptedException
	{
		homepage.getMyInfo();
		Thread.sleep(2000);
		myInfopage.verifyDetailsUpdated(fn);
		Thread.sleep(1000);
		System.out.println("testcase2 is verified");
	}
	
}
