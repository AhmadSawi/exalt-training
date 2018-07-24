package com.sawi.parser.resources;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;

import com.sawi.parser.main.FileHandeler;
import com.sawi.parser.model.Log;
import com.sawi.parser.service.LogService;

@Path("log")
public class LogResource{
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	LogService service = context.getBean(LogService.class);
	
	
	@GET
	@Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Log> getAll() {
		return service.list();     
    }
	
	@GET
	@Path("/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Log singleLog(@PathParam("Id") int id){
		   return service.byId(id);
	}
	
	@GET
	@Path("exceptions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Log> exceptionLog(){
		return findExceptionLog(getAll());
	}
	
	
	@GET
	@Path("type")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Log> logType(@QueryParam("type") String type){
		return service.byType(type);
	}
	
	
	@GET
	@Path("thread")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Log> logThread(@QueryParam("thread") String thread){
		return service.byThread(thread);
	}
	
	@GET
	@Path("class")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Log> logClass(@QueryParam("class") String className){
		return service.byClass(className);
	}
	
	@GET
	@Path("service")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Log> logService(@QueryParam("service") String sservice){
		return service.byService(sservice);
	}
	
	@GET
	@Path("date")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Log> logService(@QueryParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
								@QueryParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate){
		return service.byDateFromTo(fromDate.getTime(), toDate.getTime());
	}
	
	@GET
	@Path("update")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDatabase(){
		try {
			saveToDB();
			return "Updated!";
		} catch (FileNotFoundException e) {
			return "File not found";
		}
		
	}
			
	
	private List<Log> findExceptionLog(List<Log> logList){
		List<Log> exceptionList = new ArrayList<Log>();
		for(int i=0; i<logList.size(); i++){
			if(logList.get(i).getType().contains("ERROR") && logList.get(i).getException() != null)
				 exceptionList.add(logList.get(i));
		}
		return exceptionList;	
	}
	
	public void saveToDB() throws FileNotFoundException{
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
	
	

}
