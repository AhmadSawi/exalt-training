package com.sawi.parser.testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
		{ IdSearchTest.class,
			ThreadSearchTest.class, 
			LogResourceTester.class,
			LogServiceTester.class})
public class AllTests {

}
