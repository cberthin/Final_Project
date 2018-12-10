package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void testPMT() {
		double r=0.07;
		int n=40;
		double p=1454485.55;
		double ExpectedPayment=554.13;
		
		Retirement rtm1= new Retirement();
		rtm1.setiYearsToWork(n);
		rtm1.setdAnnualReturnWorking(r);
		rtm1.setdRequiredIncome(10000);
		rtm1.setdMonthlySSI(2642);
		rtm1.setiYearsRetired(20);
		rtm1.setdAnnualReturnRetired(0.02);
		
		
		double PMT=rtm1.AmountToSave();
		System.out.println("This is PMT");
		System.out.println(PMT);
		assertEquals(ExpectedPayment, PMT,0.01);
		String result=String.format("%.2f", PMT);
		System.out.println(result);
	}
	
	@Test
	public void testpv() {
		double r=0.02;
		int n=20;
		double y=2642;
		double f=10000; 
		boolean t=false;
		double ExpectedTotalPayment=1454485.55;
		
		
		Retirement rtm2= new Retirement();
		rtm2.setiYearsRetired(n);
		rtm2.setdAnnualReturnRetired(r);
		rtm2.setdMonthlySSI(y);
		rtm2.setdRequiredIncome(f);
		
		double PV=rtm2.TotalAmountSaved();
		System.out.println(PV);
		
		assertEquals(ExpectedTotalPayment, PV,0.01);
		String result=String.format("%.2f", PV);
		System.out.println(result);
	}

}
