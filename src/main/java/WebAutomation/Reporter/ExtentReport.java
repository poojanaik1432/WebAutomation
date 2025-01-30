package WebAutomation.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import WebAutomation.Utilities.FrameworkConstants;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extentReports;

	public static void initReport() throws IOException {
		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath())
					.viewConfigurer().viewOrder().as(new ViewName[] { ViewName.DASHBOARD, ViewName.TEST,
							ViewName.CATEGORY, ViewName.AUTHOR, ViewName.DEVICE, ViewName.EXCEPTION, ViewName.LOG })
					.apply();

			extentReports.attachReporter(spark);

			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("FO Web Automation");
			spark.config().setReportName("FO Web Automation");
			spark.config().setJs("document.getElementsByClassName('card-body')[2].style.backgroundColor='#28a745';"
					+ "document.getElementsByClassName('card-body')[3].style.backgroundColor='#ff5722';"
					+ "document.getElementsByClassName('card-body')[3].children[0].classList.remove('text-fail'); "
					+ "document.getElementsByClassName('card-body')[2].children[0].classList.remove('text-pass'); "
					+ "document.getElementsByClassName('card-body')[2].children[0].style.color='#fff';"
					+ "document.getElementsByClassName('card-body')[3].children[0].style.color='#fff';"
					+ "document.getElementsByClassName('card-body')[2].children[1].style.color='#fff';"
					+ "document.getElementsByClassName('card-body')[3].children[1].style.color='#fff';"
					+ "document.getElementsByClassName('card-body')[0].children[0].style.color='#28a745';"
					+ "document.getElementsByClassName('card-body')[0].children[1].style.color='#28a745';"
					+ "document.getElementsByClassName('card')[0].style.borderColor='#28a745';"
					+ "document.getElementsByClassName('card-body')[1].children[0].style.color='#ff5722';"
					+ "document.getElementsByClassName('card-body')[1].children[1].style.color='#ff5722';"
					+ "document.getElementsByClassName('card')[1].style.borderColor='#ff5722'");

			extentReports.setSystemInfo("OS", System.getProperty("os.name"));
			extentReports.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
			extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
			extentReports.setSystemInfo("Java Home", System.getProperty("java.home"));
			extentReports.setSystemInfo("Username", System.getProperty("user.name"));
			extentReports.setSystemInfo("User Directory", System.getProperty("user.dir"));

		}
	}

	public static void createTest(Method method) {
		String testCaseDesc=method.getName();
		ExtentReportManager.setExtentTest(extentReports.createTest(testCaseDesc));
		ExtentReportManager.getExtentTest().assignAuthor(System.getProperty("user.name"));

		for (String s : Reporter.getOutput()) {
			extentReports.addTestRunnerOutput(s);
		}
	}

	public static void flushReport() throws IOException {

		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
		}
		ExtentReportManager.unload();
	}

}