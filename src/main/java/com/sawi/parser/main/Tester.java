package com.sawi.parser.main;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sawi.parser.model.Log;
import com.sawi.parser.service.LogService;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//LogService service = context.getBean(LogService.class);
		saveToDB();
		
		//List<Log> list = service.list();
		
		//for(Log log : list){
		//	System.out.println("log List::"+log);
		//}

		context.close();	


	}
	
	public static void saveToDB() throws FileNotFoundException{
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		LogService service = context.getBean(LogService.class);
		
		List<Log> list = FileHandeler.getServiceLogList();
		
		for(int i=0; i<list.size(); i++)
			service.save(list.get(i));
		
		System.out.println("Done 1");
		
		List<Log> list2 = FileHandeler.getDeviceLogList();
		
		for(int i=0; i<list2.size(); i++)
			service.save(list2.get(i));
		System.out.println("Done 2");

		context.close();	
	}
	
	public static Log findExceptionLog(List<Log> logList){
		for(int i=0; i<logList.size(); i++){
			if(logList.get(i).getType().equals("ERROR") && !logList.get(i).getException().isEmpty())
				return logList.get(i);
		}
		return null;	
	}
	
}