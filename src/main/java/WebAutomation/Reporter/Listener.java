package WebAutomation.Reporter;
import org.testng.*;

import java.io.IOException;

public class Listener implements ITestListener, ISuiteListener {

	@Override
	public void onFinish(ISuite arg0) {
		try {
			ExtentReport.flushReport();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onStart(ISuite arg0) {
		try {
			ExtentReport.initReport();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed...");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped...");

	}

	@Override
	public void onTestStart(ITestResult result) {
		 ExtentReport.createTest(result.getMethod().getConstructorOrMethod().getMethod());
		 ExtentLogger.info(result.getMethod().getMethodName()+" is Started...");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed...");

	}

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

}