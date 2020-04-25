package utils;

import org.testng.Assert;

public class SoftAssert extends CommonUtil {
	private static final String PASSED = "Assert Passed";
	private static final String PASSED_MSG = "Actual value [%s] matches the expected value[%s]";
	private static final String FAILED = "Assert Failed";
	private static final String FAILED_MSG = "Actual value [%s] does not matche the expected value[%s]";

	private SoftAssert() {
	}

	public static void assertTrue(boolean assertExpression) {
		if (assertExpression) {
			testLog.pass(PASSED);
		} else {
			testLog.fail(FAILED);

		}
		Assert.assertTrue(assertExpression);
	}

	public static void assertTrue(boolean assertExpression, String assertLogTextIfFailed) {
		if (assertExpression) {
			testLog.pass(PASSED);
		} else {
			testLog.fail("Assert Failed:: " + assertLogTextIfFailed);
		}
		Assert.assertTrue(assertExpression, assertLogTextIfFailed);
	}

	public static void assertFalse(boolean assertExpression, String assertLogTextIfFailed) {
		if (!assertExpression) {
			testLog.pass(PASSED);
		} else {
			testLog.fail("Assert Failed:: " + assertLogTextIfFailed);
		}
		Assert.assertFalse(assertExpression, assertLogTextIfFailed);
	}

	public static void assertFalse(boolean assertExpression) {
		if (!assertExpression) {
			testLog.pass(PASSED);
		} else {
			testLog.fail(FAILED);
		}
		Assert.assertFalse(assertExpression);
	}

	public static void assertEquals(Object actual, Object expected, String assertLogTextIfFailed) {
		if (actual == expected) {
			testLog.pass(String.format(PASSED_MSG, actual, expected));
			testLog.info(assertLogTextIfFailed);
		} else {
			testLog.fail(String.format(FAILED_MSG, actual, expected));
			testLog.error(assertLogTextIfFailed);
		}
		Assert.assertEquals(actual, expected, assertLogTextIfFailed);
	}

	public static void assertEquals(String actual, String expected, String assertLogTextIfFailed) {
		if (actual.equals(expected)) {
			testLog.pass(String.format(PASSED_MSG, actual, expected));
			testLog.info(assertLogTextIfFailed);
		} else {
			testLog.fail(String.format(FAILED_MSG, actual, expected));
			testLog.error(assertLogTextIfFailed);
		}
		Assert.assertEquals(actual, expected, assertLogTextIfFailed);
	}

	public static void assertEquals(Object actual, Object expected) {
		if (null == expected) {
			if (null == actual) {
				testLog.pass("Assert Passed:: Actual value [null] matches the expected value[null]");
			} else {
				testLog.fail(String.format("Assert Failed:: Actual value [%s] NOT matches the expected value[null]",
						actual));
			}
		} else {
			if (null == actual) {
				testLog.fail(String.format("Assert Failed:: Actual value [null] NOT matches the expected value[%s]",
						expected));
			} else {
				if (actual == (expected)) {
					testLog.pass(String.format(PASSED_MSG, actual, expected));
				} else {
					testLog.fail(String.format(FAILED_MSG, actual, expected));
					testLog.error(String.format("<font color=\"#ee9a4d\">*** actual   value [%s] is of datatype [%s]</font>", actual, actual.getClass().getSimpleName()));
					testLog.error(String.format("<font color=\"#ee9a4d\">*** expected value [%s] is of datatype [%s]</font>", expected, expected.getClass().getSimpleName()));
				}
			}
		}
		Assert.assertEquals(actual, expected);
	}

	public static void assertEquals(float actual, float expected) {
		if (Float.compare(actual, expected) == 0) {
			testLog.pass(String.format(PASSED_MSG, actual, expected));
		} else {
			testLog.fail(String.format(FAILED_MSG, actual, expected));
		}
		Assert.assertEquals(actual, expected);
	}

	public static void assertEquals(double actual, double expected) {
		if (Double.compare(actual, expected) == 0) {
			testLog.pass(String.format(PASSED_MSG, actual, expected));
		} else {
			testLog.fail(String.format(FAILED_MSG, actual, expected));
		}
		Assert.assertEquals(actual, expected);
	}

	public static void assertEquals(String actual, String expected) {
		if (null == expected) {
			if (null == actual) {
				testLog.pass("Assert Passed:: Actual value [null] matches the expected value[null]");
			} else {
				testLog.fail(String.format("Assert Failed:: Actual value [%s] NOT matches the expected value[null]",
						actual));
			}
		} else {
			if (null == actual) {
				testLog.fail(String.format("Assert Failed:: Actual value [null] NOT matches the expected value[%s]",
						expected));
			} else {
				if (actual.equals(expected)) {
					testLog.pass(String.format(PASSED_MSG, actual, expected));
				} else {
					testLog.fail(String.format(FAILED_MSG, actual, expected));
				}
			}
		}
		Assert.assertEquals(actual, expected);
	}

	public static void assertNotEquals(Object actual, Object expected) {
		if (actual != expected) {
			testLog.pass(String.format(PASSED_MSG, actual, expected));
		} else {
			testLog.fail(String.format(FAILED_MSG, actual, expected));
		}
		Assert.assertNotEquals(actual, expected);
	}

	public static void assertNotEquals(String actual, String expected) {
		if (!actual.equals(expected)) {
			testLog.pass(String.format(PASSED_MSG, actual, expected));
		} else {
			testLog.fail(String.format(FAILED_MSG, actual, expected));
		}
		Assert.assertNotEquals(actual, expected);
	}
}
