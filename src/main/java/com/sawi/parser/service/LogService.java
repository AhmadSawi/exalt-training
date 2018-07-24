package com.sawi.parser.service;

import java.util.List;

import com.sawi.parser.model.Log;

public interface LogService {

	public void save(Log log);
	
	public List<Log> list();
	
	public Log byId(int id);
	
	public List<Log> byType(String type);
	
	public List<Log> byThread(String thread);
	
	public List<Log> byService(String service);
	
	public List<Log> byClass(String className);
	
	public List<Log> byDateFromTo(long from, long to);
	

	
}
