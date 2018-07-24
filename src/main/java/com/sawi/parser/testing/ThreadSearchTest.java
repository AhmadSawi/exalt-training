package com.sawi.parser.testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sawi.parser.model.Log;
import com.sawi.parser.resources.LogResource;

public class ThreadSearchTest {

	LogResource resource = null;
	
	@Before
	public void setUp() throws Exception {
		resource = new LogResource();
	}
	
	@Test
	public void test() {
		List<Log> actual = resource.logThread("qtp399534175-610");
		assertFalse(actual.isEmpty());
		assertNotNull(actual.get(1).getMessage());
		assertNotNull(actual.get(1).getTime());
	}
}
