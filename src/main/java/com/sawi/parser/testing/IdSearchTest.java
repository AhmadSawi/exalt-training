package com.sawi.parser.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.sawi.parser.model.Log;
import com.sawi.parser.resources.LogResource;

public class IdSearchTest {

	LogResource resource = null;
	
	@Before
	public void initialize(){
		resource = new LogResource();
	}
	
	@Test
	public void test() {
		Log actual = resource.singleLog(1);
		assertNotNull(actual);
	}

}
