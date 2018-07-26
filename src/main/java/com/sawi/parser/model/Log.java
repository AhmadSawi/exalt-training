/*
 * Log POJO
 * 
 * */

package com.sawi.parser.model;

import java.sql.Timestamp;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="info")
@XmlRootElement
public class Log {
	
	public Log() {
	}
	
	public Log(int id, Timestamp time, int ms, String type, String threadName, String className, String message,
			String exception, String serviceName) {
		super();
		this.id = id;
		this.time = time;
		this.ms = ms;
		this.type = type;
		this.threadName = threadName;
		this.className = className;
		this.message = message;
		this.exception = exception;
		this.serviceName = serviceName;
	}

	@Id
	private int id;
	
	@Column(name="time", nullable=true)
	private Timestamp time;
	
	@Column(name="ms", nullable=true)
	private int ms; //?
	
	@Column(name="type", length=30, nullable=true)
	private String type;
	
	@Column(name="threadname", length=100, nullable=true)
	private String threadName;
	
	@Column(name="classname", length=100, nullable=true)
	private String className;
	
	@Column(name="message", nullable=true)
	private String message;

	@Column(name="exception", nullable=true)
	private String exception;
	
	@Column(name="servicename", nullable=true)
	private String serviceName;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public int getMs() {
		return ms;
	}
	public void setMs(int ms) {
		this.ms = ms;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getThreadName() {
		return threadName;
	}
	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getException() {
		return exception;
	}
	
	public void setException(String exception) {
		this.exception = exception;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", time=" + time + ", ms=" + ms + ", type=" + type + ", threadName=" + threadName
				+ ", className=" + className + ", message=" + message + ", exception=" + exception + ", serviceName="
				+ serviceName + "]";
	}

}
