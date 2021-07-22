package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

    private int retryNum = 0;
    private static final int MAX_RETRY = 2;


    public boolean retry(ITestResult result) {
        if (retryNum < MAX_RETRY) {
            retryNum++;
            return true;
        } else return false;
    }

}
