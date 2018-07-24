package com.sawi.parser.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sawi.parser.model.Log;

public class FileHandeler {
	
	
	  @SuppressWarnings("deprecation")
	public static List<Log> getServiceLogList() throws FileNotFoundException{
		  Boolean errorFlag = false; //exception reading already handeled if true so next error log dont do exceptoin
		  String errorLog2 = "";
		  File file =  new File("/Users/AhmadSawi/Downloads/spf-service-manager.log");
			    Scanner sc;
			
					sc = new Scanner(file);
					
					List<Log> logList = new ArrayList<Log>();
					
					  while (sc.hasNextLine()){
				   // for(int i=0; i<size; i++){
				    	String line;
				    	if(errorFlag == true)
				    		line = errorLog2;
				    	else
				    		line = sc.nextLine();
				    	//System.out.println(line);
				    	
				    	
				    	if(line.length()<=4 || !isNumeric(line.substring(0, 3)))
				    		continue;
				    	
				    	String[] splitted = line.split("\\|");             //0 is date time //1 type //2 thread //3 ignore //4 class //5 message //6 ignore

				    	//splitting timestamp
				    	String[] dateTime = splitted[0].split(" |-|:|,"); //0 is year //1 is month //2 is day //3 is hour //4 is minute //5 is second //6 is nanosecond
				    	
				    	Log log = new Log();
				    	log.setServiceName("spf-service-manager");
				    	log.setTime(new Timestamp(Integer.parseInt(dateTime[0])-1900, Integer.parseInt(dateTime[1])-1, Integer.parseInt(dateTime[2]), Integer.parseInt(dateTime[3]), Integer.parseInt(dateTime[4]), Integer.parseInt(dateTime[5]), 0));
				    	log.setMs(Integer.parseInt(dateTime[6]));
				    	log.setType(splitted[1].trim());
				    	log.setThreadName(splitted[2].trim());
				    	log.setClassName(splitted[4].trim());
				    	log.setMessage(splitted[5]);
				    	
				    	String exception = "";
				    	if(splitted[1].contains("ERROR") && errorFlag == false){
				    		errorFlag = true;
				    		//read all next lines and add them to exception string until the next log comes 
				    		String newLine = sc.nextLine();
				    		while(!isNumeric(newLine.substring(0, 3))){ //if not numeric means its exception
				    			exception = exception + newLine + '\n';
				    			newLine = sc.nextLine();
				    		}
				    		
				    		//after fininshing the line we have is the next one to be used
				    		errorLog2 = newLine;	
				    		log.setException(exception);
				    		//System.out.println(exception);
				    	}else if(splitted[1].contains("ERROR") && errorFlag == true)
				    		errorFlag = false; //ending part of error log
				    	
				    	
				    	logList.add(log);
				    }
				    
				    sc.close();
				    return logList;
	  }
	  
	  
	  
	  @SuppressWarnings("deprecation")
	public static List<Log> getDeviceLogList() throws FileNotFoundException{
		  boolean jsonFlag = false;
		  String logAfterJson = "";
		  File file =  new File("/Users/AhmadSawi/Downloads/spf-device-manager.log");
			    Scanner sc;
			
					sc = new Scanner(file);
					
					List<Log> logList = new ArrayList<Log>();
					
					  while (sc.hasNextLine()){
				   // for(int i=0; i<size; i++){
						  String line;
					    	if(jsonFlag == true){
					    		line = logAfterJson;
					    		jsonFlag = false;
					    	}
					    	else
					    		line = sc.nextLine();
				    	//System.out.println(line);
				    	
				    	
				    	if(line.length()<=4 || !isNumeric(line.substring(0, 3)) || !line.contains("|"))
				    		continue;
				    	
				    	String[] splitted = line.split("\\|");             //0 is date time //1 type //2 thread //3 ignore //4 class //5 message //6 ignore

				    	//splitting timestamp
				    	String[] dateTime = splitted[0].split(" |-|:|,"); //0 is year //1 is month //2 is day //3 is hour //4 is minute //5 is second //6 is nanosecond
				    	
				    	Log log = new Log();
				    	log.setServiceName("spf-device-manager");
				    	log.setTime(new Timestamp(Integer.parseInt(dateTime[0])-1900, Integer.parseInt(dateTime[1])-1, Integer.parseInt(dateTime[2]), Integer.parseInt(dateTime[3]), Integer.parseInt(dateTime[4]), Integer.parseInt(dateTime[5]), 0));
				    	log.setMs(Integer.parseInt(dateTime[6]));
				    	log.setType(splitted[1].trim());
				    	log.setThreadName(splitted[2].trim());
				    	log.setClassName(splitted[4].trim());
				    	log.setMessage(splitted[5]);
				    	
				    	String json = "";
				    	if(splitted[5].trim().equals("***** wfDesignJson{")){
				    		jsonFlag = true;
				    		String newLine = sc.nextLine();
				    		while(newLine.length()<=4 || !isNumeric(newLine.substring(0, 3))){ //if not numeric means its exception
				    			json = json + newLine + '\n';
				    			newLine = sc.nextLine();
				    		}
				    		logAfterJson = newLine;
				    		log.setMessage(log.getMessage() + json);
				    	}
				    	
				    	logList.add(log);
				    }
				    
				    sc.close();
				    return logList;
	  }
	  
	  
	  private static boolean isNumeric(String s) 
	  {
	      try
	      {
	          Integer.parseInt(s);
	          return true;
	      }
	      catch (Exception e) 
	      {
	          return false;
	      }
	  }
	  
	  
}
