package com.sawi.parser.testing;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sawi.parser.model.Log;
import com.sawi.parser.service.LogService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LogServiceTester {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
	@InjectMocks 
	LogService service = context.getBean(LogService.class);
	
	@Mock
	Session session;
	
	@SuppressWarnings("deprecation")
	@Test
	public void byIdTest() {
		Log expected = new Log();
		expected.setId(1);
		expected.setClassName("c.c.m.c.f.CasCustomAuthenticationFilter");
		expected.setServiceName("spf-service-manager");
		expected.setType("INFO");
		expected.setThreadName("qtp399534175-610");
		expected.setTime(new Timestamp(118,6,9,10,6,20,0)); //2018-07-09 10:06:20
		expected.setException(null);
		expected.setMessage(" username for logged in user : admin ");
		expected.setMs(504);
		
		when(session.get(Log.class, 1)).thenReturn(expected);
		
		Log returned = service.byId(1);
		
		assertNotNull(returned);
		
		assertEquals(expected.toString(), returned.toString());	
	}
	

}
