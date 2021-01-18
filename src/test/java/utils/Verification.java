package utils;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Verification {

    private final static SoftAssert softAssert = new SoftAssert();;


    public static void assertTrue(Boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public static void assertEquals(Object actual, Object expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(int actual, int expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public static void assertEquals(String actual, String expected, String message){
        Assert.assertEquals(actual, expected, message);
    }

    public static void softAssertTrue(Boolean condition, String message) {
        softAssert.assertTrue(condition, message);
    }

    public static void softAssertEquals(Object actual, Object expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void softAssertEquals(int actual, int expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void softAssertEquals(String actual, String expected, String message) {
        softAssert.assertEquals(actual, expected, message);
    }

    public static void assertAll() {
        softAssert.assertAll();
    }

}
