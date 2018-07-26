package com.sawi.parser.testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sawi.parser.model.Log;
import com.sawi.parser.resources.LogResource;
import com.sawi.parser.service.LogService;

/*
 * JUnit testing using Mockito
 * */

@RunWith(MockitoJUnitRunner.class)
public class LogResourceTester {

	@InjectMocks 
	LogResource logResource = new LogResource();
	
	@Mock
	LogService service;
	
	@SuppressWarnings("deprecation")
	@Test
	public void byIDTest() {	
		
		//values for the log of ID=1 in the database
		Log expected = new Log();
		expected.setClassName("c.c.m.c.f.CasCustomAuthenticationFilter");
		expected.setServiceName("spf-service-manager");
		expected.setType("INFO");
		expected.setThreadName("qtp399534175-610");
		expected.setTime(new Timestamp(118,6,9,10,6,20,0)); //2018-07-09 10:06:20
		expected.setException(null);
		expected.setMessage(" username for logged in user : admin ");
		expected.setMs(504);
		
		when(service.byId(1)).thenReturn(expected);
		Log expectedLog = logResource.singleLog(1);
		assertNotNull(expected);
		assertEquals(expected, expectedLog);
	}
	

}
